package sv.edu.udb.www.proyecto_2023.managedBeans;

import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.RequestScoped;
import org.eclipse.persistence.jpa.jpql.parser.DateTime;
import sv.edu.udb.www.proyecto_2023.util.JsfUtil;
import sv.edu.udb.www.proyecto_2023.entities.ProyectosEntity;
import sv.edu.udb.www.proyecto_2023.model.ProyectosModel;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
@ManagedBean
@RequestScoped
public class ProyectosBean {

    ProyectosModel modelo = new ProyectosModel();

    private ProyectosEntity proyecto;
    private List<ProyectosEntity> listaProyectos;

    public ProyectosBean(){

        proyecto = new ProyectosEntity();
    }

    public ProyectosEntity getProyecto(){

        return proyecto;
    }

    public void setProyecto(ProyectosEntity proyecto) {
        this.proyecto = proyecto;
    }

    public List<ProyectosEntity> getListaProyectos(){
        return modelo.listaProyectos();
    }

    public String saveProyecto(){
        if(modelo.obtenerProyectos(proyecto.getIdProyecto()) != null){ // Modificar
            if (modelo.modificarProyecto(proyecto) !=1){
                JsfUtil.setErrorMessage(null,"Error al modificar el Proyecto");
                return null;
            }else{
                JsfUtil.setFlashMessage("ok","Proyecto modificado con exito!");
                return "registroProyectos?faces-redirect=true";
            }
        } else {
            if (modelo.insertarProyecto(proyecto) !=1){
                JsfUtil.setErrorMessage(null,"ya se registro este Proyecto");
                return null;
            }else{
                JsfUtil.setFlashMessage("ok","Proyecto registrado con exito!");
                return "registroProyectos?faces-redirect=true";
            }
        }

    }

    public String eliminarProyecto(){
        String idProyecto = JsfUtil.getRequest().getParameter("idProyecto");

        if (modelo.eliminarProyecto(idProyecto)>0){
            JsfUtil.setFlashMessage(null,"Proyecto eliminado correctamente");
        }else{
            JsfUtil.setErrorMessage(null,"No se pudo eliminar este Proyecto");
        }
        return "registroProyectos?faces-redirect=true";
    }

    public String cargarProyecto(String id) {
        ProyectosEntity est = modelo.obtenerProyectos(id);
        if (est != null) {
            proyecto = est; // Cargar los datos del estudiante en el formulario
        }
        return null; // No redireccionamos, permanecemos en la misma página
    }
}
