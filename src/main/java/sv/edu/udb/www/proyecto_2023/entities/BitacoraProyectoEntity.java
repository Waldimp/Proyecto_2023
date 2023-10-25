package sv.edu.udb.www.proyecto_2023.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "bitacora_proyecto", schema = "proyectos_2023")
@NamedQuery(name="bitacora_proyecto.findByIdProyecto",query = "SELECT e FROM BitacoraProyectoEntity e where e.idProyecto= :id")
@NamedQuery(name="bitacora_proyecto.allBitacoraProyecto",query = "SELECT e FROM BitacoraProyectoEntity e")
public class BitacoraProyectoEntity {

    @Id
    @Column(name = "id_bitacora", nullable = false, length = 20)
    private String idBitacora;
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
    @Column(name = "id_proyecto", nullable = false, length = 20)
    private String idProyecto;
    @ManyToOne
    @JoinColumn(name = "id_proyecto", referencedColumnName = "id_proyecto", insertable=false, updatable=false)
    private ProyectosEntity proyectosByIdProyecto;

    public String getIdBitacora() {
        return idBitacora;
    }

    public void setIdBitacora(String idBitacora) {
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

    public String getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(String idProyecto) {
        this.idProyecto = idProyecto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BitacoraProyectoEntity that = (BitacoraProyectoEntity) o;

        if (idBitacora != null ? !idBitacora.equals(that.idBitacora) : that.idBitacora != null) return false;
        if (descripcionBitacora != null ? !descripcionBitacora.equals(that.descripcionBitacora) : that.descripcionBitacora != null)
            return false;
        if (tipoBitacora != null ? !tipoBitacora.equals(that.tipoBitacora) : that.tipoBitacora != null) return false;
        if (descripcionEvento != null ? !descripcionEvento.equals(that.descripcionEvento) : that.descripcionEvento != null)
            return false;
        if (idProyecto != null ? !idProyecto.equals(that.idProyecto) : that.idProyecto != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idBitacora != null ? idBitacora.hashCode() : 0;
        result = 31 * result + (descripcionBitacora != null ? descripcionBitacora.hashCode() : 0);
        result = 31 * result + (tipoBitacora != null ? tipoBitacora.hashCode() : 0);
        result = 31 * result + (descripcionEvento != null ? descripcionEvento.hashCode() : 0);
        result = 31 * result + (idProyecto != null ? idProyecto.hashCode() : 0);
        return result;
    }

    public ProyectosEntity getProyectosByIdProyecto() {
        return proyectosByIdProyecto;
    }

    public void setProyectosByIdProyecto(ProyectosEntity proyectosByIdProyecto) {
        this.proyectosByIdProyecto = proyectosByIdProyecto;
    }
}
