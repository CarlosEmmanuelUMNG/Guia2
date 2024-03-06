package guia2;
import static guia2.Persona.bubbleSort;
import static guia2.Persona.mergeSort;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Taller2 {
    
    Scanner scanner = new Scanner(System.in);
void tresuno() {
int opcion;
        
do{
        System.out.println("Operaciones matemáticas:");
        System.out.println("1. Suma de matrices");
        System.out.println("2. Producto de matrices");
        System.out.println("3. Producto de un escalar con una matriz");
        System.out.println("4. Traspuesta de una matriz");
        System.out.println("0. salir");
         opcion = scanner.nextInt();
        switch (opcion) {
            case 1:
                System.out.println("ponga el número de filas de las matrices:");
        int filasa = scanner.nextInt();
        System.out.println("ponga el número de columnas de las matrices:");
        int columnasa = scanner.nextInt();

        int[][] matriza1 = new int[filasa][columnasa];
        int[][] matriza2 = new int[filasa][columnasa];

        System.out.println("Ingrese la primera matriz:");
        llenarMatriz(matriza1);

        System.out.println("Ingrese la segunda matriz:");
        llenarMatriz(matriza2);
                imprimirMatriz(sumarMatriz(matriza1, matriza2));
                break;
            case 2:
                System.out.println("ponga el número de filas de las matrices:");
        int filasb = scanner.nextInt();
        System.out.println("ponga el número de columnas de las matrices:");
        int columnasb = scanner.nextInt();

        int[][] matrizb1 = new int[filasb][columnasb];
        int[][] matrizb2 = new int[filasb][columnasb];

        System.out.println("Ingrese la primera matriz:");
        llenarMatriz(matrizb1);

        System.out.println("Ingrese la segunda matriz:");
        llenarMatriz(matrizb2);
                imprimirMatriz(multiplicarMatrices(matrizb1, matrizb2));
                break;
            case 3:
                System.out.println("ponga el número de filas de las matrices:");
        int filasc = scanner.nextInt();
        System.out.println("ponga el número de columnas de las matrices:");
        int columnasc = scanner.nextInt();

        int[][] matrizc = new int[filasc][columnasc];
        

        System.out.println("Ingrese la primera matriz:");
        llenarMatriz(matrizc);

       
                System.out.println("Ingrese el escalar:");
                int escalar = scanner.nextInt();
                imprimirMatriz(MatrizEscalar(matrizc, escalar));
                break;
            case 4:
                System.out.println("ponga el número de filas de las matrices:");
        int filasd = scanner.nextInt();
        System.out.println("ponga el número de columnas de las matrices:");
        int columnasd = scanner.nextInt();

        int[][] matrizd = new int[filasd][columnasd];
        

        System.out.println("Ingrese la primera matriz:");
        llenarMatriz(matrizd);
                imprimirMatriz(traspuestaMatriz(matrizd));
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }while (opcion != 0);
}
    void llenarMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.println("ponga el elemento en la posición [" + i + "][" + j + "]:");
                matriz[i][j] = scanner.nextInt();
            }
        }
    }

    int[][] sumarMatriz(int[][] matriz1, int[][] matriz2) {
        int[][] resultado = new int[matriz1.length][matriz1[0].length];
        for (int i = 0; i < matriz1.length; i++) {
            for (int j = 0; j < matriz1[0].length; j++) {
                resultado[i][j] = matriz1[i][j] + matriz2[i][j];
            }
        }
        return resultado;
    }

    int[][] multiplicarMatrices(int[][] matriz1, int[][] matriz2) {
        int filas1 = matriz1.length;
        int columnas1 = matriz1[0].length;
        int columnas2 = matriz2[0].length;

        int[][] resultado = new int[filas1][columnas2];

        for (int i = 0; i < filas1; i++) {
            for (int j = 0; j < columnas2; j++) {
                for (int k = 0; k < columnas1; k++) {
                    resultado[i][j] += matriz1[i][k] * matriz2[k][j];
                }
            }
        }
        return resultado;
    }

    int[][] MatrizEscalar(int[][] matriz, int escalar) {
        int filas = matriz.length;
        int columnas = matriz[0].length;

        int[][] resultado = new int[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                resultado[i][j] = matriz[i][j] * escalar;
            }
        }
        return resultado;
    }

    int[][] traspuestaMatriz(int[][] matriz) {
        int filas = matriz.length;
        int columnas = matriz[0].length;

        int[][] resultado = new int[columnas][filas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                resultado[j][i] = matriz[i][j];
            }
        }
        return resultado;
    }

    void imprimirMatriz(int[][] matriz) {
        System.out.println("Resultado:");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }
    }
    
   void tresdos() {
        int[] tamanios = { 100, 500, 1000, 5000, 10000 };

        System.out.println("Tabla comparativa de tiempos de ordenamiento:");
       System.out.println("Tamaño    Burbuja (ms)    Inserción (ms)    Selección (ms)    Mergesort (ms)");

        for (int tamano : tamanios) {
            double[] arreglo = generarArregloAleatorio(tamano);

            long inicioBurbuja = System.currentTimeMillis();
            ordenarBurbuja(arreglo.clone());
            long finBurbuja = System.currentTimeMillis();

            long inicioInsercion = System.currentTimeMillis();
            ordenarInsercion(arreglo.clone());
            long finInsercion = System.currentTimeMillis();

            long inicioSeleccion = System.currentTimeMillis();
            ordenarSeleccion(arreglo.clone());
            long finSeleccion = System.currentTimeMillis();

            long inicioMergesort = System.currentTimeMillis();
            ordenarMergesort(arreglo.clone());
            long finMergesort = System.currentTimeMillis();

            System.out.printf("%-15d%-20d%-20d%-20d%-20d%n", tamano,(finBurbuja - inicioBurbuja),(finInsercion - inicioInsercion),(finSeleccion - inicioSeleccion),(finMergesort - inicioMergesort));
        }
    }



    void ordenarBurbuja(double[] arreglo) {
        int n = arreglo.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arreglo[j] > arreglo[j + 1]) {
                    double temp = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = temp;
                }
            }
        }
    }

    void ordenarInsercion(double[] arreglo) {
        int n = arreglo.length;
        for (int i = 1; i < n; ++i) {
            double key = arreglo[i];
            int j = i - 1;
            while (j >= 0 && arreglo[j] > key) {
                arreglo[j + 1] = arreglo[j];
                j = j - 1;
            }
            arreglo[j + 1] = key;
        }
    }

    void ordenarSeleccion(double[] arreglo) {
        int n = arreglo.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arreglo[j] < arreglo[minIndex]) {
                    minIndex = j;
                }
            }
            double temp = arreglo[minIndex];
            arreglo[minIndex] = arreglo[i];
            arreglo[i] = temp;
        }
    }

    void ordenarMergesort(double[] arreglo) {
        if (arreglo.length > 1) {
            int mitad = arreglo.length / 2;
            double[] izquierda = Arrays.copyOfRange(arreglo, 0, mitad);
            double[] derecha = Arrays.copyOfRange(arreglo, mitad, arreglo.length);

            ordenarMergesort(izquierda);
            ordenarMergesort(derecha);

            fusionar(arreglo, izquierda, derecha);
        }
    }

    void fusionar(double[] arreglo, double[] izquierda, double[] derecha) {
        int i = 0, j = 0, k = 0;

        while (i < izquierda.length && j < derecha.length) {
            if (izquierda[i] <= derecha[j]) {
                arreglo[k++] = izquierda[i++];
            } else {
                arreglo[k++] = derecha[j++];
            }
        }

        while (i < izquierda.length) {
            arreglo[k++] = izquierda[i++];
        }

        while (j < derecha.length) {
            arreglo[k++] = derecha[j++];
        }
    }

    double[] generarArregloAleatorio(int tamano) {
        double[] arreglo = new double[tamano];
        Random random = new Random();

        for (int i = 0; i < tamano; i++) {
            arreglo[i] = random.nextDouble();
        }

        return arreglo;
    }


    void trestres() {
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

    
    void menu() {
        int opc;
        
        do {
            System.out.println("bienvenido al desarrollo del taller 2, elija el ejercicio a desarrollar:");
            System.out.println("1. Operaciones con matrices (3.1)");
            System.out.println("2. Ordenar arreglos (3.2)");
            System.out.println("3. Ordenar personas (3.3)");
            
            System.out.println("0. salir");
            opc = scanner.nextInt();

            switch (opc) {
                case 1:
                    tresuno();
                    break;
                case 2:
                    tresdos();
                    break;
                case 3:
                    trestres();
                    break;
                
                case 0:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Dato no válido.");
                    break;
            }
        } while (opc != 0);
    }

    public static void main(String[] args) {
        Taller2 taller = new Taller2();
        taller.menu();
    }
}