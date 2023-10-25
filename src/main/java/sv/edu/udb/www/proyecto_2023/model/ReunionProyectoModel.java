package sv.edu.udb.www.proyecto_2023.model;

import java.util.List;
import jakarta.persistence.*;
import sv.edu.udb.www.proyecto_2023.entities.UsuariosEntity;
import sv.edu.udb.www.proyecto_2023.util.JpaUtil;
import sv.edu.udb.www.proyecto_2023.entities.ReunionProyectoEntity;

public class ReunionProyectoModel {

    public List<ReunionProyectoEntity> listaReuniones(){

        EntityManager em = JpaUtil.getEntityManager();

        try{
            Query con = em.createNamedQuery("reunion_proyecto.allReunionProyecto");
            List<ReunionProyectoEntity> lista = con.getResultList();
            em.close();
            return lista;

        }catch (Exception e){
            em.close();
            return null;
        }
    }

    public ReunionProyectoEntity obtenerReunionesProyecto (String idReunion){
        EntityManager em = JpaUtil.getEntityManager();

        try{

            ReunionProyectoEntity reunion = em.find(ReunionProyectoEntity.class,idReunion);
            em.close();
            return reunion;
        }catch (Exception e){
            em.close();
            return null;
        }
    }


    public int insertarReunionProyecto (ReunionProyectoEntity reunion){
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tran = em.getTransaction();

        try{
            tran.begin();
            em.persist(reunion);
            tran.commit();
            em.close();
            return 1;
        }catch (Exception e){
            em.close();
            return 0;
        }
    }

    public int modificarReunionProyecto (ReunionProyectoEntity reunion){
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tran = em.getTransaction();

        try{
            tran.begin();
            em.merge(reunion);
            tran.commit();
            em.close();
            return 1;
        }catch (Exception e){
            em.close();
            return 0;
        }
    }


    public int eliminarReunionProyecto (String idReunion){
        EntityManager em = JpaUtil.getEntityManager();
        int filas =0;

        try{

            ReunionProyectoEntity reu = em.find(ReunionProyectoEntity.class,idReunion);
            if (reu !=null){
                EntityTransaction tran = em.getTransaction();
                tran.begin();
                em.remove(reu);
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
