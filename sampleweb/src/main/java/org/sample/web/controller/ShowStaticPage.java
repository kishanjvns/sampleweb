package org.sample.web.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ShowStaticPage {
	@RequestMapping(method = RequestMethod.GET, value = "/showMessage")
	public String showMessage() {
		return "showMessage";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/display")
	public void display(HttpServletResponse response, HttpServletRequest request) throws IOException {
		InputStream in = null;
		OutputStream out = null;
		try {
			String name = request.getParameter("name");
			in = request.getServletContext().getResourceAsStream("/WEB-INF/images/" + name);
			response.setContentType(MediaType.IMAGE_JPEG_VALUE);
			out = response.getOutputStream();
			byte[] buf = new byte[1024];
			int count = 0;
			while ((count = in.read(buf)) >= 0) {
				out.write(buf, 0, count);
			}

		} catch (Exception e) {
			response.setContentType(MediaType.TEXT_HTML_VALUE);
			response.getWriter().write("<h1>please input correct value</h1>");
			response.getWriter().flush();
		}
		try {

		} finally {
			out.close();
			in.close();
		}
	}


}
