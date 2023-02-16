package hibernate.hibernate05;

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

    //eliminar en cascada desde detalle_alumno
    public void option_delete_on_cascade(){
        /*para poder eliminar en cascada, debemos utilizar CascadeType.ALL como tipo de
        la 'cascada' anotación del atributo alumno de la clase Detalle_Alumno*/

        create_factory_session();
        try{
            int id= AdditionalMethods.questions_data_integer("id","consultar");
            mySession.beginTransaction();

            //obtener detalle_alumno
            Detalle_Alumno details=mySession.get(Detalle_Alumno.class,id);
            System.out.println(details.getAlumno());
            System.out.println("Eliminar en cascada desde detalle_alumno");

            mySession.getTransaction().commit();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            mySession.close();
            myFactory.close();
        }
    }

    //eliminar detalle_alumno SIN ELIMINAR el alumno
    public void option_delete_detalle_alumno(){
        /*para poder realizar el cometido de este método, debemos eliminar
        de la 'cascada' anotación del atributo alumno de la clase Detalle_Alumno*/

        create_factory_session();
        try{
            int id= AdditionalMethods.questions_data_integer("id","consultar");
            mySession.beginTransaction();

            //obtener detalle_alumno
            Detalle_Alumno details=mySession.get(Detalle_Alumno.class,id);
            details.getAlumno().setDetalleAlumno(null);//este detalle_alumno NO TIENE CLIENTE ASOCIADO

            if(details!=null){
                mySession.delete(details);
            }
            System.out.println(details.getAlumno());
            System.out.println("Eliminar en cascada desde detalle_alumno");

            mySession.getTransaction().commit();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            mySession.close();
            myFactory.close();
        }
    }

}
