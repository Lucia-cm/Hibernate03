package hibernate.hibernate02;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Options {
    private SessionFactory myFactory;
    private Session mySession;

    //crear factory y session
    public void create_factory_session(){
        myFactory=new Configuration()
                .configure("hibernate03.cfg.xml")
                .addAnnotatedClass(Alumno.class)
                .addAnnotatedClass(Detalle_Alumno.class)
                .buildSessionFactory();

        mySession=myFactory.openSession();
    }

    //Insert
    public void option_insert(){
        create_factory_session();
        try{
            Alumno student=AdditionalMethods.createAlumno();
            Detalle_Alumno details=AdditionalMethods.createDetalleAlumno();

            student.setDetalleAlumno(details);

            mySession.beginTransaction();
            mySession.save(student);

            mySession.getTransaction().commit();
            mySession.close();

            System.out.println("Alumno INSERTADO");

        }finally {
            myFactory.close();
        }
    }





}
