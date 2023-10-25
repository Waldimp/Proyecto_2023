package sv.edu.udb.www.proyecto_2023.model;
import java.util.List;
import jakarta.persistence.*;
import sv.edu.udb.www.proyecto_2023.entities.UsuariosEntity;
import sv.edu.udb.www.proyecto_2023.util.JpaUtil;
import sv.edu.udb.www.proyecto_2023.entities.TipoProyectoEntity;
public class TipoProyectoModel {

    public List<TipoProyectoEntity> listarTipoProyecto(){

        EntityManager em = JpaUtil.getEntityManager();

        try{
            Query con = em.createNamedQuery("tipo_proyecto.allTipoProyecto");
            List<TipoProyectoEntity> lista = con.getResultList();
            em.close();
            return lista;


        }catch (Exception e){
            em.close();
            return null;
        }
    }

    public TipoProyectoEntity obtenerTipoProyecto (String idTipo){
        EntityManager em = JpaUtil.getEntityManager();

        try{

            TipoProyectoEntity Tipo = em.find(TipoProyectoEntity.class,idTipo);
            em.close();
            return Tipo;
        }catch (Exception e){
            em.close();
            return null;
        }
    }

    public int insertarTipoProyecto (TipoProyectoEntity tipo){
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tran = em.getTransaction();

        try{
            tran.begin();
            em.persist(tipo);
            tran.commit();
            em.close();
            return 1;
        }catch (Exception e){
            em.close();
            return 0;
        }
    }

    public int modificarTipoProyecto (TipoProyectoEntity tipo){
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tran = em.getTransaction();

        try{
            tran.begin();
            em.merge(tipo);
            tran.commit();
            em.close();
            return 1;
        }catch (Exception e){
            em.close();
            return 0;
        }
    }

    public int eliminarTipoProyecto (String idTipo){
        EntityManager em = JpaUtil.getEntityManager();
        int filas =0;

        try{

            TipoProyectoEntity tip = em.find(TipoProyectoEntity.class,idTipo);
            if (tip !=null){
                EntityTransaction tran = em.getTransaction();
                tran.begin();
                em.remove(tip);
                tran.commit();
                filas =1;
            }
            em.close();
            return filas;

        }catch (Exception e){
            em.close();
            return 0;
        }
    }
}
