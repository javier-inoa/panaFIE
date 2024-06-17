package panafie.fie.model.moderator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "moderator")
public class moderator {

    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    private String rol = "moderador";
    private int cantidadJuegos;


    public moderator() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public int getCantidadJuegos() {
        return cantidadJuegos;
    }

    public void setCantidadJuegos(int cantidadJuegos) {
        this.cantidadJuegos = cantidadJuegos;
    }


    public void login() {

    }

    public void sortearPasanaku() {

    }

    public void visualizarPasanaku() {

    }

    public void enviarComentarioJugadores() {

    }

    public void notificarAdministrador() {

    }

    public void controlPagos() {

    }
}
