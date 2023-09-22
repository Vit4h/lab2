package wjhs;
import java.util.Scanner;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Scanner opcion = new Scanner(System.in);

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

            break;
            case 3:

            break;
            default:
            System.out.println("valor no valido");
            
            break;


        }

    }
}
