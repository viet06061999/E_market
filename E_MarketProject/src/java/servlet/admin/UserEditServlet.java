package servlet.admin;

import dao.UserDAO;
import dao.UserDAOImpl;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UserEditServlet extends HttpServlet {

    UserDAO userService = new UserDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        User user = userService.getUser(id);
        req.setAttribute("user", user);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/view/edit-user.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
           req.setCharacterEncoding("utf-8");
              resp.setCharacterEncoding("utf-8");
        User user = new User();          
             user.setUser_id(Integer.parseInt(req.getParameter("id")));
             user.setEmail(req.getParameter("email"));
             user.setDiachi(req.getParameter("diachi"));
             user.setPassword(req.getParameter("password"));
             user.setSdt(req.getParameter("sdt"));
             user.setRole(req.getParameter("role"));
            userService.updateUser(user);
            resp.sendRedirect(req.getContextPath() + "/UserListServlet");


    }
}

