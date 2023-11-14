package sv.edu.udb.www.proyecto_2023.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "reunion_proyecto", schema = "proyecto_2023")
@NamedQueries({
        @NamedQuery(name="reunion_proyecto.findByFechaEvento",query = "SELECT e FROM ReunionProyectoEntity e where e.fechaEvento= :fecha"),
        @NamedQuery(name="reunion_proyecto.findByIdProyecto",query = "SELECT e FROM ReunionProyectoEntity e where e.idProyecto= :idProyecto"),
        @NamedQuery(name="reunion_proyecto.findByIdUsuario",query = "SELECT e FROM ReunionProyectoEntity e where e.idUsuario= :idUsuario"),
        @NamedQuery(name="reunion_proyecto.allReunionProyecto",query = "SELECT e FROM ReunionProyectoEntity e")

})
public class ReunionProyectoEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_reunion", nullable = false)
    private long idReunion;
    @Basic
    @Column(name = "nombre_reunion", nullable = false, length = 250)
    private String nombreReunion;
    @Basic
    @Column(name = "fecha_evento", nullable = false)
    private Date fechaEvento;
    @Basic
    @Column(name = "descripcion_evento", nullable = false, length = 250)
    private String descripcionEvento;
    @Basic
    @Column(name = "id_proyecto", nullable = false, length = 20)
    private long idProyecto;
    @Basic
    @Column(name = "id_usuario", nullable = false, length = 20)
    private long idUsuario;
    @ManyToOne
    @JoinColumn(name = "id_proyecto", referencedColumnName = "id_proyecto", insertable=false, updatable=false)
    private ProyectosEntity proyectosByIdProyecto;
    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario", insertable=false, updatable=false)
    private UsuariosEntity usuariosByIdUsuario;

    public long getIdReunion() {
        return idReunion;
    }

    public void setIdReunion(long idReunion) {
        this.idReunion = idReunion;
    }

    public String getNombreReunion() {
        return nombreReunion;
    }

    public void setNombreReunion(String nombreReunion) {
        this.nombreReunion = nombreReunion;
    }

    public Date getFechaEvento() {
        return fechaEvento;
    }

    public void setFechaEvento(Date fechaEvento) {
        this.fechaEvento = fechaEvento;
    }

    public String getDescripcionEvento() {
        return descripcionEvento;
    }

    public void setDescripcionEvento(String descripcionEvento) {
        this.descripcionEvento = descripcionEvento;
    }

    public long getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(long idProyecto) {
        this.idProyecto = idProyecto;
    }

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public ProyectosEntity getProyectosByIdProyecto() {
        return proyectosByIdProyecto;
    }

    public void setProyectosByIdProyecto(ProyectosEntity proyectosByIdProyecto) {
        this.proyectosByIdProyecto = proyectosByIdProyecto;
    }

    public UsuariosEntity getUsuariosByIdUsuario() {
        return usuariosByIdUsuario;
    }

    public void setUsuariosByIdUsuario(UsuariosEntity usuariosByIdUsuario) {
        this.usuariosByIdUsuario = usuariosByIdUsuario;
    }
}
