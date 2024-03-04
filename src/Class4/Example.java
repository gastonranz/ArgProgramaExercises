package Class4;

import java.util.Arrays;

/**
 *
 * @author gaston_ranz
 */
public class Example {
    public static void main(String[] args) {
        int a = 8;
        int b = 2;
        int c = 4;
        boolean isAscendant = true;
        int[] ab = Example.ordenarNumeros(a, b, c, isAscendant);
        System.out.println(Arrays.toString(ab));
    }

    public static int[] ordenarNumeros(int a, int b, int c, boolean ascendente) {

        // Creamos un array con los 3 números
        int[] numeros = {a, b, c};
        // Recorremos el array desde el principio hasta el penúltimo elemento
        for (int i = 0; i < numeros.length - 1; i++) {
            // Buscamos el índice del elemento mínimo desde la posición i hasta el final
            int min = i;
            for (int j = i + 1; j < numeros.length; j++) {
                if (numeros[j] < numeros[min]) {
                    min = j;
                }
            }
            // Si el elemento mínimo no es el actual, lo intercambiamos
            if (min != i) {
                int aux = numeros[i];
                numeros[i] = numeros[min];
                numeros[min] = aux;
            }
        }
        // Retornamos el array ordenado dependiendo si el orden es ascendente o descendente
        if (ascendente) {
            return numeros;
        } else {
            int auxMin = numeros[0];
            numeros[0] = numeros[2];
            numeros[2] = auxMin;
            return numeros;
        }
    }
}