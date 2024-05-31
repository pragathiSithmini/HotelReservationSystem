package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Hotel {
    private Room[] roomList;
    private CircularQueue<Person> waitingList;

    public Hotel(){
        roomList = new Room[8];
        waitingList = new CircularQueue<>(8);
    }

    public Hotel(int noOfRooms, int sizeOfWaitingList){
        roomList = new Room[noOfRooms];
        waitingList = new CircularQueue<>(sizeOfWaitingList);
    }
    public void initialise() {
        System.out.println( "---initialise---");
        for (int x = 0; x < 8; x++ ) {
            roomList[x]=(new Room("e"));
            System.out.println("Room " + x + " is empty");
        }
    }

    public void viewsallrooms(){                                                    //method for view all rooms.
        for (int x = 0; x < 8; x++ ){
            System.out.println("room " + x + " occupied by " + roomList[x].getName());
        }
    }

    public void displayEmptyRooms() {                                                //method for display empty rooms.
        for (int x = 0; x < 8; x++ ){
            if (roomList[x].getName().equals("e")){
                System.out.println("room " + x + " is empty");
            }
        }
    }

    public void addscustomertoroom(int roomNum, Person person){                                               //method for add a customer to a room.
        Room r = roomList[roomNum];
        if (r.getName().equals("e")){
            r.setName(person.getName());
            r.setPayingCustomer(person);
        } else {
            waitingList.enqueue(person);
        }

    }

    public void deleteCustomer(int roomdelete){                                                   //method for delete customer from room.
        if (!waitingList.isEmpty()){
            Person p = waitingList.dequeue();
            roomList[roomdelete].setName(p.getName());
            roomList[roomdelete].setPayingCustomer(p);
        } else {
            roomList[roomdelete].setName("e");
        }
    }

    public void findcustomer(String findperson){                                                     //method for find room from customer name.
        for(int x=0;x<8;x++){
            if(roomList[x].getName().equals(findperson)){
                System.out.println("* "+findperson+"'s room number is " +x+".");
            }
        }
    }

    public void storedata(String filename) throws IOException {                                         //method for store the data into file.
        FileWriter fw=new FileWriter (filename);
        for (int x = 0; x < 8; x++ ){
            fw.write("room " + x + " occupied by " + roomList[x].getName() + "\n");
        }
        fw.close();
    }

    public void loaddata(String fileName) throws FileNotFoundException {                            //method for load data into file.
        File f=new File(fileName);
        Scanner sc=new Scanner(f);
        while ((sc.hasNext())){
            System.out.println(sc.nextLine());
        }
    }
    public void viewguests(){   //method for view the guests ordered alphabetically by name.

        ArrayList<Room> sortedRoomNames = new ArrayList<Room>(Arrays.asList(roomList));
        for(int i = 0; i< sortedRoomNames.size()-1; i++)
        {
            for (int j = i+1; j< sortedRoomNames.size()-1; j++)
            {
                //compares each elements of the array to all the remaining elements
                if(sortedRoomNames.get(i).getName().compareTo(sortedRoomNames.get(j).getName())>0)
                {   //swapping array elements
                    Room temp = sortedRoomNames.get(i);
                    sortedRoomNames.set(i,sortedRoomNames.get(j));
                    sortedRoomNames.set(j,temp);
                }
            }
        }

        for (int x = 0; x < 8; x++ ){
            if (!(sortedRoomNames.get(x).getName()=="e")){
                System.out.println(sortedRoomNames.get(x).getName());
            }

        }
    }

}
