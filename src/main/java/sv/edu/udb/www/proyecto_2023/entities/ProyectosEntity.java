package sv.edu.udb.www.proyecto_2023.entities;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "proyectos", schema = "proyectos_2023")
@NamedQueries({
        @NamedQuery(name="proyectos.findByIdProyecto",query = "SELECT e FROM ProyectosEntity e where e.idProyecto= :id_proyecto"),
        @NamedQuery(name="proyectos.findByFechaInicio",query = "SELECT e FROM ProyectosEntity e where e.fechaInicio= :fechaIni"),
        @NamedQuery(name="proyectos.findByFechaFin",query = "SELECT e FROM ProyectosEntity e where e.fechaFin= :fechaFin"),
        @NamedQuery(name="proyectos.findByTipoProyecto",query = "SELECT e FROM ProyectosEntity e where e.idTipoProyecto= :id_tipo"),
        @NamedQuery(name="proyectos.allProyectos",query = "SELECT e FROM ProyectosEntity e")
})
public class ProyectosEntity {
    @Id
    @Column(name = "id_proyecto", nullable = false, length = 20)
    private String idProyecto;
    @Basic
    @Column(name = "nombre_proyecto", nullable = false, length = 100)
    private String nombreProyecto;
    @Basic
    @Column(name = "descripcion", nullable = false, length = 250)
    private String descripcion;
    @Basic
    @Column(name = "fecha_inicio", nullable = false)
    private Date fechaInicio;
    @Basic
    @Column(name = "fecha_fin", nullable = false)
    private Date fechaFin;
    @Basic
    @Column(name = "observaciones", nullable = false, length = 250)
    private String observaciones;
    @Basic
    @Column(name = "id_tipo_proyecto", nullable = false, length = 20)
    private String idTipoProyecto;
    @OneToMany(mappedBy = "proyectosByIdProyecto")
    private Collection<BitacoraProyectoEntity> bitacoraProyectosByIdProyecto;
    @OneToMany(mappedBy = "proyectosByIdProyecto")
    private Collection<GestionProyectoEntity> gestionProyectosByIdProyecto;
    @ManyToOne
    @JoinColumn(name = "id_tipo_proyecto", referencedColumnName = "Id_tipo_proyecto", insertable=false, updatable=false)
    private TipoProyectoEntity tipoProyectoByIdTipoProyecto;
    @OneToMany(mappedBy = "proyectosByIdProyecto")
    private Collection<ReunionProyectoEntity> reunionProyectosByIdProyecto;
    @OneToMany(mappedBy = "proyectosByIdProyecto")
    private Collection<TareasProyectosEntity> tareasProyectosByIdProyecto;

    public String getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(String idProyecto) {
        this.idProyecto = idProyecto;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getIdTipoProyecto() {
        return idTipoProyecto;
    }

    public void setIdTipoProyecto(String idTipoProyecto) {
        this.idTipoProyecto = idTipoProyecto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProyectosEntity that = (ProyectosEntity) o;

        if (idProyecto != null ? !idProyecto.equals(that.idProyecto) : that.idProyecto != null) return false;
        if (nombreProyecto != null ? !nombreProyecto.equals(that.nombreProyecto) : that.nombreProyecto != null)
            return false;
        if (descripcion != null ? !descripcion.equals(that.descripcion) : that.descripcion != null) return false;
        if (fechaInicio != null ? !fechaInicio.equals(that.fechaInicio) : that.fechaInicio != null) return false;
        if (fechaFin != null ? !fechaFin.equals(that.fechaFin) : that.fechaFin != null) return false;
        if (observaciones != null ? !observaciones.equals(that.observaciones) : that.observaciones != null)
            return false;
        if (idTipoProyecto != null ? !idTipoProyecto.equals(that.idTipoProyecto) : that.idTipoProyecto != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idProyecto != null ? idProyecto.hashCode() : 0;
        result = 31 * result + (nombreProyecto != null ? nombreProyecto.hashCode() : 0);
        result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
        result = 31 * result + (fechaInicio != null ? fechaInicio.hashCode() : 0);
        result = 31 * result + (fechaFin != null ? fechaFin.hashCode() : 0);
        result = 31 * result + (observaciones != null ? observaciones.hashCode() : 0);
        result = 31 * result + (idTipoProyecto != null ? idTipoProyecto.hashCode() : 0);
        return result;
    }

    public Collection<BitacoraProyectoEntity> getBitacoraProyectosByIdProyecto() {
        return bitacoraProyectosByIdProyecto;
    }

    public void setBitacoraProyectosByIdProyecto(Collection<BitacoraProyectoEntity> bitacoraProyectosByIdProyecto) {
        this.bitacoraProyectosByIdProyecto = bitacoraProyectosByIdProyecto;
    }

    public Collection<GestionProyectoEntity> getGestionProyectosByIdProyecto() {
        return gestionProyectosByIdProyecto;
    }

    public void setGestionProyectosByIdProyecto(Collection<GestionProyectoEntity> gestionProyectosByIdProyecto) {
        this.gestionProyectosByIdProyecto = gestionProyectosByIdProyecto;
    }

    public TipoProyectoEntity getTipoProyectoByIdTipoProyecto() {
        return tipoProyectoByIdTipoProyecto;
    }

    public void setTipoProyectoByIdTipoProyecto(TipoProyectoEntity tipoProyectoByIdTipoProyecto) {
        this.tipoProyectoByIdTipoProyecto = tipoProyectoByIdTipoProyecto;
    }

    public Collection<ReunionProyectoEntity> getReunionProyectosByIdProyecto() {
        return reunionProyectosByIdProyecto;
    }

    public void setReunionProyectosByIdProyecto(Collection<ReunionProyectoEntity> reunionProyectosByIdProyecto) {
        this.reunionProyectosByIdProyecto = reunionProyectosByIdProyecto;
    }

    public Collection<TareasProyectosEntity> getTareasProyectosByIdProyecto() {
        return tareasProyectosByIdProyecto;
    }

    public void setTareasProyectosByIdProyecto(Collection<TareasProyectosEntity> tareasProyectosByIdProyecto) {
        this.tareasProyectosByIdProyecto = tareasProyectosByIdProyecto;
    }
}
