package cn.ustc.web;

import cn.ustc.service.Impl.UserServiceImpl;
import cn.ustc.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserController {

    public static void main(String[] args) {
        ApplicationContext app = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        UserService userService = (UserServiceImpl) app.getBean("userService");
        userService.save();
    }
}
