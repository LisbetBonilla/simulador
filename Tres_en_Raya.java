package com.tiernoparla.simulador;

import java.util.Scanner;

public class Tres_en_Raya {

    public static void main(String[] args) {

        //variables del Scanner
        Scanner teclado = new Scanner(System.in);
        int posPersona;
        
        final int tam = 11;
        int[] juego = new int[tam];
        final int CERO = 0;
        final int POSOR = 1;
        final int POSPER = 2;

        //variables de uso
        boolean posicion_ok = false;
        boolean finPartida = false;
        int posOrdenador;

        //rellenar de 0 el array
        System.out.println("El tablero empieza a 0: ");
        verTablero(tam, juego);
        System.out.println(" ");

        //bucle del juego
        while (finPartida == false) {

            posOrdenador = (int) (Math.random() * tam + 1);
            while (posicion_ok == false) {
                posicion_ok = ponerPosicionOr(juego, posOrdenador, tam,
                        posicion_ok, CERO, POSOR, POSPER);
            }//cierre while
            
            posicion_ok = false;

            System.out.println("El juego esta así:");
            verTablero(tam, juego);
            System.out.println(" ");

            while (posicion_ok == false) {
                System.out.println("Dame una posicion");
                posPersona = teclado.nextInt();

                posicion_ok = ponerPosicionPer(juego, posPersona, posicion_ok,
                        CERO, POSOR, POSPER);
            }//while persona

            posicion_ok = false;

            finPartida = hayTresCoincidencias(tam, juego, finPartida);

            System.out.println("Continuamos Jugando");
        }//cierre while

    }//main

    //METODOS*******************************************************************
    
    private static boolean hayTresCoincidencias(final int tam, int[] juego, 
            boolean finPartida) {
        /* System.out.println("El juego esta así:");
        verTablero(tam, juego);
        System.out.println(" ");*/
        //Calcular si hay tres consecutivos
        for (int i = 0; i < tam - 2; i++) {
            if (juego[i] == juego[i + 1] && juego[i + 1] == juego[i + 2]
                    && juego[i] == 1) {
                System.out.println("Gana el ordenador");
                finPartida = true;
                break;
            }//cierre if
            else if (juego[i] == juego[i + 1] && juego[i + 1]
                    == juego[i + 2] && juego[i] == 2) {
                System.out.println("Tu Ganas");
                finPartida = true;
                break;
            }//Cierre else if
        }//cierre for
        return finPartida;
    }

    private static boolean ponerPosicionPer(int[] juego, int posPersona,
            boolean posicion_ok, final int CERO, final int POSOR,
            final int POSPER) {

        if (juego[posPersona] == CERO) {
            juego[posPersona] = POSPER;
            posicion_ok = true;
        }//cierre if
        else if (juego[posPersona] == POSOR || juego[posPersona] == POSPER) {
            System.out.println("Posicion ocupada ingresa otra");
            posicion_ok = false;
        }//cierre else if
        return posicion_ok;
    }//cierre metodo

    private static void verTablero(final int tam, int[] juego) {
        for (int i = 0; i < tam; i++) {
            System.out.print(juego[i]);
        }//Cierre for
    }//cierre metodo

    private static boolean ponerPosicionOr(int[] juego, int posOrdenador,
            final int tam, boolean posicion_ok,
            final int CERO, final int POSOR,
            final int POSPER) {

        if (juego[posOrdenador] == CERO) {
            juego[posOrdenador] = POSOR;
            //posOrdenador = (int) (Math.random() * tam + 1);
            posicion_ok = true;
        }//cierre if
        else if (juego[posOrdenador] == POSOR || juego[posOrdenador] == POSPER) {
            posicion_ok = false;
        }//cierre else
        return posicion_ok;
    }//cierre metodo

}// cierre main

