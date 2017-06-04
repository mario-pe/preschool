package servlets.grupa;

import dao.GrupaDao;
import dao.PersonDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by mario on 30.05.2017.
 */
@WebServlet(name = "GActionServlet", urlPatterns = "/gAction")
public class GActionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain;charset=utf-8");
        String id = request.getParameter("id");
        String action = request.getParameter("action");

        if (action.equals("delete")) {
            GrupaDao gd = (GrupaDao) getServletContext().getAttribute("grupaDao");
            int intId = Integer.parseInt(id);
            if (gd.deleteGrupa(intId)) {
                request.setAttribute("info", "Grupa została usunieta");
            } else {
                request.setAttribute("info", "usuniecie sie nie powiodło");
            }
            request.getRequestDispatcher(request.getContextPath() + "/grupa").forward(request, response);
        } else if (action.equals("edit")) {
            String kat = request.getParameter("kat");
            String sala = request.getParameter("sala");
            String  rok = request.getParameter("rok");

            request.setAttribute("id", id);
            request.setAttribute("kat", kat);
            request.setAttribute("sala", sala);
            request.setAttribute("rok", rok);

            request.getRequestDispatcher(request.getContextPath() + "WEB-INF/grupa/gEdit.jsp").forward(request, response);
        } else if (action.equals("details")) {

            request.setAttribute("id",id);
            request.getRequestDispatcher(request.getContextPath() + "/gDetails").forward(request, response);
        } else if (action.equals("deleteChild")) {
            int intIdG = Integer.parseInt(id);
            int intIdC = Integer.parseInt(request.getParameter("idC"));

            PersonDao personDao = (PersonDao) getServletContext().getAttribute("personDao");
            personDao.deleteChildFromGroup(intIdC,intIdG);
            request.setAttribute("id", id);

        }else if (action.equals("add")) {
            request.getRequestDispatcher(request.getContextPath() + "WEB-INF/grupa/gAdd.jsp").forward(request, response);
        }
    }
}
