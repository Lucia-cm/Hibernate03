package hibernate.hibernate03;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="detalle_alumno")
public class Detalle_Alumno {
    public Detalle_Alumno() {
    }

    public Detalle_Alumno(String direccion, String web, String tfno, String comentarios) {
        this.direccion = direccion;
        this.web = web;
        this.tfno = tfno;
        this.comentarios = comentarios;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getWeb() {
        return web;
    }
    public void setWeb(String web) {
        this.web = web;
    }

    public String getTfno() {
        return tfno;
    }
    public void setTfno(String tfno) {
        this.tfno = tfno;
    }

    public String getComentarios() {
        return comentarios;
    }
    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    @Id
    @Column(name="id")
    int id;
    @Column(name="direccion")
    String direccion;
    @Column(name="web")
    String web;
    @Column(name="tfno")
    String tfno;
    @Column(name="comentarios")
    String comentarios;

}
