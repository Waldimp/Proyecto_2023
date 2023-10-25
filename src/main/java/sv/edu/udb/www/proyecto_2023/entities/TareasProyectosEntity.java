package sv.edu.udb.www.proyecto_2023.entities;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "tareas_proyectos", schema = "proyectos_2023")
@NamedQueries({
        @NamedQuery(name="tareas_proyectos.allTareas",query = "SELECT e FROM TareasProyectosEntity e"),
        @NamedQuery(name="tareas_proyectos.findByIdTarea",query = "SELECT e FROM TareasProyectosEntity e where e.idTarea= :id_tarea")    ,
        @NamedQuery(name="tareas_proyectos.findByFechaRegistro",query = "SELECT e FROM TareasProyectosEntity e where e.fechaRegistro= :fecha"),
        @NamedQuery(name="tareas_proyectos.findByPlazos",query = "SELECT e FROM TareasProyectosEntity e where e.plazosCumplimiento= :plazos"),
        @NamedQuery(name="tareas_proyectos.findByEstadoTarea",query = "SELECT e FROM TareasProyectosEntity e where e.estadoTarea= :estado"),
        @NamedQuery(name="tareas_proyectos.findByPrioridad",query = "SELECT e FROM TareasProyectosEntity e where e.prioridad=:prioridad"),
        @NamedQuery(name="tareas_proyectos.findByIdProyecto",query = "SELECT e FROM TareasProyectosEntity e where e.idProyecto=:id_proyecto")
})
public class TareasProyectosEntity {
    @Id
    @Column(name = "id_tarea", nullable = false, length = 20)
    private String idTarea;
    @Basic
    @Column(name = "nombre_tarea", nullable = false)
    private int nombreTarea;
    @Basic
    @Column(name = "descripcion", nullable = false, length = 250)
    private String descripcion;
    @Basic
    @Column(name = "fecha_registro", nullable = false)
    private Date fechaRegistro;
    @Basic
    @Column(name = "Plazos_cumplimiento", nullable = false)
    private int plazosCumplimiento;
    @Basic
    @Column(name = "prioridad", nullable = false, length = 20)
    private String prioridad;
    @Basic
    @Column(name = "estado_tarea", nullable = false, length = 50)
    private String estadoTarea;
    @Basic
    @Column(name = "observaciones_tarea", nullable = false, length = 250)
    private String observacionesTarea;
    @Basic
    @Column(name = "id_proyecto", nullable = false, length = 20)
    private String idProyecto;
    @OneToMany(mappedBy = "tareasProyectosByIdTarea")
    private Collection<TareaAsignadasEntity> tareaAsignadasByIdTarea;
    @ManyToOne
    @JoinColumn(name = "id_proyecto", referencedColumnName = "id_proyecto", insertable=false, updatable=false)
    private ProyectosEntity proyectosByIdProyecto;

    public String getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(String idTarea) {
        this.idTarea = idTarea;
    }

    public int getNombreTarea() {
        return nombreTarea;
    }

    public void setNombreTarea(int nombreTarea) {
        this.nombreTarea = nombreTarea;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public int getPlazosCumplimiento() {
        return plazosCumplimiento;
    }

    public void setPlazosCumplimiento(int plazosCumplimiento) {
        this.plazosCumplimiento = plazosCumplimiento;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public String getEstadoTarea() {
        return estadoTarea;
    }

    public void setEstadoTarea(String estadoTarea) {
        this.estadoTarea = estadoTarea;
    }

    public String getObservacionesTarea() {
        return observacionesTarea;
    }

    public void setObservacionesTarea(String observacionesTarea) {
        this.observacionesTarea = observacionesTarea;
    }

    public String getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(String idProyecto) {
        this.idProyecto = idProyecto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TareasProyectosEntity that = (TareasProyectosEntity) o;

        if (nombreTarea != that.nombreTarea) return false;
        if (plazosCumplimiento != that.plazosCumplimiento) return false;
        if (idTarea != null ? !idTarea.equals(that.idTarea) : that.idTarea != null) return false;
        if (descripcion != null ? !descripcion.equals(that.descripcion) : that.descripcion != null) return false;
        if (fechaRegistro != null ? !fechaRegistro.equals(that.fechaRegistro) : that.fechaRegistro != null)
            return false;
        if (prioridad != null ? !prioridad.equals(that.prioridad) : that.prioridad != null) return false;
        if (estadoTarea != null ? !estadoTarea.equals(that.estadoTarea) : that.estadoTarea != null) return false;
        if (observacionesTarea != null ? !observacionesTarea.equals(that.observacionesTarea) : that.observacionesTarea != null)
            return false;
        if (idProyecto != null ? !idProyecto.equals(that.idProyecto) : that.idProyecto != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idTarea != null ? idTarea.hashCode() : 0;
        result = 31 * result + nombreTarea;
        result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
        result = 31 * result + (fechaRegistro != null ? fechaRegistro.hashCode() : 0);
        result = 31 * result + plazosCumplimiento;
        result = 31 * result + (prioridad != null ? prioridad.hashCode() : 0);
        result = 31 * result + (estadoTarea != null ? estadoTarea.hashCode() : 0);
        result = 31 * result + (observacionesTarea != null ? observacionesTarea.hashCode() : 0);
        result = 31 * result + (idProyecto != null ? idProyecto.hashCode() : 0);
        return result;
    }

    public Collection<TareaAsignadasEntity> getTareaAsignadasByIdTarea() {
        return tareaAsignadasByIdTarea;
    }

    public void setTareaAsignadasByIdTarea(Collection<TareaAsignadasEntity> tareaAsignadasByIdTarea) {
        this.tareaAsignadasByIdTarea = tareaAsignadasByIdTarea;
    }

    public ProyectosEntity getProyectosByIdProyecto() {
        return proyectosByIdProyecto;
    }

    public void setProyectosByIdProyecto(ProyectosEntity proyectosByIdProyecto) {
        this.proyectosByIdProyecto = proyectosByIdProyecto;
    }
}
