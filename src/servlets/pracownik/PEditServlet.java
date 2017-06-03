package servlets.pracownik;

import dao.PracownikDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by mario on 30.05.2017.
 */
@WebServlet(name = "PEditServlet", urlPatterns = "/pEdit")
public class PEditServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain;charset=utf-8");
        int id = Integer.parseInt(request.getParameter("id"));
        String imie = request.getParameter("imie");
        String nazwisko = request.getParameter("nazwisko");
        PracownikDao pracownikDao = (PracownikDao) getServletContext().getAttribute("pracownikDao");
        pracownikDao.editPracownik(id,imie,nazwisko);
        request.getRequestDispatcher(request.getContextPath() + "/pracownik").forward(request,response);



    }
}
