package es.albarregas.controllers;

import es.albarregas.beans.Codigo;
import es.albarregas.beans.Profesor;
import es.albarregas.dao.IProfesorDAO;
import es.albarregas.daoFactory.DAOFactory;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Maria
 */
@WebServlet(name = "Delete", urlPatterns = {"/Delete"})
public class Delete extends HttpServlet {

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
        String url = "index.jsp";
        Profesor profesor = null;
        Codigo codigoRecuperado = null;

        if (request.getParameter("eliminar") != null) {
            url = "/jsp/delete/confirmar.jsp";

            String codigo = request.getParameter("idProfesor");
            if (codigo != null && !codigo.isEmpty()) {
                String[] codPartido = codigo.split("_");
                Integer id = Integer.parseInt(codPartido[0]);
                String tipo = codPartido[1];
                codigoRecuperado = new Codigo();
                codigoRecuperado.setId(id);
                codigoRecuperado.setTipo(tipo);
            }
            profesor = pdao.getOne(codigoRecuperado);

            if (profesor != null) {
                if (profesor.getFecha() != null) {
                    profesor.setFechaFormateada(profesor.getFecha());
                }
                //lo establezco en la sesión
                request.getSession().setAttribute("profesorEliminar", profesor);
            }

        }

        if (request.getParameter("confirmarElminiar") != null) {
            //Comprobar que el profesor no venga nullo
            profesor = (Profesor) request.getSession().getAttribute("profesorEliminar");
            if (profesor != null) {
                pdao.delete(profesor);
                request.getSession().removeAttribute("profesor");
            }
        }

        if (request.getParameter("cancelar") != null) {
            //Hay que borrar la sesión si se cancela
            if (request.getSession().getAttribute("profesorEliminar") != null) {
                request.getSession().removeAttribute("profesorEliminar");
            }
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
