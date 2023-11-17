package sv.edu.udb.www.proyecto_2023.entities;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "usuarios", schema = "proyecto_2023")

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
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_usuario", nullable = false)
    private long idUsuario;
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
    private long idRol;
    @OneToMany(mappedBy = "usuariosByIdUsuario")
    private Collection<ReunionProyectoEntity> reunionProyectosByIdUsuario;
    @OneToMany(mappedBy = "usuariosByIdUsuario")
    private Collection<TareaAsignadasEntity> tareaAsignadasByIdUsuario;
    @ManyToOne
    @JoinColumn(name = "id_rol", referencedColumnName = "id_rol", insertable=false, updatable=false)
    private RolUsuarioEntity rolUsuarioByIdRol;

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
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

    public long getIdRol() {
        return idRol;
    }

    public void setIdRol(long idRol) {
        this.idRol = idRol;
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
