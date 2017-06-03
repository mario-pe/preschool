package servlets.pracownik;

import dao.GrupaDao;
import dao.PracownikDao;
import model.Grupa;
import model.Pracownik;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by mario on 30.05.2017.
 */
@WebServlet(name = "PracownikServlet", urlPatterns = "/pracownik")
public class PracownikServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain;charset=utf-8");
        PracownikDao pracownikDao = (PracownikDao) getServletContext().getAttribute("pracownikDao");
        ArrayList<Pracownik> pracownicy = pracownikDao.getAllPracownicy();
        request.setAttribute("pracownicy",pracownicy);
        request.getRequestDispatcher(request.getContextPath() + "WEB-INF/pracownik/pracownicy.jsp").forward(request, response);
    }
}
