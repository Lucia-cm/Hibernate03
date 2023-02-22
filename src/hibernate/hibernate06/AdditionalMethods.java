package hibernate.hibernate06;

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

    static int questions_data_integer(){
        System.out.println("Introduzca el ID del ALUMNO:");
        int id=checkPossitiveNumber();

        return id;
    }

    static Asignatura createAsignatura(){
        System.out.println("Indica la FECHA DE MATRICULACION:");
        String date=sc.nextLine();

        return new Asignatura(date);
    }

}
