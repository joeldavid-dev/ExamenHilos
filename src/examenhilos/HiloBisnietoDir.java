package examenhilos;
// Realizará la búsqueda de directorios

import java.io.File;

public class HiloBisnietoDir extends Thread {

    //Atributos
    private String ruta;
    private String patron;

    //Constructores
    public HiloBisnietoDir(String ruta, String patron) {
        this.ruta = ruta;
        this.patron = patron;
    }

    //Metodos
    @Override
    public void run() {
        File carpeta = new File(ruta);
        String[] listado = carpeta.list();

        int nMaches = 0;
        if (listado == null || listado.length == 0) {
            imp("No hay elementos dentro de la ruta dada");
        } else {
            try {
                for (String archivo : listado) {
                    if (archivo.matches(patron)) {
                        nMaches++;
                        imp("Encontrado en: " + archivo);
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
        System.out.println(this.getName() + " (Bisnieto, busqueda de directorios): " + mensaje);
    }
}
