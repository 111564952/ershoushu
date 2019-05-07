package ershoushu.servlet;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ershoushu.dao.*;
import ershoushu.util.Page;

public class BaseForeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected CategoryDAO categoryDAO = new CategoryDAO();
	protected OrderDAO orderDAO = new OrderDAO();
	protected OrderItemDAO orderItemDAO = new OrderItemDAO();
	protected ProductDAO productDAO = new ProductDAO();
	protected ProductImageDAO productImageDAO = new ProductImageDAO();
	protected PropertyDAO propertyDAO = new PropertyDAO();
	protected PropertyValueDAO propertyValueDAO = new PropertyValueDAO();
	protected ReviewDAO reviewDAO = new ReviewDAO();
	protected UserDAO userDAO = new UserDAO();

	public BaseForeServlet() {
		super();

	}

	public void service(HttpServletRequest request, HttpServletResponse response) {
		try {
			int start = 0;
			int count = 10;
			try {
				start = Integer.parseInt(request.getParameter("page.start"));
			} catch (Exception e) {
				// TODO: handle exception
			}
			try {
				count = Integer.parseInt(request.getParameter("page.count"));
			} catch (Exception e) {
				// TODO: handle exception
			}
			Page page = new Page(start, count);

			String method = (String) request.getAttribute("method");
			Method m = this.getClass().getMethod(method, javax.servlet.http.HttpServletRequest.class,
					javax.servlet.http.HttpServletResponse.class, Page.class);
			String redirect = m.invoke(this, request, response, page).toString();
			if (redirect.startsWith("@"))
				response.sendRedirect(redirect.substring(1));
			else if (redirect.startsWith("%"))
				response.getWriter().print(redirect.substring(1));
			else
				request.getRequestDispatcher(redirect).forward(request, response);

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
