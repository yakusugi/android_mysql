package com.example.android_mysql;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class MainActivity extends AppCompatActivity {



        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            try {
                //データベースに接続
                Connection con = MySqlConnect.getConnection();
                //ステートメントオブジェクトを作成
                Statement stmt = (Statement) con.createStatement();

                //SQL
                String mySql = "select product_name from product_master;";
                ResultSet rs = stmt.executeQuery(mySql);

                while(rs.next()) {
                    Toast.makeText(getApplicationContext(), rs.getString("product_name"), Toast.LENGTH_LONG).show();
                    Log.d("TAG", "onCreate: " + rs.getString("product_name"));
                }

                //オブジェクトを解放
                rs.close();
                stmt.close();
                con.close();

            } catch (Exception e) {
            }


    }
}