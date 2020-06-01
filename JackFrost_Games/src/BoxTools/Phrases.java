/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BoxTools;

import java.io.Serializable;
import java.util.Random;

/**
 *
 * @author camran
 */
public class Phrases implements Serializable{
    String[] Multa = {" Trajo a su hijo al museo y destruyo una reliquia, paga ",
    " Se le olvido devolver una pelicula de Blockbuster y ahora debe ",
    " Lo paro la policia, y le dijeron que tenia covid-19\n pero se le quitaba pagando ",
    " Se desvelo jugando varios dias y lo llevaron al hospital, pagas ",
    " Vio una pelicula tan horrible que insulto al \n le hicieron una multa de ",
    " Viajo a venezuela, y al aterrizar le robaron ",
    " Lo demandaro, y la indemnizacion costo ",
    " Se quedo dormido en el boliche, ahora debe ",
    " Fue a los bolos y le pegaron, le quitaron "};
 
    String[] irCarcel = { " Fue parado por la policia, le pidieron mordida\n pero como no traia dinero se lo llevaron",
        " Le pego a un niño",
        " Le pego a un viejo",
        " Opino que Elite era bueno",
        " Vio DanganRonpa e imito la serie",
        " Dijo que sistemas era malo"};
            
    String[] desplazarse = {" Hubo una ola de trapar y avanza hacia la casilla ",
        " Rick y morty aparecen y lo teletransportan a la casilla ",
        " No le dio dinero a un viejito, este lo patea y lo manda volando a la casilla ",
        " El aire es tan fuerte que se lo lleva volando a la casilla ",
        " Le metiron un escopetazo tan fuerte en\n fornite que lo manda volando a la casilla",
        " Quiso viajar al lugar más frio del mundo\n que era el pecho de messi pero termina en la casilla ",
        " Andaba caminando cuando el bicho aparece\n y se lo lleva a la casilla "
    };
    
    String[] multaJugadores = {" Dona a cada jugador ",
        " Hace un movimiento de tipo amarillo y le da a cada jugador ",
        " Su mamá lo regaña por tacaño y le da a cada jugador ",
        " Su mamá lo regaña por tacaño y le da a cada jugador ",
        " Maduro aparece y le quita su dinero, le da a cada jugador ",
        " La empresa que trabaja le quita su dinero del almuerzo\n, y le da a cada jugador ",
        " Se convirtio en socialista, y le da a cada jugador ",
        " La policia indica que caminaba de forma sospechosa\n y le quitan su dinero, le dan a cada jugador "
    };
    String [] mover = {
        " Se pone a realizar reffing, y se desplaza ",
        " Viaja en un gundam, y se desplaza ",
        " Le pega a un hule, y el rebote lo lanza volando ",
        " Se desplaza ",
        " Lo corren los perros y se mueve ",
        " Un amigo le invita a subir a su auto y se desplaza ",
        " Vio tiktok, y vio un video tan feo\n que sale corriendo "
    };
    String[] turnoPerdido = {
        " Se queda a dormir, pierde ",
        " Le da un infarto, pierde ",
        " Se muere su hermano, asiste a su funeral pierde ",
        " Le da depresion, y en su camino para recuperarse pierde ",
        " Le da el sindrome de Guillain-Barré, se recupera en ",
        " Vio a Ichiko Ohya y se enfermo, pierde ",
        " Se le cae la pierna, pierde"
    };
    String[] premio = {" Se gana la loteria, gana ",
        " Se hace amigo del presidente Venezolano, le da ",
        " Gana un torneo de Smash, gana ",
        " Su Esposo/a muere, le dan una indemnización de ",
        " Gana un concurso de canto, gana ",
        " Se encuentra con un viejoAmigo, y le devuelve dinero prestado, ganas ",
        " Realiza un remix de AcidThunder, se lo compran y gana "
    };
    
    Random random = new Random();

    /**
     * Retorna una frase segun el tipo de cada tarjeta
     * 1.- Frase Tarjeta Multa
     * 2.- Frase Tarjeta Salir de Carcel
     * 3.- Frase Tarjeta Ir a Carcel
     * 4.- Frase Tarjeta Desplazarse a casilla
     * 5.- Frase Tarjeta Pago a cada Jugador
     * 6.- Frases Tarjeta Mover
     * 7.- Frases Tarjeta Perdio Turno
     * 8.- Frases Tarjeta Premio
     * @param tipoTarjeta
     * @return
     */
    public String getPhrases(int tipoTarjeta){
        String frase ="";
        int indexFrase =0 ;
        switch(tipoTarjeta){
            case 1:
                   indexFrase=random.nextInt((Multa.length-1)+1);
                   frase = Multa[indexFrase];
                break;
                    
            case 2:
                frase = "Un amigo le ayudo, y sale de la carcel";
                break;
            
            case 3:
                    indexFrase=random.nextInt((this.irCarcel.length-1)+1);
                   frase = irCarcel[indexFrase];
                break;
            
            case 4:
                indexFrase=random.nextInt((desplazarse.length-1)+1);
                   frase = desplazarse[indexFrase];
                break;
            
            case 5:
                indexFrase=random.nextInt((multaJugadores.length-1)+1);
                   frase = multaJugadores[indexFrase];
                break;
            
            case 6:
                indexFrase=random.nextInt((mover.length-1)+1);
                   frase = mover[indexFrase];
                break;
                
            case 7:
                indexFrase=random.nextInt((turnoPerdido.length-1)+1);
                   frase = turnoPerdido[indexFrase];
                break;
                
            case 8:
                indexFrase=random.nextInt((premio.length-1)+1);
                   frase = premio[indexFrase];
                break;
        }
        
        return frase;
        
    }
    
    
}
