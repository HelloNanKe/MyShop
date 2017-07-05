package com.zt.Utils;


import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.UUID;

/**
 * Created by zt on 2017/7/5.
 */
public class WebUtils {

    public static <T> T request2Bean(HttpServletRequest request, Class<T> beanClass){

        try {
            //1.创建要封装数据的bean
            T bean=beanClass.newInstance();
            //2.将request中数据封装到bean中
            Enumeration e= request.getParameterNames();
            while(e.hasMoreElements()){
                String name= (String) e.nextElement();
                String value=request.getParameter(name);

                BeanUtils.setProperty(bean,name,value);
            }
            return bean;
        } catch (Exception e) {
           throw new RuntimeException(e);
        }

    }

    public static void copyBean(final Object src, Object dest){

        //自定义一个string到date的转换器
        ConvertUtils.register(new Converter() {
            public Object convert(Class type, Object value) {
                if(value==null){
                    return null;
                }
                String str= (String) value;
                if(str.trim().equals("")){
                    return null;
                }
                SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
                try {
                    return df.parse(str);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
            }
        }, Date.class);


        try {
            BeanUtils.copyProperties(dest,src);
        } catch (Exception e) {
           throw new RuntimeException(e);
        }
    }
    //产生全球唯一的ID
    public static String generateId(){
        return UUID.randomUUID().toString();
    }
}
