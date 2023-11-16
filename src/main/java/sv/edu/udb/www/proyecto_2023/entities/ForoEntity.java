package sv.edu.udb.www.proyecto_2023.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "foro", schema = "proyecto_2023")
@NamedQueries({
        @NamedQuery(name="foro.findByIdProyecto",query = "SELECT e FROM ForoEntity e where e.idProyecto= :idProyecto"),
        @NamedQuery(name="foro.findByIdUsuario",query = "SELECT e FROM ForoEntity e where e.idUsuario= :idUsuario"),
        @NamedQuery(name="foro.allForo",query = "SELECT e FROM ForoEntity e")

})
public class ForoEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_foro", nullable = false)
    private long idForo;

    @Basic
    @Column(name = "comentario", nullable = false, length = 2000)
    private String comentario;

    @Basic
    @Column(name = "fecha_comentario", nullable = false)
    private Date fechaComentario;

    @Basic
    @Column(name = "id_proyecto", nullable = false, length = 20)
    private long idProyecto;
    @Basic
    @Column(name = "id_usuario", nullable = false, length = 20)
    private long idUsuario;
    @ManyToOne
    @JoinColumn(name = "id_proyecto", referencedColumnName = "id_proyecto", insertable=false, updatable=false)
    private ProyectosEntity proyectosByIdProyecto;
    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario", insertable=false, updatable=false)
    private UsuariosEntity usuariosByIdUsuario;


    public ProyectosEntity getProyectosByIdProyecto() {
        return proyectosByIdProyecto;
    }

    public void setProyectosByIdProyecto(ProyectosEntity proyectosByIdProyecto) {
        this.proyectosByIdProyecto = proyectosByIdProyecto;
    }

    public long getIdForo() {
        return idForo;
    }

    public void setIdForo(long idForo) {
        this.idForo = idForo;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public long getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(long idProyecto) {
        this.idProyecto = idProyecto;
    }

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public UsuariosEntity getUsuariosByIdUsuario() {
        return usuariosByIdUsuario;
    }

    public void setUsuariosByIdUsuario(UsuariosEntity usuariosByIdUsuario) {
        this.usuariosByIdUsuario = usuariosByIdUsuario;
    }

    public Date getFechaComentario() {
        return fechaComentario;
    }

    public void setFechaComentario(Date fechaComentario) {
        this.fechaComentario = fechaComentario;
    }
}
