/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restaurant.jdbc;

import com.restaurant.business.Emp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class EmpDao {
    
    public static Connection getConnection() throws ClassNotFoundException, SQLException{
        Connection con=null;
        try{
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "");
        }
        catch(Exception e){ System.out.println(e);}
        return con;
    }
    
    public static void save(Emp e) throws ClassNotFoundException, SQLException{
        Connection con = EmpDao.getConnection();
        String insertRecord ="INSERT INTO `employeedetails`(`name`, `gender`, `age`, `email`, `country`) VALUES ('"+e.getName()+"','"+e.getGender()+"','"+e.getAge()+"','"+e.getEmail()+"','"+e.getCountry()+"')";
        Statement st = con.createStatement();
        st.executeUpdate(insertRecord);
    }
}
