/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Map_Initializer;

import Board.TemplateGUI;
import Box.BoxProperty;
import File.ErrorException_GUI;
import java.io.Serializable;

/**
 * Clase auxiliable para la creación de tableros, especialmente la ruta
 * que seguiran los jugadores como la visualización del mapa mismo
 * @author camran
 */
public class Route implements Serializable{
    private Template[] ruta;
    private int[] numerosAntesCasillas;
    public Template[] getRoute(){
        return ruta;
    }
    
    
    public int[] getnumerosAntesCasillas(){
        return numerosAntesCasillas;
    }
    
    /**
     * Método que nos permite comprobar si un tablero tiene continuidad
     * con respecto a las agujas del reloj, además de que cumpla ciertos parámetros
     * como solo tener una casilla inicio y que llegue al final
     * @param template
     * @return
     */
    public boolean checkRoute(Template[][] template,Bank bank){
        int start=0;
        int magnitudRuta=0;
        int indexRows = 0;
        int indexCols = 0;
        boolean rutaComprobada=false;
        boolean rutaTomada=false;
        /*Obtenemos la casilla inicio y comprobamos si hay mas de una
          y obtenemos la cantidad de casillas que estan llenas
        */
        for(int i=0;i<template.length;i++){
            for(int j=0;j<template[0].length;j++){ 
                if(template[i][j].getType()!=null){    
                    if(template[i][j].getType().equalsIgnoreCase("Inicio")){
                        start++;
                        indexRows=i;
                        indexCols=j;
                    }
                    if(template[i][j].getPrimitiv()==false){
                        magnitudRuta++;
                       
                    }
                }
            }
        }
        //Comprobamos si la ruta de las casillas es orientado a favor de las
        //agujas del reloj y generamos la ruta que tomaran los jugadores
        if(start==1){
            /*
                Usaremos la variable rutaTomada para combrobar que solo se tome una ruta
                en caso de que puedan existir dos alternativas
            */
            try{   
                Template[] rutaAuxiliar = new Template[magnitudRuta];
                //Tomaremos estos vectores para saber en donde hay una casilla llena y con propiedades
                int[] rowsChecked = new int[magnitudRuta];
                int[] colsChecked = new int[magnitudRuta];
                numerosAntesCasillas = new int[magnitudRuta];
                magnitudRuta=0;
                rowsChecked[magnitudRuta] = indexRows;
                colsChecked[magnitudRuta] = indexCols;
                numerosAntesCasillas[0] = indexRows + indexCols+1;
                rutaAuxiliar[0]=template[indexRows][indexCols];
                
                while(magnitudRuta<rutaAuxiliar.length){
                    System.out.println(magnitudRuta);
                    rutaTomada=false;
                    magnitudRuta++;
                    //Comprobamos de primero a la derecha, luego abajo, luego izquierda, luego arriba
                    //Comprobamos de primero si su index no se sale de los parametros y luego comprobamos
                    //Si hay una casilla modificada usando la variable primitiv obtenia del metodo getPrimitiv
                    //Y tambien se comprueba de que la siguiente posicion no sea una de las posiciones ya guardadas                    
                    if(magnitudRuta<rutaAuxiliar.length){
                        
                        if((colsChecked[magnitudRuta-1]+1)<(template[0].length)){    
                            if(template[rowsChecked[magnitudRuta-1]][colsChecked[magnitudRuta-1]+1].getPrimitiv()==false &&
                                checkRight(rowsChecked,colsChecked,magnitudRuta)==true && rutaTomada==false){
                                rowsChecked[magnitudRuta] = rowsChecked[magnitudRuta-1];
                                colsChecked[magnitudRuta] = colsChecked[magnitudRuta-1]+1;
                                rutaAuxiliar[magnitudRuta]=template[rowsChecked[magnitudRuta]][colsChecked[magnitudRuta]];
                                rutaTomada=true;
                            }
                        }if((rowsChecked[magnitudRuta-1]+1)<(template.length) ){                            
                            if(template[rowsChecked[magnitudRuta-1]+1][colsChecked[magnitudRuta-1]].getPrimitiv()==false &&
                                checkDown(rowsChecked,colsChecked,magnitudRuta)==true && rutaTomada==false){
                                rowsChecked[magnitudRuta] = rowsChecked[magnitudRuta-1]+1;
                                colsChecked[magnitudRuta] = colsChecked[magnitudRuta-1];
                                rutaAuxiliar[magnitudRuta]=template[rowsChecked[magnitudRuta]][colsChecked[magnitudRuta]];
                                rutaTomada=true;
                            }
                        }if((colsChecked[magnitudRuta-1]-1)>=0 ){
                            if(template[rowsChecked[magnitudRuta-1]][colsChecked[magnitudRuta-1]-1].getPrimitiv()==false &&
                                checkLeft(rowsChecked,colsChecked,magnitudRuta)==true && rutaTomada==false){ 
                                rowsChecked[magnitudRuta] = rowsChecked[magnitudRuta-1];
                                colsChecked[magnitudRuta] = colsChecked[magnitudRuta-1]-1;
                                rutaAuxiliar[magnitudRuta]=template[rowsChecked[magnitudRuta]][colsChecked[magnitudRuta]];
                                rutaTomada=true;
                            }
                        }if((rowsChecked[magnitudRuta-1]-1)>=0 ){
                            if(template[rowsChecked[magnitudRuta-1]-1][colsChecked[magnitudRuta-1]].getPrimitiv()==false &&
                                checkUp(rowsChecked,colsChecked,magnitudRuta)==true && rutaTomada==false){
                                rowsChecked[magnitudRuta] = rowsChecked[magnitudRuta-1]-1;
                                colsChecked[magnitudRuta] = colsChecked[magnitudRuta-1];
                                rutaAuxiliar[magnitudRuta]=template[rowsChecked[magnitudRuta]][colsChecked[magnitudRuta]]; 
                                rutaTomada=true;
                            }
                        }if (rutaTomada==false){
                            new ErrorException_GUI("Error creando ruta: Ruta incompleta, asegurese que este cerrada "
                                    + "y que no choque con ninguna otra casilla, deje una casilla de distancia");
                            return false;
                            }
                        
                        //Tomaremos la variable numerosAntesCasillas para conocer cual era su numero antes de 
                        //convertirlos en paneles de juego panelGame()
                        numerosAntesCasillas[magnitudRuta] = rowsChecked[magnitudRuta] + colsChecked[magnitudRuta] +1;
                        //Sentencia para Comprobar que la ruta termine en la casilla inicio se comprueba la columa +1
                        //luego la fila +1 luego la columna-1 luego la fila-1
                    }else{
                        if((colsChecked[magnitudRuta-1]+1)<(template[0].length) ){
                            if(template[rowsChecked[magnitudRuta-1]][colsChecked[magnitudRuta-1]+1].getType()!=null){
                                if(template[rowsChecked[magnitudRuta-1]][colsChecked[magnitudRuta-1]+1].getType().equalsIgnoreCase("Inicio")){
                                    System.out.println("Entro1");
                                    rutaComprobada=true;
                               }   
                            }                                          
                        }if((rowsChecked[magnitudRuta-1]+1)<(template.length)){
                            if(template[rowsChecked[magnitudRuta-1]+1][colsChecked[magnitudRuta-1]].getType()!=null){
                                if(template[rowsChecked[magnitudRuta-1]+1][colsChecked[magnitudRuta-1]].getType().equalsIgnoreCase("Inicio")){
                                    System.out.println("Entro2");
                                    rutaComprobada=true;   
                                }
                            }
                        }
                        if((colsChecked[magnitudRuta-1]-1)>=0){
                            if(template[rowsChecked[magnitudRuta-1]][colsChecked[magnitudRuta-1]-1].getType()!=null){
                                if(template[rowsChecked[magnitudRuta-1]][colsChecked[magnitudRuta-1]-1].getType().equalsIgnoreCase("Inicio")){
                                    System.out.println("Entro 3");
                                    rutaComprobada=true;     
                                }
                            }
                        }
                        if((rowsChecked[magnitudRuta-1]-1)>=0){
                            if(template[rowsChecked[magnitudRuta-1]-1][colsChecked[magnitudRuta-1]].getType()!=null){
                                if(template[rowsChecked[magnitudRuta-1]-1][colsChecked[magnitudRuta-1]].getType().equalsIgnoreCase("Inicio")){
                                    System.out.println("Entro4");
                                    rutaComprobada=true;     
                                }
                            }
                        }
                    }
                    
                    
                    
                    
                }
                
                if(rutaComprobada){
                    System.out.println("Gotcha");
                    this.ruta = rutaAuxiliar;
                    int size=0;
                    for(int i=0;i<ruta.length;i++){
                        if(ruta[i].getBox() instanceof BoxProperty)
                            size++;
                    }
                    
                    setPropertys(size,ruta,bank);
                    setPanels();
                    System.out.println("Gotcha2");
                    return true;
                }else{
                    new ErrorException_GUI("Error creando ruta: No ha terminado en la casilla Inicio");
                    return false;                    
                }
            
            }catch(Exception e){
                new ErrorException_GUI(e.getMessage());
                return false;
            }            
        }else{
            new ErrorException_GUI("Existe mas de una casilla Inicio o no existe, solo puede haber una");
            return false;
        }
    }
    
//Funcion que nos permite determinar si la siguiente posicion ya se encuentra en el vector
    //Chequeo a la derecha
    private boolean checkRight(int[] rows, int[] cols, int magnitud){
        for(int i=0;i<magnitud-1;i++){
            if((rows[magnitud-1]==rows[i]) && ((cols[magnitud-1]+1)==cols[i]))
                return false;
        }
        return true;
    }
    
