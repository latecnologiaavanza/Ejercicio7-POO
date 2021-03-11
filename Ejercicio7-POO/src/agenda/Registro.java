package agenda;

import java.util.Scanner;
import javax.swing.JOptionPane;
/*
          Añadir contacto
          Listar contactos
          buscar contacto
          comprobar si existe contacto
          eliminar contacto
          contactos disponibles
          Agenda llena
          Salir
 */


public class Registro {
     public static void main(String[] args) {
        
          Scanner teclado = new Scanner(System.in);
          int opcion;
          int telefono;
          String nombre;
          Contacto contacto; 
          int tamañoAgenda;
          
          tamañoAgenda = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite la cantidad de contactos para su agenda : "));
          Agenda agendaTelefonica = new Agenda(tamañoAgenda);
          
          do{
              System.out.println("\n\tBIENVENIDO A LA TELEFONICA");
              System.out.println("1 . Añadir contacto");
              System.out.println("2 . Listar contactos");
              System.out.println("3 . Buscar un contacto");
              System.out.println("4 . Comprobar si existe un contacto");
              System.out.println("5 . Eliminar contacto");
              System.out.println("6 . Comprobar contactos disponibles");
              System.out.println("7 . Comprobar si la agenda esta llena");
              System.out.println("8 . Salir");
              System.out.print("Digite una opcion porfavor : ");
              opcion = teclado.nextInt();
              
              switch(opcion){
                  //Añadimos un contacto
                  case 1:
                      System.out.print("\nDigite su nombre : ");
                      nombre = teclado.next();
                      
                      System.out.print("Digite su telefono : ");
                      telefono = teclado.nextInt();
                      
                      contacto = new Contacto(nombre,telefono);
                      agendaTelefonica.añadirContacto(contacto);
                      System.out.println("");
                      break;
                      
                  //Listamos los contactos    
                  case 2:
                      System.out.println("");
                      agendaTelefonica.listarContactos();
                      System.out.println("");
                      break;
                      
                  //Buscamos un contacto    
                  case 3:
                      System.out.print("\nDigite un nombre : ");
                      nombre = teclado.next();
                      
                      agendaTelefonica.buscarContacto(nombre);
                      System.out.println("");
                      break;
                      
                  //Comprobamos si un contacto existe
                  case 4:
                      System.out.print("\nDigite su nombre : ");
                      nombre = teclado.next();
                      
                      contacto = new Contacto(nombre);
                      if(agendaTelefonica.comprobarSiExisteContacto(contacto)){
                          System.out.println("\nEl contacto existe");
                      }
                      else{
                          System.out.println("\nEl contacto no existe");
                      }
                      System.out.println("");
                      break;
                      
                  //Eliminamos un contacto
                  case 5:
                      System.out.print("\nDigite su nombre : ");
                      nombre = teclado.next();
                      
                      contacto = new Contacto(nombre);
                      agendaTelefonica.eliminarContacto(contacto);
                      System.out.println("");
                      break;
            
                  //Comprobamos si hay contactos disponibles
                  case 6:
                      System.out.println("\nHay " + agendaTelefonica.comprobarSiHayHuecosLibres() + " contactos");
                      System.out.println("");
                      break;
                      
                  //Comprobamos si la agenda esta llena    
                  case 7:
                      if(agendaTelefonica.comprobarSiLaAgendaEstaLlena()){
                          System.out.println("\nla agenda esta llena");
                      }else{
                          System.out.println("\nAún puedes registrar contactos");
                      }
                      System.out.println("");         
                      break;
                      
                  case 8:
                      System.out.println("\nGracias por participar !!!");
                      opcion = 8;
                      break;
                      
                  default:
                      System.out.println("\nOpcion no valida , porfavor vuelva a digitar");
                      System.out.println("");
                      break;
              }
          }while(opcion != 8);
    }
}
