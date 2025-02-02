package es.albarregas.dao;

import es.albarregas.beans.Codigo;
import es.albarregas.beans.Profesor;
import es.albarregas.persistence.HibernateUtil;
import org.hibernate.Session;
import java.util.List;

public class ProfesorDAO implements IProfesorDAO {

    @Override
    public void add(Profesor profesor) {

        Session sesion = null;
        try {
            //Se abre la sesión
            sesion = HibernateUtil.getSessionFactory().openSession();
            //Así se empieza una transacción
            sesion.beginTransaction();
            //Save es insertar
            sesion.save(profesor);
            //Se ejecuta el commit
            sesion.getTransaction().commit();
        } catch (org.hibernate.JDBCException ex) {
            //Para que muestre el error
            ex.printStackTrace();
            //Mejor asegurar que no es nulla
            if (sesion != null) {
                sesion.getTransaction().rollback();
            }
        } finally {
            if (sesion != null) {
                sesion.close();
            }
        }
    }

    @Override
    public List<Profesor> get() {
        Session sesion = null;
        List<Profesor> listaProfesores = null;

        try {
            //Se abre la sesión
            sesion = HibernateUtil.getSessionFactory().openSession();
            //Se inicia la transacción para asegurarse
            listaProfesores = sesion.createQuery("from Profesor").list();
        } catch (org.hibernate.JDBCException ex) {
            //Para que muestre el error
            ex.printStackTrace();
        } finally {
            if (sesion != null) {
                sesion.close();
            }
        }
        return listaProfesores;
    }

    @Override
    public void delete(Profesor profesor) {
        //Si no le pasas el objeto completo no funciona
        // si está vacío no funciona
        Session sesion = null;
        try {
            sesion = HibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();
            sesion.delete(profesor);
            sesion.getTransaction().commit();
        } catch (org.hibernate.JDBCException ex) {
            if (sesion != null) {
                ex.printStackTrace();
                sesion.getTransaction().rollback();
            }
        } finally {
            if (sesion != null) {
                sesion.close();
            }
        }
    }

    @Override
    public Profesor getOne(Codigo codigo) {

        Profesor profesor = null;
        Session sesion = null;
        try {
            sesion = HibernateUtil.getSessionFactory().openSession();
            profesor = (Profesor) sesion.get(Profesor.class, codigo);
        } catch (org.hibernate.JDBCException ex) {
            ex.printStackTrace();
        } finally {
            if (sesion != null) {
                sesion.close();
            }
        }
        return profesor;
    }

    @Override
    public void update(Profesor profesor) {
        Session sesion = null;
        try {
            sesion = HibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();
            sesion.update(profesor);
            sesion.getTransaction().commit();
        } catch (org.hibernate.JDBCException ex) {
            ex.printStackTrace();
            if (sesion != null) {
                sesion.getTransaction().rollback();
            }
        } finally {
            if (sesion != null) {
                sesion.close();
            }
        }
    }

}
