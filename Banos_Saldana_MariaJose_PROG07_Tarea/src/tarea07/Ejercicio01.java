package tarea07;

import java.util.Set;
import java.util.HashSet;

/**
 * Ejercicio 1. Creando conjuntos de países.
 *
 * @author María José Baños Saldaña
 */
public class Ejercicio01 {

    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        
        // Constantes
        // (No hay variables constantes para este ejercicio)
        
        // Variables de entrada       
        // (No hay variables de entrada para este ejercicio)

        // Variables auxiliares
        String[] arrayPaisesUE, arrayMayoresEconomias;

        // Variables de salida
        Set<String> setPaisesUE, setMayoresEconomias, union, interseccion, diferencia;
        
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        
        // No hay entrada de datos, pues se usa un número fijo de elementos
        
        System.out.println("CONJUNTOS DE PAISES DE LA UE Y PAISES CON LAS MAYORES ECONOMÍAS MUNDIALES");
        System.out.println("-------------------------------------------------------------------------");

        
        //----------------------------------------------
        //                  Procesamiento
        //----------------------------------------------
        
        // Inicializamos los arrays que vamos a utilizar
        arrayPaisesUE = Utilidades.getARRAY_PAISES_UE();
        arrayMayoresEconomias = Utilidades.getARRAY_PAISES_MUNDO();

        // Inicializamos las colecciones que vamos a utilizar
        // Al usar conjuntos (Set) garantizamos que no se pueden repetir elementos
        setPaisesUE = new HashSet<>();
        setMayoresEconomias = new HashSet<>();

        // Rellenamos los conjuntos de los paises de la UE.
        for (String pais : arrayPaisesUE) {
            setPaisesUE.add(pais);
        }

        // Rellenamos los conjuntos de los paises con las mayores economías mundiales.
        for (String pais : arrayMayoresEconomias) {
            setMayoresEconomias.add(pais);
        }

        // Unión de los dos conjuntos
        union = new HashSet<>(setPaisesUE);
        union.addAll(setMayoresEconomias);

        // Intersección de los conjuntos
        interseccion = new HashSet<>(setPaisesUE);
        interseccion.retainAll(setMayoresEconomias);

        // Diferencia de los conjuntos
        diferencia = new HashSet<>(setMayoresEconomias);
        diferencia.removeAll(setPaisesUE);

        
        //----------------------------------------------
        //              Salida de Resultados 
        //----------------------------------------------
        
        // Recorremos los conjuntos y mostramos su contenido por pantalla
        System.out.printf("Conjunto C1 (países UE):\n");
        Utilidades.mostrarPaises(setPaisesUE);

        System.out.printf("\nConjunto C2 (países mayores economías):\n");
        Utilidades.mostrarPaises(setMayoresEconomias);

        System.out.printf("\nUnión C1 y C2:\n");
        Utilidades.mostrarPaises(union);

        System.out.printf("\nInterseccion C1 y C2:\n");
        Utilidades.mostrarPaises(interseccion);

        System.out.printf("\nDiferencia C1 y C2:\n");
        Utilidades.mostrarPaises(diferencia);

    }
}
