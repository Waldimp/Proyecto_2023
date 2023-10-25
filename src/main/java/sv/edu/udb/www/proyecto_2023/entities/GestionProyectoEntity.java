package sv.edu.udb.www.proyecto_2023.entities;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "gestion_proyecto", schema = "proyectos_2023")
@NamedQueries({
        @NamedQuery(name="gestion_proyecto.findByFechaGestion",query = "SELECT e FROM GestionProyectoEntity e where e.fechaGestion=:fecha"),
        @NamedQuery(name="gestion_proyecto.findByTipoGestion",query = "SELECT e FROM GestionProyectoEntity e where e.tipoGestion=:tipo"),
        @NamedQuery(name="gestion_proyecto.findByIdProyecto",query = "SELECT e FROM GestionProyectoEntity e where e.idProyecto=:id"),
        @NamedQuery(name="gestion_proyecto.allGestionesProyecto",query = "SELECT e FROM GestionProyectoEntity e")
})
public class GestionProyectoEntity {
    @Id
    @Column(name = "id_gestion", nullable = false, length = 20)
    private String idGestion;
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
    private String idProyecto;
    @Basic
    @Column(name = "id_tipo_recurso", nullable = false, length = 20)
    private String idTipoRecurso;
    @OneToOne
    @JoinColumn(name = "id_gestion", referencedColumnName = "id_recurso", insertable=false, updatable=false)
    private RecursoGestionesEntity recursoGestionesByIdGestion;
    @ManyToOne
    @JoinColumn(name = "id_proyecto", referencedColumnName = "id_proyecto", insertable=false, updatable=false)
    private ProyectosEntity proyectosByIdProyecto;

    public String getIdGestion() {
        return idGestion;
    }

    public void setIdGestion(String idGestion) {
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

    public String getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(String idProyecto) {
        this.idProyecto = idProyecto;
    }

    public String getIdTipoRecurso() {
        return idTipoRecurso;
    }

    public void setIdTipoRecurso(String idTipoRecurso) {
        this.idTipoRecurso = idTipoRecurso;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GestionProyectoEntity that = (GestionProyectoEntity) o;

        if (idGestion != null ? !idGestion.equals(that.idGestion) : that.idGestion != null) return false;
        if (descripcionGestion != null ? !descripcionGestion.equals(that.descripcionGestion) : that.descripcionGestion != null)
            return false;
        if (fechaGestion != null ? !fechaGestion.equals(that.fechaGestion) : that.fechaGestion != null) return false;
        if (tipoGestion != null ? !tipoGestion.equals(that.tipoGestion) : that.tipoGestion != null) return false;
        if (idProyecto != null ? !idProyecto.equals(that.idProyecto) : that.idProyecto != null) return false;
        if (idTipoRecurso != null ? !idTipoRecurso.equals(that.idTipoRecurso) : that.idTipoRecurso != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idGestion != null ? idGestion.hashCode() : 0;
        result = 31 * result + (descripcionGestion != null ? descripcionGestion.hashCode() : 0);
        result = 31 * result + (fechaGestion != null ? fechaGestion.hashCode() : 0);
        result = 31 * result + (tipoGestion != null ? tipoGestion.hashCode() : 0);
        result = 31 * result + (idProyecto != null ? idProyecto.hashCode() : 0);
        result = 31 * result + (idTipoRecurso != null ? idTipoRecurso.hashCode() : 0);
        return result;
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
