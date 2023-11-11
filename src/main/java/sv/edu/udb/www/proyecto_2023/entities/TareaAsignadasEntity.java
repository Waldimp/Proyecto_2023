package sv.edu.udb.www.proyecto_2023.entities;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "tarea_asignadas", schema = "proyecto_2023")
@NamedQueries({
        @NamedQuery(name="tarea_asignadas.allTareasAsignadas",query = "SELECT e FROM TareaAsignadasEntity e"),
@NamedQuery(name="tarea_asignadas.findByFechaInicio",query = "SELECT e FROM TareaAsignadasEntity e where e.fechaInicio= :fechaIni"),
@NamedQuery(name="tarea_asignadas.findByFechaFinal",query = "SELECT e FROM TareaAsignadasEntity e where e.fechaFinal= :fechaFin"),
@NamedQuery(name="tarea_asignadas.findByUsuario",query = "SELECT e FROM TareaAsignadasEntity e where e.idUsuario= :idUsuario"),
@NamedQuery(name="tarea_asignadas.findByTarea",query = "SELECT e FROM TareaAsignadasEntity e where e.idTarea= :idTarea")
})
public class TareaAsignadasEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_tarea_asignada")
    private long idTareaAsignada;
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

    public long getIdTareaAsignada() {
        return idTareaAsignada;
    }

    public void setIdTareaAsignada(long idTareaAsignada) {
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
