package sv.edu.udb.www.proyecto_2023.model;
import java.util.List;
import jakarta.persistence.*;
import sv.edu.udb.www.proyecto_2023.entities.UsuariosEntity;
import sv.edu.udb.www.proyecto_2023.util.JpaUtil;
import sv.edu.udb.www.proyecto_2023.entities.RecursoGestionesEntity;
public class RecursosGestionesModel {


    public List<RecursoGestionesEntity> listarRecursosGestiones(){

        EntityManager em = JpaUtil.getEntityManager();

        try{
            Query con = em.createNamedQuery("recurso_gestiones.allRecursoGestiones");
            List<RecursoGestionesEntity> lista = con.getResultList();
            em.close();
            return lista;


        }catch (Exception e){
            em.close();
            return null;
        }
    }

    public RecursoGestionesEntity obtenerRecursoGestion (String idRecurso){
        EntityManager em = JpaUtil.getEntityManager();

        try{

            RecursoGestionesEntity recurso = em.find(RecursoGestionesEntity.class,idRecurso);
            em.close();
            return recurso;
        }catch (Exception e){
            em.close();
            return null;
        }
    }

    public int insertarRecurso (RecursoGestionesEntity recurso){
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tran = em.getTransaction();

        try{
            tran.begin();
            em.persist(recurso);
            tran.commit();
            em.close();
            return 1;
        }catch (Exception e){
            em.close();
            return 0;
        }
    }

    public int modificarRecurso (RecursoGestionesEntity recurso){
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tran = em.getTransaction();

        try{
            tran.begin();
            em.merge(recurso);
            tran.commit();
            em.close();
            return 1;
        }catch (Exception e){
            em.close();
            return 0;
        }
    }

    public int eliminarRecurso(String idRecurso){
        EntityManager em = JpaUtil.getEntityManager();
        int filas =0;

        try{

            RecursoGestionesEntity rec = em.find(RecursoGestionesEntity.class,idRecurso);
            if (rec !=null){
                EntityTransaction tran = em.getTransaction();
                tran.begin();
                em.remove(rec);
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
