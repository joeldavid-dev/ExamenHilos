package examenhilos;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

//Solicita datos ruta, patron y espera a su hijo
public class HiloPrincipal {

    public static void main(String[] args) {
        String ruta = "";
        String patron = "";
        
        Scanner entradaEscaner = new Scanner(System.in);
        imp("Ruta del directorio a trabajar: ");
        ruta = entradaEscaner.nextLine();
        imp("Patrón de busqueda: ");
        patron = entradaEscaner.nextLine();

        HiloHijo hijo = new HiloHijo(ruta, patron);
        hijo.start();

        Thread[] arrayHilos = new Thread[5];
        ThreadGroup grupo = Thread.currentThread().getThreadGroup();
        imp("Esperando a " + grupo.activeCount() + " hijos");

        int grupoSize = grupo.enumerate(arrayHilos);
        for (int i = 0; i < grupoSize; i++) {
            System.out.println(i + ") Thread [" + arrayHilos[i].getName() + ", "
                    + arrayHilos[i].getPriority() + ", " + grupo.getName() + "]");
        }
        try {
            hijo.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(HiloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }

        imp("He terminado");
    }

    private static void imp(String mensaje) {
        System.out.println("HILO PRINCIPAL: " + mensaje);
    }
}
