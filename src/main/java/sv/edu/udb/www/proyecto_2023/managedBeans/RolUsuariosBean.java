package sv.edu.udb.www.proyecto_2023.managedBeans;


import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.RequestScoped;
import sv.edu.udb.www.proyecto_2023.util.JsfUtil;
import sv.edu.udb.www.proyecto_2023.entities.RolUsuarioEntity;
import sv.edu.udb.www.proyecto_2023.model.RolUsuariosModel;
import java.util.List;
@ManagedBean
@RequestScoped
public class RolUsuariosBean {

RolUsuariosModel modelo = new RolUsuariosModel();

private RolUsuarioEntity rolUsuario;

private List<RolUsuarioEntity> listaRoles;

public RolUsuariosBean(){
    rolUsuario = new RolUsuarioEntity();
}

public RolUsuarioEntity getRolUsuario(){
    return rolUsuario;
}

public void setRolUsuario(RolUsuarioEntity rolUsuario){
    this.rolUsuario = rolUsuario;
}

public List<RolUsuarioEntity> getListaRoles(){
    return modelo.listaRoles();
}

public String saveRol(){
    if (modelo.insertarRolUsuario(rolUsuario)!=1){
        JsfUtil.setErrorMessage(null,"Ya se registro un rol con este ID");
        return null;
    }else{
        JsfUtil.setFlashMessage("ok","Rol registrado correctamente");
        return "registroRoles?faces-redirect=true";
    }
}

    public String eliminarRol() {
        // Leyendo el parametro enviado desde la vista
        String idRol= JsfUtil.getRequest().getParameter("idRol");

        if (modelo.eliminarRolUsuario(idRol) > 0) {
            JsfUtil.setFlashMessage("exito", "Rol eliminado correctamente");
        }
        else{
            JsfUtil.setErrorMessage(null, "No se pudo borrar a este alumno");
        }
        return "registroRoles?faces-redirect=true";
    }
}
