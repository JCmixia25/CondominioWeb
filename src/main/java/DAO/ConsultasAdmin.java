/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Models.Anuncio;
import Models.Usuario;
import Models.Reporte;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author CompuFire
 */
public class ConsultasAdmin {

    ConexionDAO con = new ConexionDAO();

    public List<Anuncio> consultarAnuncios() throws Exception {
        List<Anuncio> anuncios = new ArrayList<Anuncio>();
        String query = "SELECT id_anuncio, usuario_id, descripcion fecha_publicacion, fecha_vencimiento FROM anuncio";
        try {

            Statement s = con.conexionMysql().createStatement();
            ResultSet r = s.executeQuery(query);

            while (r.next()) {
                Anuncio datos = new Anuncio();

                datos.setId_anuncio(r.getLong("id_anuncio"));
                datos.setUsuario_id(r.getLong("usuario_id"));
                datos.setDescripcion(r.getString("descripcion"));
//              datos.setImagen(r.getBlob("imagen"));
                datos.setFecha_publicacion(r.getString("fecha_publicacion"));
                datos.setFecha_vencimiento(r.getString("fecha_vencimiento"));
                anuncios.add(datos);
            }
        } catch (Exception e) {

            System.out.println("Error al consultar anuncios" + query);

            System.out.println("Error al consultar anuncios");

        } finally {
            if (con != null) {
                try {
                    con.conexionMysql().close();
                    System.out.println("Cierre de conexion exitosa");
                } catch (SQLException ex) {
                    System.out.println("Error al cerrar conexion");
                }
            }
        }
        return anuncios;
    }

}
