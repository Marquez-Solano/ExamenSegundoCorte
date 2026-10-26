import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Estudiante {
    String nombre;
    double eval1;
    double eval2;
    double eval3;
    double promedio;
    String resultado;

    public Estudiante(String nombre, double eval1, double eval2, double eval3) {
        this.nombre = nombre;
        this.eval1 = eval1;
        this.eval2 = eval2;
        this.eval3 = eval3;
        this.promedio = (eval1 + eval2 + eval3) / 3.0;

        this.resultado = this.promedio >= 6.0 ? "APROBADO" : "REPROBADO";
    }
}

public class examen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Estudiante> estudiantes = new ArrayList<>();
        int opcion = 0;

        do {
            System.out.println("=====================================");
            System.out.println("       CONTROL DE CALIFICACIONES     ");
            System.out.println("=====================================");
            System.out.println("1. Registrar calificaciones");
            System.out.println("2. Mostrar estadísticas");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine();
            } else {
                scanner.nextLine();
                System.out.println("\nPor favor, ingrese un número válido.\n");
                continue;
            }

            switch (opcion) {
                case 1:
                    System.out.println("\n=====================================");
                    System.out.println("        REGISTRAR ESTUDIANTE         ");
                    System.out.println("=====================================");
                    System.out.print("¿Cuántos estudiantes registrará?: ");
                    int cantidad = scanner.nextInt();
                    scanner.nextLine();

                    for (int i = 1; i <= cantidad; i++) {
                        System.out.println("-------------------------------------");
                        System.out.println("Estudiante " + i);
                        System.out.println("-------------------------------------");
                        System.out.print("Nombre: ");
                        String nombre = scanner.nextLine();

                        System.out.print("Evaluación 1: ");
                        double eval1 = scanner.nextDouble();
                        System.out.print("Evaluación 2: ");
                        double eval2 = scanner.nextDouble();
                        System.out.print("Evaluación 3: ");
                        double eval3 = scanner.nextDouble();
                        scanner.nextLine();

                        Estudiante est = new Estudiante(nombre, eval1, eval2, eval3);
                        estudiantes.add(est);

                        System.out.printf("Promedio: %.2f\n", est.promedio);
                        System.out.println("Resultado: " + est.resultado);
                    }
                    System.out.println("-------------------------------------\n");
                    break;

                case 2:
                    System.out.println("\n=====================================");
                    System.out.println("       ESTADÍSTICAS DEL GRUPO        ");
                    System.out.println("=====================================");

                    int totalRegistrados = estudiantes.size();
                    if (totalRegistrados == 0) {
                        System.out.println("No hay estudiantes registrados todavía.\n");
                        break;
                    }

                    int aprobados = 0;
                    int reprobados = 0;
                    double sumaPromedios = 0;

                    for (Estudiante e : estudiantes) {
                        if (e.resultado.equals("APROBADO")) {
                            aprobados++;
                        } else {
                            reprobados++;
                        }
                        sumaPromedios += e.promedio;
                    }

                    double promedioGeneral = sumaPromedios / totalRegistrados;

                    System.out.println("Estudiantes registrados: " + totalRegistrados);
                    System.out.println("Estudiantes aprobados: " + aprobados);
                    System.out.println("Estudiantes reprobados: " + reprobados);
                    System.out.printf("Promedio general: %.2f\n", promedioGeneral);
                    System.out.println("=====================================\n");
                    break;

                case 3:
                    System.out.println("\nSaliendo del programa. ¡Hasta luego!");
                    break;

                default:
                    System.out.println("\nOpción inválida. Intente de nuevo.\n");
            }

        } while (opcion != 3);

        scanner.close();

    }
}


}

