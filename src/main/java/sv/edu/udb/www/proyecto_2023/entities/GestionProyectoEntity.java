package sv.edu.udb.www.proyecto_2023.entities;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "gestion_proyecto", schema = "proyecto_2023")
@NamedQueries({
        @NamedQuery(name="gestion_proyecto.findByFechaGestion",query = "SELECT e FROM GestionProyectoEntity e where e.fechaGestion=:fecha"),
        @NamedQuery(name="gestion_proyecto.findByTipoGestion",query = "SELECT e FROM GestionProyectoEntity e where e.tipoGestion=:tipo"),
        @NamedQuery(name="gestion_proyecto.findByIdProyecto",query = "SELECT e FROM GestionProyectoEntity e where e.idProyecto=:id"),
        @NamedQuery(name="gestion_proyecto.allGestionesProyecto",query = "SELECT e FROM GestionProyectoEntity e")
})
public class GestionProyectoEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_gestion", nullable = false)
    private long idGestion;
    @Basic
    @Column(name = "descripcion_gestion", nullable = false, length = 250)
    private String descripcionGestion;
    @Basic
    @Column(name = "fecha_gestion", nullable = false)
    private Date fechaGestion;
    @Basic
    @Column(name = "tipo_gestion", nullable = false, length = 250)
    private String tipoGestion;
    @Basic
    @Column(name = "id_proyecto", nullable = false, length = 20)
    private long idProyecto;
    @Basic
    @Column(name = "id_tipo_recurso", nullable = false, length = 20)
    private long idTipoRecurso;
    @OneToOne
    @JoinColumn(name = "id_gestion", referencedColumnName = "id_recurso", insertable=false, updatable=false)
    private RecursoGestionesEntity recursoGestionesByIdGestion;
    @ManyToOne
    @JoinColumn(name = "id_proyecto", referencedColumnName = "id_proyecto", insertable=false, updatable=false)
    private ProyectosEntity proyectosByIdProyecto;

    public long getIdGestion() {
        return idGestion;
    }

    public void setIdGestion(long idGestion) {
        this.idGestion = idGestion;
    }

    public String getDescripcionGestion() {
        return descripcionGestion;
    }

    public void setDescripcionGestion(String descripcionGestion) {
        this.descripcionGestion = descripcionGestion;
    }

    public Date getFechaGestion() {
        return fechaGestion;
    }

    public void setFechaGestion(Date fechaGestion) {
        this.fechaGestion = fechaGestion;
    }

    public String getTipoGestion() {
        return tipoGestion;
    }

    public void setTipoGestion(String tipoGestion) {
        this.tipoGestion = tipoGestion;
    }

    public long getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(long idProyecto) {
        this.idProyecto = idProyecto;
    }

    public long getIdTipoRecurso() {
        return idTipoRecurso;
    }

    public void setIdTipoRecurso(long idTipoRecurso) {
        this.idTipoRecurso = idTipoRecurso;
    }

    public RecursoGestionesEntity getRecursoGestionesByIdGestion() {
        return recursoGestionesByIdGestion;
    }

    public void setRecursoGestionesByIdGestion(RecursoGestionesEntity recursoGestionesByIdGestion) {
        this.recursoGestionesByIdGestion = recursoGestionesByIdGestion;
    }

    public ProyectosEntity getProyectosByIdProyecto() {
        return proyectosByIdProyecto;
    }

    public void setProyectosByIdProyecto(ProyectosEntity proyectosByIdProyecto) {
        this.proyectosByIdProyecto = proyectosByIdProyecto;
    }
}
