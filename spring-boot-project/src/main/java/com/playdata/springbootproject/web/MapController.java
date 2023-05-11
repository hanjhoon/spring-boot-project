package com.playdata.springbootproject.web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MapController {

    private Connection conn;

    // 데이터베이스 연결 초기화
    public void initDB() throws Exception {
        String dbUrl = "jdbc:postgresql://" + "192.168.0.193" + ":" + "5432" + "/" + "'mountaindew'";
        conn = DriverManager.getConnection(dbUrl, "'postgres'", "'playdata'");
    }

    public String getXmlData(String fileName, String search) throws Exception {
        String query = "SELECT xml_data FROM mountaindew_table WHERE file_name LIKE '%" + search+ "%'";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        if (rs.next()) {
            return rs.getString("xml_data");
        } else {
            return null;
        }
    }


    // XML 데이터 가져오기
    public String getXmlData(String fileName) throws Exception {

        String query = "SELECT xml_data FROM mountaindew_table WHERE file_name LIKE '%" + fileName + "%'";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        if (rs.next()) {
            return rs.getString("xml_data");
        } else {
            return null;
        }
    }
}
