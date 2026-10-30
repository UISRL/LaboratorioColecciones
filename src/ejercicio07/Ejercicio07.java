package ejercicio07;

import java.util.Scanner;

public class Ejercicio07 {
    public static void main(String[] args) {
        // objeto scanner para entrada de datos
        Scanner sc = new Scanner(System.in);

        // pedimos la cantidad n de estudiantes
        System.out.print("ingrese cantidad de estudiantes (n): ");
        int n = sc.nextInt();
        // constante de 8 materias
        final int MATERIAS = 8;

        // arreglo para los codigos de estudiantes
        String[] codigos = new String[n];
        // matriz para las notas: filas=estudiantes, columnas=materias
        double[][] notas = new double[n][MATERIAS];

        // ingreso de datos por estudiante
        for (int i = 0; i < n; i++) {
            // solicitamos el codigo del estudiante
            System.out.print("\ncodigo del estudiante " + (i + 1) + ": ");
            codigos[i] = sc.next();

            // solicitamos las notas de las 8 materias
            for (int j = 0; j < MATERIAS; j++) {
                System.out.print("nota materia " + (j + 1) + " (0-10): ");
                notas[i][j] = sc.nextDouble();
            }
        }

        // literal a y c: promedio por estudiante y buscar el mayor
        double[] promEstudiantes = new double[n];
        int indiceMayor = 0;

        System.out.println("\n--- a. promedio de cada estudiante ---");
        for (int i = 0; i < n; i++) {
            // sumamos las 8 notas del estudiante
            double suma = 0.0;
            for (int j = 0; j < MATERIAS; j++) {
                suma += notas[i][j];
            }
            // calculamos su promedio
            promEstudiantes[i] = suma / MATERIAS;
            System.out.printf("estudiante %s: %.2f\n", codigos[i], promEstudiantes[i]);

            // verificamos si es el mayor promedio
            if (promEstudiantes[i] > promEstudiantes[indiceMayor]) {
                indiceMayor = i;
            }
        }

        // literal b: promedio por cada materia (promedio por columna)
        System.out.println("\n--- b. promedio por materia ---");
        for (int j = 0; j < MATERIAS; j++) {
            double sumaCol = 0.0;
            for (int i = 0; i < n; i++) {
                // sumamos la nota de cada estudiante en la materia
                sumaCol += notas[i][j];
            }
            // mostramos el promedio de la materia
            System.out.printf("materia %d: %.2f\n", (j + 1), (sumaCol / n));
        }

        // literal c: estudiante con mayor promedio
        System.out.println("\n--- c. estudiante con mayor promedio ---");
        System.out.printf("codigo: %s con promedio de: %.2f\n", codigos[indiceMayor], promEstudiantes[indiceMayor]);

        // literal d y e: aprobados y reprobados por materia
        System.out.println("\n--- d y e. aprobados y reprobados por materia ---");
        for (int j = 0; j < MATERIAS; j++) {
            int aprobados = 0;
            int reprobados = 0;
            for (int i = 0; i < n; i++) {
                // evaluamos si aprueba o reprueba
                if (notas[i][j] >= 7.0 && notas[i][j] <= 10.0) {
                    aprobados++;
                } else if (notas[i][j] < 7.0) {
                    reprobados++;
                }
            }
            // mostramos el reporte por materia
            System.out.println("materia " + (j + 1) + " -> aprobados: " + aprobados + ", reprobados: " + reprobados);
        }

        // cerramos el scanner
        sc.close();
    }
}
