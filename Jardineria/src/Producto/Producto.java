/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Producto;

/**
 *
 * @author MoisesDario
 */
public class Producto {
    String id_producto;
    String nombreproducto;
    String tipoproducto;
    String condicionactual;
    String fechaingreso;
    String id_tipo;
    
    public String getId_producto() {
        return id_producto;
    }

    public void setId_producto(String id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombreproducto() {
        return nombreproducto;
    }

    public void setNombreproducto(String nombreproducto) {
        this.nombreproducto = nombreproducto;
    }

    public String getTipoproducto() {
        return tipoproducto;
    }

    public void setTipoproducto(String tipoproducto) {
        this.tipoproducto = tipoproducto;
    }

    public String getCondicionactual() {
        return condicionactual;
    }

    public void setCondicionactual(String condicionactual) {
        this.condicionactual = condicionactual;
    }

    public String getFechaingreso() {
        return fechaingreso;
    }

    public void setFechaingreso(String fechaingreso) {
        this.fechaingreso = fechaingreso;
    }

    public String getId_tipo() {
        return id_tipo;
    }

    public void setId_tipo(String id_tipo) {
        this.id_tipo = id_tipo;
    }

    public Producto(String id_producto, String nombreproducto, String tipoproducto, String condicionactual, String fechaingreso, String id_tipo) {
        this.id_producto = id_producto;
        this.nombreproducto = nombreproducto;
        this.tipoproducto = tipoproducto;
        this.condicionactual = condicionactual;
        this.fechaingreso = fechaingreso;
        this.id_tipo = id_tipo;
    }
    
    public Producto(){
        
    }
    
}
