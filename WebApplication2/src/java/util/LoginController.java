package util;

import entity.User;
import java.io.Serializable;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pc
 */
@Named
@SessionScoped

public class LoginController implements Serializable{
    private User user;
    
    public String login(){
        
    
        return "";
    }
    
    

    public User getUser() {
        if(this.user==null)
            this.user=new User();
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    
    
    
}
