package servlets.dziecko;

import dao.PersonDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by mario on 29.05.2017.
 */
@WebServlet(name = "UEditServlet", urlPatterns = "/uEdit")
public class UEditServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain;charset=utf-8");
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String  city = request.getParameter("city");
        String street  = request.getParameter("street");
        String home = request.getParameter("home");

        PersonDao personDao = (PersonDao) getServletContext().getAttribute("personDao");
        personDao.editChild(id,name,surname,city,street,home);
        request.getRequestDispatcher(request.getContextPath() + "/uczniowie").forward(request,response);
    }
}
