package wjhs;
import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
        Scanner opcion = new Scanner(System.in);
        String nombre;

        System.out.println( "Laboratorio 1." );
        System.out.println("--------------------------------");
        System.out.println("Escoja una opcion");
        System.out.println("1. Mostrar lista");
        System.out.println("2. Buscar persona");
        System.out.println("3. Buscar con codificacion");
        int menu = opcion.nextInt();
        switch (menu){
            case 1:
                
            break;
            case 2:
            System.out.println("Escriba el nombre de la persona en minusculas");
            nombre = opcion.nextLine();

            break;
            case 3:
            System.out.println("Escriba el nombre de la persona en minusculas");
            nombre = opcion.nextLine();

            break;
            default:
            System.out.println("valor no valido");
            
            break;


        }

    }
}
