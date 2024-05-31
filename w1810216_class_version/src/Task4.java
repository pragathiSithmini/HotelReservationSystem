import model.Hotel;
import model.Person;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Task4 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Hotel hotel =  new Hotel();
        hotel.initialise();

        while (true){                                          //execute the menu method.
            System.out.println("\n");
            System.out.print("Enter \n 1)V-view all rooms \n 2)A-add a customer to a room \n 3)E-display empty rooms" +
                    " \n 4)D-delete customer from room \n 5)F-Find room from customer name \n 6)S-store program data into file \n " +
                    "7)L-load program data into file \n 8)O- View guests Ordered alphabetically by name \n 9)Z-Stop : ");
            String choice= input.next();
            System.out.println("\n");
            if (choice.equals("Z")){
                break;
            }
            switch (choice) {
                case "V":
                    System.out.println("---VIEW ALL ROOMS---");
                    hotel.viewsallrooms();
                    break;
                case "A":
                    System.out.println("---ADD A CUSTOMER TO A ROOM---");
                    System.out.print("Enter room number (0-8) or 8 to stop: " );
                    int roomNum = input.nextInt();
                    System.out.print("Enter name for room " + roomNum +" : " ) ;
                    String roomName = input.next();
                    System.out.print("Enter first name : " );
                    String firstName = input.next();
                    System.out.print("Enter surname : " );
                    String surName = input.next();
                    System.out.print("Enter credit card number : " );
                    int creditCardNum = input.nextInt();
                    System.out.print("Enter number of guests: " );
                    int noOfGuests = input.nextInt();

                    Person person  = new Person(roomName, firstName, surName, creditCardNum, noOfGuests);

                    hotel.addscustomertoroom(roomNum, person);
                    break;
                case "E":
                    System.out.println("---DISPLAY EMPTY ROOMS---");
                    hotel.displayEmptyRooms();
                    break;
                case "D":
                    System.out.println("---DELETE CUSTOMER FROM ROOM---");
                    System.out.print("Enter the room number which want to delete the customer : ");
                    int roomdelete = input.nextInt();
                    hotel.deleteCustomer(roomdelete);
                    break;
                case "F":
                    System.out.println("---FIND ROOM FROM CUSTOMER NAME---");
                    System.out.print("Enter the name of the person who want owns the room number to be find : ");
                    String findperson=input.next();
                    hotel.findcustomer(findperson);
                    break;
                case "S":
                    try {
                        hotel.storedata("store.txt");
                    } catch (IOException e) {
                        System.out.println("File Not Found");
                    }
                    break;
                case "L":
                    System.out.println("---LOAD PROGRAM DATA INTO FILE---");
                    try {
                        hotel.loaddata("store.txt");
                    } catch (FileNotFoundException e) {
                        System.out.println("File Not Found");
                    }
                    break;
                case "O":
                    System.out.println("---VIEW GUESTS ORDERED ALPHABETICALLY BY NAME---");   //method for bview guests ordered alphabetically by name.
                    hotel.viewguests();
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }
        }
    }
}
