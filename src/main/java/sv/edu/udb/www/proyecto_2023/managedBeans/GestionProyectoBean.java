package sv.edu.udb.www.proyecto_2023.managedBeans;
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.RequestScoped;
import sv.edu.udb.www.proyecto_2023.entities.BitacoraProyectoEntity;
import sv.edu.udb.www.proyecto_2023.entities.ProyectosEntity;
import sv.edu.udb.www.proyecto_2023.entities.RecursoGestionesEntity;
import sv.edu.udb.www.proyecto_2023.model.ProyectosModel;
import sv.edu.udb.www.proyecto_2023.model.RecursosGestionesModel;
import sv.edu.udb.www.proyecto_2023.util.JsfUtil;

import java.text.SimpleDateFormat;
import java.util.List;
import sv.edu.udb.www.proyecto_2023.entities.GestionProyectoEntity;
import sv.edu.udb.www.proyecto_2023.model.GestionProyectoModel;

@ManagedBean
@RequestScoped
public class GestionProyectoBean {

    GestionProyectoModel modelo = new GestionProyectoModel();

    ProyectosModel proyectosModel = new ProyectosModel();
    RecursosGestionesModel recursosGestionesModel = new RecursosGestionesModel();
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
            ProyectosEntity proy = proyectosModel.obtenerProyectos(gestiones.getIdProyecto());
            gestiones.setProyectosByIdProyecto(proy);

            RecursoGestionesEntity recurso = recursosGestionesModel.obtenerRecursoGestion(gestiones.getIdTipoRecurso());
            gestiones.setRecursoGestionesByIdGestion(recurso);

            if (modelo.modificarGestion(gestiones) !=1){
                JsfUtil.setErrorMessage(null,"Error al modificar el Gestion");
                return null;
            }else{
                JsfUtil.setFlashMessage("ok","Gestion modificado con exito!");
                return "registroGestionProyecto?faces-redirect=true";
            }
        } else {
            ProyectosEntity proy = proyectosModel.obtenerProyectos(gestiones.getIdProyecto());
            gestiones.setProyectosByIdProyecto(proy);

            RecursoGestionesEntity recurso = recursosGestionesModel.obtenerRecursoGestion(gestiones.getIdTipoRecurso());
            gestiones.setRecursoGestionesByIdGestion(recurso);

            if (modelo.insertarGestion(gestiones) !=1){
                JsfUtil.setErrorMessage(null,"ya se registro esta Gestion");
                return null;
            }else{
                JsfUtil.setFlashMessage("ok","Gestion registrada con exito!");
                return "registroGestionProyecto?faces-redirect=true";
            }
        }


    }

    public String eliminarGestion(){
        String idGestion = JsfUtil.getRequest().getParameter("idGestion");

        if (modelo.eliminarGestion(Long.parseLong(idGestion))>0){
            JsfUtil.setFlashMessage("ok","Gestion eliminada correctamente");
        }else{
            JsfUtil.setErrorMessage(null,"No se pudo eliminar esta Gestion");
        }
        return "registroGestionProyecto?faces-redirect=true";
    }

    public String cargarProyecto(long id) {
        GestionProyectoEntity est = modelo.obtenerGestion(id);
        if (est != null) {
            gestiones = est; // Cargar los datos del estudiante en el formulario
        }
        return null; // No redireccionamos, permanecemos en la misma página
    }

    public String reload(){
        return "registroGestionProyecto?faces-redirect=true";
    }

    public String fecha(java.util.Date _fecha){
        if (_fecha == null) {
            return "";
        }
        SimpleDateFormat mdyFormat = new SimpleDateFormat("dd/MM/yyyy");
        return mdyFormat.format(_fecha);
    }
}
