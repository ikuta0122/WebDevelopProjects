package com.ikuta.servlets;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置下载文件名
		String fileName = "星野南.jpg";
		// 打散
		byte[] bytes = fileName.getBytes("UTF-8");
		// 组装
		fileName = new String(bytes, "ISO8859-1");
		// 修改相应的头部属性content-disposition为attachment
		response.setHeader("content-disposition", "attachment;filename=" + fileName);
		// 获取链接服务端资源文件的输入流
		InputStream is = this.getServletContext().getResourceAsStream("/resources/aaa.jpg");
		// 获取输出流
		ServletOutputStream os = response.getOutputStream();
		// 将输入流中的数据写入输出流中
		int len = -1;
		byte[] buffer = new byte[1024];
		while ((len = is.read(buffer)) != -1) {
			os.write(buffer, 0, len);
		}
		// 关闭流
		os.close();
		is.close();
	}

}
