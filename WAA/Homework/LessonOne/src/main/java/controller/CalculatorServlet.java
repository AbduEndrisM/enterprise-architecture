package controller;

import service.Calculate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/calculator")
public class CalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int num1 = Integer.parseInt(request.getParameter("num1").trim());
        int num2 = Integer.parseInt(request.getParameter("num2").trim());
        int num11 = Integer.parseInt(request.getParameter("num11").trim());
        int num22 = Integer.parseInt(request.getParameter("num22").trim());

        Calculate c = new Calculate();
        int sum =  c.sum(num1, num2);
        int product = c.product(num11, num22);
    request.setAttribute("sum", sum);
    request.setAttribute("product", product);

        request.setAttribute("num1", num1);
        request.setAttribute("num2", num2);
        request.setAttribute("num11", num11);
        request.setAttribute("num22", num22);

        RequestDispatcher requestDispatcher =  request.getRequestDispatcher("result.jsp");
        requestDispatcher.forward(request, response);


    }
}
