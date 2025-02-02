package es.albarregas.beans;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import org.hibernate.annotations.DynamicUpdate;

//Anotar como una entidad sino no persiste
@Entity
//Esto es para si quieres poner el nombre de la tabla diferente en la bbdd
@Table(name = "profesoresAnotacion")
//Esta anotación en propia de hibernate, hace la actualización sólo de los campos que cambien
//de forma automática
@DynamicUpdate(true)
public class Profesor implements Serializable {
//asi especificas que el att que venga debajo de esto es el id de la tabla

    //En la columna colum(name = "nombre" nullable = false -> no permite nulos
    //@colum por si quieres que sea distinta, como sel llama la columan en la tabla
    /*
    anotacion con primary key compuesta
     */
    @EmbeddedId
    private Codigo codigo;
    @Column(name = "nombre", length = 20, nullable = false)
    private String nombre;
    @Column(name = "apellido1", length = 15, nullable = false)
    private String apellido1;
    @Column(name = "apellido2", length = 15, nullable = true)
    private String apellido2;
    @Column(name = "escala",
            columnDefinition = "set('s','t') default 's'",
            insertable = false)
    private String escala;
    @Column(name = "fecha",
            columnDefinition = "datetime default now()",
            insertable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar fecha;
    @Transient
    private String fechaFormateada;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getEscala() {
        return escala;
    }

    public void setEscala(String escala) {
        this.escala = escala;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    public String getFechaFormateada() {
        return fechaFormateada;
    }

    public void setFechaFormateada(Calendar fecha) {

        if (fecha != null) {
            SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy HH:mm");
            String formateada = formateador.format(fecha.getTime());
            this.fechaFormateada = formateada;
        }
        
    }

    public Codigo getCodigo() {
        return codigo;
    }

    public void setCodigo(Codigo codigo) {
        this.codigo = codigo;
    }

}
