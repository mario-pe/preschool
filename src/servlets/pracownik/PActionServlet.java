package servlets.pracownik;

import dao.GrupaDao;
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
@WebServlet(name = "PActionServlet", urlPatterns = "/pAction")
public class PActionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain;charset=utf-8");
        String id = request.getParameter("id");
        String action = request.getParameter("action");

        if (action.equals("delete")) {
            PracownikDao pd = (PracownikDao) getServletContext().getAttribute("pracownikDao");
            int intId = Integer.parseInt(id);
            if (pd.deletePracownik(intId)) {
                request.setAttribute("info", "pracownik została usunieta");
            } else {
                request.setAttribute("info", "usuniecie sie nie powiodło");
            }
            request.getRequestDispatcher(request.getContextPath() + "/pracownik").forward(request, response);
        } else if (action.equals("edit")) {
            String imie = request.getParameter("imie");
            String nazwisko = request.getParameter("nazwisko");

            request.setAttribute("id", id);
            request.setAttribute("imie", imie);
            request.setAttribute("nazwisko", nazwisko);


            request.getRequestDispatcher(request.getContextPath() + "WEB-INF/pracownik/pEdit.jsp").forward(request, response);
        } else if (action.equals("details")) {
            String stanowisko = request.getParameter("stanowisko");
            request.setAttribute("id", id);
            request.setAttribute("stanowisko", stanowisko);
            request.getRequestDispatcher(request.getContextPath() + "/pDetails").forward(request, response);
        } else if (action.equals("add")) {
            String zawod = request.getParameter("zawod");
            if (zawod.equals("nauczyciel")) {
                request.getRequestDispatcher(request.getContextPath() + "WEB-INF/pracownik/pAddN.jsp").forward(request, response);
            } else if (zawod.equals("opiekunka")) {
                request.getRequestDispatcher(request.getContextPath() + "WEB-INF/pracownik/pAdd.jsp").forward(request, response);
            } else if (zawod.equals("kucharka")) {
                request.getRequestDispatcher(request.getContextPath() + "WEB-INF/pracownik/pAddK.jsp").forward(request, response);
            } else if (zawod.equals("sprzataczka")) {
                request.getRequestDispatcher(request.getContextPath() + "WEB-INF/pracownik/pAddS.jsp").forward(request, response);
            }else {
                request.getRequestDispatcher(request.getContextPath() + "/pracownik").forward(request, response);
            }
        }

    }
}
