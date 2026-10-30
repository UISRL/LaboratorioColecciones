package ejercicio09;

import java.util.ArrayList;
import java.util.Scanner;

// clase que representa un medicamento
class Medicamento {
    // atributos
    String nombre;
    int stockActual;
    int stockMinimo;
    double precioUnitario;

    // constructor
    public Medicamento(String nombre, int stockActual, int stockMinimo, double precioUnitario) {
        this.nombre = nombre;
        this.stockActual = stockActual;
        this.stockMinimo = stockMinimo;
        this.precioUnitario = precioUnitario;
    }

    // metodo para mostrar datos
    public void mostrar() {
        System.out.printf("nombre: %-15s | stock: %-4d | min: %-4d | precio: $%.2f\n",
                nombre, stockActual, stockMinimo, precioUnitario);
    }
}

public class Ejercicio09 {
    public static void main(String[] args) {
        // scanner para entrada de teclado
        Scanner sc = new Scanner(System.in);
        // lista de medicamentos
        ArrayList<Medicamento> lista = new ArrayList<>();

        int opcion;
        do {
            // menu de opciones
            System.out.println("\n--- menu farmacia ---");
            System.out.println("1. registrar medicamento");
            System.out.println("2. mostrar stock bajo el minimo");
            System.out.println("3. calcular valor economico total");
            System.out.println("4. actualizar stock por venta");
            System.out.println("5. reporte general de inventario");
            System.out.println("6. salir");
            System.out.print("elija una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    // registro de nuevo medicamento
                    System.out.print("nombre del medicamento: ");
                    String nom = sc.nextLine().trim();
                    System.out.print("stock actual: ");
                    int act = sc.nextInt();
                    System.out.print("stock minimo: ");
                    int min = sc.nextInt();
                    System.out.print("precio unitario: ");
                    double precio = sc.nextDouble();

                    // agregamos a la lista
                    lista.add(new Medicamento(nom, act, min, precio));
                    System.out.println("medicamento registrado con exito");
                    break;

                case 2:
                    // medicamentos bajo stock minimo
                    System.out.println("\n--- medicamentos con stock critico ---");
                    boolean hayCriticos = false;
                    for (Medicamento m : lista) {
                        // evaluamos si el stock es menor al minimo
                        if (m.stockActual < m.stockMinimo) {
                            m.mostrar();
                            hayCriticos = true;
                        }
                    }
                    if (!hayCriticos) {
                        System.out.println("ningun medicamento esta por debajo del minimo");
                    }
                    break;

                case 3:
                    // valor economico total
                    double valorTotal = 0.0;
                    for (Medicamento m : lista) {
                        // acumulamos stock * precio
                        valorTotal += (m.stockActual * m.precioUnitario);
                    }
                    System.out.printf("valor total del inventario: $%.2f\n", valorTotal);
                    break;

                case 4:
                    // actualizar stock por venta
                    System.out.print("ingrese el nombre del medicamento a vender: ");
                    String buscar = sc.nextLine().trim();
                    boolean encontrado = false;

                    for (Medicamento m : lista) {
                        // buscamos por nombre
                        if (m.nombre.equalsIgnoreCase(buscar)) {
                            encontrado = true;
                            System.out.print("ingrese cantidad vendida: ");
                            int cant = sc.nextInt();
                            // validamos que haya suficiente stock
                            if (cant <= m.stockActual) {
                                m.stockActual -= cant;
                                System.out.println("venta realizada. nuevo stock: " + m.stockActual);
                            } else {
                                System.out.println("error: stock insuficiente (disponible: " + m.stockActual + ")");
                            }
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("medicamento no encontrado");
                    }
                    break;

                case 5:
                    // reporte general
                    System.out.println("\n--- inventario general ---");
                    if (lista.isEmpty()) {
                        System.out.println("el inventario esta vacio");
                    } else {
                        for (Medicamento m : lista) {
                            m.mostrar();
                        }
                    }
                    break;

                case 6:
                    // salida
                    System.out.println("saliendo del sistema");
                    break;

                default:
                    System.out.println("opcion invalida");
            }
        } while (opcion != 6);

        // cerramos el scanner
        sc.close();
    }
}
