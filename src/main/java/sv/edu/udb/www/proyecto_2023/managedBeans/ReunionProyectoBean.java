package sv.edu.udb.www.proyecto_2023.managedBeans;


import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.RequestScoped;
import sv.edu.udb.www.proyecto_2023.entities.ProyectosEntity;
import sv.edu.udb.www.proyecto_2023.util.JsfUtil;
import sv.edu.udb.www.proyecto_2023.entities.ReunionProyectoEntity;
import sv.edu.udb.www.proyecto_2023.model.ReunionProyectoModel;
import java.util.List;
@ManagedBean
@RequestScoped
public class ReunionProyectoBean {

    ReunionProyectoModel modelo = new ReunionProyectoModel();

    private ReunionProyectoEntity reunionProyecto;

    private List<ReunionProyectoEntity> listaReuniones;

    public ReunionProyectoBean(){

        reunionProyecto = new ReunionProyectoEntity();
    }

    public ReunionProyectoEntity getReunionProyecto() {
        return reunionProyecto;
    }

    public void setReunionProyecto(ReunionProyectoEntity reunionProyecto) {
        this.reunionProyecto = reunionProyecto;
    }

    public List<ReunionProyectoEntity> getListaReuniones(){
        return modelo.listaReuniones();
    }


    public String saveReunionProyecto(){
        if(modelo.obtenerReunionesProyecto(reunionProyecto.getIdReunion()) != null){ // Modificar
            if (modelo.modificarReunionProyecto(reunionProyecto) !=1){
                JsfUtil.setErrorMessage(null,"Error al modificar la Reunion");
                return null;
            }else{
                JsfUtil.setFlashMessage("ok","Reunion modificada con exito!");
                return "registroReunionesProyecto?faces-redirect=true";
            }
        } else {
            if (modelo.insertarReunionProyecto(reunionProyecto) !=1){
                JsfUtil.setErrorMessage(null,"ya se registro esta Reunion");
                return null;
            }else{
                JsfUtil.setFlashMessage("ok","Reunion registrada con exito!");
                return "registroReunionesProyecto?faces-redirect=true";
            }
        }


    }

    public String eliminarReunionProyecto(){
        String idReunionProyecto = JsfUtil.getRequest().getParameter("idReunionProyecto");

        if (modelo.eliminarReunionProyecto(idReunionProyecto)>0){
            JsfUtil.setFlashMessage(null,"Reunion Proyecto eliminado correctamente");
        }else{
            JsfUtil.setErrorMessage(null,"No se pudo eliminar esta Reunion Proyecto");
        }
        return "registroReunionesProyecto?faces-redirect=true";
    }

    public String cargarReunionProyecto(String id) {
        ReunionProyectoEntity est = modelo.obtenerReunionesProyecto(id);
        if (est != null) {
            reunionProyecto = est; // Cargar los datos del estudiante en el formulario
        }
        return null; // No redireccionamos, permanecemos en la misma página
    }

}
