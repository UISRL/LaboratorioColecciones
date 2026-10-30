package ejercicio02;

import java.util.Random;
import java.util.Scanner;

public class Ejercicio02 {
    public static void main(String[] args) {
        // objeto scanner para leer teclado
        Scanner sc = new Scanner(System.in);
        // objeto random para generar numeros aleatorios
        Random rand = new Random();

        // vector original de 20 enteros
        int[] original = new int[20];

        // llenamos el vector con aleatorios entre 1 y 50
        System.out.println("vector original generado:");
        for (int i = 0; i < original.length; i++) {
            // numero aleatorio entre 1 y 50
            original[i] = rand.nextInt(50) + 1;
            // mostramos el valor con su indice
            System.out.print("[" + i + "]=" + original[i] + " ");
        }
        System.out.println();

        // literal a: buscar numero por teclado
        System.out.print("\ningrese un numero a buscar: ");
        int buscado = sc.nextInt();
        int posEncontrada = -1;

        // recorremos para buscar la primera coincidencia
        for (int i = 0; i < original.length; i++) {
            // si el elemento coincide con el buscado
            if (original[i] == buscado) {
                posEncontrada = i;
                break;
            }
        }

        // mostramos el resultado de la busqueda
        if (posEncontrada != -1) {
            // mensaje si se encontro
            System.out.println("el numero " + buscado + " esta en la posicion: " + posEncontrada);
        } else {
            // mensaje si no existe en el arreglo
            System.out.println("el numero " + buscado + " no se encuentra en el vector");
        }

        // literal b: vector con elementos en indices impares (indices 1,3,5,... = 10 elementos)
        int[] impares = new int[original.length / 2];
        int k = 0;

        // guardamos los de indice impar
        for (int i = 1; i < original.length; i += 2) {
            // copiamos el elemento al segundo vector
            impares[k] = original[i];
            k++;
        }

        // imprimimos el vector resultante
        System.out.println("\nvector con elementos en posiciones de indice impar:");
        for (int i = 0; i < impares.length; i++) {
            // mostramos cada elemento
            System.out.print(impares[i] + " ");
        }
        System.out.println();

        // literal c: contar cuantos son mayores a 20 en el segundo vector
        int mayoresA20 = 0;
        for (int i = 0; i < impares.length; i++) {
            // evaluamos si es mayor a 20
            if (impares[i] > 20) {
                // incrementamos el contador
                mayoresA20++;
            }
        }

        // mostramos la cantidad de mayores a 20
        System.out.println("cantidad de elementos mayores a 20 en el segundo vector: " + mayoresA20);

        // cerramos el scanner
        sc.close();
    }
}
