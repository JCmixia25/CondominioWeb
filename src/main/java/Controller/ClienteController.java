/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.ConsultasDAO;
import Models.Cuenta;
import Models.Transaccion;
import Models.Usuario;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author CompuFire
 */
@ManagedBean(name = "bkn_cliente")

public class ClienteController {

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

    /**
     * @return the usuario_id
     */
    public Long getUsuario_id() {
        return usuario_id;
    }

    /**
     * @param usuario_id the usuario_id to set
     */
    public void setUsuario_id(Long usuario_id) {
        this.usuario_id = usuario_id;
    }

    AdminController accion = new AdminController();

    private Long cuenta_id;
    private Long transaccion_id;
    private Long servicio_id;
    private float monto;
    //usuario
    private String nombreUsuario;
    private Long usuario_id;
    //Cuenta

    @PostConstruct
    public void init() {

        obtenerSesion();
        accion.listarCuentas();

    }

    public void obtenerSesion() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        Map<String, Object> sessionMap = externalContext.getSessionMap();

        // Asumiendo que "miObjeto" es el nombre clave bajo el cual guardaste el objeto en la sesión
        Usuario user = (Usuario) sessionMap.get("sesion");
        setNombreUsuario(user.getNombre_usuario());
        setUsuario_id(user.getId_usuario());
    }

    public void registrarPago() {
        //Obtiene datos del usuario que ingreso
        obtenerSesion();

        ConsultasDAO consulta = new ConsultasDAO();
        Transaccion transaccion = new Transaccion();

        for (Cuenta cuenta : accion.getListaCuentas()) {
            if (cuenta.getUsuario_id() == usuario_id) {
                transaccion.setCuenta_id(cuenta.getId_cuenta());
                transaccion.setTransaccion_id(transaccion_id);
            }
        }

        try {
            consulta.insertarCliente(transaccion);
        } catch (Exception e) {

        }

    }

    /**
     * @return the nombreUsuario
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    /**
     * @param nombreUsuario the nombreUsuario to set
     */
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

}
