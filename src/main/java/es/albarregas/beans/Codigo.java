package es.albarregas.beans;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Maria
 */
@Embeddable
public class Codigo implements Serializable {

    @Column(name = "id")
    private Integer id;
    @Column(name = "tipo")

    private String tipo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Codigo other = (Codigo) obj;
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }

}
