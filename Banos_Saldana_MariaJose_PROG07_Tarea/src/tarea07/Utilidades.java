package tarea07;

import java.util.Iterator;

/**
 * Clase Utilidades
 *
 * @author Profesor
 */
public class Utilidades {

    private static final String[] ARRAY_PAISES_UE = {
            "4.70 - Alemania (EUR)",
            "3.20 - Francia (EUR)",
            "2.40 - Italia (EUR)",
            "1.70 - España (EUR)",
            "1.20 - Países Bajos (EUR)",
            "0.86 - Polonia (EUR)",
            "0.66 - Bélgica (EUR)",
            "0.61 - Suecia (EUR)",
            "0.56 - Irlanda (EUR)",
            "0.54 - Austria (EUR)",
            "0.41 - Dinamarca (EUR)",
            "0.38 - Rumanía (EUR)",
            "0.34 - República Checa (EUR)",
            "0.31 - Finlandia (EUR)",
            "0.30 - Portugal (EUR)",
            "0.25 - Grecia (EUR)",
            "0.23 - Hungría (EUR)",
            "0.14 - Eslovaquia (EUR)",
            "0.11 - Bulgaria (EUR)",
            "0.09 - Luxemburgo (EUR)",
            "0.05 - Estonia (EUR)",
            "0.05 - Letonia (EUR)",
            "0.04 - Chipre (EUR)",
            "0.03 - Malta (EUR)",
            "0.09 - Lituania (EUR)",
            "0.09 - Croacia (EUR)",
            "0.07 - Eslovenia (EUR)"
    };

    private static final String[] ARRAY_PAISES_MUNDO = {
            "9.90 - Estados Unidos (AME)",
            "8.50 - China (ASI)",
            "4.70 - Alemania (EUR)",
            "4.28 - Japón (ASI)",
            "4.13 - India (ASI)",
            "3.96 - Reino Unido (EUR)",
            "3.20 - Francia (EUR)",
            "2.40 - Italia (EUR)",
            "2.54 - Rusia (EUR)",
            "2.28 - Canadá (AME)",
            "2.26 - Brasil (AME)",
            "1.70 - España (EUR)",
            "1.86 - México (AME)",
            "1.86 - Corea del Sur (ASI)",
            "1.83 - Australia (OCE)",
            "1.57 - Turquía (EUR)",
            "1.44 - Indonesia (ASI)",
            "1.20 - Países Bajos (EUR)",
            "1.27 - Arabia Saudita (ASI)",
            "1.04 - Polonia (EUR)"
    };
    
    /**
     * Devuelve el Array de paises de la UE
     *
     * @return ARRAY_PAISES_UE
     */
    public static String[] getARRAY_PAISES_UE() {

        return Utilidades.ARRAY_PAISES_UE;
    }

    /**
     * Devuelve el Array de paises del mundo
     *
     * @return ARRAY_PAISES_MUNDO
     */
    public static String[] getARRAY_PAISES_MUNDO() {

        return Utilidades.ARRAY_PAISES_MUNDO;
    }
        
    /** Recorre cualquier colección que implemente Iterable y muestra
     *  cada elemento uno a uno por pantalla con su formato correspondiente
     *
     * @param paises colección a mostrar por pantalla
     */
    public static void mostrarPaises(Iterable<String> paises) {
        
        int cont = 0;
        Iterator<String> it = paises.iterator();

        while (it.hasNext()) {
            System.out.printf("%d. %s\n", ++cont, it.next());
        }
    }
}
