package sv.edu.udb.www.proyecto_2023.managedBeans;
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.RequestScoped;
import sv.edu.udb.www.proyecto_2023.entities.BitacoraProyectoEntity;
import sv.edu.udb.www.proyecto_2023.util.JsfUtil;
import java.util.List;
import sv.edu.udb.www.proyecto_2023.entities.GestionProyectoEntity;
import sv.edu.udb.www.proyecto_2023.model.GestionProyectoModel;

@ManagedBean
@RequestScoped
public class GestionProyectoBean {

    GestionProyectoModel modelo = new GestionProyectoModel();

    private GestionProyectoEntity gestiones;

    private List<GestionProyectoEntity> listaGestiones;

    public GestionProyectoBean()
    {
        gestiones  = new GestionProyectoEntity();

    }

    public GestionProyectoEntity getGestiones() {
        return gestiones;
    }

    public void setGestiones(GestionProyectoEntity gestiones) {
        this.gestiones = gestiones;
    }

    public List<GestionProyectoEntity> gestListaGestiones(){
        return modelo.listarGestiones();

    }

    public String saveGestion (){
        if(modelo.obtenerGestion(gestiones.getIdGestion()) != null){
            if (modelo.modificarGestion(gestiones) !=1){
                JsfUtil.setErrorMessage(null,"Error al modificar el Gestion");
                return null;
            }else{
                JsfUtil.setFlashMessage("ok","Gestion modificado con exito!");
                return "registroGestion?faces-redirect=true";
            }
        } else {
            if (modelo.insertarGestion(gestiones) !=1){
                JsfUtil.setErrorMessage(null,"ya se registro esta Gestion");
                return null;
            }else{
                JsfUtil.setFlashMessage("ok","Gestion registrada con exito!");
                return "registroGestion?faces-redirect=true";
            }
        }


    }

    public String eliminarGestion(){
        String idGestion = JsfUtil.getRequest().getParameter("idGestion");

        if (modelo.eliminarGestion(idGestion)>0){
            JsfUtil.setFlashMessage(null,"Gestion eliminada correctamente");
        }else{
            JsfUtil.setErrorMessage(null,"No se pudo eliminar esta Gestion");
        }
        return "registroGestion?faces-redirect=true";
    }

    public String cargarProyecto(String id) {
        GestionProyectoEntity est = modelo.obtenerGestion(id);
        if (est != null) {
            gestiones = est; // Cargar los datos del estudiante en el formulario
        }
        return null; // No redireccionamos, permanecemos en la misma página
    }
}
