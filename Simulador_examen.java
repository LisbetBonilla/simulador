package com.tiernoparla.simulador;
//www.discoduroderoer.es/juego-3-en-raya-o-tic-tac-toe-en-java/

import java.util.Scanner;

public class Simulador_examen {

    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        Simulador_examen juego = new Simulador_examen();

        int fila;
        boolean posValida, correcto;
        
        while(!juego.finPartida()){
            do{
                juego.verTurno();
                juego.verTablero();
                
                correcto = false;
                fila = pedirInteger("dame una posicion: ");
                
            }
        }

    }

//METODOS
//jugadores y sus representaciones******************************************
    private final char ordenador = 'o';
    private final char usuario = 'u';
    private final char nul = '-';

//orden de los turnos*******************************************************    
//true = ordenador, false = usuario*****************************************
    private boolean turno;

// tablero donde se juega***************************************************
    private char tablero[];

//arrancar el tablero vacio*************************************************
    private void iniciarTablero() {
        for (int i = 0; i < tablero.length; i++) {
            tablero[i] = nul;
        }
    }

// contructor*******************************************************************
    public Simulador_examen() {
        this.turno = true;
        this.tablero = new char[9];
        this.iniciarTablero();
    }

//Mostrar el tablero ***********************************************************
    public void verTablero() {
        for (int i = 0; i < this.tablero.length; i++) {
            System.out.println(this.tablero[i] + "");
        }
        System.out.println("");
    }

//Mostrar turno*****************************************************************
    public void verTurno() {
        if (turno) {
            System.out.println("Le toca al ORDENADOR");
        } else {
            System.out.println("Le toca al USUARIO");
        }
    }

//Cambio de turno***************************************************************
    public void cambiaTurno() {
        this.turno = !this.turno;
    }

//Insertar objecto**************************************************************
    public void insertar(int fila) {
        if (turno) {
            this.tablero[fila] = ordenador;
        } else {
            this.tablero[fila] = usuario;
        }
    }
//Si es valida la posicion******************************************************

    public boolean validarPosicion(int fila) {
        if (fila < 0 || fila >= tablero.length) {
            return true;
        }
        return false;
    }

// si la posisicin esta marcada*************************************************
    public boolean hayAlgo(int fila) {
        if (this.tablero[fila] != nul) {
            return true;
        }
        return false;
    }

// tabla llena******************************************************************
    public boolean tableroLleno() {
        for (int i = 0; i < tablero.length; i++) {
            if (tablero[i] == nul) {
                return false;
            }
        }
        return true;
    }

// linea************************************************************************
    private char coincidencia3() {
        char simbolo;
        boolean coincidencia;

        for (int i = 0; i < tablero.length; i++) {
            coincidencia = true;
            simbolo = tablero[i];
            if (simbolo != nul) {
                if (simbolo != tablero[i]) {
                    coincidencia = false;
                }//if 2
            }//if 1
            if (coincidencia) {
                return simbolo;
            }//if
        }//for
        return nul;
    }

    //Indicardor de fon de partida**********************************************
    public boolean finPartida() {

        if (tableroLleno()
                || coincidencia3() != nul) {
            return true;
        }
        return false;
    }

    //Mostrar ganador***********************************************************
    public void mostrarGanador() {

        char simbolo = coincidencia3();

        if (simbolo != nul) {
            ganador(simbolo, 1);
            return;
        }
        System.out.println("Hay empate");

    }

    private void ganador(char simbolo, int tipo) {

        switch (tipo) {
            case 1 -> {
                if (simbolo == ordenador) {
                    System.out.println("Ha ganado el ORDENADOR por linea");
                } else {
                    System.out.println("Ha ganado el USUARIO por linea");
                }
            }
        }
    }
}