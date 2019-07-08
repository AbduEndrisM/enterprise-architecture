package edu.mum.cs544;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "StudentsCourseServlet", urlPatterns = "/StudentsCourseServlet")
public class StudentsCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String studentIdStr = request.getParameter("studentid");
		
		long studentid = -1;
		Student student = null;
		
		if (studentIdStr != null && studentIdStr.matches("\\d+")) {
			studentid = Long.parseLong(studentIdStr);
			StudentService studentService = new StudentService();
			student = studentService.getStudent(studentid);
		}
		
		request.setAttribute("student", student);
		request.getRequestDispatcher("student.jsp").forward(request, response);		

	}

}
