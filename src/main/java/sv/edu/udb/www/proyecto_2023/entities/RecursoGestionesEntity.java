package sv.edu.udb.www.proyecto_2023.entities;

import jakarta.persistence.*;

@Entity

@NamedQuery(name="recurso_gestiones.findByNombreRecurso",query = "SELECT e FROM RecursoGestionesEntity e where e.idRecurso= :idRecurso")
@NamedQuery(name="recurso_gestiones.allRecursoGestiones",query = "SELECT e FROM RecursoGestionesEntity e")
@Table(name = "recurso_gestiones", schema = "proyectos_2023")

public class RecursoGestionesEntity {
    @Id
    @Column(name = "id_recurso", nullable = false, length = 20)
    private String idRecurso;
    @Basic
    @Column(name = "nombre_recurso", nullable = false, length = 100)
    private String nombreRecurso;
    @Basic
    @Column(name = "descripcion", nullable = false, length = 250)
    private String descripcion;
    @OneToOne(mappedBy = "recursoGestionesByIdGestion")
    private GestionProyectoEntity gestionProyectoByIdRecurso;

    public String getIdRecurso() {
        return idRecurso;
    }

    public void setIdRecurso(String idRecurso) {
        this.idRecurso = idRecurso;
    }

    public String getNombreRecurso() {
        return nombreRecurso;
    }

    public void setNombreRecurso(String nombreRecurso) {
        this.nombreRecurso = nombreRecurso;
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

        RecursoGestionesEntity that = (RecursoGestionesEntity) o;

        if (idRecurso != null ? !idRecurso.equals(that.idRecurso) : that.idRecurso != null) return false;
        if (nombreRecurso != null ? !nombreRecurso.equals(that.nombreRecurso) : that.nombreRecurso != null)
            return false;
        if (descripcion != null ? !descripcion.equals(that.descripcion) : that.descripcion != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idRecurso != null ? idRecurso.hashCode() : 0;
        result = 31 * result + (nombreRecurso != null ? nombreRecurso.hashCode() : 0);
        result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
        return result;
    }

    public GestionProyectoEntity getGestionProyectoByIdRecurso() {
        return gestionProyectoByIdRecurso;
    }

    public void setGestionProyectoByIdRecurso(GestionProyectoEntity gestionProyectoByIdRecurso) {
        this.gestionProyectoByIdRecurso = gestionProyectoByIdRecurso;
    }
}
