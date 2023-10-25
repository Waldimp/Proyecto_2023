package sv.edu.udb.www.proyecto_2023.model;
import java.util.List;
import jakarta.persistence.*;
import sv.edu.udb.www.proyecto_2023.entities.GestionProyectoEntity;
import sv.edu.udb.www.proyecto_2023.entities.UsuariosEntity;
import sv.edu.udb.www.proyecto_2023.util.*;
import sv.edu.udb.www.proyecto_2023.entities.ProyectosEntity;

public class ProyectosModel {


    public List<ProyectosEntity> listaProyectos(){

        EntityManager em = JpaUtil.getEntityManager();

        try{
            Query con = em.createNamedQuery("proyectos.allProyectos");
            List<ProyectosEntity> lista = con.getResultList();
            em.close();
            return lista;


        }catch (Exception e){
            em.close();
            return null;
        }

    }

    public ProyectosEntity obtenerProyectos (String idProyecto){
        EntityManager em = JpaUtil.getEntityManager();

        try{

            ProyectosEntity proyecto = em.find(ProyectosEntity.class,idProyecto);
            em.close();
            return proyecto;
        }catch (Exception e){
            em.close();
            return null;
        }
    }

    public int insertarProyecto (ProyectosEntity proyecto){
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tran = em.getTransaction();

        try{
            tran.begin();
            em.persist(proyecto);
            tran.commit();
            em.close();
            return 1;
        }catch (Exception e){
            em.close();
            return 0;
        }
    }

    public int modificarProyecto (ProyectosEntity proyecto){
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tran = em.getTransaction();

        try{
            tran.begin();
            em.merge(proyecto);
            tran.commit();
            em.close();
            return 1;
        }catch (Exception e){
            em.close();
            return 0;
        }
    }

    public int eliminarProyecto (String id){
        EntityManager em = JpaUtil.getEntityManager();
        int filas =0;

        try{

            ProyectosEntity pro = em.find(ProyectosEntity.class,id);
            if (pro !=null){
                EntityTransaction tran = em.getTransaction();
                tran.begin();
                em.remove(pro);
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
