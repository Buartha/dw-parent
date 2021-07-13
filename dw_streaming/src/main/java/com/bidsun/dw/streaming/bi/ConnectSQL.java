package com.bidsun.dw.streaming.bi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectSQL {
    // URL指向要访问的数据库名

    //public static final String url = "jdbc:mysql://121.36.202.26/bidsun_data";
    public static final String url = "jdbc:mysql://47.117.34.236/bidsun_ecs";
    // 驱动程序名
    public static final String name = "com.mysql.jdbc.Driver";
    // MySQL配置时的用户名
    //public static final String user = "root";
    public static final String user = "services";
    // MySQL配置时的密码
    //public static final String password = "123456abc";
    public static final String password = "#MYsBvVB";

    public Connection conn = null;
    public PreparedStatement pst = null;

    public ConnectSQL(String sql) {
        try {
            Class.forName(name);// 指定连接类型
            conn = DriverManager.getConnection(url, user, password);// 获取连接
            pst = conn.prepareStatement(sql);// 准备执行语句
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            this.conn.close();
            this.pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
