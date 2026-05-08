/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ets_polimorfismo_herencia_ejemplo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

/**
 *
 * @author sebastian
 */
public class Partida {
    
    private UUID id;
    private String nombre;
    private LocalDate marcaTiempo;
    private int estado;
    private int jugadoresMax;
    private Jugador creador;
    ArrayList<Jugador> jugadores;
    private Baraja baraja = new Baraja();

    public Partida(String nombre, int jugadoresMax, Jugador creador) {
        this.creador = creador;
        this.nombre = nombre;
        this.jugadoresMax = jugadoresMax;
        this.jugadores.add(creador);
        
        this.estado = Juego.PARTIDA_ABIERTA;
        this.id = UUID.randomUUID();
        this.marcaTiempo = LocalDate.now();
        
        this.baraja.barajar();
    }
    
    public void agregarJugador(Jugador nuevo){
        if (this.jugadores.size() < this.jugadoresMax) {
            this.jugadores.add(nuevo);
            System.out.println("Se ha unido " + nuevo.getNombre() + "a la partida");
        } else {
        }
    }
    
    public void verJugadores(){
        System.out.println("Partida: " + this.nombre);
        for (Jugador jugador : jugadores) {
            String dato = " - " + jugador.getNombre();
            if (jugador == creador) {
                dato += " - (Creador)";
            }
            System.out.println(dato);
        }
    }
    
}
