package sv.edu.udb.www.proyecto_2023.managedBeans;
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.RequestScoped;
import sv.edu.udb.www.proyecto_2023.entities.ProyectosEntity;
import sv.edu.udb.www.proyecto_2023.util.JsfUtil;
import sv.edu.udb.www.proyecto_2023.entities.RecursoGestionesEntity;
import sv.edu.udb.www.proyecto_2023.model.RecursosGestionesModel;
import java.util.List;
@ManagedBean
@RequestScoped
public class RecursoGestionesBean {

    RecursosGestionesModel modelo = new RecursosGestionesModel();

    private RecursoGestionesEntity recursos;

    private List<RecursoGestionesEntity> listaRecursos;

    public RecursoGestionesBean(){
        recursos = new RecursoGestionesEntity();
    }

    public RecursoGestionesEntity getRecursos() {
        return recursos;
    }

    public void setRecursos(RecursoGestionesEntity recursos) {
        this.recursos = recursos;
    }

    public List<RecursoGestionesEntity> getListaRecursos(){
        return modelo.listarRecursosGestiones();
    }

    public String saveRecursoGestion(){
        if(modelo.obtenerRecursoGestion(recursos.getIdRecurso()) != null){ // Modificar
            if (modelo.modificarRecurso(recursos) !=1){
                JsfUtil.setErrorMessage(null,"Error al modificar el Recurso");
                return null;
            }else{
                JsfUtil.setFlashMessage("ok","Recurso modificado con exito!");
                return "registroRecursosGestion?faces-redirect=true";
            }
        } else {
            if (modelo.insertarRecurso(recursos) != 1) {
                JsfUtil.setErrorMessage(null, "ya se registro este Recurso");
                return null;
            } else {
                JsfUtil.setFlashMessage("ok", "Tipo de Recurso generado!");
                return "registroRecursosGestion?faces-redirect=true";
            }
        }
    }

    public String eliminarRecursos() {
        String idRecursoGestion = JsfUtil.getRequest().getParameter("idRecursoGestion");

        if (modelo.eliminarRecurso(idRecursoGestion)>0){
            JsfUtil.setFlashMessage(null,"Tipo de Recurso eliminado correctamente");
        }else{
            JsfUtil.setErrorMessage(null,"No se pudo eliminar este Recurso");
        }
        return "registroRecursosGestion?faces-redirect=true";
    }

    public String cargarProyecto(String id) {
        RecursoGestionesEntity est = modelo.obtenerRecursoGestion(id);
        if (est != null) {
            recursos = est; // Cargar los datos del estudiante en el formulario
        }
        return null; // No redireccionamos, permanecemos en la misma página
    }

}
