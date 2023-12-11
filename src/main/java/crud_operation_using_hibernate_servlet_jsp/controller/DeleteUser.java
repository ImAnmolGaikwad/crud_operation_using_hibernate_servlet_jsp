package crud_operation_using_hibernate_servlet_jsp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crud_operation_using_hibernate_servlet_jsp.dao.UserDao;

@WebServlet("/delete")
public class DeleteUser extends HttpServlet{
	 @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		
		UserDao dao=new UserDao();
		dao.deleteUser(id);
		resp.sendRedirect("index.jsp");
	}
}
