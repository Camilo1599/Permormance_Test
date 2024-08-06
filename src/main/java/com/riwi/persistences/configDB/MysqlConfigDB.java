package com.riwi.persistences.configDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlConfigDB {
    public static Connection connection = null;

    public static Connection openConnection(){
        String Url = "jdbc:mysql://localhost:3306/riwiAcademyDB";
        String User = "root";
        String Password = "tupassword";

        try{
            connection  = DriverManager.getConnection(Url,User,Password);

            System.out.println("Connection Successful");
        }catch(SQLException e){
            throw new RuntimeException(e.getMessage());
        }
        return connection;
    }

    public static void closeConnection(){
        if(connection != null){
            try{
                connection.close();

                System.out.println("Connection Closed");
            }catch(SQLException e){
                throw new RuntimeException(e.getMessage());
            }
        }
    }
}
