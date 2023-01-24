/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

/**
 *
 * @author pc
 */
public class UserDao {
    
    public void insert(User x){
        
        try {
            Connection c=DBConnection.connect();
            Statement st=c.createStatement();
            st.executeUpdate("insert into users (name) values ('"+x.getName()+"')");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public List<User> read(){
        List <User> list=new ArrayList<>();
        try {
            Connection c=DBConnection.connect();
            Statement st=c.createStatement();
            ResultSet rs=st.executeQuery("select * from users order by id asc");
            while(rs.next()){
                User tmp=new User(rs.getInt("id"), rs.getString("name"), rs.getString("password"));
                list.add(tmp);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
    
    public void update(User x){
        
        try {
            Connection c=DBConnection.connect();
            Statement st=c.createStatement();
            st.executeUpdate("update users set name='"+x.getName()+"' where id="+x.getId());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void delete(User x){
        
        try {
            Connection c=DBConnection.connect();
            Statement st=c.createStatement();
            st.executeUpdate("delete from users where id="+x.getId());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
