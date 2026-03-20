/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laberinto01;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

/**
 *
 * @author sebastian
 */
public class Mapa extends JPanel {
    
    Cuadro[][] casilleros;    
    double[][] elevaciones;
    
    int max_cuadros_y = 30;
    int max_cuadros_x = 50;
    int alto_cuadros = 0;
    
    int posicionJugadorX = 0;
    int posicionJugadorY = 0;
    
    public Mapa(int dimX, int dimY, int altoCuadros) {
        this.setBounds(0, 0, dimX, dimY);
        this.setLayout(null);
        
        this.alto_cuadros = altoCuadros;
        
        casilleros = new Cuadro[max_cuadros_x][max_cuadros_y];
        
        for (int i = 0; i < max_cuadros_y; i++) {
            for (int j = 0; j < max_cuadros_x; j++) {
                int posX = j * alto_cuadros;
                int posY = i * alto_cuadros;
                Cuadro c = new Cuadro(alto_cuadros, posX, posY);
                casilleros[j][i] = c;
                
                this.add(c);
            }
            
        }
        
        crearMapa();

        //Buscar un espacio en la primer columna para el personaje
        for (int i = 0; i < casilleros[0].length; i++) {
            if (casilleros[0][i].getValor() == 10) {
                System.out.println("y:" + casilleros[0][i].getPosY());
                //casilleros[0][i].cambiarImagen(100);
                casilleros[0][i].setOcupado(true);
                posicionJugadorY = i;
                
                break;
            }
        }
        
        InputMap mapaEntradas = this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap mapaAcciones = this.getActionMap();
        
        mapaEntradas.put(KeyStroke.getKeyStroke("RIGHT"), "moverDerecha");
        mapaEntradas.put(KeyStroke.getKeyStroke("LEFT"), "moverIzquierda");
        mapaEntradas.put(KeyStroke.getKeyStroke("UP"), "moverArriba");
        mapaEntradas.put(KeyStroke.getKeyStroke("DOWN"), "moverAbajo");
        
        mapaAcciones.put("moverDerecha",
            new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    moverJugador(Terreno.DIRECCION_DERECHA);
                    repaint(); // Refrescar el dibujo del mapa
                }
            }   
        );
        
        mapaAcciones.put("moverIzquierda",
            new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    moverJugador(Terreno.DIRECCION_IZQUIERDA);
                    repaint(); // Refrescar el dibujo del mapa
                }
            }   
        );
        
        mapaAcciones.put("moverArriba",
            new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    moverJugador(Terreno.DIRECCION_ARRIBA);
                    repaint(); // Refrescar el dibujo del mapa
                }
            }   
        );
        
        mapaAcciones.put("moverAbajo",
            new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    moverJugador(Terreno.DIRECCION_ABAJO);
                    repaint(); // Refrescar el dibujo del mapa
                }
            }   
        );
        
    }

    /**
     * Permite generar el mapa
     */
    private void crearMapa() {
        RuidoPerlin generador = new RuidoPerlin(System.currentTimeMillis());
        double escala = 0.1; // Cuanto más pequeño, más suaves las transiciones

        for (int x = 0; x < max_cuadros_x; x++) {
            for (int y = 0; y < max_cuadros_y; y++) {
                // Obtenemos un valor entre -1 y 1
                double valor = generador.noise(x * escala, y * escala);

                // Convertimos a 0.0 - 1.0 para que sea más fácil de manejar
                double elevacion = (valor + 1) / 2.0;

                // Aquí decides el terreno según la tabla que vimos antes
                if (elevacion < 0.15) {
                    casilleros[x][y].cambiarColor(Terreno.AGUA_PROFUNDA);
                } else if (elevacion < 0.3) {
                    casilleros[x][y].cambiarColor(Terreno.AGUA);
                } else if (elevacion < 0.5) {
                    casilleros[x][y].cambiarColor(Terreno.LLANURA);
                } else if (elevacion < 0.7) {
                    casilleros[x][y].cambiarColor(Terreno.BOSQUE_LIGERO);
                } else if (elevacion < 0.8) {
                    casilleros[x][y].cambiarColor(Terreno.BOSQUE_CERRADO);
                } else if (elevacion < 0.9) {
                    casilleros[x][y].cambiarColor(Terreno.ROCAS);
                } else {
                    casilleros[x][y].cambiarColor(Terreno.MONTANIA);
                }
                
                casilleros[x][y].cambiarImagen();
            }
        }
    }
    
    private void moverJugador(int direccion) {
        
        int x = posicionJugadorX;
        int y = posicionJugadorY;
        
        switch (direccion) {
            case Terreno.DIRECCION_IZQUIERDA:
                if (x > 0) {
                    x--;
                }
                break;
            case Terreno.DIRECCION_DERECHA:
                if (x < (max_cuadros_x - 1)) {
                    x++;
                }
                
                break;
            case Terreno.DIRECCION_ARRIBA:
                if (y > 0) {
                    y--;
                }
                
            break;
            case Terreno.DIRECCION_ABAJO:
                if (y < (max_cuadros_y - 1)) {
                    y++;
                }
                break;
            default:
                throw new AssertionError();
        }
        
        casilleros[posicionJugadorX][posicionJugadorY].setOcupado(false);
        casilleros[x][y].setOcupado(true);
        
        posicionJugadorX = x;
        posicionJugadorY = y;
        
    }
    
    private void configurar() {
        
    }
}
