package sv.edu.udb.www.proyecto_2023.managedBeans;


import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.RequestScoped;
import sv.edu.udb.www.proyecto_2023.entities.BitacoraProyectoEntity;
import sv.edu.udb.www.proyecto_2023.entities.ProyectosEntity;
import sv.edu.udb.www.proyecto_2023.model.BitacoraModel;
import sv.edu.udb.www.proyecto_2023.model.GestionProyectoModel;
import sv.edu.udb.www.proyecto_2023.model.ProyectosModel;
import sv.edu.udb.www.proyecto_2023.util.JsfUtil;

import java.text.SimpleDateFormat;
import java.util.List;

@ManagedBean
@RequestScoped
public class BitacoraBean {

BitacoraModel modelo = new BitacoraModel();
ProyectosModel proyectosModel = new ProyectosModel();

private BitacoraProyectoEntity bitacora;

private List<BitacoraProyectoEntity> listaBitacoras;

public BitacoraBean(){
    bitacora = new BitacoraProyectoEntity();
}

    public BitacoraProyectoEntity getBitacora() {
        return bitacora;
    }

    public void setBitacora(BitacoraProyectoEntity bitacora) {
        this.bitacora = bitacora;
    }

   public List<BitacoraProyectoEntity> getListaBitacoras(){
    return modelo.listaBitacoras();
   }

    public List<BitacoraProyectoEntity> getListaBitacorasProyecto(long idProyecto){

        return modelo.listaBitacorasProyecto(idProyecto);
    }

    public String saveBitacora(){
        if(modelo.obtenerProyectos(bitacora.getIdBitacora()) != null){
            ProyectosEntity proy = proyectosModel.obtenerProyectos(bitacora.getIdProyecto());
            bitacora.setProyectosByIdProyecto(proy);
            if (modelo.modificarBitacora(bitacora) !=1){
                JsfUtil.setErrorMessage(null,"Error al modificar el Bitacora");
                return null;
            }else{
                JsfUtil.setFlashMessage("ok","Bitacora modificado con exito!");
                return "registroBitacora?faces-redirect=true";
            }
        } else {
            ProyectosEntity proy = proyectosModel.obtenerProyectos(bitacora.getIdProyecto());
            bitacora.setProyectosByIdProyecto(proy);
            if (modelo.insertarBitacora(bitacora) !=1){
                JsfUtil.setErrorMessage(null,"ya se registro esta bitacora");
                return null;
            }else{
                JsfUtil.setFlashMessage("ok","Bitacora registrado con exito!");
                return "registroBitacora?faces-redirect=true";
            }
        }

    }

    public String saveBitacoraDesdeProyecto(){

        ProyectosEntity proy = proyectosModel.obtenerProyectos(bitacora.getIdProyecto());
        bitacora.setProyectosByIdProyecto(proy);

        if (modelo.insertarBitacora(bitacora) !=1){
            JsfUtil.setErrorMessage(null,"ya se registro esta bitacora");
            return null;
        }else{
            JsfUtil.setFlashMessage("ok","Bitacora registrado con exito!");
            return "verProyecto.xhtml?faces-redirect=true&id="+bitacora.getIdProyecto();
        }
    }

    public String guardarIdProyecto(long id) {
        ProyectosEntity est = proyectosModel.obtenerProyectos(id);
        if (est != null) {
            bitacora.setIdProyecto(id);

        }
        return null; // No redireccionamos, permanecemos en la misma página
    }

    public String eliminarBitacora(){
        String idBitacora = JsfUtil.getRequest().getParameter("idBitacora");

        if (modelo.eliminarBitacora(Long.parseLong(idBitacora))>0){
            JsfUtil.setFlashMessage("ok","Bitacora eliminada correctamente");
        }else{
            JsfUtil.setErrorMessage(null,"No se pudo eliminar esta Bitacora");
        }
        return "registroBitacora?faces-redirect=true";
    }

    public String cargarProyecto(long id) {
        BitacoraProyectoEntity est = modelo.obtenerProyectos(id);
        if (est != null) {
            bitacora = est; // Cargar los datos del estudiante en el formulario
        }
        return null; // No redireccionamos, permanecemos en la misma página
    }

    public String eliminarBitacoraProyectoUrl(long idBitacora) {
        if(idBitacora != 0){
            if (modelo.eliminarBitacora(idBitacora)>0){
                JsfUtil.setFlashMessage("ok","Bitacora eliminado correctamente");
            }else{
                JsfUtil.setErrorMessage(null,"No se pudo eliminar esta Bitacora");
            }
        }
        return null;
    }

    public String reload(){
        return "registroBitacora?faces-redirect=true";
    }

    public String conteoBitacoras(){
        return "" + modelo.listaBitacoras().size();
    }

    public String fecha(java.util.Date _fecha){
        if (_fecha == null) {
            return "";
        }
        SimpleDateFormat mdyFormat = new SimpleDateFormat("dd/MM/yyyy");
        return mdyFormat.format(_fecha);
    }
}
