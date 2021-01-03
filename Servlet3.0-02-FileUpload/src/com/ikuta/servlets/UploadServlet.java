package com.ikuta.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/uploadServlet")
@MultipartConfig
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取服务端保存的上传文件的目录
		String path = this.getServletContext().getRealPath("/images");
		// 从请求中获取Multipart请求中的上传文件"部分"对象
		Part part = request.getPart("photo");
		
		// 解析出原始文件名
		// 获取指定的头部属性
		String header = part.getHeader("Content-Disposition");
		int index = header.lastIndexOf("=");
		String fileName = header.substring(index + 2, header.length() - 1);
		
		// 完成文件上传
		part.write(path + "/" + fileName);
	}

}
