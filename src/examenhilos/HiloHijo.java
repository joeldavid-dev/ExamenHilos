package examenhilos;
//Lista todos los archivos de la ruta

import java.io.File;

public class HiloHijo extends Thread {

    //Atributos
    private String ruta;
    private String patron;

    //Constructores
    public HiloHijo(String ruta, String patron) {
        this.ruta = ruta;
        this.patron = patron;
    }

    //Metodos
    @Override
    public void run() {
        HiloNieto nieto = new HiloNieto(patron);
        nieto.start();

        File carpeta = new File(ruta);
        String[] listado = carpeta.list();
        if (listado == null || listado.length == 0) {
            System.out.println("No hay elementos dentro de la carpeta actual");
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
