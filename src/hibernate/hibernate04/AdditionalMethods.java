package hibernate.hibernate04;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AdditionalMethods {
    static Scanner sc=new Scanner(System.in);

    //COMPROBAR QUE UN INT ES VÁLIDO
    public static int readInteger(){
        int value=0;
        boolean valid=true;

        while(valid)
            try{
                value=sc.nextInt();
                sc.nextLine();
                valid=false;
            } catch(InputMismatchException e){
                sc.nextLine();
                System.out.println("Esa opción no es válida (entero), introduzca otra:");
            }
        return value;
    }
    public static int checkPossitiveNumber(){
        int number=readInteger();
        while(number<0){
            System.out.println("El número introducido es negativo.\nIntroduzca un número positivo:");
            number=readInteger();
        }
        if(number>0)
            number=number;
        return number;
    }

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

    static int questions_data_integer(String data, String action){
        System.out.println("Introduzca el "+data+" del alumno que desea "+action.toUpperCase());
        int id=checkPossitiveNumber();

        return id;
    }

}
