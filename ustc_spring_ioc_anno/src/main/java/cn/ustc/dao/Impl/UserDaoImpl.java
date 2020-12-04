package cn.ustc.dao.Impl;

import cn.ustc.dao.UserDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/*<bean id="userDao" class="cn.ustc.dao.Impl.UserDaoImpl" >
<property name="name" value="文文"></property>
<property name="password" value="666"></property>
</bean>*/
@Component("userDao")
public class UserDaoImpl implements UserDao {
    @Value("小白")
    private String name;
    @Value("666")
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void save() {
        System.out.println("用户名：" + getName() + "-------" + "密码：" + getPassword());
    }

}
