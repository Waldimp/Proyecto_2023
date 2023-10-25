package sv.edu.udb.www.proyecto_2023.managedBeans;


import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.RequestScoped;
import sv.edu.udb.www.proyecto_2023.entities.BitacoraProyectoEntity;
import sv.edu.udb.www.proyecto_2023.entities.ProyectosEntity;
import sv.edu.udb.www.proyecto_2023.model.BitacoraModel;
import sv.edu.udb.www.proyecto_2023.model.GestionProyectoModel;
import sv.edu.udb.www.proyecto_2023.util.JsfUtil;
import java.util.List;

@ManagedBean
@RequestScoped
public class BitacoraBean {

BitacoraModel modelo = new BitacoraModel();

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

    public String saveBitacora(){
//        bitacora.setDescripcionEvento("Nueva bitacora");

        if(modelo.obtenerProyectos(bitacora.getIdBitacora()) != null){
            if (modelo.modificarBitacora(bitacora) !=1){
                JsfUtil.setErrorMessage(null,"Error al modificar el Bitacora");
                return null;
            }else{
                JsfUtil.setFlashMessage("ok","Bitacora modificado con exito!");
                return "registroBitacora?faces-redirect=true";
            }
        } else {
            if (modelo.insertarBitacora(bitacora) !=1){
                JsfUtil.setErrorMessage(null,"ya se registro esta bitacora");
                return null;
            }else{
                JsfUtil.setFlashMessage("ok","Bitacora registrado con exito!");
                return "registroBitacora?faces-redirect=true";
            }
        }

    }

    public String eliminarBitacora(){
        String idBitacora = JsfUtil.getRequest().getParameter("idBitacora");

        if (modelo.eliminarBitacora(idBitacora)>0){
            JsfUtil.setFlashMessage("ok","Bitacora eliminada correctamente");
        }else{
            JsfUtil.setErrorMessage(null,"No se pudo eliminar esta Bitacora");
        }
        return "registroBitacora?faces-redirect=true";
    }

    public String cargarProyecto(String id) {
        BitacoraProyectoEntity est = modelo.obtenerProyectos(id);
        if (est != null) {
            bitacora = est; // Cargar los datos del estudiante en el formulario
        }
        return null; // No redireccionamos, permanecemos en la misma página
    }
}
