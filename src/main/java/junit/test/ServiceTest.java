package junit.test;

import com.zt.Exception.UserExistExcetion;
import com.zt.domain.User;
import com.zt.service.impl.BusinessServiceImpl;
import org.junit.Test;

import java.io.IOException;
import java.util.Date;

/**
 * Created by zt on 2017/7/4.
 */
public class ServiceTest {
    @Test
    public void testRegister(){
        User user=new User();
        user.setUsername("nanke1");
        user.setPassword("123456");
        user.setEmail("yu@sina.com");
        user.setNickname("灰色天空");
        user.setBirthday(new Date());
        user.setId("hjdhghdi");

        BusinessServiceImpl service =new BusinessServiceImpl();
        try {
            service.register(user);
            System.out.println("用户注册成功");
        } catch (UserExistExcetion userExistExcetion) {
            System.out.println("用户已经存在");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @Test
    public void testLogin(){
        BusinessServiceImpl service =new BusinessServiceImpl();
       User u= service.login("nanke1","123456");
       if(u!=null){
           System.out.println("登录成功");
       }else {
           System.out.println("登录失败");
       }
    }
}
