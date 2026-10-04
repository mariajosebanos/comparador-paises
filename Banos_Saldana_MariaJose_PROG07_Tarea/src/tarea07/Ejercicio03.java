package tarea07;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/**
 * Ejercicio 3. Mapa de Continentes y Países
 *
 * @author Maria José Baños Saldaña
 */
public class Ejercicio03 {

    public static void main(String[] args) {

        //----------------------------------------------
        //    Declaración de variables y constantes
        //----------------------------------------------
        
        // Constantes
        // (No existen variables constantes para este ejercicio)
        
        // Variables de entrada
        // (No existen variables de entrada para este ejercicio)
        
        // Variables auxiliares
        List<String> listaPaises;

        // Variables de salida
        Map<String, List<String>> mapaPaisesPorContinente;
        Map<String, Double> mapaPIBPorContinente;
        
        
        //----------------------------------------------
        //               Entrada de datos 
        //----------------------------------------------
        
        // No se piden datos al usuario, ya que se usa un número fijo de elementos
        
        System.out.println("RELACIÓN DE PAISES y ACUMULADO DE PIB ORGANIZADOS POR CONTINENTES");
        System.out.println("-----------------------------------------------------------------");

        
        //----------------------------------------------
        //                  Procesamiento
        //----------------------------------------------
        
        // Instanciamos las variables con las que vamos a trabajar
        mapaPaisesPorContinente = new TreeMap<>();
        mapaPIBPorContinente = new TreeMap<>();
        listaPaises = new ArrayList<>(Arrays.asList(Utilidades.getARRAY_PAISES_MUNDO()));

        // Recorremos la lista de países y creamos el mapa continentes => países del continente. 
        for (String pais : listaPaises) {

            // Extraemos el PIB para dividir el String es dos partes: {"1.70", "España (EUR)"}
            String[] parte1 = pais.split(" - ");
            double valorPIB = Double.parseDouble(parte1[0]);

            // Nos quedamos con la segunda parte {"España (EUR)"}
            String resto = parte1[1];

            // Extraemos el nombre del país dividiendo el String por " ("
            // El split genera: {"España", "EUR")}, por lo que tomamos la posición 0
            String[] parte2 = resto.split(" \\(");
            String nombrePais = parte2[0];

            // Extraemos el continente eliminando el último paréntesis
            // El split genera: {"EUR", ""}, por lo que tomamos la posición 0
            String continente = parte2[1].split("\\)")[0];

            // Si para el primer mapa el continente no existe como clave, se crea una nueva entrada con una lista vacía
            if (!mapaPaisesPorContinente.containsKey(continente)) {
                mapaPaisesPorContinente.put(continente, new ArrayList<>());
            }

            // Añadimos el país a la lista correspondiente a su continente
            mapaPaisesPorContinente.get(continente).add(nombrePais);

            // Si el continente no existe como clave, se inicializa su PIB acumulado a 0.0
            if (!mapaPIBPorContinente.containsKey(continente)) {
                mapaPIBPorContinente.put(continente, 0.0);
            }

            // Obtenemos el valor actual del PIB
            double pibActual = mapaPIBPorContinente.get(continente);
            // Actualizamos el PIB acumulado del continente
            mapaPIBPorContinente.put(continente, pibActual + valorPIB);
        }

        
        //----------------------------------------------
        //           Salida de resultados
        //----------------------------------------------
        
        System.out.printf("Contenido del mapa de países organizados por continentes:\n\n");

        for (Map.Entry<String, List<String>> elemento : mapaPaisesPorContinente.entrySet()) {
            System.out.printf("Países de %s: %s\n",
                    elemento.getKey(), elemento.getValue());

        }

        System.out.printf("\nContenido del mapa de PIB total por continente:\n\n");

        for (Map.Entry<String, Double> elemento : mapaPIBPorContinente.entrySet()) {
            System.out.printf("Continente: %s ---> PIB Total: %.2f\n",
                    elemento.getKey(), elemento.getValue());
        }

    }
}
