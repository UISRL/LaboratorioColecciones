package ejercicio08;

import java.util.Scanner;

// clase que representa el registro de un trabajador
class Trabajador {
    // atributos del trabajador
    String codigo;
    int horasAusencia;
    int defectuosos;
    int producidos;
    int gradoEficiencia;

    // constructor para inicializar datos
    public Trabajador(String codigo, int horasAusencia, int defectuosos, int producidos) {
        this.codigo = codigo;
        this.horasAusencia = horasAusencia;
        this.defectuosos = defectuosos;
        this.producidos = producidos;
        this.gradoEficiencia = calcularGrado();
    }

    // metodo para evaluar condiciones y asignar grado
    private int calcularGrado() {
        // condicion a: ausencia <= 3 horas
        boolean c1 = this.horasAusencia <= 3;
        // condicion b: defectuosos < 300
        boolean c2 = this.defectuosos < 300;
        // condicion c: producidos > 10000
        boolean c3 = this.producidos > 10000;

        // asignacion segun las combinaciones de condiciones
        if (c1 && c2 && c3) {
            return 20; // cumple las tres condiciones
        } else if (!c1 && c2 && c3) {
            return 15; // cumple segunda y tercera
        } else if (c1 && !c2 && c3) {
            return 13; // cumple primera y tercera
        } else if (c1 && c2 && !c3) {
            return 12; // cumple primera y segunda
        } else if (!c1 && !c2 && c3) {
            return 9;  // solo cumple tercera
        } else if (!c1 && c2 && !c3) {
            return 8;  // solo cumple segunda
        } else if (c1 && !c2 && !c3) {
            return 7;  // solo cumple primera
        } else {
            return 5;  // no cumple ninguna
        }
    }

    // metodo para mostrar los datos del trabajador
    public void mostrarInfo() {
        System.out.println("codigo: " + codigo + 
                " | ausencias: " + horasAusencia + " hrs" +
                " | defectuosos: " + defectuosos + 
                " | producidos: " + producidos + 
                " | grado: " + gradoEficiencia);
    }
}

public class Ejercicio08 {
    public static void main(String[] args) {
        // scanner para entrada por teclado
        Scanner sc = new Scanner(System.in);

        // pedimos la cantidad n de operarios
        System.out.print("ingrese cantidad de operarios (n): ");
        int n = sc.nextInt();

        // arreglo de objetos trabajador
        Trabajador[] trabajadores = new Trabajador[n];

        // lectura de datos de cada trabajador
        for (int i = 0; i < n; i++) {
            System.out.println("\n--- datos del trabajador " + (i + 1) + " ---");
            // solicitamos codigo
            System.out.print("codigo: ");
            String cod = sc.next();
            // solicitamos horas de ausencia
            System.out.print("horas de ausencia: ");
            int aus = sc.nextInt();
            // solicitamos pupitres defectuosos
            System.out.print("pupitres defectuosos: ");
            int def = sc.nextInt();
            // solicitamos pupitres producidos
            System.out.print("pupitres producidos: ");
            int prod = sc.nextInt();

            // creamos y guardamos el objeto en el arreglo
            trabajadores[i] = new Trabajador(cod, aus, def, prod);
        }

        // impresion del reporte general de eficiencia
        System.out.println("\n=== reporte de eficiencia de operarios ===");
        for (int i = 0; i < n; i++) {
            // mostramos informacion del operario
            trabajadores[i].mostrarInfo();
        }

        // cerramos el scanner
        sc.close();
    }
}
