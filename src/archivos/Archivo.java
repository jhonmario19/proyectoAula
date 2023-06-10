package archivos;

import java.io.File;

public abstract class Archivo {
    protected File archivo;
    
    public Archivo(String ruta){
        this.archivo = new File(ruta);
    }
    
    public File getArchivo(){return this.archivo;}
    public void setArchivo(File archivo){this.archivo = archivo;}
}
