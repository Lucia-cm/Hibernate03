package hibernate.hibernate06;

import javax.persistence.*;

@Entity
@Table(name="asignatura")
public class Asignatura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="fecha_matriculacion")
    private String fecha_matriculacion;

    @Column(name="forma_pago")
    private String forma_pago;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})  //una asignatura muchos alumnos
    @JoinColumn(name="alumno_id")
    private Alumno alumno;





    public Asignatura(){}

    public Asignatura(String fecha_matriculacion) {
        this.fecha_matriculacion = fecha_matriculacion;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getForma_pago() {
        return forma_pago;
    }
    public void setForma_pago(String forma_pago) {
        this.forma_pago = forma_pago;
    }

    public Alumno getAlumno() {
        return alumno;
    }
    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    @Override
    public String toString() {
        return "Asignatura{" +
                "id=" + id +
                ", fecha_matriculacion='" + fecha_matriculacion + '\'' +
                ", forma_pago='" + forma_pago + '\'' +
                '}';
    }
}
