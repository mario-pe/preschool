package servlets.zajecia;

import dao.GrupaDao;
import dao.ZajeciaDao;
import model.Grupa;
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
@WebServlet(name = "ZajeciaServlet", urlPatterns = "/zajecia")
public class ZajeciaServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain;charset=utf-8");
        ZajeciaDao zajeciaDao = (ZajeciaDao) getServletContext().getAttribute("zajeciaDao");
        ArrayList<Zajecia> zajecia = zajeciaDao.getAllZajecia();
        request.setAttribute("zajecia",zajecia);
        request.getRequestDispatcher(request.getContextPath() + "WEB-INF/zajecia/zajecia.jsp").forward(request, response);
    }
}
