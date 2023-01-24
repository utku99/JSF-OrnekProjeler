/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import entity.User;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author pc
 */
@WebFilter("/*")
public abstract  class loginFilter implements Filter{

 

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        
        String url = req.getRequestURI();
        
        User u =(User) req.getSession().getAttribute("valid_user");
        
        if(u==null){
            if(url.contains("logout")){
                res.sendRedirect(req.getContextPath()+"/login.xhtml");
            }else{
                chain.doFilter(request, response);
            }
            
        }else{
            if(url.contains("login")){
                
            
            }else if(url.contains("logout")){
            
            }else{
                chain.doFilter(request, response);
            }
        
        
        }
        
        
        
        
        
    }

}
