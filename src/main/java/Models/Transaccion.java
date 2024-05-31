/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.io.Serializable;

/**
 *
 * @author CompuFire
 */
public class Transaccion implements Serializable {

    private Long id_transaccion;
    private Long cuenta_id;
    private Long transaccion_id;
    private Long servicio_id;
    private float monto;

    public Transaccion(Long cuenta_id, Long transaccion_id, Long servicio_id, float monto) {
        this.cuenta_id = cuenta_id;
        this.transaccion_id = transaccion_id;
        this.servicio_id = servicio_id;
        this.monto = monto;
    }

    public Transaccion() {
    }
    
    
    
    /**
     * @return the id_transaccion
     */
    public Long getId_transaccion() {
        return id_transaccion;
    }

    /**
     * @param id_transaccion the id_transaccion to set
     */
    public void setId_transaccion(Long id_transaccion) {
        this.id_transaccion = id_transaccion;
    }

    /**
     * @return the cuenta_id
     */
    public Long getCuenta_id() {
        return cuenta_id;
    }

    /**
     * @param cuenta_id the cuenta_id to set
     */
    public void setCuenta_id(Long cuenta_id) {
        this.cuenta_id = cuenta_id;
    }

    /**
     * @return the transaccion_id
     */
    public Long getTransaccion_id() {
        return transaccion_id;
    }

    /**
     * @param transaccion_id the transaccion_id to set
     */
    public void setTransaccion_id(Long transaccion_id) {
        this.transaccion_id = transaccion_id;
    }

    /**
     * @return the servicio_id
     */
    public Long getServicio_id() {
        return servicio_id;
    }

    /**
     * @param servicio_id the servicio_id to set
     */
    public void setServicio_id(Long servicio_id) {
        this.servicio_id = servicio_id;
    }

    /**
     * @return the monto
     */
    public float getMonto() {
        return monto;
    }

    /**
     * @param monto the monto to set
     */
    public void setMonto(float monto) {
        this.monto = monto;
    }
    
    
}
