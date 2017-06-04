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
            PersonDao personDao = (PersonDao) getServletContext().getAttribute("personDao");
            int intId = Integer.parseInt(id);
            if (personDao.deleteChild(intId)) {
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
        } else if (action.equals("deleteKeeper")) {
            PersonDao personDao = (PersonDao) getServletContext().getAttribute("personDao");
            int intId = Integer.parseInt(request.getParameter("id"));
            int intIdk = Integer.parseInt(request.getParameter("idk"));
            personDao.deleteOpiekaKeeperIDChildID(intIdk, intId);
            if (personDao.deleteKeeper(intIdk)) {
                request.setAttribute("info", "usunales opiekuna ");
            } else {
                request.setAttribute("info", "usuniecie sie nie powiodło");
            }
            request.setAttribute("id", id);
            request.getRequestDispatcher(request.getContextPath() + "/uDetails").forward(request, response);
        } else if (action.equals("addGrupa")) {
            PersonDao personDao = (PersonDao) getServletContext().getAttribute("personDao");
            int intId = Integer.parseInt(request.getParameter("id"));
            int intIdG = Integer.parseInt(request.getParameter("id_grupy"));
            int intN = 3;
            int idO = 2;
            int idS = 7;
            personDao.setChildToGrup(intId, intIdG, intN, idO, idS);
            request.setAttribute("id", id);
            request.getRequestDispatcher(request.getContextPath() + "/uDetails").forward(request, response);

        } else if (action.equals("addZajecia")) {
            PersonDao personDao = (PersonDao) getServletContext().getAttribute("personDao");
            int intId = Integer.parseInt(request.getParameter("id"));
            int intIdZ = Integer.parseInt(request.getParameter("id_zajecia"));
            int intN = 3;
            personDao.setChildToZajecia(intN, intIdZ, intId);
            request.setAttribute("id", id);
            request.getRequestDispatcher(request.getContextPath() + "/uDetails").forward(request, response);
        }else if (action.equals("deleteFromGrupa")) {
            PersonDao personDao = (PersonDao) getServletContext().getAttribute("personDao");
            int intIdD = Integer.parseInt(request.getParameter("id"));
            int intIdG = Integer.parseInt(request.getParameter("idG"));
            personDao.deleteChildFromGroup(intIdD, intIdG);
            request.setAttribute("id", id);
            request.getRequestDispatcher(request.getContextPath() + "/uDetails").forward(request, response);
        }else if (action.equals("deleteFromZajecia")) {
            PersonDao personDao = (PersonDao) getServletContext().getAttribute("personDao");
            int intIdD = Integer.parseInt(request.getParameter("id"));
            int intIdZ = Integer.parseInt(request.getParameter("idZ"));
            personDao.deleteChildFromZajecia(intIdD, intIdZ);
            request.setAttribute("id", id);
            request.getRequestDispatcher(request.getContextPath() + "/uDetails").forward(request, response);
        }
    }
}
