package examenhilos;

import java.io.File;

public class HiloNieto extends Thread {

    private String ruta;
    private String patron;

    public HiloNieto(String ruta, String patron) {
        this.ruta = ruta;
        this.patron = patron;
    }

    @Override
    public void run() {
        HiloBisnietoDir bisnietoDir = new HiloBisnietoDir(ruta, patron);
        HiloBisnietoArch bisnietoArch = new HiloBisnietoArch(ruta, patron);
        bisnietoDir.start();
        bisnietoArch.start();

        File carpeta = new File(ruta);
        File[] archivos = carpeta.listFiles();

        int nMaches = 0;
        if (archivos == null || archivos.length == 0) {
            imp("No hay elementos dentro de la ruta dada");
        } else {
            try {
                for (File archivo : archivos) {
                    if (archivo.getName().matches(patron)) {
                        nMaches++;
                        imp("Patron encontrado en '" + archivo.getName() + "' | (" + archivo.length() + " bytes)");
                    }
                }

                if (nMaches == 0) {
                    imp("No hay elementos que coincidan con el patron.");
                }
            } catch (Exception ex) {
                imp("ERROR. El patron no esta bien redactado.");
            }
        }
    }

    private void imp(String mensaje) {
        System.out.println(this.getName() + " (Nieto, busqueda general): " + mensaje);
    }
}
