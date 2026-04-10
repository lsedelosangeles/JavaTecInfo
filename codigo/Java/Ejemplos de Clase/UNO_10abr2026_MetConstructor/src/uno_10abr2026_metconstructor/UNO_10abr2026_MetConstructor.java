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
        
        Carta[] baraja = new Carta[108];
        int color = 0;
        int numero = 0;
        
        for (int contador = 0; contador < 108; contador++) {
            
            if(numero<14){
                numero++;
            }
            else{
                numero=0;
                if (color<3) {
                   color++;
                }
                else{
                    color=0;
                }
            }
            Carta x = new Carta
                    (numero, color);
            
            
            
            baraja[contador] = x;
        }
        
        for (int i = 0; i < 108; i++) {
            System.out.println
                ("Num:" + baraja[i].verNumero() + 
                 " Color: "+baraja[i].verColor());
        }
    
    
    }
    
}
