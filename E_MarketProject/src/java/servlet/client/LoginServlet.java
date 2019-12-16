package servlet.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Cart;
import dao.UserDAOImpl;
import java.net.URLEncoder;
import javax.servlet.annotation.WebServlet;

public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private UserDAOImpl userDAO = new UserDAOImpl();
    private List<Cart> cart = new ArrayList<Cart>();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        String err = "";
        if (username.equals("") || password.equals("")) {
            err += "Phải nhập đầy đủ thông tin!";
        } else {
            if (userDAO.login(username, password) == false) {
                err += "Tên đăng nhập hoặc mật khẩu không chính xác!";
            }
        }

        if (err.length() > 0) {
            request.setAttribute("err", err);
        }

        String url = "/login.jsp";
        
            if (err.length() == 0 && (Integer.parseInt(userDAO.getUser(username).getRole())==2)) {
                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                session.setAttribute("cart", cart);
              //  Cookie loginCookie = new Cookie("username", username);
              
            Cookie loginCookie = new Cookie("username", URLEncoder.encode(username, "UTF-8"));
                //setting cookie to expiry in 30 mins
                loginCookie.setMaxAge(30 * 60);
                response.addCookie(loginCookie);
                response.sendRedirect("index.jsp");
                url = "/index.jsp";
            }
            else if(err.length() == 0 && (Integer.parseInt(userDAO.getUser(username).getRole())==1)){
               response.sendRedirect("Welcom");
            }
            else {
                url = "/login.jsp";
                RequestDispatcher rd = getServletContext()
                        .getRequestDispatcher(url);
                rd.forward(request, response);
            }

      
    }

}
