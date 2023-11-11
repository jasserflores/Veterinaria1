package com.example.veterinaria1;

public class Registro {

    int id;

    String Nombre;

    String Telefono;

    String Ciudad;

    String Email;

    String Tipo;

    public Registro(){

    }

    public Registro(String nombre, String telefono, String ciudad, String email, String tipo) {
        Nombre = nombre;
        Telefono = telefono;
        Ciudad = ciudad;
        Email = email;
        Tipo = tipo;
    }

    public Registro(int id, String nombre, String telefono, String ciudad, String email, String tipo) {
        this.id = id;
        Nombre = nombre;
        Telefono = telefono;
        Ciudad = ciudad;
        Email = email;
        Tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public String getCiudad() {
        return Ciudad;
    }

    public void setCiudad(String ciudad) {
        Ciudad = ciudad;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }
}
