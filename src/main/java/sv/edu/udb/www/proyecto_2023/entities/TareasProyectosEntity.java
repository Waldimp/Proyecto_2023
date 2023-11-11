package sv.edu.udb.www.proyecto_2023.entities;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "tareas_proyectos", schema = "proyecto_2023")
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
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_tarea", nullable = false, length = 20)
    private long idTarea;
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

    public long getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(long idTarea) {
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
