package tarea07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Ejercicio 2. Trabajando con listas de paises
 *
 * @author María José Baños Saldaña
 */
public class Ejercicio02 {

    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        
        // Constantes
        // (No hay variables constantes en este ejercicio)
        
        // Variables de entrada
        List<String> listaPaisesUE;
        List<String> listaMayoresEconomias;

        // Variables auxiliares
        String[] arrayPaisesUE, arrayMayoresEconomias;
        int indice;

        // Variables de salida
        List<String> listaPaisesMasRicosUE;
        Set<String> conjuntoPaisesMasRicosUE;

        
        //----------------------------------------------
        //               Entrada de datos 
        //----------------------------------------------
        
        // No hay entrada de datos, pues se usa un número fijo de elementos.
        
        System.out.println("LISTAS DE PAISES");
        System.out.println("----------------");

        // Inicializamos los arrays que vamos a utilizar
        arrayPaisesUE = Utilidades.getARRAY_PAISES_UE();
        arrayMayoresEconomias = Utilidades.getARRAY_PAISES_MUNDO();

        // Instanciamos las colecciones para trabajar con ellas
        listaPaisesUE = new ArrayList<>();
        listaMayoresEconomias = new ArrayList<>();

        // Rellenamos las listas de los paises correspondientes
        Collections.addAll(listaPaisesUE, arrayPaisesUE);
        Collections.addAll(listaMayoresEconomias, arrayMayoresEconomias);

        
        //----------------------------------------------
        //               Procesamiento
        //----------------------------------------------
        
        //Instanciamos las variables necesarias
        listaPaisesMasRicosUE = new ArrayList<>();
        conjuntoPaisesMasRicosUE = new HashSet<>();

        System.out.println();
        System.out.printf("Contenido inicial de la lista países de la UE:  \n");
        Utilidades.mostrarPaises(listaPaisesUE);

        System.out.println();
        System.out.printf("Contenido inicial de la lista de países con mayores economías:  \n");
        Utilidades.mostrarPaises(listaMayoresEconomias);

        // Recorremos la lista de paises de la UE
        Iterator<String> iterador = listaPaisesUE.iterator();
        indice = 0;
        while (iterador.hasNext()) {
            String pais = iterador.next();

            // Extraemos el PIB de cada país para dividir el String es dos partes: {1.70, España (EUR}
            String[] partes = pais.split(" - ");
            double valorPIB = Double.parseDouble(partes[0]);

            // Si el PIB supera el billón de euros
            if (valorPIB > 1.0) {
                listaPaisesMasRicosUE.add(pais);
                conjuntoPaisesMasRicosUE.add(pais);
                String paisRico = "$$" + pais + "$$";
                listaPaisesUE.set(indice, paisRico);
            }
            indice++;
        }

        // Ordenación de la lista por nombre del pais (alfabético) y la mostramos por pantalla
        System.out.println();
        System.out.printf("Ordenación de la lista de países con mayores economías por nombre (alfabético):\n");
        Collections.sort(listaMayoresEconomias, new ComparadorPaisesPorNombre());
        Utilidades.mostrarPaises(listaMayoresEconomias);

        // Ordenación de la lista de paises por PIB y la mostramos por pantalla
        System.out.println();
        System.out.printf("Ordenación de la lista de paises con mayores economías por PIB:\n");
        Collections.sort(listaMayoresEconomias, new ComparadorPaisesPorPIB());
        Utilidades.mostrarPaises(listaMayoresEconomias);

        
        //----------------------------------------------
        //            Salida de resultados
        //----------------------------------------------
        
        System.out.println();
        System.out.printf("Contenido final de la lista de Paises de la UE:\n");
        Utilidades.mostrarPaises(listaPaisesUE);

        System.out.println();
        System.out.printf("Contenido final de la lista de países de la UE con PIB superior a 1 Billón:\n");
        Utilidades.mostrarPaises(listaPaisesMasRicosUE);

        System.out.println();
        System.out.printf("Contenido final del conjunto de países de la UE con PIB superior a 1 Billón:\n");
        Utilidades.mostrarPaises(conjuntoPaisesMasRicosUE);

    }
}

/**
 * Clase que permite comparar dos paises usando como criterio de comparación su
 * nombre. Se trata de una comparación alfabética.
 *
 * @author María José Baños Saldaña
 */
class ComparadorPaisesPorNombre implements Comparator<String> {

    /**
     * Comparación de dos objetos de tipo <code>String</code> que representan
     * países, usando como criterio de comparación el <strong>nombre del
     * país</strong>. Se trata de una comparación de tipo lexicográfica
     * (alfabética), ignorando mayúsculas y minúsculas.
     *
     * El resultado de la comparación será:
     * <ul>
     * <li>negativo si el nombre del primer país es "menor" o se sitúa antes que
     * el segundo en orden alfabético,</li>
     * <li>cero si ambos nombres son iguales,</li>
     * <li>positivo si el nombre del primer país es "mayor" o se sitúa después
     * que el segundo en orden alfabético.</li>
     * </ul>
     *
     * @param pais1 primer término de la comparación (primer país)
     * @param pais2 segundo término de la comparación (segundo país)
     * @return resultado de la comparación según el nombre del país
     */
    @Override
    public int compare(String pais1, String pais2) {

        /* Primero, mediante el método split(" - "), se separa el PIB del resto,
        obteniendo en la posición 1 la cadena "Alemania (EUR)".
        A continuación, se realiza un segundo split(" (") sobre esa cadena,
        separando el nombre del país del continente.
        De esta forma, el nombre del país se obtiene en la posición 0 del array resultante.
         */
        String p1 = pais1.split(" - ")[1].split(" \\(")[0];
        String p2 = pais2.split(" - ")[1].split(" \\(")[0];

        // Comparamos el nombre de ambos países alfabéticamente de manera ascendiente
        return p1.compareToIgnoreCase(p2);

    }

}

/**
 * Clase que permite comparar dos paises usando como criterio de comparación su
 * PIB.
 *
 * @author María José Baños Saldaña
 */
class ComparadorPaisesPorPIB implements Comparator<String> {

    /**
     * Comparación de dos objetos de tipo <code>String</code> que representan
     * países, usando como criterio de comparación el <strong>Producto Interior
     * Bruto (PIB)</strong>
     * de cada país. Para ello, se extrae el valor numérico del PIB a partir de
     * la cadena de texto y se realiza una comparación de tipo numérica
     * (double).
     *
     * El resultado de la comparación será:
     * <ul>
     * <li>negativo si el PIB del primer país es menor o se sitúa antes que el
     * segundo al ordenarlos (menor valor de PIB),</li>
     * <li>cero si ambos países tienen el mismo PIB,</li>
     * <li>positivo si el PIB del primer país es mayor o se sitúa después que el
     * segundo al ordenarlos (mayor valor de PIB).</li>
     * </ul>
     *
     * @param pais1 primer término de la comparación (primer país)
     * @param pais2 segundo término de la comparación (segundo país)
     * @return resultado de la comparación según el valor del PIB
     */
    @Override
    public int compare(String pais1, String pais2) {

        // Utilizando el método split(), extramos el PIB de cada país
        String[] partes1 = pais1.split(" - ");
        double valorPIB1 = Double.parseDouble(partes1[0]);

        String[] partes2 = pais2.split(" - ");
        double valorPIB2 = Double.parseDouble(partes2[0]);

        return Double.compare(valorPIB1, valorPIB2);
    }

}
