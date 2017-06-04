package servlets.zajecia;

import dao.PracownikDao;
import dao.ZajeciaDao;
import model.Person;
import model.Pracownik;
import model.Zajecia;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by mario on 04.06.2017.
 */
@WebServlet(name = "ZDetailsServlet", urlPatterns = "/zDetails")
public class ZDetailsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain;charset=utf-8");
        int id = Integer.parseInt(request.getParameter("id"));
        ZajeciaDao zajeciaDao = (ZajeciaDao) getServletContext().getAttribute("zajeciaDao");
        PracownikDao pracownikDao = (PracownikDao) getServletContext().getAttribute("pracownikDao");

        Zajecia zajecia = zajeciaDao.selectZajeciaByID(id);
        ArrayList<Person> childList = zajeciaDao.getChildListZajecia(id);
        Pracownik pracownik = pracownikDao.selectNauczycielByIdZajecia(id);

        request.setAttribute("childList", childList);
        request.setAttribute("pracownik", pracownik);
        request.setAttribute("zajecia", zajecia);
        request.getRequestDispatcher(request.getContextPath() + "WEB-INF/zajecia/zDetails.jsp").forward(request,response);
    }
}
