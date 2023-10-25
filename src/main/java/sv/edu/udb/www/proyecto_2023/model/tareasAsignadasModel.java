package sv.edu.udb.www.proyecto_2023.model;


import java.util.List;
import jakarta.persistence.*;
import sv.edu.udb.www.proyecto_2023.entities.TipoProyectoEntity;
import sv.edu.udb.www.proyecto_2023.util.JpaUtil;
import sv.edu.udb.www.proyecto_2023.entities.TareaAsignadasEntity;


public class tareasAsignadasModel {
    public List<TareaAsignadasEntity> listarTareasAsignadas(){

        EntityManager em = JpaUtil.getEntityManager();

        try{
            Query con = em.createNamedQuery("tarea_asignadas.allTareasAsignadas");
            List<TareaAsignadasEntity> lista = con.getResultList();
            em.close();
            return lista;


        }catch (Exception e){
            em.close();
            return null;
        }

    }


    public TareaAsignadasEntity obtenerTarea (String idTarea){
        EntityManager em = JpaUtil.getEntityManager();

        try{

            TareaAsignadasEntity tarea = em.find(TareaAsignadasEntity.class,idTarea);
            em.close();
            return tarea;
        }catch (Exception e){
            em.close();
            return null;
        }
    }

    public int insertarTarea (TareaAsignadasEntity tarea){
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tran = em.getTransaction();

        try{
            tran.begin();
            em.persist(tarea);
            tran.commit();
            em.close();
            return 1;
        }catch (Exception e){
            em.close();
            return 0;
        }
    }

    public int modificarTarea (TareaAsignadasEntity tarea){
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tran = em.getTransaction();

        try{
            tran.begin();
            em.merge(tarea);
            tran.commit();
            em.close();
            return 1;
        }catch (Exception e){
            em.close();
            return 0;
        }
    }

    public int eliminarTarea (String idTarea){
        EntityManager em = JpaUtil.getEntityManager();
        int filas =0;

        try{
            TareaAsignadasEntity tat = em.find(TareaAsignadasEntity.class,idTarea);
            if (tat !=null){
                EntityTransaction tran = em.getTransaction();
                tran.begin();
                em.remove(tat);
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
