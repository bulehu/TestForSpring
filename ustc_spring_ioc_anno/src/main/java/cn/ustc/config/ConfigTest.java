package cn.ustc.config;

import com.alibaba.druid.pool.DruidPooledConnection;

public class ConfigTest {

    public static void main(String[] args) throws Exception {

        SpringConfiguration sc = new SpringConfiguration();
        System.out.println(sc.getDruidDataSource());
        DruidPooledConnection dpConn = sc.getDruidDataSource().getConnection();
        System.out.println(dpConn);
    }
}
