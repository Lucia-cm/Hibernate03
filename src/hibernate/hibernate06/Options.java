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
                .addAnnotatedClass(Asignatura.class)
                .buildSessionFactory();

        mySession=myFactory.openSession();
    }

    //Insert
    public void option_insert_asignatura(){
        create_factory_session();
        int id=AdditionalMethods.questions_data_integer();
        try{
            mySession.beginTransaction();
            //OBTENER alumno de la tabla Alumno
            Alumno alumno=mySession.get(Alumno.class,id);

            //CREAR Asignatura para el Alumno
            /*Asignatura asignatura1=AdditionalMethods.createAsignatura();
            Asignatura asignatura2=AdditionalMethods.createAsignatura();
            Asignatura asignatura3=AdditionalMethods.createAsignatura();
*/
            Asignatura asignatura1=new Asignatura("2023-01-01");
            Asignatura asignatura2=new Asignatura("2023-02-01");
            Asignatura asignatura3=new Asignatura("2023-03-01");

            //ASIGNAR asignaturas asl Alumno
            alumno.addAsignaturas(asignatura1);
            alumno.addAsignaturas(asignatura2);
            alumno.addAsignaturas(asignatura3);

            //GUARDAR en DDBB
            mySession.save(asignatura1);
            mySession.save(asignatura2);
            mySession.save(asignatura3);

            mySession.getTransaction().commit();

            System.out.println("Asignatura INSERTADA");

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            mySession.close();
            myFactory.close();
        }
    }

}
