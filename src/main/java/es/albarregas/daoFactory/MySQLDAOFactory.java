
package es.albarregas.daoFactory;
 
import es.albarregas.dao.IProfesorDAO;
import es.albarregas.dao.ProfesorDAO;


/**
 *
 * @author Maria
 */
public class MySQLDAOFactory extends DAOFactory {

    @Override
    public IProfesorDAO getProfesorDAO() {
        return new ProfesorDAO();
    }
}
