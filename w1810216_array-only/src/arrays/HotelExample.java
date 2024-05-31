package arrays;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;     //******should extend.(Task 4)
import java.io.IOException;
import java.io.*;
import java.util.*;
public class HotelExample {
    static int roomNum;
    static String roomName;
    static String findperson;                          //created the variables as global variables.
    static int roomdelete;
    static String[] hotel = new String[9];            //created the global  arraylist.
    static Integer[] noGuests = new Integer[9];            //created the global  arraylist.
    static String[] firstNames = new String[9];
    static String[] sirnames = new String[9];
    static Integer[] creditCardNumbers = new Integer[9];
    static Scanner input = new Scanner(System.in);
    static ArrayList sortedRoomNames;
    static String name;


    public static void main(String[] args) throws IOException {         //main class
        initialise();                                                   //main class  for (int x = 0; x < 6; x++ ) hotel[x] = ""; //better to initialise in a procedure
        menu();                                     //execute the menu method.
    }
    static void initialise() {
        System.out.println( "---initilise---");
        for (int x = 0; x < 8; x++ ) {
            hotel[x] = "e";
            System.out.println("Room " + x + " is empty");
        }
    }
    static void menu() throws IOException {//created the method called menu for stored the methods which prompt from the user.

        while (true) {
            System.out.println("\n");
            System.out.print("Enter \n 1)V-view all rooms \n 2)A-add a customer to a room \n 3)E-display empty rooms" +
                    " \n 4)D-delete customer from room \n 5)F-Find room from customer name \n 6)S-store program data into file \n " +
                    "7)L-load program data into file \n 8)O- View guests Ordered alphabetically by name \n 9)Z-Stop : ");
            String choice = input.next();
            System.out.println("\n");
            if (choice.equals("Z")){
                break;
            }
            switch (choice) {
                case "V":
                    System.out.println("---VIEW ALL ROOMS---");
                    viewsallrooms();
                    break;
                case "A":
                    System.out.println("---ADD A CUSTOMER TO A ROOM---");
                    addscustomertoroom();
                    break;
                case "E":
                    System.out.println("---DISPLAY EMPTY ROOMS---");
                    displayEmptyRooms();
                    break;
                case "D":
                    System.out.println("---DELETE CUSTOMER FROM ROOM---");
                    deleteCustomer();
                    break;
                case "F":
                    System.out.println("---FIND ROOM FROM CUSTOMER NAME---");
                    findcustomer();
                    break;
                case "S":
                    storedata();
                    break;
                case "L":
                    System.out.println("---LOAD PROGRAM DATA INTO FILE---");
                    loaddata();
                    break;
                case "O":
                    System.out.println("---VIEW GUESTS ORDERED ALPHABETICALLY BY NAME---");   //method for bview guests ordered alphabetically by name.
                    viewguests();
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }

        }
    }
    static void addscustomertoroom(){                                               //method for add a customer to a room.
        System.out.print("Enter room number (0-8) or 8 to stop: " );
        roomNum = input.nextInt();
        System.out.print("Enter name for room " + roomNum +" : " ) ;
        roomName = input.next();
        hotel[roomNum] = roomName ;


        System.out.print("Enter FirstNAme : " ) ;
        String firstName = input.next();
        firstNames[roomNum] = firstName;

        System.out.print("Enter Sirname : " ) ;
        String sirname = input.next();
        sirnames[roomNum] = firstName;

        System.out.print("Enter Credit card Number : " ) ;
        int CreditCardNo = input.nextInt();
        creditCardNumbers[roomNum] = CreditCardNo;

        System.out.print("Enter number of guests in  room : " ) ;
        int guestCount = input.nextInt();
        noGuests[roomNum] = guestCount ;

    }
    static void viewsallrooms(){                                                    //method for view all rooms.
        for (int x = 0; x < 8; x++ ){
            System.out.println("room " + x + " occupied by " + hotel[x]);
        }
    }

    static void displayEmptyRooms() {                                                //method for display empty rooms.
        for (int x = 0; x < 8; x++ ){
            if (hotel[x].equals("e")){
                System.out.println("room " + x + " is empty");
            }
        }
    }

    static void deleteCustomer(){                                                   //method for delete customer from room.
        System.out.print("Enter the room number which want to delete the customer : ");
        roomdelete = input.nextInt();
        hotel[roomdelete]="e";
        noGuests[roomdelete] = 0;
        firstNames[roomdelete] = "";
        sirnames[roomdelete] = "";
        creditCardNumbers[roomdelete] = 0;
    }
    static void findcustomer(){                                                     //method for find room from customer name.
        System.out.print("Enter the name of the person who want owns the room number to be find : ");
        findperson=input.next();
        for(int x=0;x<8;x++){
            if(hotel[x].equals(findperson)){
                System.out.println("* "+findperson+"'s room number is " +x+".");
            }
        }
    }

    static void storedata() throws IOException {                                         //method for store the data into file.
        FileWriter fw=new FileWriter ("store.txt");
        for (int x = 0; x < 8; x++ ){
            fw.write("room " + x + " occupied by " + hotel[x]+"\n");
        }
        fw.close();
    }

    static void loaddata() throws FileNotFoundException {                            //method for load data into file.
       File f=new File("store.txt");
       Scanner sc=new Scanner(f);
       while ((sc.hasNext())){
           System.out.println(sc.nextLine());
       }
    }
    static void viewguests(){//method for view the guests ordered alphabetically by name.

        ArrayList<String> sortedRoomNames = new ArrayList<>(Arrays.asList(hotel));
        for(int i = 0; i< sortedRoomNames.size()-1; i++)
        {
            for (int j = i+1; j< sortedRoomNames.size()-1; j++)
            {
            //compares each elements of the array to all the remaining elements
                if(sortedRoomNames.get(i).compareTo(sortedRoomNames.get(j))>0)
                {   //swapping array elements
                    String temp = sortedRoomNames.get(i);
                    sortedRoomNames.set(i,sortedRoomNames.get(j));
                    sortedRoomNames.set(j,temp);
                }
            }
        }

        for (int x = 0; x < 8; x++ ){
            if (!(sortedRoomNames.get(x)=="e")){
                System.out.println(sortedRoomNames.get(x));
            }

        }
    }
}