package com.company.fingoals.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/*")
public class AuthenticationFilter implements Filter {

	private static final String[] allowedUrls = { "html", "css", "js",
			"login.jsp","register.jsp", "validateUser", "logout" };

	private ServletContext context;

	public void init(FilterConfig fConfig) throws ServletException {
		this.context = fConfig.getServletContext();
		this.context.log("AuthenticationFilter initialized");
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		String uri = req.getRequestURI();
		this.context.log("Requested Resource::" + uri);

		HttpSession session = req.getSession(false);

		if (session != null) {
			if (session.getAttribute("user") != null) {
				chain.doFilter(request, response);
				return;
			}
		}

		boolean isUnprotected = false;

		for (int i = 0; i < allowedUrls.length; i++) {
			isUnprotected = uri.endsWith(allowedUrls[i]);
			if (isUnprotected)
				break;
		}

		if (!(isUnprotected)) {
			this.context.log("Unauthorized access request");
			res.sendRedirect("login.jsp");
		} else {
			// pass the request along the filter chain
			this.context.log("Unprotected");
			chain.doFilter(request, response);
		}

	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		this.context.log("filter is getting destroyed");
	}

}
