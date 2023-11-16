package sv.edu.udb.www.proyecto_2023.model;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import sv.edu.udb.www.proyecto_2023.entities.ForoEntity;
import sv.edu.udb.www.proyecto_2023.util.JpaUtil;

import java.util.List;

public class ForoModel {

    public List<ForoEntity> listaForo(){
        EntityManager em = JpaUtil.getEntityManager();

        try{
            Query con = em.createNamedQuery("foro.allForo");
            List<ForoEntity> lista = con.getResultList();
            em.close();
            return lista;
        }catch (Exception e){
            em.close();
            return null;
        }
    }

    public List<ForoEntity> listaForoProyecto(long idProyecto){
        EntityManager em = JpaUtil.getEntityManager();

        try{
            Query con = em.createNamedQuery("foro.findByIdProyecto");
            con.setParameter("idProyecto", idProyecto);
            List<ForoEntity> lista = con.getResultList();
            em.close();
            return lista;
        }catch (Exception e){
            em.close();
            return null;
        }
    }

    public int insertarForoProyecto (ForoEntity reunion){
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

    public int eliminarReunionProyecto (long idForo){
        EntityManager em = JpaUtil.getEntityManager();
        int filas =0;

        try{

            ForoEntity reu = em.find(ForoEntity.class,idForo);
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
