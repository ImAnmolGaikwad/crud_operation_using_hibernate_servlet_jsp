package crud_operation_using_hibernate_servlet_jsp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crud_operation_using_hibernate_servlet_jsp.dao.UserDao;
import crud_operation_using_hibernate_servlet_jsp.dto.User;

@WebServlet("/editUser")
public class EditUser extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id= Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		String address=req.getParameter("address");
		long phone= Long.parseLong(req.getParameter("phone"));
		
		User user=new User();
		user.setName(name);
		user.setPhone(phone);
		user.setAddress(address);
		
		UserDao dao=new UserDao();
		dao.updateUser(user, id);
		
		resp.sendRedirect("index.jsp");
		
	}
}
