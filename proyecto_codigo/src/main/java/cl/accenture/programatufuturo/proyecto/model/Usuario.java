package cl.accenture.programatufuturo.proyecto.model;

import java.util.Date;

public class Usuario {
    private int id, telefono;
    private String nombre, email, contraseña, nacionalidad, rut, genero;
    private Date ultimoLogin, fechaNac;
    private Rol rol;

    public Usuario(int id, int telefono, String nombre, String email, String contraseña, String nacionalidad, String rut, String genero, Date ultimoLogin, Date fechaNac, Rol rol) {
        this.id = id;
        this.nombre = nombre;
        this.rut = rut;
        this.telefono = telefono;
        this.email = email;
        this.nacionalidad = nacionalidad;
        this.genero = genero;
        this.ultimoLogin = ultimoLogin;
        this.fechaNac = fechaNac;
        this.rol = rol;
        this.contraseña = contraseña;
    }

    public String getNombre() {
        return nombre;
    }

    public String getContraseña() {
        return contraseña;
    }
}
