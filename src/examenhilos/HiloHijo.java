package examenhilos;
//Lista todos los archivos de la ruta
public class HiloHijo extends Thread {
    //Atributos
    private String ruta = "";
    private String patron = "";
    
    //Constructores
    public HiloHijo (String ruta, String patron){
        this.ruta = ruta;
        this.patron = patron;
    }
    
    //Metodos
    @Override
    public void run(){
        imp("Ruta: "+ruta+", patron: "+patron);
    }
    
    private void imp(String mensaje) {
        System.out.println(this.getName() +" (Hijo): " + mensaje);
    }
}
