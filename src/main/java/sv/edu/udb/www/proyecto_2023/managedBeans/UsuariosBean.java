package sv.edu.udb.www.proyecto_2023.managedBeans;


import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.RequestScoped;
import sv.edu.udb.www.proyecto_2023.entities.ProyectosEntity;
import sv.edu.udb.www.proyecto_2023.util.JsfUtil;
import sv.edu.udb.www.proyecto_2023.entities.UsuariosEntity;
import sv.edu.udb.www.proyecto_2023.model.UsuariosModel;
import java.util.List;
@ManagedBean
@RequestScoped
public class UsuariosBean {

    UsuariosModel modelo = new UsuariosModel();

    private UsuariosEntity usuario;

    private List<UsuariosEntity> listaUsuarios;

    public UsuariosBean(){
        usuario = new UsuariosEntity();
    }

    public UsuariosEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuariosEntity usuario) {
        this.usuario = usuario;
    }

    public List<UsuariosEntity> getListaUsuarios(){
        return modelo.listarUsuarios();
    }

    public String saveUsuario(){
        if(modelo.obtenerUsuario(usuario.getIdUsuario()) != null){
            if (modelo.modificarUsuario(usuario) !=1){
                JsfUtil.setErrorMessage(null,"Error al modificar el usuario");
                return null;
            }else{
                JsfUtil.setFlashMessage("ok","Usuario modificado con exito!");
                return "registroUsuarios?faces-redirect=true";
            }

        }else{
            if (modelo.insertarUsuario(usuario) !=1){
                JsfUtil.setErrorMessage(null,"ya se registro este usuario");
                return null;
            }else{
                JsfUtil.setFlashMessage("ok","Usuario registrado con exito!");
                return "registroUsuarios?faces-redirect=true";
            }
        }

    }

    public String eliminarUsuario(){
        String idUsuario = JsfUtil.getRequest().getParameter("idUsuario");

        if (modelo.eliminarUsuario(idUsuario)>0){
            JsfUtil.setFlashMessage(null,"Usuario eliminado correctamente");
        }else{
            JsfUtil.setErrorMessage(null,"No se pudo eliminar este usuario");
        }
        return "registroUsuarios?faces-redirect=true";
    }

    public String cargarUsuario(String id) {
        UsuariosEntity est = modelo.obtenerUsuario(id);
        if (est != null) {
            usuario = est; // Cargar los datos del estudiante en el formulario
        }
        return null; // No redireccionamos, permanecemos en la misma página
    }
}
