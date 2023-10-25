package sv.edu.udb.www.proyecto_2023.entities;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "tarea_asignadas", schema = "proyectos_2023")
@NamedQueries({
        @NamedQuery(name="tarea_asignadas.allTareasAsignadas",query = "SELECT e FROM TareaAsignadasEntity e"),
@NamedQuery(name="tarea_asignadas.findByFechaInicio",query = "SELECT e FROM TareaAsignadasEntity e where e.fechaInicio= :fechaIni"),
@NamedQuery(name="tarea_asignadas.findByFechaFinal",query = "SELECT e FROM TareaAsignadasEntity e where e.fechaFinal= :fechaFin"),
@NamedQuery(name="tarea_asignadas.findByUsuario",query = "SELECT e FROM TareaAsignadasEntity e where e.idUsuario= :idUsuario"),
@NamedQuery(name="tarea_asignadas.findByTarea",query = "SELECT e FROM TareaAsignadasEntity e where e.idTarea= :idTarea")
})
public class TareaAsignadasEntity {
    @Id
    @Column(name = "id_tarea_asignada")
    private String idTareaAsignada;
    @Basic
    @Column(name = "fecha_inicio")
    private Date fechaInicio;
    @Basic
    @Column(name = "fecha_final")
    private Date fechaFinal;
    @Basic
    @Column(name = "id_usuario")
    private String idUsuario;
    @Basic
    @Column(name = "id_tarea")
    private String idTarea;
    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario", insertable=false, updatable=false)
    private UsuariosEntity usuariosByIdUsuario;
    @ManyToOne
    @JoinColumn(name = "id_tarea", referencedColumnName = "id_tarea", insertable=false, updatable=false)
    private TareasProyectosEntity tareasProyectosByIdTarea;

    public String getIdTareaAsignada() {
        return idTareaAsignada;
    }

    public void setIdTareaAsignada(String idTareaAsignada) {
        this.idTareaAsignada = idTareaAsignada;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(String idTarea) {
        this.idTarea = idTarea;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TareaAsignadasEntity that = (TareaAsignadasEntity) o;

        if (idTareaAsignada != null ? !idTareaAsignada.equals(that.idTareaAsignada) : that.idTareaAsignada != null)
            return false;
        if (fechaInicio != null ? !fechaInicio.equals(that.fechaInicio) : that.fechaInicio != null) return false;
        if (fechaFinal != null ? !fechaFinal.equals(that.fechaFinal) : that.fechaFinal != null) return false;
        if (idUsuario != null ? !idUsuario.equals(that.idUsuario) : that.idUsuario != null) return false;
        if (idTarea != null ? !idTarea.equals(that.idTarea) : that.idTarea != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idTareaAsignada != null ? idTareaAsignada.hashCode() : 0;
        result = 31 * result + (fechaInicio != null ? fechaInicio.hashCode() : 0);
        result = 31 * result + (fechaFinal != null ? fechaFinal.hashCode() : 0);
        result = 31 * result + (idUsuario != null ? idUsuario.hashCode() : 0);
        result = 31 * result + (idTarea != null ? idTarea.hashCode() : 0);
        return result;
    }

    public UsuariosEntity getUsuariosByIdUsuario() {
        return usuariosByIdUsuario;
    }

    public void setUsuariosByIdUsuario(UsuariosEntity usuariosByIdUsuario) {
        this.usuariosByIdUsuario = usuariosByIdUsuario;
    }

    public TareasProyectosEntity getTareasProyectosByIdTarea() {
        return tareasProyectosByIdTarea;
    }

    public void setTareasProyectosByIdTarea(TareasProyectosEntity tareasProyectosByIdTarea) {
        this.tareasProyectosByIdTarea = tareasProyectosByIdTarea;
    }
}
