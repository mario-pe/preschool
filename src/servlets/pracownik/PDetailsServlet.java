package servlets.pracownik;

import dao.PracownikDao;
import model.Pracownik;
import model.Umowa;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by mario on 05.06.2017.
 */
@WebServlet(name = "PDetailsServlet")
public class PDetailsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        PracownikDao pracownikDao = (PracownikDao) getServletContext().getAttribute("pracownikDao");

        Pracownik pracownik = pracownikDao.selectPracownik(id);
        ArrayList<Umowa> umowaList = pracownikDao.selectListUmowaByIdPracownik(id);


    }
}
