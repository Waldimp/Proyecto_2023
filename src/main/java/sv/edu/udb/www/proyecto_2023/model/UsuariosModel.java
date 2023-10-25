package sv.edu.udb.www.proyecto_2023.model;

import java.util.List;
import jakarta.persistence.*;
import sv.edu.udb.www.proyecto_2023.util.JpaUtil;
import sv.edu.udb.www.proyecto_2023.entities.UsuariosEntity;
public class UsuariosModel {

    public List<UsuariosEntity> listarUsuarios(){

        EntityManager em = JpaUtil.getEntityManager();

        try{
            Query con = em.createNamedQuery("usuarios.AllUsuarios");
            List<UsuariosEntity> lista = con.getResultList();
            em.close();
            return lista;


        }catch (Exception e){
            em.close();
            return null;
        }
    }

    public UsuariosEntity loginUsuario(String correo, String password){

        EntityManager em = JpaUtil.getEntityManager();

        try{
            Query con = em.createNamedQuery("usuarios.findByLogin");
            con.setParameter("correo", correo);
            con.setParameter("password", password);
            List<UsuariosEntity> lista = con.getResultList();
            em.close();

            if(lista.size() > 0){
                return lista.get(0);
            }

            return null;

        }catch (Exception e){
            em.close();
            return null;
        }
    }

    public UsuariosEntity obtenerUsuario (String idUsuario){
        EntityManager em = JpaUtil.getEntityManager();

        try{

            UsuariosEntity usuario = em.find(UsuariosEntity.class,idUsuario);
            em.close();
            return usuario;
        }catch (Exception e){
            em.close();
            return null;
        }
    }

    public int insertarUsuario (UsuariosEntity usuario){
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tran = em.getTransaction();

        try{
            tran.begin();
            em.persist(usuario);
            tran.commit();
            em.close();
            return 1;
        }catch (Exception e){
            em.close();
         return 0;
        }
    }

    public int modificarUsuario (UsuariosEntity usuario){
        EntityManager em = JpaUtil.getEntityManager();
        EntityTransaction tran = em.getTransaction();

        try{
            tran.begin();
            em.merge(usuario);
            tran.commit();
            em.close();
            return 1;
        }catch (Exception e){
            em.close();
            return 0;
        }
    }

    public int eliminarUsuario (String dui){
        EntityManager em = JpaUtil.getEntityManager();
        int filas =0;

        try{

            UsuariosEntity usu = em.find(UsuariosEntity.class,dui);
            if (usu !=null){
                EntityTransaction tran = em.getTransaction();
                tran.begin();
                em.remove(usu);
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
