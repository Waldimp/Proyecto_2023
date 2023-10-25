package sv.edu.udb.www.proyecto_2023.model;

import java.util.List;
import jakarta.persistence.*;
import sv.edu.udb.www.proyecto_2023.entities.UsuariosEntity;
import sv.edu.udb.www.proyecto_2023.util.JpaUtil;
import sv.edu.udb.www.proyecto_2023.entities.RolUsuarioEntity;
public class RolUsuariosModel {
//ListaRoles
    public List<RolUsuarioEntity> listaRoles (){
        EntityManager em = JpaUtil.getEntityManager();

        try{
            Query con = em.createNamedQuery("rol_usuario.allRolesUsuario");
            List<RolUsuarioEntity> lista1 = con.getResultList();
            em.close();
            return lista1;


        }catch (Exception e){
            em.close();
            return null;
        }
    }

    public RolUsuarioEntity obtenerRoles (String idRol){

        EntityManager em = JpaUtil.getEntityManager();
        try{

            RolUsuarioEntity roles = em.find(RolUsuarioEntity.class,idRol);
            em.close();
            return roles;
        }catch (Exception e){
            em.close();
            return null;
        }
    }

    public int insertarRolUsuario (RolUsuarioEntity rolUsuario){
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tran = em.getTransaction();

        try{
            tran.begin();
            em.persist(rolUsuario);
            tran.commit();
            em.close();
            return 1;
        }catch (Exception e){
            em.close();
            return 0;
        }
    }

    public int modificarRolUsuario (RolUsuarioEntity roles){
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tran = em.getTransaction();

        try{
            tran.begin();
            em.merge(roles);
            tran.commit();
            em.close();
            return 1;
        }catch (Exception e){
            em.close();
            return 0;
        }
}

    public int eliminarRolUsuario (String idRol){
        EntityManager em = JpaUtil.getEntityManager();
        int filas =0;

        try{

            RolUsuarioEntity rol = em.find(RolUsuarioEntity.class,idRol);
            if (rol !=null){
                EntityTransaction tran = em.getTransaction();
                tran.begin();
                em.remove(rol);
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