package sv.edu.udb.www.proyecto_2023.managedBeans;

import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.NavigationHandler;
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.RequestScoped;
import jakarta.faces.context.ExternalContext;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import sv.edu.udb.www.proyecto_2023.entities.UsuariosEntity;
import sv.edu.udb.www.proyecto_2023.model.UsuariosModel;
import sv.edu.udb.www.proyecto_2023.util.JsfUtil;

import java.io.Serializable;

@Named
@SessionScoped
public class UserSessionBean implements Serializable {

    UsuariosModel modelo = new UsuariosModel();

    private boolean loggedIn;
    private UsuariosEntity usuarioSesion;

    private UsuariosEntity usuario;

    public UserSessionBean(){
        usuario = new UsuariosEntity();
    }

    public UsuariosEntity getUsuario() { return usuario; }

    public void setUsuario(UsuariosEntity usuario) { this.usuario = usuario; }


    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public UsuariosEntity getUsuarioSesion() {
        return usuarioSesion;
    }

    public void setUsuarioSesion(UsuariosEntity usuarioSesion) {
        this.usuarioSesion = usuarioSesion;
    }

    public String loginUsuario(){
        this.usuarioSesion = modelo.loginUsuario(usuario.getCorreo(), usuario.getPassword());
        if (usuarioSesion == null){
            JsfUtil.setErrorMessage(null,"Error de credenciales");
            return null;
        }else{
            this.loggedIn = true;
            JsfUtil.setFlashMessage("ok","Acceso correcto!");
            return "registroProyectos?faces-redirect=true";
        }
    }

    public void checkLoggedIn() {
        if (loggedIn) {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            NavigationHandler navigationHandler = facesContext.getApplication().getNavigationHandler();
            navigationHandler.handleNavigation(facesContext, null, "registroProyectos.xhtml?faces-redirect=true");
        }
    }

    public void checkYaLogueado() {
        if (!loggedIn) {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            NavigationHandler navigationHandler = facesContext.getApplication().getNavigationHandler();
            navigationHandler.handleNavigation(facesContext, null, "login.xhtml?faces-redirect=true");
        }
    }

    public String logOut(){
        this.loggedIn = false;
        this.usuarioSesion = null;
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        externalContext.invalidateSession();
        return "login?faces-redirect=true";
    }
}
