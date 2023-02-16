package hibernate.hibernate06;

import javax.persistence.*;

@Entity
@Table(name="alumno")
public class Alumno {
    public Alumno() {
    }
    public Alumno(String nombre, String apellidos) {
        this.nombre = nombre;
        this.apellidos = apellidos;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Detalle_Alumno getDetalleAlumno() {
        return detalleAlumno;
    }
    public void setDetalleAlumno(Detalle_Alumno detalleAlumno) {
        this.detalleAlumno = detalleAlumno;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                '}';
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private Detalle_Alumno detalleAlumno;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    int id;
    @Column(name="nombre")
    String nombre;
    @Column(name="apellidos")
    String apellidos;


}