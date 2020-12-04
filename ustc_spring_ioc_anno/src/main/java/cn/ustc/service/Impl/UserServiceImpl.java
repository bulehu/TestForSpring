package cn.ustc.service.Impl;

import cn.ustc.dao.Impl.UserDaoImpl;
import cn.ustc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/*<bean id="userService" class="cn.ustc.service.Impl.UserServiceImpl" >
<property name="userDao" ref="userDao"></property>
</bean>*/
@Component("userService") //组件声明
public class UserServiceImpl implements UserService {
    @Autowired
    @Qualifier("userDao") //注入依赖
    private UserDaoImpl userDao;

    @Value("${jdbc.Driver}")
    private String Driver;

    public UserDaoImpl getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDaoImpl userDao) {
        this.userDao = userDao;
    }

    @Override
    public void save() {
        userDao.save(); //调用了Dao层的方法
        System.out.println(Driver);
    }

}
