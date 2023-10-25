package sv.edu.udb.www.proyecto_2023.entities;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "tipo_proyecto", schema = "proyectos_2023")
@NamedQuery(name="tipo_proyecto.allTipoProyecto",query = "SELECT e FROM TipoProyectoEntity e")
@NamedQuery(name="tipo_proyecto.findByNombreTipo",query = "SELECT e FROM TipoProyectoEntity e where e.idTipoProyecto= :id")
public class TipoProyectoEntity {

    @Id
    @Column(name = "Id_tipo_proyecto", nullable = false, length = 20)
    private String idTipoProyecto;
    @Basic
    @Column(name = "nombre_tipo", nullable = false, length = 100)
    private String nombreTipo;
    @Basic
    @Column(name = "descripcion", nullable = true, length = 250)
    private String descripcion;
    @OneToMany(mappedBy = "tipoProyectoByIdTipoProyecto")
    private Collection<ProyectosEntity> proyectosByIdTipoProyecto;

    public String getIdTipoProyecto() {
        return idTipoProyecto;
    }

    public void setIdTipoProyecto(String idTipoProyecto) {
        this.idTipoProyecto = idTipoProyecto;
    }

    public String getNombreTipo() {
        return nombreTipo;
    }

    public void setNombreTipo(String nombreTipo) {
        this.nombreTipo = nombreTipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TipoProyectoEntity that = (TipoProyectoEntity) o;

        if (idTipoProyecto != null ? !idTipoProyecto.equals(that.idTipoProyecto) : that.idTipoProyecto != null)
            return false;
        if (nombreTipo != null ? !nombreTipo.equals(that.nombreTipo) : that.nombreTipo != null) return false;
        if (descripcion != null ? !descripcion.equals(that.descripcion) : that.descripcion != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idTipoProyecto != null ? idTipoProyecto.hashCode() : 0;
        result = 31 * result + (nombreTipo != null ? nombreTipo.hashCode() : 0);
        result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
        return result;
    }

    public Collection<ProyectosEntity> getProyectosByIdTipoProyecto() {
        return proyectosByIdTipoProyecto;
    }

    public void setProyectosByIdTipoProyecto(Collection<ProyectosEntity> proyectosByIdTipoProyecto) {
        this.proyectosByIdTipoProyecto = proyectosByIdTipoProyecto;
    }
}
