/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package indexpage;
import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author reena
 */
public class InitConnection {
     public static Connection initConn(){
Connection con=null;
     try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("driver open");
        con= DriverManager.getConnection("jdbc:mysql://localhost:3306/datademo","root","");
        System.out.println("connection done");
        }catch(Exception tt){
        System.out.println(tt);
        
        }
      return con;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    }
}
    

