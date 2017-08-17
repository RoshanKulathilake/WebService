/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packageOne;

import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import java.sql.*; 

@WebService(serviceName = "NewWebService")
public class NewWebService {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
         String tName="";
        try{
            Class.forName("com.mysql.jdbc.Driver"); 
            Connection conn = DriverManager.getConnection(  
                "jdbc:mysql://localhost:3306/webservice","im_2013_051","roshan");  
            Statement stmt=conn.createStatement(); 
            ResultSet rs = stmt.executeQuery("select * from student where stuID ='"+txt+"'");
            
            while(rs.next()) { 
                tName = rs.getString("stuName");
                  
            }
            conn.close();
        }catch(Exception e){
            System.out.println(e);
        } 
        return tName;
    }
}
