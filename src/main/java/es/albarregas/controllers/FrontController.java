package es.albarregas.controllers;

import es.albarregas.beans.Profesor;
import es.albarregas.dao.IProfesorDAO;
import es.albarregas.daoFactory.DAOFactory;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Maria
 */
@WebServlet(name = "FrontController", urlPatterns = {"/FrontController"})
public class FrontController extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DAOFactory daof = DAOFactory.getDAOFactory();
        IProfesorDAO pdao = daof.getProfesorDAO();
        List<Profesor> listaProfesores = null;
        String opcion = request.getParameter("boton");
        //Primero recupero la lista por la opcion pulsada así lo requiere
        listaProfesores = pdao.get();
        String url = "index.jsp";
        Boolean vacia = false;

        if (listaProfesores == null || listaProfesores.isEmpty()) {
            vacia = true;
            request.setAttribute("sms", "La lista se encuentra vacía");
        } else {
            //Si no está vacía por cada profesor establecemos su fechaFormateada
            for (Profesor pro : listaProfesores) {
                if (pro.getFecha() != null) {
                    pro.setFechaFormateada(pro.getFecha());
                }
            }
            request.setAttribute("lista", listaProfesores);
        }

        switch (opcion) {
            case "Create":
                url = "/jsp/create/create.jsp";
                break;
            case "Delete":
                if (!vacia) {
                    url = "/jsp/delete/delete.jsp";
                }
                break;
            case "Update":
                if (!vacia) {
                    url = "/jsp/update/elegirActualizar.jsp";
                }
                break;
            case "Read":
                if (!vacia) {
                    url = "/jsp/read/read.jsp";
                }
                break;

        }
        request.getRequestDispatcher(url).forward(request, response);

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
