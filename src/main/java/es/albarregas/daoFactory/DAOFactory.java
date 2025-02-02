package es.albarregas.daoFactory;

import es.albarregas.dao.IProfesorDAO;

/**
 *
 * @author Maria
 */
public abstract class DAOFactory {

    /**
     * Una clase abstracta por cada tabla de la base de datos
     *
     * @return Inteface de las operaciones a realizar con la tabla
     */
    public abstract IProfesorDAO getProfesorDAO();

    /**
     * Fábrica abstracta, cambia al haber más de una fuente de datos
     *
     * @return Objeto de la fábrica abstracta
     */
    public static DAOFactory getDAOFactory() {
        DAOFactory daof = null;

        daof = new MySQLDAOFactory();

        return daof;
    }

}
