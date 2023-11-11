package sv.edu.udb.www.proyecto_2023.entities;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "tipo_proyecto", schema = "proyecto_2023")
@NamedQuery(name="tipo_proyecto.allTipoProyecto",query = "SELECT e FROM TipoProyectoEntity e")
@NamedQuery(name="tipo_proyecto.findByNombreTipo",query = "SELECT e FROM TipoProyectoEntity e where e.idTipoProyecto= :id")
public class TipoProyectoEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "Id_tipo_proyecto", nullable = false, length = 20)
    private long idTipoProyecto;
    @Basic
    @Column(name = "nombre_tipo", nullable = false, length = 100)
    private String nombreTipo;
    @Basic
    @Column(name = "descripcion", nullable = true, length = 250)
    private String descripcion;
    @OneToMany(mappedBy = "tipoProyectoByIdTipoProyecto")
    private Collection<ProyectosEntity> proyectosByIdTipoProyecto;

    public long getIdTipoProyecto() {
        return idTipoProyecto;
    }

    public void setIdTipoProyecto(long idTipoProyecto) {
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

    public Collection<ProyectosEntity> getProyectosByIdTipoProyecto() {
        return proyectosByIdTipoProyecto;
    }

    public void setProyectosByIdTipoProyecto(Collection<ProyectosEntity> proyectosByIdTipoProyecto) {
        this.proyectosByIdTipoProyecto = proyectosByIdTipoProyecto;
    }
}
