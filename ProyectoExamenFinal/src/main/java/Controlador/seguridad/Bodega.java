/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.seguridad;

/**
 *
 * @author visitante
 */
public class Bodega {
    
    int pkid;
    String fkidTipobodega;
    String nombre;
    String direccion;
    String estado;

    public Bodega(int pkid, String fkidTipobodega, String nombre, String direccion, String estado) {
        this.pkid = pkid;
        this.fkidTipobodega = fkidTipobodega;
        this.nombre = nombre;
        this.nombre = direccion;
        this.nombre = estado;
        
    }

    @Override
    public String toString() {
        return "Bodega{" + "pkid=" + pkid + ", fkidTipobodega=" + fkidTipobodega + ", nombre=" + nombre + ", direccion=" + direccion + ", estado=" + estado +'}';
    }
    
    public int getPkid() {
        return pkid;
    }

    public void setPkid(int pkid) {
        this.pkid = pkid;
    }

    public String getFkidTipobodega() {
        return fkidTipobodega;
    }

    public void setFkidTipobodega(String fkidTipobodega) {
        this.fkidTipobodega = fkidTipobodega;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Bodega() {
    }
   
}
