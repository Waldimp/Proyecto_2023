package sv.edu.udb.www.proyecto_2023.managedBeans;
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.RequestScoped;
import sv.edu.udb.www.proyecto_2023.entities.ProyectosEntity;
import sv.edu.udb.www.proyecto_2023.util.JsfUtil;
import sv.edu.udb.www.proyecto_2023.entities.TipoProyectoEntity;
import sv.edu.udb.www.proyecto_2023.model.TipoProyectoModel;
import java.util.List;
@ManagedBean
@RequestScoped
public class TipoProyectoBean {

    TipoProyectoModel modelo = new TipoProyectoModel();


    private TipoProyectoEntity tipoProyecto;

    private List<TipoProyectoEntity> listaTipoProyectos;

    public TipoProyectoBean(){
        tipoProyecto = new TipoProyectoEntity();
    }

    public TipoProyectoEntity getTipoProyecto() {
        return tipoProyecto;
    }

    public void setTipoProyecto(TipoProyectoEntity tipoProyecto) {
        this.tipoProyecto = tipoProyecto;
    }

    public List<TipoProyectoEntity> getListaTipoProyectos (){
        return modelo.listarTipoProyecto();
    }

    public String saveTipoProyecto(){
        if(modelo.obtenerTipoProyecto(tipoProyecto.getIdTipoProyecto()) != null) { // Modificar
            if (modelo.modificarTipoProyecto(tipoProyecto) !=1){
                JsfUtil.setErrorMessage(null,"Error al modificar el Tipo de Proyecto");
                return null;
            }else{
                JsfUtil.setFlashMessage("ok","Tipo de Proyecto modificado con exito!");
                return "registroTipoProyecto?faces-redirect=true";
            }
        }else{
            if (modelo.insertarTipoProyecto(tipoProyecto) !=1){
                JsfUtil.setErrorMessage(null,"ya se registro este Tipo de PROYECTO");
                return null;
            }else{
                JsfUtil.setFlashMessage("ok","Tipo de proyecto registrado con exito!");
                return "registroTipoProyecto?faces-redirect=true";
            }
        }
    }

    public String eliminarTipoProyecto(){
        String idTipoProyecto = JsfUtil.getRequest().getParameter("idTipoProyecto");

        if (modelo.eliminarTipoProyecto(idTipoProyecto)>0){
            JsfUtil.setFlashMessage(null,"Tipo de proyecto eliminado correctamente");
        }else{
            JsfUtil.setErrorMessage(null,"No se pudo eliminar este Tipo de proyecto");
        }
        return "registroTipoProyecto?faces-redirect=true";
    }

    public String cargarTipoProyecto(String id) {
        TipoProyectoEntity est = modelo.obtenerTipoProyecto(id);
        if (est != null) {
            tipoProyecto = est; // Cargar los datos del estudiante en el formulario
        }
        return null; // No redireccionamos, permanecemos en la misma página
    }
}
