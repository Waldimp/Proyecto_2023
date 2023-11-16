package sv.edu.udb.www.proyecto_2023.managedBeans;

import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.RequestScoped;
import org.eclipse.persistence.jpa.jpql.parser.DateTime;
import sv.edu.udb.www.proyecto_2023.entities.TipoProyectoEntity;
import sv.edu.udb.www.proyecto_2023.model.TipoProyectoModel;
import sv.edu.udb.www.proyecto_2023.util.JsfUtil;
import sv.edu.udb.www.proyecto_2023.entities.ProyectosEntity;
import sv.edu.udb.www.proyecto_2023.model.ProyectosModel;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
@ManagedBean
@RequestScoped
public class ProyectosBean {

    ProyectosModel modelo = new ProyectosModel();
    TipoProyectoModel modeloTipo = new TipoProyectoModel();

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
            TipoProyectoEntity tipo = modeloTipo.obtenerTipoProyecto(proyecto.getIdTipoProyecto());
            proyecto.setTipoProyectoByIdTipoProyecto(tipo);
            if (modelo.modificarProyecto(proyecto) !=1){
                JsfUtil.setErrorMessage(null,"Error al modificar el Proyecto");
                return null;
            }else{
                JsfUtil.setFlashMessage("ok","Proyecto modificado con exito!");
                return "registroProyectos?faces-redirect=true";
            }
        } else {
            TipoProyectoEntity tipo = modeloTipo.obtenerTipoProyecto(proyecto.getIdTipoProyecto());
            proyecto.setTipoProyectoByIdTipoProyecto(tipo);
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
        if (modelo.eliminarProyecto(Long.parseLong(idProyecto))>0){
            JsfUtil.setFlashMessage("ok","Proyecto eliminado correctamente");
        }else{
            JsfUtil.setErrorMessage(null,"No se pudo eliminar este Proyecto");
        }
        return "registroProyectos?faces-redirect=true";
    }

    public String cargarProyecto(long id) {
        ProyectosEntity est = modelo.obtenerProyectos(id);
        if (est != null) {
            proyecto = est; // Cargar los datos del estudiante en el formulario
        }
        return null; // No redireccionamos, permanecemos en la misma página
    }

    public String reload(){
        return "registroProyectos?faces-redirect=true";
    }

    public String conteoProyectos(){
        return "" + modelo.listaProyectos().size();
    }

    public String fecha(java.util.Date _fecha){
        if (_fecha == null) {
            return "";
        }
        SimpleDateFormat mdyFormat = new SimpleDateFormat("dd/MM/yyyy");
        return mdyFormat.format(_fecha);
    }
}
