package com.itzjx.controller;

import com.itzjx.domain.User;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping(path = "/user")
public class UserController {
    /**
     * SpringMVC文件上传
     *
     * @param upload MultipartFile类型要记，变量名要与index.jsp中input的name属性保持一致
     * @return
     */
    @RequestMapping(path = "/fileupload2")
    public String fileupload2(HttpServletRequest request, MultipartFile upload) throws Exception {
        System.out.println("springmvc文件上传...");
        //使用fileupload组件完成文件上传
        //上传的位置
        System.out.println("上传路径： " + request.getSession().getServletContext().getRealPath("/uploads/"));
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        //判断路径是否存在
        File file = new File(path);
        if (!file.exists()) {
            //创建文件夹
            file.mkdirs();
        }
        //获取上传文件的名称
        String filename = upload.getOriginalFilename();
        //把文件的名称设置为唯一值，uuid
        String uuid = UUID.randomUUID().toString().replace("-", "");
        filename = uuid + "_" + filename;
        //完成文件上传
        upload.transferTo(new File(path,filename));
        return "success";
    }

    /**
     * 跨服务器文件上传
     * @return
     */
    @RequestMapping(path = "/fileupload3")
    public String fileupload3(MultipartFile upload) throws Exception {
        System.out.println("跨服务器文件上传...");
        //定义上传服务器路径
        String path = "http://localhost:9090/fileuploadserver_war/uploads/";
        //获取上传文件的名称
        String filename = upload.getOriginalFilename();
        //把文件的名称设置为唯一值，uuid
        String uuid = UUID.randomUUID().toString().replace("-", "");
        filename = uuid + "_" + filename;
        //完成文件上传

        //1.创建客户端对象
        Client client = Client.create();

        //2.和图片服务器进行连接
        WebResource webResource = client.resource(path + filename);

        //3.上传文件
        webResource.put(upload.getBytes());

        return "success";
    }

    /**
     * 传统的文件上传
     *
     * @return
     */
    @RequestMapping(path = "/fileupload1")
    public String fileupload1(HttpServletRequest request) throws Exception {
        System.out.println("文件上传...");
        //使用fileupload组件完成文件上传
        //上传的位置
        System.out.println("上传路径： " + request.getSession().getServletContext().getRealPath("/uploads/"));
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        //判断路径是否存在
        File file = new File(path);
        if (!file.exists()) {
            //创建文件夹
            file.mkdirs();
        }
        //解析request对象，获取上传文件项。
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        //解析request
        List<FileItem> items = upload.parseRequest(request);
        for (FileItem item : items) {
            //进行判断，当前item对象是否是一个上传文件的选项
            if (item.isFormField()) {
                //普通表单项
            } else {
                //上传文件项
                //获取上传文件的名称
                String filename = item.getName();
                //把文件的名称设置为唯一值，uuid
                String uuid = UUID.randomUUID().toString().replace("-", "");
                filename = uuid + "_" + filename;
                //完成文件上传
                item.write(new File(path, filename));
                //删除临时文件
                item.delete();
            }
        }
        return "success";
    }
}
