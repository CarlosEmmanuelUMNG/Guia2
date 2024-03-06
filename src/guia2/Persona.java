package guia2;
import java.util.Scanner;

public class Persona {
    public int cedula;
    public String nombre;
    public float estatura;
    public float edad;

    public Persona(int cedula, String nombre, float estatura, float edad) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.estatura = estatura;
        this.edad = edad;
    }
    public static void mergeSort(Persona[] arr, int l, int r, String criterio) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSort(arr, l, m, criterio);
            mergeSort(arr, m + 1, r, criterio);
            merge(arr, l, m, r, criterio);
        }
    }

    public static void bubbleSort(Persona[] arr, String criterio) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (criterio.equals("estatura")) {
                    if (arr[j].estatura > arr[j + 1].estatura) {
                        Persona temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                } else {
                    if (arr[j].edad > arr[j + 1].edad) {
                        Persona temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                }
            }
        }
    }

    private static void merge(Persona[] arr, int l, int m, int r, String criterio) {
        int n1 = m - l + 1;
        int n2 = r - m;

        Persona[] L = new Persona[n1];
        Persona[] R = new Persona[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2) {
            if (criterio.equals("estatura")) {
                if (L[i].estatura <= R[j].estatura) {
                    arr[k] = L[i];
                    i++;
                } else {
                    arr[k] = R[j];
                    j++;
                }
            } else { 
                if (L[i].edad <= R[j].edad) {
                    arr[k] = L[i];
                    i++;
                } else {
                    arr[k] = R[j];
                    j++;
                }
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
        public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el numero de personas:");
        float numPersonas = scanner.nextFloat();
        scanner.nextLine();

        Persona[] personas = new Persona[(int)numPersonas];

        for (int i = 0; i < numPersonas; i++) {
            System.out.println("Ingrese la cedula de la persona " + (i+1) + ":");
            int cedula = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Ingrese el nombre de la persona " + (i+1) + ":");
            String nombre = scanner.nextLine();

            System.out.println("Ingrese la estatura de la persona " + (i+1) + ":");
            float estatura = scanner.nextFloat();
            scanner.nextLine(); 

            System.out.println("Ingrese la edad de la persona " + (i+1) + ":");
            float edad = scanner.nextInt();
            scanner.nextLine(); 

            personas[i] = new Persona(cedula, nombre, estatura, edad);
        }

        System.out.println("¿Como desea ordenar las personas? (1: Estatura, 2: Edad)");
        int opcionOrdenamiento = scanner.nextInt();

        System.out.println("¿Que algoritmo de ordenamiento desea utilizar? (1: MergeSort, 2: Bubble Sort)");
        int opcionAlgoritmo = scanner.nextInt();

        if (opcionOrdenamiento == 1) {
            if (opcionAlgoritmo == 1) {
                mergeSort(personas, 0, personas.length - 1, "estatura");
            } else {
                bubbleSort(personas, "estatura");
            }
        } else {
            if (opcionAlgoritmo == 1) {
                mergeSort(personas, 0, personas.length - 1, "edad");
            } else {
                bubbleSort(personas, "edad");
            }
        }

        System.out.println("Personas ordenadas:");

        for (Persona persona : personas) {
            System.out.println(persona.nombre + " - Cedula: " + persona.cedula +
                    ", Estatura: " + persona.estatura + ", Edad: " + persona.edad);
        }
    }

    Persona() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}