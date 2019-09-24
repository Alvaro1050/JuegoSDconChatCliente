/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author alvar
 */
public class Usuario {

    private String nombreUsuario;
    private int tiempo;
    private String mensaje;

    public Usuario(String nombreUsuario, int puntaje) {
        this.nombreUsuario = nombreUsuario;
        this.tiempo = puntaje;
    }

    public Usuario(String nombreUsuario, int tiempo, String mensaje) {
        this.nombreUsuario = nombreUsuario;
        this.tiempo = tiempo;
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int puntaje) {
        this.tiempo = puntaje;
    }

}
