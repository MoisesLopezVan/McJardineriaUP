/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Historial;

/**
 *
 * @author SAINZ
 */
public class HistorialFotografia {
        String id_historial,fechahistorial,fotografia,id_producto,producto;

    public HistorialFotografia(String id_historial, String fechahistorial, String fotografia, String id_producto, String producto) {
        this.id_historial = id_historial;
        this.fechahistorial = fechahistorial;
        this.fotografia = fotografia;
        this.id_producto = id_producto;
        this.producto = producto;
    }
          
    public String getId_historial() {
        return id_historial;
    }

    public void setId_historial(String id_historial) {
        this.id_historial = id_historial;
    }

    public String getFechahistorial() {
        return fechahistorial;
    }

    public void setFechahistorial(String fechahistorial) {
        this.fechahistorial = fechahistorial;
    }

    public String getFotografia() {
        return fotografia;
    }

    public void setFotografia(String fotografia) {
        this.fotografia = fotografia;
    }

    public String getId_producto() {
        return id_producto;
    }

    public void setId_producto(String id_producto) {
        this.id_producto = id_producto;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

  
        
}
