package hibernate.hibernate03;

import java.util.Scanner;

public class AdditionalMethods {
    static Scanner sc=new Scanner(System.in);

    static Alumno createAlumno(){
        System.out.println("Indica su NOMBRE:");
        String name= sc.nextLine();
        System.out.println("Indica sus APELLIDOS:");
        String last_name= sc.nextLine();

        return new Alumno(name,last_name);
    }

    static Detalle_Alumno createDetalleAlumno(){
        System.out.println("Indica su DIRECCION:");
        String address= sc.nextLine();
        System.out.println("Indica su WEB:");
        String web= sc.nextLine();
        System.out.println("Indica su TELEFONO:");
        String tfno= sc.nextLine();
        System.out.println("Indica los COMENTARIOS:");
        String comments= sc.nextLine();

        return new Detalle_Alumno(address,web,tfno,comments);
    }

}
