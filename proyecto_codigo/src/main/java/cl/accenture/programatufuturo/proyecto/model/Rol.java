package cl.accenture.programatufuturo.proyecto.model;

public class Rol {
    private Integer id;
    private String nombre;

    public Rol(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    public Rol(){
        this.id=0;
        this.nombre="";
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


}
