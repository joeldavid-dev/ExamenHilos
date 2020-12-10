package examenhilos;
// Realizará la búsqueda de archivos y directorios sin distinción

import java.io.File;

public class HiloNieto extends Thread {

    //Atributos
    private String patron;

    //Constructores
    public HiloNieto(String patron) {
        this.patron = patron;
    }

    //Metodos
    @Override
    public void run() {
        HiloBisnietoDir bisnietoDir = new HiloBisnietoDir();
        HiloBisnietoArch bisnietoArch = new HiloBisnietoArch();
        bisnietoDir.start();
        bisnietoArch.start();

        imp("Recibí el patron " + patron);
    }

    private void imp(String mensaje) {
        System.out.println(this.getName() + " (Nieto, busqueda general): " + mensaje);
    }
}
