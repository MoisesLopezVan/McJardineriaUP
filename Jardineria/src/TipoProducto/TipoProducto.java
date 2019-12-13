/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TipoProducto;

//import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author MoisesDario
 */
public class TipoProducto {
    String id_tipo,tipo;
    /*
    public SimpleStringProperty tipo = new SimpleStringProperty();
    public TipoProducto(String string) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public TipoProducto() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public String getTipo() {
    return tipo.get();
    }
     */
    public TipoProducto( String id_tipo,String tipo) {
        super();
        this.id_tipo = id_tipo;
        this.tipo = tipo;
    }

    public String getId_tipo() {
        return id_tipo;
    }

    public void setId(String id_tipo) {
        this.id_tipo = id_tipo;
    }
    
    public String getTipo() {
        return tipo;
    }
   
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
   
    
    
}
