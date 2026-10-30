package ejercicio06;

import java.util.Scanner;

public class Ejercicio06 {
    public static void main(String[] args) {
        // objeto scanner para lectura
        Scanner sc = new Scanner(System.in);

        // pedimos la cantidad de vendedores n
        System.out.print("ingrese cantidad de vendedores (n): ");
        int n = sc.nextInt();

        // pedimos la cantidad de años m
        System.out.print("ingrese cantidad de anos (m): ");
        int m = sc.nextInt();

        // matriz para registrar ventas
        double[][] ventas = new double[n][m];

        // llenamos la matriz con las ventas
        System.out.println("\n--- ingreso de ventas ---");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // solicitamos la venta del vendedor i en el año j
                System.out.print("vendedor " + (i + 1) + ", ano " + (j + 1) + ": ");
                ventas[i][j] = sc.nextDouble();
            }
        }

        // variable para el total general de la empresa
        double totalEmpresa = 0.0;

        // literal a: total de ventas de cada vendedor (suma por filas)
        System.out.println("\n--- a. total ventas por vendedor ---");
        for (int i = 0; i < n; i++) {
            // acumulador para el vendedor actual
            double totalVendedor = 0.0;
            for (int j = 0; j < m; j++) {
                // sumamos la venta del año
                totalVendedor += ventas[i][j];
            }
            // acumulamos al total de la empresa
            totalEmpresa += totalVendedor;
            // mostramos el resultado del vendedor
            System.out.printf("vendedor %d: $%.2f\n", (i + 1), totalVendedor);
        }

        // literal b: total de ventas por cada año (suma por columnas)
        System.out.println("\n--- b. total ventas por ano ---");
        for (int j = 0; j < m; j++) {
            // acumulador para el año actual
            double totalAno = 0.0;
            for (int i = 0; i < n; i++) {
                // sumamos la venta de cada vendedor en este año
                totalAno += ventas[i][j];
            }
            // mostramos el total del año
            System.out.printf("ano %d: $%.2f\n", (j + 1), totalAno);
        }

        // literal c: total de ventas de la empresa
        System.out.println("\n--- c. total ventas de la empresa ---");
        System.out.printf("total general: $%.2f\n", totalEmpresa);

        // cerramos el scanner
        sc.close();
    }
}
