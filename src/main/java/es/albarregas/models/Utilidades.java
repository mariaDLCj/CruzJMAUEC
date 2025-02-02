
package es.albarregas.models;

import java.util.Enumeration;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Maria
 */
public class Utilidades {
    
    public static Boolean campoVacio(Enumeration <String> nombres,List <String> camposOpcionales, HttpServletRequest request){
        Boolean vacio = false;
          while (nombres.hasMoreElements()) {
                String nombre = nombres.nextElement();
                String valor = request.getParameter(nombre);
                if (valor.isEmpty() && !camposOpcionales.contains(nombre)) {
                    vacio = true;
                }
            }
            
           return vacio;
    }
    
}
