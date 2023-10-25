package sv.edu.udb.www.proyecto_2023.model;

import java.util.List;
import jakarta.persistence.*;
import sv.edu.udb.www.proyecto_2023.util.JpaUtil;
import sv.edu.udb.www.proyecto_2023.entities.GestionProyectoEntity;
public class GestionProyectoModel {

    public List<GestionProyectoEntity> listarGestiones(){

        EntityManager em = JpaUtil.getEntityManager();

        try{
            Query con = em.createNamedQuery("gestion_proyecto.allGestionesProyecto");
            List<GestionProyectoEntity> lista = con.getResultList();
            em.close();
            return lista;


        }catch (Exception e){
            em.close();
            return null;
        }
    }

    public GestionProyectoEntity obtenerGestion (String idGestion){
        EntityManager em = JpaUtil.getEntityManager();

        try{

            GestionProyectoEntity gestion = em.find(GestionProyectoEntity.class,idGestion);
            em.close();
            return gestion;
        }catch (Exception e){
            em.close();
            return null;
        }
    }


    public int insertarGestion (GestionProyectoEntity gestion){
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tran = em.getTransaction();

        try{
            tran.begin();
            em.persist(gestion);
            tran.commit();
            em.close();
            return 1;
        }catch (Exception e){
            em.close();
            return 0;
        }
    }

    public int modificarGestion (GestionProyectoEntity gestion){
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tran = em.getTransaction();

        try{
            tran.begin();
            em.merge(gestion);
            tran.commit();
            em.close();
            return 1;
        }catch (Exception e){
            em.close();
            return 0;
        }
    }


    public int eliminarGestion (String idGestion){
        EntityManager em = JpaUtil.getEntityManager();
        int filas =0;

        try{

            GestionProyectoEntity  ges = em.find(GestionProyectoEntity .class,idGestion);
            if (ges!=null){
                EntityTransaction tran = em.getTransaction();
                tran.begin();
                em.remove(ges);
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
