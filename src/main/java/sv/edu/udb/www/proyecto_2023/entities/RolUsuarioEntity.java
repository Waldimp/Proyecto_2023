package sv.edu.udb.www.proyecto_2023.entities;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "rol_usuario", schema = "proyectos_2023")
@NamedQuery(name="rol_usuario.findByrolUsuario",query = "SELECT e FROM RolUsuarioEntity e where e.idRol= :idRol")
@NamedQuery(name="rol_usuario.allRolesUsuario",query = "SELECT e FROM RolUsuarioEntity e")
public class RolUsuarioEntity {
    @Id
    @Column(name = "id_rol", nullable = false, length = 20)
    private String idRol;
    @Basic
    @Column(name = "rol_usuario", nullable = true, length = 200)
    private String rolUsuario;
    @Basic
    @Column(name = "descripcion", nullable = false, length = 250)
    private String descripcion;
    @OneToMany(mappedBy = "rolUsuarioByIdRol")
    private Collection<UsuariosEntity> usuariosByIdRol;

    public String getIdRol() {
        return idRol;
    }

    public void setIdRol(String idRol) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RolUsuarioEntity that = (RolUsuarioEntity) o;

        if (idRol != null ? !idRol.equals(that.idRol) : that.idRol != null) return false;
        if (rolUsuario != null ? !rolUsuario.equals(that.rolUsuario) : that.rolUsuario != null) return false;
        if (descripcion != null ? !descripcion.equals(that.descripcion) : that.descripcion != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idRol != null ? idRol.hashCode() : 0;
        result = 31 * result + (rolUsuario != null ? rolUsuario.hashCode() : 0);
        result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
        return result;
    }

    public Collection<UsuariosEntity> getUsuariosByIdRol() {
        return usuariosByIdRol;
    }

    public void setUsuariosByIdRol(Collection<UsuariosEntity> usuariosByIdRol) {
        this.usuariosByIdRol = usuariosByIdRol;
    }
}
