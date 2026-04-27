/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package uno_10abr2026_metconstructor;

/**
 *
 * @author sebastian
 */
public class UNO_10abr2026_MetConstructor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Jugador uno = new Jugador("Pepito");
        Jugador dos = new Jugador("Anita");
        Jugador tres = new Jugador("Carlitos");
        Jugador cuatro = new Jugador("Pedrito");
        
        Partida sala1 = new Partida(4);
        sala1.agregarJugador(uno);
        sala1.agregarJugador(dos);
        sala1.agregarJugador(tres);
        sala1.agregarJugador(cuatro);
        
        sala1.repartir();
    }

}
