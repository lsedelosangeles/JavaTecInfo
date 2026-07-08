/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejemplo.juegopet2026.sistema.mensajes;

/**
 *
 * @author sebastian
 */
public class Informacion {
    
    //Atributos con las palabras claves fijas para usar en el sistema
    public static final String LOGIN = "LOGIN";
    public static final String LOGIN_OK = "LOGIN_OK";
    public static final String LOGIN_ERROR = "LOGIN_ERROR";
    public static final String LOGOUT = "LOGOUT";
    public static final String REGISTRAR = "REGISTRAR";
    public static final String REGISTRO_OK = "REGISTRO_OK";
    public static final String REGISTRO_ERROR = "REGISTRO_ERROR";
    public static final String MENSAJE = "MENSAJE";
    public static final String USUARIO_ID = "USUARIO_ID";
    public static final String SESION_ID = "SESION_ID";
    
    private String accion;
    private String datos;

    /**
     * @return the accion
     */
    public String getAccion() {
        return accion;
    }

    /**
     * @param accion the accion to set
     */
    public void setAccion(String accion) {
        this.accion = accion;
    }

    /**
     * @return the datos
     */
    public String getDatos() {
        return datos;
    }

    /**
     * @param datos the datos to set
     */
    public void setDatos(String datos) {
        this.datos = datos;
    }
    
    
}
