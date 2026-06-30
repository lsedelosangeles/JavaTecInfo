/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejemplo.juegopet2026.basededatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author sebastian
 */
public class Conexion {
    private static final String BASE = "jdbc:mysql://localhost:3306/juego_pet_2026";
    private static final String USUARIO = "estudiante";
    private static final String PASSWORD = "estudiante";
    
    
    /**
     * Establece una conexión con la base de datos
     * @return 
     */
    public static Connection conectar(){
        Connection conexion = null;
        try {
            conexion = DriverManager.getConnection(BASE, USUARIO, PASSWORD);
            System.out.println("Base de Datos: Conexión Exitosa");
        } catch (SQLException e) {
            System.err.println("ERROR. Base de Datos: " + e.getMessage());
        }
        return conexion;
    }
}
