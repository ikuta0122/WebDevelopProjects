package com.ikuta.servlets;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 1.判断请求是否为multipart请求
        if (!ServletFileUpload.isMultipartContent(request)) {
            throw new RuntimeException("当前请求不支持文件上传");
        }

        try {
            // 2.创建一个FileItem工厂
            DiskFileItemFactory factory = new DiskFileItemFactory();
            // 3.创建文件上传核心组件
            ServletFileUpload upload = new ServletFileUpload(factory);
            // 4.解析请求,获取到所有的item
            List<FileItem> items = upload.parseRequest(request);
            // 5.遍历items
            for (FileItem item : items) {
                if (item.isFormField()) { // 如果item为普通表单项
                    String fieldName = item.getFieldName(); // 获取表单项名称
                    String fieldValue = item.getString(); // 获取表单项的值
                    System.out.println(fieldName + " = " + fieldValue);
                } else { // 如果item为文件表单项
                    // 获取输入流,其中有上传文件的内容
                    InputStream is = item.getInputStream();
                    // 获取上传文件的原始名称
                    String fileName = item.getName();
                    // 获取文件保存在服务器的路径
                    String path = this.getServletContext().getRealPath("/images");
                    // 创建目标文件,将来用于保存上传文件
                    File descFile = new File(path, fileName);
                    // 创建文件输出流
                    OutputStream os = new FileOutputStream(descFile);
                    // 将输入流中的数据写入到输出流中
                    int len;
                    byte[] buffer = new byte[1024];
                    while ((len = is.read(buffer)) != -1) {
                        os.write(buffer, 0, len);
                    }
                    // 关闭流
                    os.close();
                    is.close();
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
    }

}
