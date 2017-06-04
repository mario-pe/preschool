package servlets.grupa;

import dao.GrupaDao;
import dao.PersonDao;
import dao.PracownikDao;
import model.Person;
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
@WebServlet(name = "GDetailsServlet", urlPatterns = "/gDetails")
public class GDetailsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain;charset=utf-8");
        String id1 = request.getParameter("id");
        int id = Integer.parseInt(id1);
        GrupaDao grupaDao = (GrupaDao) getServletContext().getAttribute("grupaDao");
        PracownikDao pracownikDao = (PracownikDao) getServletContext().getAttribute("pracownikDao");
        PersonDao personDao = (PersonDao) getServletContext().getAttribute("personDao");

        ArrayList<Person> childList = personDao.getChildrenListGrupa(id);
        ArrayList<Pracownik> nauczycielList = pracownikDao.selectNauczycielByIdGrupa(id);
        ArrayList<Pracownik> opiekunList = pracownikDao.selectOpiekunByIdGrupa(id);
        Pracownik sprzataczka = pracownikDao.selectSprzataczkaByIdGrupa(id);

        request.setAttribute("id",id1);
        request.setAttribute("childList",childList);
        request.setAttribute("opiekunList",opiekunList);
        request.setAttribute("nauczycielList",nauczycielList);
        request.setAttribute("sprzataczka",sprzataczka);


        request.getRequestDispatcher(request.getContextPath() + "WEB-INF/grupa/gDetails.jsp").forward(request,response);
    }
}
