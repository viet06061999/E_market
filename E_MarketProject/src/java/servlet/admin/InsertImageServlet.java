/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.admin;

import dao.CategoryDAOImpl;
import dao.ProductDAOImpl;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Product;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author lovelan
 */
public class InsertImageServlet extends HttpServlet {

    ProductDAOImpl productService = new ProductDAOImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

     
        int id=0;
        String file_image;
        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);

        try {
            List<FileItem> items = servletFileUpload.parseRequest(req);

            for (FileItem item : items) {
                if (item.getFieldName().equals("id")) {
                    id = Integer.parseInt(item.getString());
                } else if (item.getFieldName().equals("image")) {
                    String itemName = item.getName();
                    String fileName = itemName.substring(itemName.lastIndexOf("\\") + 1);
                    String realPath = getServletContext().getRealPath("/") + "sanpham\\" + fileName;
                    File storeFile = new File(realPath);

                    // saves the file on disk
                    item.write(storeFile);
                  file_image=fileName;
                 Product p= productService.getProduct(id);
                if(file_image!=null) {p.setHinh_anh(file_image);}
                  productService.update(p);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(InsertImageServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
          
        resp.sendRedirect(req.getContextPath() + "/ProductListServlet");
    }

}
