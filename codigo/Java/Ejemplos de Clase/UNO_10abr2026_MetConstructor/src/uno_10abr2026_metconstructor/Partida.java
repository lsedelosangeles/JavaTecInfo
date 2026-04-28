/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uno_10abr2026_metconstructor;

import java.util.ArrayList;

/**
 *
 * @author sebastian
 */
public class Partida {
    private ArrayList<Jugador> jugadores = 
            new ArrayList<>();
    private Baraja baraja = new Baraja();
    private int limite;

    public Partida(int limite) {
        this.limite = limite;
        baraja.barajar();
    }
    
    
    public void agregarJugador(Jugador x){
        if ( jugadores.size() < limite ) {
            jugadores.add(x);
            System.out.println
              ("Se añadió a " + x.verNombre());
            
            if (jugadores.size() == limite) {
                System.out.println
                    ("Limite alcanzado");
            }
        }
        else{
            System.out.println
                ("Partida llena, no pudo entrar "+
                        x.verNombre());
        }
    }
    
    public void repartir(){
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < jugadores.size(); j++) {
                Carta x = baraja.obtenerCarta();
                jugadores.get(j).recibirCarta(x);
            }
        }
        
        for (int j = 0; j < jugadores.size(); j++) {
                jugadores.get(j).verMano();
            }
    }
}
