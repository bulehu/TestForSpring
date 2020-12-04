package cn.ustc.config;


import com.alibaba.druid.pool.DruidDataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Component;


import java.sql.Connection;
import java.sql.SQLException;


@Configuration //用于表明此类为Spring的配置类
//<context:component-scan base-package="cn.ustc"></context:component-scan>
@ComponentScan("cn.ustc") //用于扫描cn.ustc包下的所有注解
//<context:property-placeholder location="jdbc.properties"></context:property-placeholder>
@PropertySource("classpath:jdbc.properties")
//@MapperScan(basePackages = "cn.incisor.dao")
public class SpringConfiguration {

    @Value("${jdbc.Driver}")
    private String DRIVER;
    @Value("${jdbc.url}")
    private String URL;
    @Value("${jdbc.username}")
    private String NAME;
    @Value("${jdbc.password}")
    private String PASSWORD;

    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean("druidDataSource")
    public DruidDataSource getDruidDataSource() throws SQLException {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(DRIVER);
        System.out.println(DRIVER);
        druidDataSource.setUrl(URL);
        //druidDataSource.setUrl("${jdbc.url}");
        System.out.println(URL);
        druidDataSource.setUsername(NAME);
        druidDataSource.setPassword(PASSWORD);
        return druidDataSource;
    }

/*    @Bean("getDataSource")
    public void getDataSource() throws Exception {
        System.out.println(DRIVER);
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/ustc_test?serverTimezone = UTC");
        dataSource.setUser("root");
        dataSource.setPassword("root");
        Connection connection = dataSource.getConnection();
        connection.close();
    }*/

}
