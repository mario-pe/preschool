package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by mario on 28.05.2017.
 */
@WebServlet(name = "IndexServlet", urlPatterns = "/index")
public class IndexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain;charset=utf-8");
//        String action = request.getParameter("action");
//        ArrayList<Child> children;
//        if (action.equals("uczniowie")) {
//            ChildDao childDao = (ChildDao) getServletContext().getAttribute("childDao");
//            if (request.getSession().getAttribute("children") == null) {
//                children = childDao.getData();
//                request.getSession().setAttribute("children", children);
//            }
//            request.getRequestDispatcher(request.getContextPath() + "uczniowie.jsp");
//        }
//        else
//            children = (ArrayList<Child>) request.getSession().getAttribute("children");

    }
}
