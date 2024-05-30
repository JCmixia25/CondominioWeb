/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.ConsultasAdmin;
import DAO.ConsultasManto;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;

import Models.Anuncio;
import java.util.List;
import javax.annotation.PostConstruct;


@ManagedBean(name = "bkn_Admin")
public class AdminController implements Serializable {

    private List<Anuncio> listaAnuncios;

    @PostConstruct
    public void init() {

        listarAnuncios();

    }
    
    public void listarAnuncios(){
        
        ConsultasAdmin consulta = new ConsultasAdmin();

        try {
            setListaAnuncios(consulta.consultarAnuncios());
        } catch (Exception e) {
            System.out.println("Error al listar anuncios");
        }
        
    }

    public List<Anuncio> getListaAnuncios() {
        return listaAnuncios;
    }

    public void setListaAnuncios(List<Anuncio> listaAnuncios) {
        this.listaAnuncios = listaAnuncios;
    }

}
