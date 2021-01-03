package com.ikuta.servlets;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 判断请求是否为multipart请求
		if (!ServletFileUpload.isMultipartContent(request)) {
			throw new RuntimeException("当前请求不支持文件上传");
		}
		try {
			// 创建一个FileItem工厂
			DiskFileItemFactory factory = new DiskFileItemFactory();
			// 设置使用临时文件的边界值,单位为字节
			// 大于该值的上传文件会先保存在临时文件中
			// 小于该值的上传文件直接保存在内存中
			int myMaxMemorySize = 1024 * 1024 * 1;// 设置边界值为1M
			factory.setSizeThreshold(myMaxMemorySize);
			// 设置临时文件
			String tempPath = this.getServletContext().getRealPath("/temp");
			File tempFile = new File(tempPath);
			factory.setRepository(tempFile);
			// 创建文件上传核心组件
			ServletFileUpload upload = new ServletFileUpload(factory);
			// 设置每一个item的头部字符编码,用于解决文件名的中文乱码问题
			upload.setHeaderEncoding("UTF-8");
			// 设置单个上传文件的最大边界值
			upload.setFileSizeMax(1024 * 1024 * 2);
			// 设置单次上传所有文件的最大边界值(对于上传多个文件时生效)
			upload.setSizeMax(1024 * 1024 * 5);
			// 解析请求,获取到所有的item
			List<FileItem> items = upload.parseRequest(request);
			// 遍历items
			for (FileItem item : items) {
				if (item.isFormField()) { // 如果item为普通表单项
					String fieldName = item.getFieldName(); // 获取表单项名称
					String fieldValue = item.getString("UTF-8"); // 获取表单项的值
					System.out.println(fieldName + " = " + fieldValue);
				} else { // 如果item为文件表单项
					// 获取输入流,其中有上传文件的内容
					InputStream is = item.getInputStream();
					// 获取上传文件的原始名称
					String fileName = item.getName();
					// 设置文件的新名称,用于解决文件重名问题
					SimpleDateFormat sdfFile = new SimpleDateFormat("yyyy_MM_dd");
					String fileTime = sdfFile.format(new Date());
					fileName = fileTime + "_" + fileName;
					// 获取文件保存在服务器的路径
					String filePath = this.getServletContext().getRealPath("/images");
					// 获取当前系统时间
					Calendar now = Calendar.getInstance();
					// 获取年,月,日
					int year = now.get(Calendar.YEAR);
					int month = now.get(Calendar.MONTH) + 1;
					int day = now.get(Calendar.DAY_OF_MONTH);

					filePath = filePath + "/" + year + "/" + month + "/" + day;
					// 如果该目录不存在,则创建目录
					File dirFile = new File(filePath);
					if (!dirFile.exists()) {
						dirFile.mkdirs();
					}
					// 创建目标文件,将来用于保存上传文件
					File descFile = new File(filePath, fileName);
					// 创建文件输出流
					OutputStream os = new FileOutputStream(descFile);
					// 将输入流中的数据写入到输出流中
					int len = -1;
					byte[] buffer = new byte[1024];
					while ((len = is.read(buffer)) != -1) {
						os.write(buffer, 0, len);
					}
					// 关闭流
					os.close();
					is.close();

					// 删除临时文件
					item.delete();
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
	}

}
