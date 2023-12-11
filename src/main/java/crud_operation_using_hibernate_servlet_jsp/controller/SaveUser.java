package crud_operation_using_hibernate_servlet_jsp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crud_operation_using_hibernate_servlet_jsp.dao.UserDao;
import crud_operation_using_hibernate_servlet_jsp.dto.User;

@WebServlet("/saveUser")
public class SaveUser extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name= req.getParameter("name");
		long phone= Long.parseLong(req.getParameter("phone"));
		String address= req.getParameter("address");
		
		User user=new User();
		user.setName(name);
		user.setPhone(phone);
		user.setAddress(address);
		
		UserDao dao=new UserDao();
		dao.addUser(user);
		resp.sendRedirect("index.jsp");
	}
}
