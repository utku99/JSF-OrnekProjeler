/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UserDao;
import entity.User;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author pc
 */
@Named
@SessionScoped

public class UserBean implements Serializable {

    private UserDao dao;
    private User entity;

    public String insert() {
        this.getDao().insert(entity);
        return "/users/list";
    }

    public List<User> getRead() {
        return this.getDao().read();
    }

    public String updateForm(User x) {
        this.entity = x;
        return "/users/update";
    }

    public String update() {
        this.getDao().update(entity);
        return "/users/list";
    }

    public void delete(User x) {
        this.getDao().delete(x);
    }

    public UserBean() {
    }

    public UserDao getDao() {
        if (this.dao == null) {
            this.dao = new UserDao();
        }
        return dao;
    }

    public void setDao(UserDao dao) {
        this.dao = dao;
    }

    public User getEntity() {
        if (entity == null) {
            this.entity = new User();
        }
        return entity;
    }

    public void setEntity(User entity) {
        this.entity = entity;
    }

}
