package servlets.pracownik;

import dao.GrupaDao;
import dao.PracownikDao;
import dao.ZajeciaDao;
import model.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 * Created by mario on 05.06.2017.
 */
@WebServlet(name = "PDetailsServlet", urlPatterns = "/pDetails")
public class PDetailsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String stanowisko = request.getParameter("stanowisko");
        int id = Integer.parseInt(request.getParameter("id"));
        GrupaDao grupaDao = (GrupaDao) getServletContext().getAttribute("grupaDao");
        ZajeciaDao zajeciaDao = (ZajeciaDao) getServletContext().getAttribute("zajeciaDao");
        PracownikDao pracownikDao = (PracownikDao) getServletContext().getAttribute("pracownikDao");
//        Pracownik pracownik = pracownikDao.selectPracownik(id);
        ArrayList<Umowa> umowaList = pracownikDao.selectListUmowaByIdPracownik(id);


        if (stanowisko.equals("opiekunka")) {
            Opiekunka pracownik = pracownikDao.selectOpiekunkaById(id);
            ArrayList<Grupa> grupas = grupaDao.grupaByIdOpiekunka(id);
            request.setAttribute("pracownik",pracownik);
            request.setAttribute("grupas",grupas);
        }  else if (stanowisko.equals("nauczyciel")) {
            Nauczyciel pracownik = pracownikDao.selectNauczycielById(id);
            ArrayList<Zajecia> zajecias = zajeciaDao.zajeciaByIdNauczyciel(id);
            ArrayList<Grupa> grupas = grupaDao.grupaByIdNauczyciel(id);

            request.setAttribute("pracownik",pracownik);
            request.setAttribute("grupas",grupas);
            request.setAttribute("zajecias",zajecias);

        } else if (stanowisko.equals("kucharka")) {
            Pracownik pracownik = pracownikDao.selectPracownik(id);
            Timestamp date = pracownikDao.selectDateKucharka(id);
            request.setAttribute("element", date);
            request.setAttribute("pracownik",pracownik);
        }else if (stanowisko.equals("sprzataczka")) {
            Pracownik pracownik = pracownikDao.selectPracownik(id);
            int grupaId = pracownikDao.selectGrupaSprzataczkaById(id);
            request.setAttribute("element",grupaId);
            request.setAttribute("pracownik",pracownik);
        }
        request.setAttribute("umowaList",umowaList);
        request.setAttribute("umowy",umowaList);
        request.getRequestDispatcher(request.getContextPath() + "WEB-INF/pracownik/pDetails.jsp").forward(request, response);
    }
}
