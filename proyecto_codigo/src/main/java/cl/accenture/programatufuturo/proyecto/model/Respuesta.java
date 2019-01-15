package cl.accenture.programatufuturo.proyecto.model;

import java.util.Date;

public class Respuesta {

    private int id;
    private String comentario;
    private Usuario usuario;
    private Date fecha;

    public int getId() {
        return id;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario){
       this.comentario = comentario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha){
        this.fecha = fecha;
    }

    public int compareTo(Date o){
        return getFecha().compareTo(o.getFecha());
    }
}

