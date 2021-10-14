package com.example.android_mysql;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySqlConnect {
    static Connection getConnection() throws Exception {
        //JDBCドライバのロード
        Class.forName("com.mysql.jdbc.Driver");
        //各設定
        String url = "jdbc:mysql://192.168.0.32/sales_db";
        String user = "and_user";
        String pass = "android0216";
        //データベースに接続
        Connection con = DriverManager.getConnection(url,user,pass);
        return con;
    }
}
