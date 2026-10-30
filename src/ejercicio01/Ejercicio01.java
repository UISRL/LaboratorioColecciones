package ejercicio01;

import java.util.Scanner;

public class Ejercicio01 {
    public static void main(String[] args) {
        // creamos el objeto scanner para leer desde teclado
        Scanner sc = new Scanner(System.in);

        // pedimos la cantidad n de elementos
        System.out.print("ingrese la cantidad de estudiantes (n): ");
        int n = sc.nextInt();

        // declaramos los vectores para guardar cedulas
        String[] mate = new String[n];
        String[] ingles = new String[n];
        String[] ambos = new String[n];
        int contAmbos = 0;

        // ingresamos cedulas de reprobados en matematica
        System.out.println("\n--- ingreso reprobados matematica ---");
        for (int i = 0; i < n; i++) {
            // pedimos la cedula del estudiante
            System.out.print("estudiante [" + (i + 1) + "]: ");
            mate[i] = sc.next();
        }

        // ingresamos cedulas de reprobados en ingles
        System.out.println("\n--- ingreso reprobados ingles ---");
        for (int i = 0; i < n; i++) {
            // pedimos la cedula del estudiante
            System.out.print("estudiante [" + (i + 1) + "]: ");
            ingles[i] = sc.next();
        }

        // buscamos las cedulas que esten en ambos vectores
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // si la cedula coincide en los dos arreglos
                if (mate[i].equals(ingles[j])) {
                    // guardamos la cedula en el tercer vector
                    ambos[contAmbos] = mate[i];
                    contAmbos++;
                    break;
                }
            }
        }

        // imprimimos el vector de matematica
        System.out.println("\nvector 1: reprobados matematica");
        for (int i = 0; i < n; i++) {
            System.out.print(mate[i] + " ");
        }

        // imprimimos el vector de ingles
        System.out.println("\n\nvector 2: reprobados ingles");
        for (int i = 0; i < n; i++) {
            System.out.print(ingles[i] + " ");
        }

        // imprimimos el vector de reprobados en ambas materias
        System.out.println("\n\nvector 3: reprobados en ambas materias");
        if (contAmbos == 0) {
            // mensaje si no hubo coincidencias
            System.out.print("ningun estudiante reprobo ambas");
        } else {
            // mostramos solo los encontrados
            for (int i = 0; i < contAmbos; i++) {
                System.out.print(ambos[i] + " ");
            }
        }
        System.out.println();

        // cerramos el scanner
        sc.close();
    }
}
