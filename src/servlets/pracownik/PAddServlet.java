package servlets.pracownik;

import dao.GrupaDao;
import dao.PracownikDao;
import model.Pracownik;
import model.Umowa;
import utils.methods.utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by mario on 30.05.2017.
 */
@WebServlet(name = "PAddServlet", urlPatterns = "/pAdd")
public class PAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain;charset=utf-8");

        String imie = request.getParameter("imie");
        String nazwisko = request.getParameter("nazwisko");
        String stanowisko = request.getParameter("stanowisko");
        String type = request.getParameter("type");
        String date = request.getParameter("date");
//        utils.converterStringToTimestamp(date);
        PracownikDao pracownikDao = (PracownikDao) getServletContext().getAttribute("pracownikDao");
        pracownikDao.addPracownik(imie, nazwisko);
        pracownikDao.addUmowa(type, date);
        Umowa umowa = pracownikDao.selectUmowa(type, date);
        Pracownik pracownik = pracownikDao.selectPracownik(imie, nazwisko);
        int id = pracownik.getId();
        pracownikDao.addPodpisuje(id, umowa.getId());
        if (stanowisko.equals("opiekunka")) {
            String specjalnosc = request.getParameter("specjalnosc");
            pracownikDao.addOpiekunka(id, specjalnosc);
        } else if (stanowisko.equals("kucharka")) {
            String badania = request.getParameter("badania");
            pracownikDao.addKucharka(id, badania);
        } else if (stanowisko.equals("nauczyciel")) {
            String przedmiot = request.getParameter("przedmiot");
            String stopien = request.getParameter("stopien");
            pracownikDao.addNauczyciel(id, stopien, przedmiot);
        } else if (stanowisko.equals("sprzataczka")) {
            pracownikDao.addSprzataczka(id);
        }
        request.getRequestDispatcher(request.getContextPath() + "/pracownik").forward(request, response);
    }
}
