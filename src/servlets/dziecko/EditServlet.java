package servlets.dziecko;

import dao.PersonDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by mario on 28.05.2017.
 */
@WebServlet(name = "EditServlet", urlPatterns = "/uAction")
public class EditServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain;charset=utf-8");
        String id = request.getParameter("id");


        String action = request.getParameter("action");
//        int id = 1;
        if (action.equals("delete")) {
            PersonDao cd = (PersonDao) getServletContext().getAttribute("personDao");
            int intId = Integer.parseInt(id);
            if (cd.deleteChild(intId)) {
                request.setAttribute("info", "usunales dziecko bydlaku !!!!!! ");
            } else {
                request.setAttribute("info", "usuniecie sie nie powiodło");
            }
            request.getRequestDispatcher(request.getContextPath() + "/uczniowie").forward(request, response);
        } else if (action.equals("edit")) {
            String imie = request.getParameter("imie");
            String nazwisko = request.getParameter("nazwisko");
            String miejscowosc = request.getParameter("miejscowosc");
            String ulica = request.getParameter("ulica");
            String dom = request.getParameter("dom");
            request.setAttribute("id", id);
            request.setAttribute("imie", imie);
            request.setAttribute("nazwisko", nazwisko);
            request.setAttribute("miejscowosc", miejscowosc);
            request.setAttribute("ulica", ulica);
            request.setAttribute("dom", dom);
            System.out.println(request.getContextPath() + "WEB-INF/dziecko/uEdit.jsp");
            request.getRequestDispatcher(request.getContextPath() + "WEB-INF/dziecko/uEdit.jsp").forward(request, response);
        } else if (action.equals("details")) {
            request.setAttribute("id", id);
            request.getRequestDispatcher(request.getContextPath() + "/uDetails").forward(request, response);
        } else if (action.equals("add")) {
            request.getRequestDispatcher(request.getContextPath() + "WEB-INF/dziecko/uAdd.jsp").forward(request, response);
        } else if (action.equals("addKeeper")) {
            request.setAttribute("id", id);
            request.getRequestDispatcher(request.getContextPath() + "WEB-INF/dziecko/uAddKeeper.jsp").forward(request, response);
        }

    }
}