    //Chequeo para abajo
    private boolean checkDown(int[] rows, int[] cols, int magnitud){
        for(int i=0;i<magnitud-1;i++){
            if((rows[magnitud-1]+1==rows[i]) && ((cols[magnitud-1])==cols[i]))
                return false;
        }
        return true;
    }
    
    //Chequeo a la izquierda
    private boolean checkLeft(int[] rows, int[] cols, int magnitud){
        for(int i=0;i<magnitud-1;i++){
            if((rows[magnitud-1]==rows[i]) && ((cols[magnitud-1]-1)==cols[i]))
                return false;
        }
        return true;
    }
    
    //Chequeo para arriba
    private boolean checkUp(int[] rows, int[] cols, int magnitud){
        for(int i=0;i<magnitud-1;i++){
            if((rows[magnitud-1]-1==rows[i]) && ((cols[magnitud-1])==cols[i]))
                return false;
        }
        return true;
    }
    //Usamos esta funcion para crear paneles panelGame() que utilizaremos 
    //para imprimirlo mientras este en el tablero
    private void setPanels(){
        for(int i=0;i<ruta.length;i++){
            ruta[i].setPanelGame(new TemplateGUI(ruta[i],i));
        }
    }
    //Usamos esta funcion para agregarle al banco las casillas que son propiedades
    //para que luego dicha clase sea la unica en encargarse de presentar las propiedades
    //manejarlas etc.
    //Le asignamos las casillas propiedades al banco para facilitar el trabajo
    private void setPropertys(int size, Template[] casillas,Bank bank){
        BoxProperty[] casillasAux = new BoxProperty[size];
        int contadora=0;
        for(int i=0;i<casillas.length;i++){
            if(casillas[i].getBox() instanceof BoxProperty){
                casillasAux[contadora] = (BoxProperty)casillas[i].getBox();
                contadora++;
            }
        }
        System.out.println("EntroBanco1");
        bank.setPropiedades(casillasAux);
        System.out.println("SalioBanco1");
    }
}
