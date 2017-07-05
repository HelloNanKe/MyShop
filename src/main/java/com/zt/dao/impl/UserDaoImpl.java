package com.zt.dao.impl;

import com.sun.javaws.jnl.XMLUtils;
import com.zt.Utils.XmlUtils;
import com.zt.domain.User;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by zt on 2017/7/4.
 */
public class UserDaoImpl implements com.zt.dao.UserDao {

    public void add(User user) throws IOException {
        Document document = null;
        try {
            document = XmlUtils.getDocument();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        Element root = document.getRootElement();
        Element user_tag = root.addElement("user");
        user_tag.setAttributeValue("id", user.getId());
        user_tag.setAttributeValue("username", user.getUsername());
        user_tag.setAttributeValue("password", user.getPassword());
        user_tag.setAttributeValue("email", user.getEmail());
//        user_tag.setAttributeValue("birthday", String.valueOf(user.getBirthday()) == null ? "" : user.getBirthday().toLocaleString());
        user_tag.setAttributeValue("nickname", user.getNickname());
        XmlUtils.write2Xml(document);
    }

    public User find(String username, String password) {
        Document document = null;
        try {
            document = XmlUtils.getDocument();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        Element e = (Element) document.selectSingleNode("//user[@username='" + username + "' and @password='" + password + "']");

        if (e == null) {
            System.out.println("没有该用户");
            return null;
        }

        User user = new User();
        String date = e.attributeValue("birthday");
        if (date == null || date.equals("")) {
            user.setBirthday(null);
        } else {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
            try {
                user.setBirthday(simpleDateFormat.parse(date));
            } catch (ParseException e1) {
//                e1.printStackTrace();
            }
        }
        user.setEmail(e.attributeValue("email"));
        user.setNickname(e.attributeValue("nickname"));
        user.setUsername(e.attributeValue("username"));
        user.setPassword(e.attributeValue("password"));
        return user;
    }

    //查找该用户是否注册
    public boolean find(String username) {

        Document document = null;
        try {
            document = XmlUtils.getDocument();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        Element e = (Element) document.selectSingleNode("//user[@username='" + username + "']");
            if(e==null){
                return false;
            }
        return true;
    }

}
