package servlets.dziecko;

import dao.PersonDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by mario on 30.05.2017.
 */
@WebServlet(name = "uAddServlet", urlPatterns = "/uAdd")
public class uAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain;charset=utf-8");
//
        String type = request.getParameter("type");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String city = request.getParameter("city");
        String street = request.getParameter("street");
        String home = request.getParameter("home");
        PersonDao personDao = (PersonDao) getServletContext().getAttribute("personDao");
        if (type.equals("child")){
            personDao.addChild(name, surname, city, street, home);
            request.getRequestDispatcher(request.getContextPath() + "/uczniowie").forward(request, response);
        }
        else { //(type.equals("keeper"))
            int idChild = Integer.parseInt(request.getParameter("id"));
            personDao.addKeeper(name, surname, city, street, home);
            int idKeeper = personDao.getKeeper(name, surname, city, street, home);
            personDao.reltationChildKeeper(idChild,idKeeper);
            String id = request.getParameter("id");
            request.setAttribute("id", id);
            request.getRequestDispatcher(request.getContextPath() + "/uDetails").forward(request, response);
        }



    }
}
