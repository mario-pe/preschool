package servlets.zajecia;



import dao.ZajeciaDao;
import model.Zajecia;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by mario on 02.06.2017.
 */
@WebServlet(name = "ZActionServlet", urlPatterns = "/zAction")
public class ZActionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain;charset=utf-8");
        String id = request.getParameter("id");
        String action = request.getParameter("action");

        if (action.equals("delete")) {
            ZajeciaDao zd = (ZajeciaDao) getServletContext().getAttribute("zajeciaDao");
            int intId = Integer.parseInt(id);
            if (zd.deleteZajecia(intId)) {
                request.setAttribute("info", "zajecia zostały usunieta");
            } else {
                request.setAttribute("info", "usuniecie sie nie powiodło");
            }
            request.getRequestDispatcher(request.getContextPath() + "/zajecia").forward(request, response);
        } else if (action.equals("edit")) {
            String przedmiot = request.getParameter("przedmiot");
            String godzina = request.getParameter("godzina");
            String  rok = request.getParameter("rok");

            request.setAttribute("id", id);
            request.setAttribute("przedmiot", przedmiot);
            request.setAttribute("godzina", godzina);
            request.setAttribute("rok", rok);

            request.getRequestDispatcher(request.getContextPath() + "WEB-INF/zajecia/zEdit.jsp").forward(request, response);
        } else if (action.equals("details")) {
            request.getRequestDispatcher(request.getContextPath() + "/zDetails").forward(request, response);
        } else if (action.equals("studentList")) {


        }else if (action.equals("add")) {
            request.getRequestDispatcher(request.getContextPath() + "WEB-INF/zajecia/zAdd.jsp").forward(request, response);
        }
    }
}
