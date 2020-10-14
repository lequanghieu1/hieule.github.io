package Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.SessionAttribute;

import Weapon.Controller.User.BaseController;
import Weapon.Entity.Users;

public class Authorization implements Filter {
private ServletContext context;
	public void init(FilterConfig filterConfig) throws ServletException {
		this.context = filterConfig.getServletContext();
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		String url = req.getRequestURI();
		Users user = (Users) req.getSession().getAttribute("LoginInfo");
		if(url.startsWith("/Weapon/admin")) {	
			if(user != null) {
				if(user.getRole().getName().equals("admin")) {
					chain.doFilter(request, response);
				}
				else if(user.getRole().getName().equals("user")) {
					res.sendRedirect("/Weapon/error");
				}
			}
			else {
				res.sendRedirect("/Weapon/error");
			}
		}
		else if(url.startsWith("/Weapon/checkout")) {
			if(user != null) {
				if(user.getRole().getName().equals("user")) {
					chain.doFilter(request, response);
				}
				else if(user.getRole().getName().equals("admin")) {
					res.sendRedirect("/Weapon/error");
				}
			}
			else {
				res.sendRedirect("/Weapon/error");
			}
		}
		else {
			chain.doFilter(request, response);
			
		}
		
	}

}
