package es.albarregas.beans;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 *
 * @author paco
 */

@Entity
@Table(name = "profesoresAnotaciones")
public class Profesor implements Serializable {

    @Id
    @GeneratedValue(generator = "generador")
    @GenericGenerator(name = "generador", strategy = "foreign", parameters = @Parameter(name = "property", value = "direccion"))
    @Column(name = "idProf")
    private int id;

    @Column(name = "nombre", length = 20, nullable = false)
    private String nombre;

    @Column(name = "ape1", length = 15, nullable = false)
    private String ape1;

    @Column(name = "ape2", length = 15, nullable = true)
    private String ape2;

    @Column(name = "escala", columnDefinition = "set('s', 't') default 's'", insertable = false, updatable = true)
    private String escala;

    @Column(name = "fecha", columnDefinition = "datetime default now()", insertable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar fecha;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Direccion direccion;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApe1() {
        return ape1;
    }

    public void setApe1(String ape1) {
        this.ape1 = ape1;
    }

    public String getApe2() {
        return ape2;
    }

    public void setApe2(String ape2) {
        this.ape2 = ape2;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }
    
    

}
