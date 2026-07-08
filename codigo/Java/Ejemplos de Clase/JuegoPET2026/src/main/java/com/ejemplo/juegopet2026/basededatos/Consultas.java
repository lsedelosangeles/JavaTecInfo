/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejemplo.juegopet2026.basededatos;

import com.ejemplo.juegopet2026.juego.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author sebastian
 */
public class Consultas {
    
    /**
     * Registra un usuario en el sistema
     * @param usuario
     * @return 
     */
    public String registrarUsuario(Usuario usuario){
        String resultado = "";
        String consulta = "INSERT INTO usuario(nombre) values (?)";
        Connection conexion = Conexion.conectar();
        
        if (conexion!=null) {
            try {
                PreparedStatement sentencia = conexion.prepareStatement(consulta);
                
                sentencia.setString(1, usuario.getNombre());
                sentencia.execute();
                resultado = "OK";
                
                sentencia.close();
                conexion.close();
            } catch (SQLException e) {
                resultado = "ERROR: " + e.getMessage();
            }
        }
        
        return resultado;
    }
    
    /**
     * Busca un usuario en el sistema usando su nombre
     * @param nombre
     * @return 
     */
    public Usuario buscarUsuario(String nombre){
        Usuario user = null;
        
        String consulta = "SELECT id,nombre FROM usuario WHERE nombre=?";
        
        Connection conexion = Conexion.conectar();
        
        if (conexion != null) {
            try {
                PreparedStatement sentencia = conexion.prepareStatement(consulta);
                sentencia.setString(1, nombre);
                
                ResultSet resultados = sentencia.executeQuery();
                
                while(resultados.next()){
                    String nombreU = resultados.getString("nombre");
                    int idU = resultados.getInt("id");
                    user = new Usuario(nombreU, idU);
                }
                
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(),"Error SQL",JOptionPane.ERROR_MESSAGE);
            }
        }
        
        return user;
    }
    
    
    /**
     * Busca un usuario en el sistema usando su id
     * @param nombre
     * @return 
     */
    public Usuario buscarUsuario(int id){
        Usuario user = null;
        
        String consulta = "SELECT id,nombre FROM usuario WHERE id=?";
        
        Connection conexion = Conexion.conectar();
        
        if (conexion != null) {
            try {
                PreparedStatement sentencia = conexion.prepareStatement(consulta);
                sentencia.setInt(1, id);
                
                ResultSet resultados = sentencia.executeQuery();
                
                while(resultados.next()){
                    String nombreU = resultados.getString("nombre");
                    int idU = resultados.getInt("id");
                    user = new Usuario(nombreU, idU);
                }
                
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(),"Error SQL",JOptionPane.ERROR_MESSAGE);
            }
        }
        
        return user;
    }
}
