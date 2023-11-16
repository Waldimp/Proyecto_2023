package sv.edu.udb.www.proyecto_2023.managedBeans;

import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.RequestScoped;
import sv.edu.udb.www.proyecto_2023.entities.ForoEntity;
import sv.edu.udb.www.proyecto_2023.entities.ProyectosEntity;
import sv.edu.udb.www.proyecto_2023.entities.ReunionProyectoEntity;
import sv.edu.udb.www.proyecto_2023.entities.UsuariosEntity;
import sv.edu.udb.www.proyecto_2023.model.ForoModel;
import sv.edu.udb.www.proyecto_2023.model.ProyectosModel;
import sv.edu.udb.www.proyecto_2023.model.UsuariosModel;
import sv.edu.udb.www.proyecto_2023.util.JsfUtil;

import java.text.SimpleDateFormat;
import java.util.List;

@ManagedBean
@RequestScoped
public class ForoBean {
    ForoModel modelo = new ForoModel();

    ProyectosModel proyectosModel = new ProyectosModel();
    UsuariosModel usuariosModel = new UsuariosModel();

    private ForoEntity foroProyecto;
    private List<ForoEntity> listaForo;

    public ForoBean(){
        foroProyecto = new ForoEntity();
    }

    public ForoEntity getForoProyecto() {
        return foroProyecto;
    }

    public void setForoProyecto(ForoEntity foroProyecto) {
        this.foroProyecto = foroProyecto;
    }

    public List<ForoEntity> getListaForoProyecto(long idProyecto){
        return modelo.listaForoProyecto(idProyecto);
    }

    public String saveForoProyectoDesdeProyecto(){
        ProyectosEntity proy = proyectosModel.obtenerProyectos(foroProyecto.getIdProyecto());
        foroProyecto.setProyectosByIdProyecto(proy);

        UsuariosEntity usu = usuariosModel.obtenerUsuario(foroProyecto.getIdUsuario());
        foroProyecto.setUsuariosByIdUsuario(usu);

        if (modelo.insertarForoProyecto(foroProyecto) !=1){
            JsfUtil.setErrorMessage(null,"Ya se registro este comentarios");
            return null;
        }else{
            JsfUtil.setFlashMessage("ok","Comentario registrado con exito!");
            return "verProyecto.xhtml?faces-redirect=true&id="+foroProyecto.getIdProyecto();
        }
    }

    public String guardarIdProyecto(long id, long idUser) {
        ProyectosEntity est = proyectosModel.obtenerProyectos(id);
        if (est != null) {
            foroProyecto.setIdProyecto(id);
            foroProyecto.setIdUsuario(idUser);
        }
        return null; // No redireccionamos, permanecemos en la misma página
    }

    public String fecha(java.util.Date _fecha){
        if (_fecha == null) {
            return "";
        }
        SimpleDateFormat mdyFormat = new SimpleDateFormat("dd/MM/yyyy");
        return mdyFormat.format(_fecha);
    }

    public String conteoMensajes(){
        return "" + modelo.listaForo().size();
    }

}
