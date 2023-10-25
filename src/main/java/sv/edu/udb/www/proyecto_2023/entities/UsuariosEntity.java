package sv.edu.udb.www.proyecto_2023.entities;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "usuarios", schema = "proyectos_2023")

@NamedQueries({
 @NamedQuery(name="usuarios.AllUsuarios",query = "SELECT e FROM UsuariosEntity e"),
        @NamedQuery(name="usuarios.findByDui",query = "SELECT e FROM UsuariosEntity e where e.dui= :dui "),
                @NamedQuery(name="usuarios.findByNombre",query = "SELECT e FROM UsuariosEntity e where e.nombre= :nombre "),
        @NamedQuery(name="usuarios.findByCorreo",query = "SELECT e FROM UsuariosEntity e where e.correo= :correo"),
        @NamedQuery(name="usuarios.findByRol",query = "SELECT e FROM UsuariosEntity e where e.idRol= :id_rol"),
        @NamedQuery(name="usuarios.findByLogin",query = "SELECT e FROM UsuariosEntity e where e.correo= :correo AND e.password = :password")

})
public class UsuariosEntity {

    @Id
    @Column(name = "id_usuario", nullable = false, length = 20)
    private String idUsuario;
    @Basic
    @Column(name = "nombre", nullable = true, length = 100)
    private String nombre;
    @Basic
    @Column(name = "apellido", nullable = true, length = 100)
    private String apellido;
    @Basic
    @Column(name = "edad", nullable = true)
    private Integer edad;
    @Basic
    @Column(name = "direccion", nullable = true, length = 450)
    private String direccion;
    @Basic
    @Column(name = "telefono", nullable = true, length = 10)
    private String telefono;
    @Basic
    @Column(name = "dui", nullable = false, length = 10)
    private String dui;
    @Basic
    @Column(name = "correo", nullable = false, length = 250)
    private String correo;
    @Basic
    @Column(name = "password", nullable = false, length = 250)
    private String password;
    @Basic
    @Column(name = "id_rol", nullable = false, length = 20)
    private String idRol;
    @OneToMany(mappedBy = "usuariosByIdUsuario")
    private Collection<ReunionProyectoEntity> reunionProyectosByIdUsuario;
    @OneToMany(mappedBy = "usuariosByIdUsuario")
    private Collection<TareaAsignadasEntity> tareaAsignadasByIdUsuario;
    @ManyToOne
    @JoinColumn(name = "id_rol", referencedColumnName = "id_rol", insertable=false, updatable=false)
    private RolUsuarioEntity rolUsuarioByIdRol;

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdRol() {
        return idRol;
    }

    public void setIdRol(String idRol) {
        this.idRol = idRol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsuariosEntity that = (UsuariosEntity) o;

        if (idUsuario != null ? !idUsuario.equals(that.idUsuario) : that.idUsuario != null) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (apellido != null ? !apellido.equals(that.apellido) : that.apellido != null) return false;
        if (edad != null ? !edad.equals(that.edad) : that.edad != null) return false;
        if (direccion != null ? !direccion.equals(that.direccion) : that.direccion != null) return false;
        if (telefono != null ? !telefono.equals(that.telefono) : that.telefono != null) return false;
        if (dui != null ? !dui.equals(that.dui) : that.dui != null) return false;
        if (correo != null ? !correo.equals(that.correo) : that.correo != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (idRol != null ? !idRol.equals(that.idRol) : that.idRol != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idUsuario != null ? idUsuario.hashCode() : 0;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (apellido != null ? apellido.hashCode() : 0);
        result = 31 * result + (edad != null ? edad.hashCode() : 0);
        result = 31 * result + (direccion != null ? direccion.hashCode() : 0);
        result = 31 * result + (telefono != null ? telefono.hashCode() : 0);
        result = 31 * result + (dui != null ? dui.hashCode() : 0);
        result = 31 * result + (correo != null ? correo.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (idRol != null ? idRol.hashCode() : 0);
        return result;
    }

    public Collection<ReunionProyectoEntity> getReunionProyectosByIdUsuario() {
        return reunionProyectosByIdUsuario;
    }

    public void setReunionProyectosByIdUsuario(Collection<ReunionProyectoEntity> reunionProyectosByIdUsuario) {
        this.reunionProyectosByIdUsuario = reunionProyectosByIdUsuario;
    }

    public Collection<TareaAsignadasEntity> getTareaAsignadasByIdUsuario() {
        return tareaAsignadasByIdUsuario;
    }

    public void setTareaAsignadasByIdUsuario(Collection<TareaAsignadasEntity> tareaAsignadasByIdUsuario) {
        this.tareaAsignadasByIdUsuario = tareaAsignadasByIdUsuario;
    }

    public RolUsuarioEntity getRolUsuarioByIdRol() {
        return rolUsuarioByIdRol;
    }

    public void setRolUsuarioByIdRol(RolUsuarioEntity rolUsuarioByIdRol) {
        this.rolUsuarioByIdRol = rolUsuarioByIdRol;
    }
}
