package sv.edu.udb.www.proyecto_2023.managedBeans;


import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.RequestScoped;
import sv.edu.udb.www.proyecto_2023.util.JsfUtil;
import sv.edu.udb.www.proyecto_2023.entities.TareaAsignadasEntity;
import sv.edu.udb.www.proyecto_2023.model.tareasAsignadasModel;
import java.util.List;
@ManagedBean
@RequestScoped
public class TareasBean {

    tareasAsignadasModel modelo = new tareasAsignadasModel();

    private TareaAsignadasEntity tareas;
    private List<TareaAsignadasEntity> listaTareas;

    public TareasBean(){
        tareas = new TareaAsignadasEntity();
    }

    public TareaAsignadasEntity getTareas(){
        return tareas;
    }

    public void setTareas(TareaAsignadasEntity tareas) {
        this.tareas = tareas;
    }

    public List<TareaAsignadasEntity> getListaTareas(){
        return modelo.listarTareasAsignadas();
    }

    public String saveTarea(){
        if (modelo.insertarTarea(tareas) !=1){
            JsfUtil.setErrorMessage(null,"ya se registro este tarea");
            return null;
        }else{
            JsfUtil.setFlashMessage("ok","Tarea registrada con exito!");
            return "registroTareasAsignadas?faces-redirect=true";
        }
    }

    public String eliminarTareas(){
        String idTareaAsignada = JsfUtil.getRequest().getParameter("idTareaAsignada");

        if (modelo.eliminarTarea(idTareaAsignada)>0){
            JsfUtil.setFlashMessage(null,"Tarea Asignada eliminada correctamente");
        }else{
            JsfUtil.setErrorMessage(null,"No se pudo eliminar este Tarea Asignada");
        }
        return "registroTareasAsignadas?faces-redirect=true";
    }
}
