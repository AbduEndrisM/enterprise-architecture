package mum.edu.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mum.edu.controller.Controller;

public class DispatcherServlet extends HttpServlet {

	private static final long serialVersionUID = 98279L;

	Map<String, Controller> controllerDispatch = null;

	@Override
	public void init() throws ServletException {

		String configFile = getServletConfig().getInitParameter("configFile");

		LoadServletProperties loadServletProperties = new LoadServletProperties(configFile);
		controllerDispatch = loadServletProperties.loadControllers();

//		controllerDispatch.entrySet().stream()
//				.forEach(e -> System.out.println(e.getKey() + ", " + e.getValue().getClass().getSimpleName()));
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		process(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		process(request, response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		String uri = request.getRequestURI();

		 /*
         * uri is in this form: /contextName/resourceName, 
         * for example: /app10a/product_input. 
         * However, in the case of a default context, the 
         * context name is empty, and uri has this form
         * /resourceName, e.g.: /product_input
         */
		
		int lastIndex = uri.lastIndexOf("/");
		String action = uri.substring(lastIndex);

		System.out.println(uri + "===" + action);
		String dispatchUrl = null;

		Controller controller = controllerDispatch.get(action);
		dispatchUrl = controller.handleRequest(request, response);

		// forward to view
		if (dispatchUrl != null) {
			RequestDispatcher rd = request.getRequestDispatcher(dispatchUrl);
			rd.forward(request, response);
		}
	}
}
