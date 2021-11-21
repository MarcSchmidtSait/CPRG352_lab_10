/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 854638
 */
public class AdminFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
       
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest)request;
        HttpSession session = httpRequest.getSession();
        String isAdmin = (String)session.getAttribute("isAdmin");
     try{   
        if(isAdmin.equals("false")){
            HttpServletResponse httpReponse = (HttpServletResponse)response; 
            httpReponse.sendRedirect("notes");
            return; 
        }
        chain.doFilter(request, response);
     }catch (Exception e){
         HttpServletResponse httpReponse = (HttpServletResponse)response; 
         httpReponse.sendRedirect("login");
     }
    }

    @Override
    public void destroy() {
        
    }
    
}
