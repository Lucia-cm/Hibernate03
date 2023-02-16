package hibernate.hibernate06;

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

    //eliminar
    public void option_delete(){
        create_factory_session();
        try{
            int id= AdditionalMethods.questions_data_integer("id","eliminar");

            mySession.beginTransaction();
            Alumno student=mySession.get(Alumno.class,id);

            if(student!=null){
                mySession.delete(student);
                System.out.println("Alumno ELIMINADO");
            }else
                System.out.println("El alumno NO EXISTE");

            mySession.getTransaction().commit();
            mySession.close();

        }finally {
            myFactory.close();
        }
    }

    //consultar datos de una tabla desde otra
    public void option_information_two_tables_references(){
        create_factory_session();
        try{
            int id= AdditionalMethods.questions_data_integer("id","consultar");
            mySession.beginTransaction();

            //Obtener Detalle_Alumno
            Detalle_Alumno details=mySession.get(Detalle_Alumno.class,id);

            if(details!=null){
                System.out.println(details);
                System.out.println(details.getAlumno());
            }else
                System.out.println("El alumno NO EXISTE");

            mySession.getTransaction().commit();
            mySession.close();

        }finally {
            myFactory.close();
        }
    }

    //eliminar en cascada
    public void option_delete_on_cascade(){
        create_factory_session();
        try{
            int id= AdditionalMethods.questions_data_integer("id","eliminar");

            mySession.beginTransaction();
            Alumno student=mySession.get(Alumno.class,id);

            if(student!=null){
                mySession.delete(student);
                System.out.println("Alumno ELIMINADO");
            }else
                System.out.println("El alumno NO EXISTE");

            mySession.getTransaction().commit();
            mySession.close();

        }finally {
            myFactory.close();
        }
    }

}
