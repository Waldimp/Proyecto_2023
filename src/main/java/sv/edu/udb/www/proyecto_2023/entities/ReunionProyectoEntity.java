package sv.edu.udb.www.proyecto_2023.entities;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "reunion_proyecto", schema = "proyectos_2023")
@NamedQueries({
        @NamedQuery(name="reunion_proyecto.findByFechaEvento",query = "SELECT e FROM ReunionProyectoEntity e where e.fechaEvento= :fecha"),
        @NamedQuery(name="reunion_proyecto.findByIdProyecto",query = "SELECT e FROM ReunionProyectoEntity e where e.idProyecto= :idProyecto"),
        @NamedQuery(name="reunion_proyecto.findByIdUsuario",query = "SELECT e FROM ReunionProyectoEntity e where e.idUsuario= :idUsuario"),
        @NamedQuery(name="reunion_proyecto.allReunionProyecto",query = "SELECT e FROM ReunionProyectoEntity e")

})
public class ReunionProyectoEntity {

    @Id
    @Column(name = "id_reunion", nullable = false, length = 20)
    private String idReunion;
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
    private String idProyecto;
    @Basic
    @Column(name = "id_usuario", nullable = false, length = 20)
    private String idUsuario;
    @ManyToOne
    @JoinColumn(name = "id_proyecto", referencedColumnName = "id_proyecto", insertable=false, updatable=false)
    private ProyectosEntity proyectosByIdProyecto;
    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario", insertable=false, updatable=false)
    private UsuariosEntity usuariosByIdUsuario;

    public String getIdReunion() {
        return idReunion;
    }

    public void setIdReunion(String idReunion) {
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

    public String getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(String idProyecto) {
        this.idProyecto = idProyecto;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReunionProyectoEntity that = (ReunionProyectoEntity) o;

        if (idReunion != null ? !idReunion.equals(that.idReunion) : that.idReunion != null) return false;
        if (nombreReunion != null ? !nombreReunion.equals(that.nombreReunion) : that.nombreReunion != null)
            return false;
        if (fechaEvento != null ? !fechaEvento.equals(that.fechaEvento) : that.fechaEvento != null) return false;
        if (descripcionEvento != null ? !descripcionEvento.equals(that.descripcionEvento) : that.descripcionEvento != null)
            return false;
        if (idProyecto != null ? !idProyecto.equals(that.idProyecto) : that.idProyecto != null) return false;
        if (idUsuario != null ? !idUsuario.equals(that.idUsuario) : that.idUsuario != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idReunion != null ? idReunion.hashCode() : 0;
        result = 31 * result + (nombreReunion != null ? nombreReunion.hashCode() : 0);
        result = 31 * result + (fechaEvento != null ? fechaEvento.hashCode() : 0);
        result = 31 * result + (descripcionEvento != null ? descripcionEvento.hashCode() : 0);
        result = 31 * result + (idProyecto != null ? idProyecto.hashCode() : 0);
        result = 31 * result + (idUsuario != null ? idUsuario.hashCode() : 0);
        return result;
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
