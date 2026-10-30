package ejercicio10;

import java.util.ArrayList;
import java.util.Scanner;

// clase que representa un pedido del restaurante
class Pedido {
    // atributos del pedido
    String cliente;
    String plato;
    int cantidad;
    double precioUnitario;

    // constructor
    public Pedido(String cliente, String plato, int cantidad, double precioUnitario) {
        this.cliente = cliente;
        this.plato = plato;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    // calcula el subtotal sin descuento
    public double calcularSubtotal() {
        return cantidad * precioUnitario;
    }

    // calcula el descuento del 10% si supera 50 usd
    public double calcularDescuento() {
        double subtotal = calcularSubtotal();
        if (subtotal > 50.0) {
            return subtotal * 0.10;
        }
        return 0.0;
    }

    // calcula el total final a pagar
    public double calcularTotal() {
        return calcularSubtotal() - calcularDescuento();
    }

    // muestra el detalle del pedido
    public void mostrarDetalle() {
        System.out.printf("cliente: %-12s | plato: %-12s | cant: %-2d | subtotal: $%.2f | desc: $%.2f | total: $%.2f\n",
                cliente, plato, cantidad, calcularSubtotal(), calcularDescuento(), calcularTotal());
    }
}

public class Ejercicio10 {
    public static void main(String[] args) {
        // scanner para capturar datos
        Scanner sc = new Scanner(System.in);
        // lista para almacenar pedidos
        ArrayList<Pedido> pedidos = new ArrayList<>();

        int opcion;
        do {
            // menu de opciones
            System.out.println("\n--- menu restaurante ---");
            System.out.println("1. registrar pedido");
            System.out.println("2. mostrar pedidos con totales a pagar");
            System.out.println("3. calcular ingreso total del restaurante");
            System.out.println("4. mostrar pedido de mayor valor");
            System.out.println("5. salir");
            System.out.print("elija una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    // registro de datos del pedido
                    System.out.print("nombre del cliente: ");
                    String cli = sc.nextLine().trim();
                    System.out.print("plato solicitado: ");
                    String pla = sc.nextLine().trim();
                    System.out.print("cantidad: ");
                    int cant = sc.nextInt();
                    System.out.print("precio unitario: ");
                    double precio = sc.nextDouble();

                    // anadimos el nuevo pedido a la lista
                    Pedido p = new Pedido(cli, pla, cant, precio);
                    pedidos.add(p);
                    System.out.printf("pedido registrado. total a pagar: $%.2f\n", p.calcularTotal());
                    break;

                case 2:
                    // listar pedidos y total a pagar de cada uno
                    System.out.println("\n--- lista de pedidos ---");
                    if (pedidos.isEmpty()) {
                        System.out.println("no hay pedidos registrados");
                    } else {
                        for (Pedido ped : pedidos) {
                            ped.mostrarDetalle();
                        }
                    }
                    break;

                case 3:
                    // calculo del ingreso total acumulado
                    double ingresoTotal = 0.0;
                    for (Pedido ped : pedidos) {
                        ingresoTotal += ped.calcularTotal();
                    }
                    System.out.printf("\ningreso total del restaurante: $%.2f\n", ingresoTotal);
                    break;

                case 4:
                    // buscar pedido de mayor valor
                    if (pedidos.isEmpty()) {
                        System.out.println("no hay pedidos registrados");
                    } else {
                        Pedido mayor = pedidos.get(0);
                        for (Pedido ped : pedidos) {
                            if (ped.calcularTotal() > mayor.calcularTotal()) {
                                mayor = ped;
                            }
                        }
                        System.out.println("\n--- pedido de mayor valor ---");
                        mayor.mostrarDetalle();
                    }
                    break;

                case 5:
                    // salir del programa
                    System.out.println("saliendo del sistema");
                    break;

                default:
                    System.out.println("opcion invalida");
            }
        } while (opcion != 5);

        // cerramos el scanner
        sc.close();
    }
}
