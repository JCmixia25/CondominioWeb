/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.ConsultasDAO;
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

    private Long cuenta_id;
    private Long transaccion_id;
    private Long servicio_id;
    //usuario
    private String nombreUsuario;

    @PostConstruct
    public void init() {

        obtenerSesion();

    }

    public void obtenerSesion() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        Map<String, Object> sessionMap = externalContext.getSessionMap();

        // Asumiendo que "miObjeto" es el nombre clave bajo el cual guardaste el objeto en la sesión
        Usuario user = (Usuario) sessionMap.get("sesion");
        setNombreUsuario(user.getNombre_usuario());
    }

    public void registrarPago() {

        ConsultasDAO consulta = new ConsultasDAO();
        Transaccion transaccion = new Transaccion();

        transaccion.setCuenta_id(cuenta_id);
        transaccion.setTransaccion_id(transaccion_id);

        try {
            consulta.insertarCliente(transaccion);
        } catch (Exception e) {

        }

    }

}
