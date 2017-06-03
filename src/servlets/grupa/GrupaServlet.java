package servlets.grupa;

import dao.GrupaDao;
import model.Grupa;

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
@WebServlet(name = "GrupaServlet", urlPatterns = "/grupa")
public class GrupaServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain;charset=utf-8");
        GrupaDao grupaDao = (GrupaDao) getServletContext().getAttribute("grupaDao");
        ArrayList<Grupa> grupy = grupaDao.getAllGroups();
        request.setAttribute("grupy",grupy);
        request.getRequestDispatcher(request.getContextPath() + "WEB-INF/grupa/grupy.jsp").forward(request, response);
    }
}
