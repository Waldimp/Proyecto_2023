package sv.edu.udb.www.proyecto_2023.managedBeans;


import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.RequestScoped;
import sv.edu.udb.www.proyecto_2023.entities.ProyectosEntity;
import sv.edu.udb.www.proyecto_2023.entities.UsuariosEntity;
import sv.edu.udb.www.proyecto_2023.model.ProyectosModel;
import sv.edu.udb.www.proyecto_2023.model.UsuariosModel;
import sv.edu.udb.www.proyecto_2023.util.JsfUtil;
import sv.edu.udb.www.proyecto_2023.entities.ReunionProyectoEntity;
import sv.edu.udb.www.proyecto_2023.model.ReunionProyectoModel;

import java.text.SimpleDateFormat;
import java.util.List;
@ManagedBean
@RequestScoped
public class ReunionProyectoBean {

    ReunionProyectoModel modelo = new ReunionProyectoModel();
    ProyectosModel proyectosModel = new ProyectosModel();

    UsuariosModel usuariosModel = new UsuariosModel();
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
            ProyectosEntity proy = proyectosModel.obtenerProyectos(reunionProyecto.getIdProyecto());
            reunionProyecto.setProyectosByIdProyecto(proy);

            UsuariosEntity usu = usuariosModel.obtenerUsuario(reunionProyecto.getIdUsuario());
            reunionProyecto.setUsuariosByIdUsuario(usu);
            
            if (modelo.modificarReunionProyecto(reunionProyecto) !=1){
                JsfUtil.setErrorMessage(null,"Error al modificar la Reunion");
                return null;
            }else{
                JsfUtil.setFlashMessage("ok","Reunion modificada con exito!");
                return "registroReunionProyectos?faces-redirect=true";
            }
        } else {
            ProyectosEntity proy = proyectosModel.obtenerProyectos(reunionProyecto.getIdProyecto());
            reunionProyecto.setProyectosByIdProyecto(proy);

            UsuariosEntity usu = usuariosModel.obtenerUsuario(reunionProyecto.getIdUsuario());
            reunionProyecto.setUsuariosByIdUsuario(usu);

            if (modelo.insertarReunionProyecto(reunionProyecto) !=1){
                JsfUtil.setErrorMessage(null,"ya se registro esta Reunion");
                return null;
            }else{
                JsfUtil.setFlashMessage("ok","Reunion registrada con exito!");
                return "registroReunionProyectos?faces-redirect=true";
            }
        }


    }

    public String eliminarReunionProyecto(){
        String idReunionProyecto = JsfUtil.getRequest().getParameter("idReunionProyecto");

        if (modelo.eliminarReunionProyecto(Long.parseLong(idReunionProyecto))>0){
            JsfUtil.setFlashMessage("ok","Reunion Proyecto eliminado correctamente");
        }else{
            JsfUtil.setErrorMessage(null,"No se pudo eliminar esta Reunion Proyecto");
        }
        return "registroReunionProyectos?faces-redirect=true";
    }

    public String cargarReunionProyecto(long id) {
        ReunionProyectoEntity est = modelo.obtenerReunionesProyecto(id);
        if (est != null) {
            reunionProyecto = est; // Cargar los datos del estudiante en el formulario
        }
        return null; // No redireccionamos, permanecemos en la misma página
    }

    public String reload(){
        return "registroReunionProyectos?faces-redirect=true";
    }

    public String fecha(java.util.Date _fecha){
        if (_fecha == null) {
            return "";
        }
        SimpleDateFormat mdyFormat = new SimpleDateFormat("dd/MM/yyyy");
        return mdyFormat.format(_fecha);
    }

}
