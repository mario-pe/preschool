package servlets.zajecia;

import dao.GrupaDao;
import dao.ZajeciaDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by mario on 02.06.2017.
 */
@WebServlet(name = "ZEditServlet", urlPatterns = "/zEdit")
public class ZEditServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain;charset=utf-8");
        int id = Integer.parseInt(request.getParameter("id"));
        String przedmiot = request.getParameter("przedmiot");
        String godzina = request.getParameter("godzina");
        String rok = request.getParameter("rok");
        ZajeciaDao zajeciaDao = (ZajeciaDao) getServletContext().getAttribute("zajeciaDao");
        zajeciaDao.editZajecia(id,przedmiot ,godzina,rok);
        request.getRequestDispatcher(request.getContextPath() + "/zajecia").forward(request,response);
    }
}
