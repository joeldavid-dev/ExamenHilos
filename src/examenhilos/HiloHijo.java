package examenhilos;

import java.io.File;

public class HiloHijo extends Thread {

    private String ruta;
    private String patron;

    public HiloHijo(String ruta, String patron) {
        this.ruta = ruta;
        this.patron = patron;
    }

    @Override
    public void run() {
        HiloNieto nieto = new HiloNieto(ruta, patron);
        nieto.start();

        File carpeta = new File(ruta);
        String[] listado = carpeta.list();

        if (listado == null || listado.length == 0) {
            imp("No hay elementos dentro de la ruta dada");
        } else {
            for (String archivo : listado) {
                imp(archivo);
            }
        }
    }

    private void imp(String mensaje) {
        System.out.println(this.getName() + " (Hijo, listado general): " + mensaje);
    }
}
