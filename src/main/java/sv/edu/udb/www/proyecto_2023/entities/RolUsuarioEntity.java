package sv.edu.udb.www.proyecto_2023.entities;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "rol_usuario", schema = "proyecto_2023")
@NamedQuery(name="rol_usuario.findByrolUsuario",query = "SELECT e FROM RolUsuarioEntity e where e.idRol= :idRol")
@NamedQuery(name="rol_usuario.allRolesUsuario",query = "SELECT e FROM RolUsuarioEntity e")
public class RolUsuarioEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_rol", nullable = false, length = 20)
    private long idRol;
    @Basic
    @Column(name = "rol_usuario", nullable = true, length = 200)
    private String rolUsuario;
    @Basic
    @Column(name = "descripcion", nullable = false, length = 250)
    private String descripcion;
    @OneToMany(mappedBy = "rolUsuarioByIdRol")
    private Collection<UsuariosEntity> usuariosByIdRol;

    public long getIdRol() {
        return idRol;
    }

    public void setIdRol(long idRol) {
        this.idRol = idRol;
    }

    public String getRolUsuario() {
        return rolUsuario;
    }

    public void setRolUsuario(String rolUsuario) {
        this.rolUsuario = rolUsuario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Collection<UsuariosEntity> getUsuariosByIdRol() {
        return usuariosByIdRol;
    }

    public void setUsuariosByIdRol(Collection<UsuariosEntity> usuariosByIdRol) {
        this.usuariosByIdRol = usuariosByIdRol;
    }
}
