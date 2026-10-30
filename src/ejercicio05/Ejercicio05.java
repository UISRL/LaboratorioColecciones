package ejercicio05;

import java.util.Scanner;

public class Ejercicio05 {
    public static void main(String[] args) {
        // objeto scanner para capturar datos
        Scanner sc = new Scanner(System.in);

        // pedimos la cantidad de articulos n
        System.out.print("ingrese cantidad de articulos (n): ");
        int n = sc.nextInt();

        // pedimos la cantidad de sucursales m
        System.out.print("ingrese cantidad de sucursales (m): ");
        int m = sc.nextInt();

        // matriz para precios de cada articulo en cada sucursal
        double[][] precios = new double[n][m];
        // matriz para cantidades vendidas de cada articulo en cada sucursal
        int[][] cantidades = new int[n][m];

        // ingreso de precios
        System.out.println("\n--- ingreso de precios por articulo y sucursal ---");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // solicitamos precio del articulo i en sucursal j
                System.out.print("precio articulo [" + (i + 1) + "] en sucursal [" + (j + 1) + "]: ");
                precios[i][j] = sc.nextDouble();
            }
        }

        // ingreso de cantidades vendidas
        System.out.println("\n--- ingreso de cantidades vendidas ---");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // solicitamos unidades vendidas
                System.out.print("cantidad vendida de articulo [" + (i + 1) + "] en sucursal [" + (j + 1) + "]: ");
                cantidades[i][j] = sc.nextInt();
            }
        }

        // calculo de total de ventas por cada articulo (sumando por filas)
        System.out.println("\n--- total de ventas por articulo ---");
        for (int i = 0; i < n; i++) {
            // acumulador por articulo
            double totalArticulo = 0.0;
            for (int j = 0; j < m; j++) {
                // sumamos precio por cantidad de cada sucursal
                totalArticulo += precios[i][j] * cantidades[i][j];
            }
            // imprimimos total de este articulo
            System.out.printf("articulo %d: $%.2f\n", (i + 1), totalArticulo);
        }

        // calculo de total de ventas por cada sucursal (sumando por columnas)
        System.out.println("\n--- total de ventas por sucursal ---");
        for (int j = 0; j < m; j++) {
            // acumulador por sucursal
            double totalSucursal = 0.0;
            for (int i = 0; i < n; i++) {
                // sumamos venta de cada articulo en la sucursal actual
                totalSucursal += precios[i][j] * cantidades[i][j];
            }
            // imprimimos total de esta sucursal
            System.out.printf("sucursal %d: $%.2f\n", (j + 1), totalSucursal);
        }

        // cerramos el scanner
        sc.close();
    }
}
