package servlets.dziecko;

import dao.PersonDao;
import model.Grupa;
import model.Person;
import model.Zajecia;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by mario on 02.06.2017.
 */
@WebServlet(name = "uDetailsServlet", urlPatterns = "/uDetails")
public class uDetailsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        PersonDao personDao = (PersonDao) getServletContext().getAttribute("personDao");
        ArrayList<Person> opiekunowie =  personDao.getKeeper(id);
        ArrayList<Grupa> grupa =  personDao.getGrupaDziecko(id);
        ArrayList<Zajecia> zajecia =  personDao.getZajeciaDziecko(id);


        request.setAttribute("opiekunowie",opiekunowie);
        request.setAttribute("grupa",grupa);
        request.setAttribute("zajecia",zajecia);
        request.getRequestDispatcher(request.getContextPath() + "WEB-INF/dziecko/uDetails.jsp").forward(request, response);
    }
}
