package ejercicio03;

import java.util.Scanner;

public class Ejercicio03 {
    public static void main(String[] args) {
        // objeto scanner para entrada de datos
        Scanner sc = new Scanner(System.in);

        // pedimos la cantidad total de empleados
        System.out.print("ingrese la cantidad de empleados (n): ");
        int n = sc.nextInt();
        // limpiamos salto de linea pendiente
        sc.nextLine();

        // arreglos paralelos para codigos y nombres
        String[] codigos = new String[n];
        String[] nombres = new String[n];

        // ciclo para registrar cada empleado
        System.out.println("\n--- registro de empleados ---");
        for (int i = 0; i < n; i++) {
            // solicitamos el codigo del empleado
            System.out.print("codigo del empleado " + (i + 1) + ": ");
            codigos[i] = sc.nextLine().trim();

            // solicitamos el nombre del empleado
            System.out.print("nombre del empleado " + (i + 1) + ": ");
            nombres[i] = sc.nextLine().trim();
        }

        // pedimos el codigo a consultar
        System.out.print("\ningrese el codigo del empleado a consultar: ");
        String codigoBuscado = sc.nextLine().trim();

        // variable para saber si encontramos al empleado
        boolean encontrado = false;

        // buscamos el codigo en el arreglo
        for (int i = 0; i < n; i++) {
            // comparamos si coincide el codigo
            if (codigos[i].equalsIgnoreCase(codigoBuscado)) {
                // mostramos el nombre del empleado
                System.out.println("empleado encontrado: " + nombres[i]);
                encontrado = true;
                break;
            }
        }

        // si no hubo coincidencia
        if (!encontrado) {
            // mostramos aviso de no existencia
            System.out.println("no existe un empleado con el codigo ingresado");
        }

        // cerramos el scanner
        sc.close();
    }
}
