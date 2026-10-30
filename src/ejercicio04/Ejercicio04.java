package ejercicio04;

import java.util.Random;
import java.util.Scanner;

public class Ejercicio04 {
    // funcion auxiliar para imprimir una matriz
    public static void imprimirMatriz(int[][] m) {
        // recorremos filas
        for (int i = 0; i < m.length; i++) {
            // recorremos columnas
            for (int j = 0; j < m[0].length; j++) {
                // mostramos el valor tabulado
                System.out.printf("%4d ", m[i][j]);
            }
            // salto de fila
            System.out.println();
        }
    }

    // funcion para llenar una matriz con numeros aleatorios entre 1 y 9
    public static void llenarMatriz(int[][] m) {
        // objeto random
        Random rand = new Random();
        // llenamos cada posicion
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                // asignamos numero de 1 a 9
                m[i][j] = rand.nextInt(9) + 1;
            }
        }
    }

    public static void main(String[] args) {
        // objeto scanner para lectura
        Scanner sc = new Scanner(System.in);

        // pedimos las dimensiones m y n
        System.out.print("ingrese filas de la matriz a (m): ");
        int m = sc.nextInt();
        System.out.print("ingrese columnas de la matriz a (n): ");
        int n = sc.nextInt();

        // creamos y llenamos la matriz a
        int[][] a = new int[m][n];
        llenarMatriz(a);

        // mostramos la matriz a
        System.out.println("\nmatriz a (" + m + "x" + n + "):");
        imprimirMatriz(a);

        // mostramos el menu de opciones
        System.out.println("\n--- operaciones disponibles ---");
        System.out.println("1. sumar matrices");
        System.out.println("2. restar matrices");
        System.out.println("3. multiplicar matrices");
        System.out.println("4. trasponer matriz");
        System.out.print("seleccione una opcion: ");
        int opcion = sc.nextInt();

        // evaluamos la opcion elegida
        switch (opcion) {
            case 1:
                // para sumar, matriz b debe ser del mismo tamaño m x n
                int[][] bSuma = new int[m][n];
                llenarMatriz(bSuma);
                System.out.println("\nmatriz b generada:");
                imprimirMatriz(bSuma);

                // matriz resultado
                int[][] suma = new int[m][n];
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        // sumamos posicion a posicion
                        suma[i][j] = a[i][j] + bSuma[i][j];
                    }
                }
                System.out.println("\nresultado de a + b:");
                imprimirMatriz(suma);
                break;

            case 2:
                // para restar, matriz b debe ser de m x n
                int[][] bResta = new int[m][n];
                llenarMatriz(bResta);
                System.out.println("\nmatriz b generada:");
                imprimirMatriz(bResta);

                // matriz resultado
                int[][] resta = new int[m][n];
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        // restamos posicion a posicion
                        resta[i][j] = a[i][j] - bResta[i][j];
                    }
                }
                System.out.println("\nresultado de a - b:");
                imprimirMatriz(resta);
                break;

            case 3:
                // para multiplicar a(m x n), b debe tener n filas (creamos n x m)
                int[][] bMult = new int[n][m];
                llenarMatriz(bMult);
                System.out.println("\nmatriz b generada (" + n + "x" + m + "):");
                imprimirMatriz(bMult);

                // resultado de multiplicar tiene dimension m x m
                int[][] prod = new int[m][m];
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < m; j++) {
                        // producto escalar fila por columna
                        for (int k = 0; k < n; k++) {
                            prod[i][j] += a[i][k] * bMult[k][j];
                        }
                    }
                }
                System.out.println("\nresultado de a * b (" + m + "x" + m + "):");
                imprimirMatriz(prod);
                break;

            case 4:
                // la transpuesta intercambia filas por columnas (n x m)
                int[][] t = new int[n][m];
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        // colocamos fila en columna
                        t[j][i] = a[i][j];
                    }
                }
                System.out.println("\nmatriz a traspuesta (" + n + "x" + m + "):");
                imprimirMatriz(t);
                break;

            default:
                // mensaje por si ingresa opcion no valida
                System.out.println("opcion no valida");
        }

        // cerramos el scanner
        sc.close();
    }
}
