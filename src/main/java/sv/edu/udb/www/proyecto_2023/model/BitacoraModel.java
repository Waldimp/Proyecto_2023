package sv.edu.udb.www.proyecto_2023.model;

import java.util.List;
import jakarta.persistence.*;
import sv.edu.udb.www.proyecto_2023.entities.BitacoraProyectoEntity;
import sv.edu.udb.www.proyecto_2023.entities.ProyectosEntity;
import sv.edu.udb.www.proyecto_2023.util.JpaUtil;

public class BitacoraModel {

    public List<BitacoraProyectoEntity> listaBitacoras(){

        EntityManager em = JpaUtil.getEntityManager();

        try{
            Query con = em.createNamedQuery("bitacora_proyecto.allBitacoraProyecto");
            List<BitacoraProyectoEntity> lista = con.getResultList();
            em.close();
            return lista;


        }catch (Exception e){
            em.close();
            return null;
        }
    }

    public BitacoraProyectoEntity obtenerProyectos (String idBitacora){
        EntityManager em = JpaUtil.getEntityManager();

        try{

            BitacoraProyectoEntity bitacora = em.find(BitacoraProyectoEntity.class,idBitacora);
            em.close();
            return bitacora;
        }catch (Exception e){
            em.close();
            return null;
        }
    }

    public int insertarBitacora (BitacoraProyectoEntity bitacora){
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tran = em.getTransaction();

        try{
            tran.begin();
            em.persist(bitacora);
            tran.commit();
            em.close();
            return 1;
        }catch (Exception e){
            em.close();
            return 0;
        }
    }

    public int modificarBitacora (BitacoraProyectoEntity bitacora){
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tran = em.getTransaction();

        try{
            tran.begin();
            em.merge(bitacora);
            tran.commit();
            em.close();
            return 1;
        }catch (Exception e){
            em.close();
            return 0;
        }
    }

    public int eliminarBitacora (String id){
        EntityManager em = JpaUtil.getEntityManager();
        int filas =0;

        try{

            BitacoraProyectoEntity bit = em.find(BitacoraProyectoEntity.class,id);
            if (bit !=null){
                EntityTransaction tran = em.getTransaction();
                tran.begin();
                em.remove(bit);
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
