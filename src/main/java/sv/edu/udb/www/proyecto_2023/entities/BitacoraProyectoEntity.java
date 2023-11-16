package sv.edu.udb.www.proyecto_2023.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "bitacora_proyecto", schema = "proyecto_2023")
@NamedQuery(name="bitacora_proyecto.findByIdProyecto",query = "SELECT e FROM BitacoraProyectoEntity e where e.idProyecto= :id")
@NamedQuery(name="bitacora_proyecto.allBitacoraProyecto",query = "SELECT e FROM BitacoraProyectoEntity e")
public class BitacoraProyectoEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_bitacora", nullable = false)
    private long idBitacora;
    @Basic
    @Column(name = "descripcion_bitacora", nullable = false, length = 250)
    private String descripcionBitacora;
    @Basic
    @Column(name = "tipo_bitacora", nullable = false, length = 250)
    private String tipoBitacora;
    @Basic
    @Column(name = "descripcion_evento", nullable = false, length = 250)
    private String descripcionEvento;
    @Basic
    @Column(name = "fecha_bitacora", nullable = false)
    private Date fechaBitacora;
    @Basic
    @Column(name = "id_proyecto", nullable = false, length = 20)
    private long idProyecto;
    @ManyToOne
    @JoinColumn(name = "id_proyecto", referencedColumnName = "id_proyecto", insertable=false, updatable=false)
    private ProyectosEntity proyectosByIdProyecto;

    public long getIdBitacora() {
        return idBitacora;
    }

    public void setIdBitacora(long idBitacora) {
        this.idBitacora = idBitacora;
    }

    public String getDescripcionBitacora() {
        return descripcionBitacora;
    }

    public void setDescripcionBitacora(String descripcionBitacora) {
        this.descripcionBitacora = descripcionBitacora;
    }

    public String getTipoBitacora() {
        return tipoBitacora;
    }

    public void setTipoBitacora(String tipoBitacora) {
        this.tipoBitacora = tipoBitacora;
    }

    public String getDescripcionEvento() {
        return descripcionEvento;
    }

    public void setDescripcionEvento(String descripcionEvento) {
        this.descripcionEvento = descripcionEvento;
    }
    public Date getFechaBitacora() { return fechaBitacora; }

    public void setFechaBitacora(Date fechaBitacora) { this.fechaBitacora = fechaBitacora; }

    public long getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(long idProyecto) {
        this.idProyecto = idProyecto;
    }

    public ProyectosEntity getProyectosByIdProyecto() {
        return proyectosByIdProyecto;
    }

    public void setProyectosByIdProyecto(ProyectosEntity proyectosByIdProyecto) {
        this.proyectosByIdProyecto = proyectosByIdProyecto;
    }
}
