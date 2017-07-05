package junit.test;

import com.zt.dao.impl.UserDaoImpl;
import com.zt.domain.User;
import org.junit.Test;

import java.io.IOException;
import java.util.Date;

/**
 * Created by zt on 2017/7/4.
 */
public class UserDaoTest {
    @Test
    public void testAdd(){
        User user=new User();
        user.setUsername("nanke");
        user.setPassword("123456");
        user.setEmail("yu@sina.com");
        user.setNickname("灰色天空");
        user.setBirthday(new Date());
        user.setId("hjdhghdi");


        UserDaoImpl userDao=new UserDaoImpl();
        try {
            userDao.add(user);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void TestFind(){
        UserDaoImpl userDao=new UserDaoImpl();
       User u= userDao.find("nanke","123456");
       if(u!=null)
       System.out.println(u.getUsername()+u.getPassword());
    }

    @Test
    public void TestFindByName(){
        UserDaoImpl userDao=new UserDaoImpl();
        System.out.println(userDao.find("nanke1"));
    }
}
