/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.ConsultasManto;
import Models.ControlReportes;
import Models.ControlReportes;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
//import org.primefaces.context.RequestContext;

@ManagedBean(name = "bkn_manto")

public class MantoController implements Serializable {

    /**
     * @return the id_reporte
     */
    public Long getId_reporte() {
        return id_reporte;
    }

    /**
     * @param id_reporte the id_reporte to set
     */
    public void setId_reporte(Long id_reporte) {
        this.id_reporte = id_reporte;
    }

    /**
     * @return the autor_id
     */
    public Long getAutor_id() {
        return autor_id;
    }

    /**
     * @param autor_id the autor_id to set
     */
    public void setAutor_id(Long autor_id) {
        this.autor_id = autor_id;
    }

    /**
     * @return the usuario_asignado_id
     */
    public Long getUsuario_asignado_id() {
        return usuario_asignado_id;
    }

    /**
     * @param usuario_asignado_id the usuario_asignado_id to set
     */
    public void setUsuario_asignado_id(Long usuario_asignado_id) {
        this.usuario_asignado_id = usuario_asignado_id;
    }

    /**
     * @return the imagen
     */
    public Long getImagen() {
        return imagen;
    }

    /**
     * @param imagen the imagen to set
     */
    public void setImagen(Long imagen) {
        this.imagen = imagen;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the fecha_creacion
     */
    public String getFecha_creacion() {
        return fecha_creacion;
    }

    /**
     * @param fecha_creacion the fecha_creacion to set
     */
    public void setFecha_creacion(String fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    /**
     * @return the fecha_cierre
     */
    public String getFecha_cierre() {
        return fecha_cierre;
    }

    /**
     * @param fecha_cierre the fecha_cierre to set
     */
    public void setFecha_cierre(String fecha_cierre) {
        this.fecha_cierre = fecha_cierre;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the listaReportes
     */
    public List<ControlReportes> getListaReportes() {
        return listaReportes;
    }

    /**
     * @param listaReportes the listaReportes to set
     */
    public void setListaReportes(List<ControlReportes> listaReportes) {
        this.listaReportes = listaReportes;
    }

    /**
     * @return the listaReportesManto2
     */
    public List<ControlReportes> getListaReportesManto2() {
        return listaReportesManto2;
    }

    /**
     * @param listaReportesManto2 the listaReportesManto2 to set
     */
    public void setListaReportesManto2(List<ControlReportes> listaReportesManto2) {
        this.listaReportesManto2 = listaReportesManto2;
    }

    /**
     * @return the listaReportesFiltrados
     */
    public List<ControlReportes> getListaReportesFiltrados() {
        return listaReportesFiltrados;
    }

    /**
     * @param listaReportesFiltrados the listaReportesFiltrados to set
     */
    public void setListaReportesFiltrados(List<ControlReportes> listaReportesFiltrados) {
        this.listaReportesFiltrados = listaReportesFiltrados;
    }

    /**
     * @return the listaReportesFiltrados2
     */
    public List<ControlReportes> getListaReportesFiltrados2() {
        return listaReportesFiltrados2;
    }

    /**
     * @param listaReportesFiltrados2 the listaReportesFiltrados2 to set
     */
    public void setListaReportesFiltrados2(List<ControlReportes> listaReportesFiltrados2) {
        this.listaReportesFiltrados2 = listaReportesFiltrados2;
    }

    /**
     * @return the listaReportesManto
     */
    public List<ControlReportes> getListaReportesManto() {
        return listaReportesManto;
    }

    /**
     * @param listaReportesManto the listaReportesManto to set
     */
    public void setListaReportesManto(List<ControlReportes> listaReportesManto) {
        this.listaReportesManto = listaReportesManto;
    }

    //Reporte
    private Long id_reporte;
    private Long autor_id;
    private Long usuario_asignado_id;
    private Long imagen;
    private String descripcion;
    private String fecha_creacion;
    private String fecha_cierre;
    private String estado;
    
    
    private List<ControlReportes>listaReportes;
    private List<ControlReportes> listaReportesFiltrados;
    private List<ControlReportes> listaReportesFiltrados2;
    
    // Filtro de Usuario Asignado ID de Mantenimiento 
    private List<ControlReportes> listaReportesManto;
    private List<ControlReportes> listaReportesManto2;
    
    
          public void listarReportesFiltrados() {
        try {
            if (listaReportes!= null) {
                setListaReportesFiltrados(listaReportes.stream()
                        .filter(reporte -> "resuelto".equalsIgnoreCase(reporte.getEstado()))
                        .collect(Collectors.toList()));
                System.out.println("Reportes filtrados encontrados: " + getListaReportesFiltrados().size());
            } else {
                System.out.println("No hay reportes para filtrar.");
            }
        } catch (Exception e) {
            System.out.println("Error al filtrar reportes");
            e.printStackTrace();
        }
    }
      
      public void listarReportesFiltrados2() {
    try {
        if (listaReportes!= null) {
            setListaReportesFiltrados2(listaReportes.stream()
                   .filter(reporte -> "pendiente".equalsIgnoreCase(reporte.getEstado()))
                   .collect(Collectors.toList()));
            System.out.println("Reportes filtrados encontrados: " + getListaReportesFiltrados2().size());
        } else {
            System.out.println("No hay reportes para filtrar.");
        }
    } catch (Exception e) {
        System.out.println("Error al filtrar reportes");
        e.printStackTrace();
    }
}
       
    public void listarReportes() {

        ConsultasManto consulta = new ConsultasManto();

        try {
            setListaReportes(consulta.consultarReportes());
            System.out.println("Reportes: " + consulta.consultarReportes());
        } catch (Exception e) {
            System.out.println("Error al listar usuarios");
        }

    }
    
     public void listarReportesFiltradosPorUsuarioAsignadoId() {
        try {
            if (getListaReportes()!= null) {
                // Filtrar reportes donde usuario_asignado_id es igual a 2
                setListaReportesManto(getListaReportes().stream()
                       .filter(reporte -> "2".equals(String.valueOf(reporte.getUsuario_asignado_id())))
                       .collect(Collectors.toList()));
                System.out.println("Reportes filtrados encontrados: " + getListaReportesManto().size());
            } else {
                System.out.println("No hay reportes para filtrar.");
            }
        } catch (Exception e) {
            System.out.println("Error al filtrar reportes");
            e.printStackTrace();
        }
    }
     
      public void listarReportesFiltradosPorUsuarioAsignadoId2() {
        try {
            if (getListaReportes()!= null) {
                // Filtrar reportes donde usuario_asignado_id es igual a 4
                setListaReportesManto2(getListaReportes().stream()
                       .filter(reporte -> "4".equals(String.valueOf(reporte.getUsuario_asignado_id())))
                       .collect(Collectors.toList()));
                System.out.println("Reportes filtrados encontrados: " + getListaReportesManto2().size());
            } else {
                System.out.println("No hay reportes para filtrar.");
            }
        } catch (Exception e) {
            System.out.println("Error al filtrar reportes");
            e.printStackTrace();
        }
    }
      
       @PostConstruct
        public void init() {
        listarReportes();
        listarReportesFiltrados();
        listarReportesFiltrados2();
        listarReportesFiltradosPorUsuarioAsignadoId();
        listarReportesFiltradosPorUsuarioAsignadoId2();


    } 
}

