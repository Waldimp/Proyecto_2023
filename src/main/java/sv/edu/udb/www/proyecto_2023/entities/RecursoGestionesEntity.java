package sv.edu.udb.www.proyecto_2023.entities;

import jakarta.persistence.*;

@Entity

@NamedQuery(name="recurso_gestiones.findByNombreRecurso",query = "SELECT e FROM RecursoGestionesEntity e where e.idRecurso= :idRecurso")
@NamedQuery(name="recurso_gestiones.allRecursoGestiones",query = "SELECT e FROM RecursoGestionesEntity e")
@Table(name = "recurso_gestiones", schema = "proyecto_2023")

public class RecursoGestionesEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_recurso", nullable = false)
    private long idRecurso;
    @Basic
    @Column(name = "nombre_recurso", nullable = false, length = 100)
    private String nombreRecurso;
    @Basic
    @Column(name = "descripcion", nullable = false, length = 250)
    private String descripcion;
    @OneToOne(mappedBy = "recursoGestionesByIdGestion")
    private GestionProyectoEntity gestionProyectoByIdRecurso;

    public long getIdRecurso() {
        return idRecurso;
    }

    public void setIdRecurso(long idRecurso) {
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

    public GestionProyectoEntity getGestionProyectoByIdRecurso() {
        return gestionProyectoByIdRecurso;
    }

    public void setGestionProyectoByIdRecurso(GestionProyectoEntity gestionProyectoByIdRecurso) {
        this.gestionProyectoByIdRecurso = gestionProyectoByIdRecurso;
    }
}
