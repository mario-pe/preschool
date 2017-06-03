package servlets.grupa;

import dao.GrupaDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by mario on 30.05.2017.
 */
@WebServlet(name = "GAddServlet", urlPatterns = "/gAdd")
public class GAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain;charset=utf-8");

        String kat = request.getParameter("kat");
        int sala = Integer.parseInt(request.getParameter("sala"));
        String rok = request.getParameter("rok");
        GrupaDao grupaDao = (GrupaDao) getServletContext().getAttribute("grupaDao");
        grupaDao.addGrupa(kat,sala,rok);
        request.getRequestDispatcher(request.getContextPath() + "/grupa").forward(request,response);
    }
}
