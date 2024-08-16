import java.util.HashMap;
import java.util.Scanner;

class HotelRoomBookingSystem{
  String[][] totalHotelRoom = new String[10][26]; //HotelStructure
  HashMap<String, String> roomBookingMap = new HashMap<>();//empty hashmap object initialised = to store all bookings
   String[] roomNames = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
   int toalcoinscount = 0;

  public void populateHotelRooms(){
      for(int floor=0;floor<=9;floor++){//i=0
          for(int roomName =0;roomName <=25;roomName ++)//i = 0 , 1
          {
              totalHotelRoom[floor][roomName] = floor + roomNames[roomName];//0A,0B
      
          }
      }
  }

// to display the 2d matrix of all rooms with id
  public void displayHotelRooms(){
      for(int floor=0;floor<=9;floor++){//0 rows
          for(int roomName = 0;roomName<=25;roomName++){
            System.out.print(totalHotelRoom[floor] [roomName] +" ");
          }
      }
  }
  
  public void BookHotels(String roompref , String name){
    roomBookingMap.put(roompref,name);
    System.out.println(roomBookingMap);
    toalcoinscount++;
  }
  public int TotalCoinsCollected(){
    return toalcoinscount;
  }

  public int TotalActiveBooking(){
    return roomBookingMap.size(); 
  }

  public void displayRoomBookedandCustomerName(){
    for(String idroom: roomBookingMap.keySet()){
        String customerName = roomBookingMap.get(idroom);
        System.out.println("Room "+idroom+" is booked by "+customerName);
    }
  }

  public String getRoomBookedCustomername(String idofroomforcustomer){
    String getcustomerName = null;
    for(String idroom: roomBookingMap.keySet()){
        if(idroom.equals(idofroomforcustomer)){
            getcustomerName = roomBookingMap.get(idroom);  
            return  getcustomerName;   
        }
    }
    return "Customer Not Found";  
  }
  
  public String getCustomernameforCheckout(String idofroom){
    String getcustomerName = null;
    for(String idroom: roomBookingMap.keySet()){
        if(idroom.equals(idofroom)){
            getcustomerName = roomBookingMap.get(idroom); 
            roomBookingMap.remove(idroom);  
            break;       
        }
    }  
    return  getcustomerName;
  }
  
  
@SuppressWarnings("resource")
public static void main(String[] args){
  
  HotelRoomBookingSystem crioHotels = new HotelRoomBookingSystem();

  Scanner roomInput = new Scanner(System.in);

  crioHotels.populateHotelRooms();
  crioHotels.displayHotelRooms();
  
  System.out.println("\nPlease Enter How many Customer needs to checkin:");
  int totalCustomerCount = roomInput.nextInt();
  for(int i=0;i<totalCustomerCount;i++){
    System.out.println("Enter Your floorNo");
    String floorno = roomInput.next();
    System.out.println("Enter Your Roomid");
    String roomid = roomInput.next();
    System.out.println("Enter Your Name");
    String custName = roomInput.next();
    crioHotels.BookHotels(floorno + roomid, custName);
  }
  System.out.println("Total Active Bookings: "+crioHotels.TotalActiveBooking());
  System.out.println("Total Coins Collected: "+crioHotels.TotalCoinsCollected());
  crioHotels.displayRoomBookedandCustomerName();

  System.out.println("Enter a RoomID For checking CustomerName : ");
  String idofroomforcustomer = roomInput.next();
  System.out.println("The name of the customer is "+crioHotels.getRoomBookedCustomername(idofroomforcustomer)+" For the room: "+idofroomforcustomer);

  
  System.out.println("Enter a RoomID whose Customer Come for Checkout: ");
  String idofroom = roomInput.next();
  System.out.println("The name of the released customer is "+crioHotels.getCustomernameforCheckout(idofroom));
  System.out.println("Total Active Bookings: "+crioHotels.TotalActiveBooking());
  System.out.println("Total Coins Collected: "+crioHotels.TotalCoinsCollected());


 }
  
}



/*
 F:\java_code\CollectionsClass>javac HotelRoomBookingSystem.java

F:\java_code\CollectionsClass>java HotelRoomBookingSystem
0A 0B 0C 0D 0E 0F 0G 0H 0I 0J 0K 0L 0M 0N 0O 0P 0Q 0R 0S 0T 0U 0V 0W 0X 0Y 0Z 
1A 1B 1C 1D 1E 1F 1G 1H 1I 1J 1K 1L 1M 1N 1O 1P 1Q 1R 1S 1T 1U 1V 1W 1X 1Y 1Z
2A 2B 2C 2D 2E 2F 2G 2H 2I 2J 2K 2L 2M 2N 2O 2P 2Q 2R 2S 2T 2U 2V 2W 2X 2Y 2Z 
3A 3B 3C 3D 3E 3F 3G 3H 3I 3J 3K 3L 3M 3N 3O 3P 3Q 3R 3S 3T 3U 3V 3W 3X 3Y 3Z 
4A 4B 4C 4D 4E 4F 4G 4H 4I 4J 4K 4L 4M 4N 4O 4P 4Q 4R 4S 4T 4U 4V 4W 4X 4Y 4Z 
5A 5B 5C 5D 5E 5F 5G 5H 5I 5J 5K 5L 5M 5N 5O 5P 5Q 5R 5S 5T 5U 5V 5W 5X 5Y 5Z 
6A 6B 6C 6D 6E 6F 6G 6H 6I 6J 6K 6L 6M 6N 6O 6P 6Q 6R 6S 6T 6U 6V 6W 6X 6Y 6Z 
7A 7B 7C 7D 7E 7F 7G 7H 7I 7J 7K 7L 7M 7N 7O 7P 7Q 7R 7S 7T 7U 7V 7W 7X 7Y 7Z 
8A 8B 8C 8D 8E 8F 8G 8H 8I 8J 8K 8L 8M 8N 8O 8P 8Q 8R 8S 8T 8U 8V 8W 8X 8Y 8Z 
9A 9B 9C 9D 9E 9F 9G 9H 9I 9J 9K 9L 9M 9N 9O 9P 9Q 9R 9S 9T 9U 9V 9W 9X 9Y 9Z
Please Enter How many Customer needs to checkin:
3
Enter Your floorNo
5
Enter Your Roomid
q
Enter Your Name
Arpan
{5q=Arpan}
Enter Your floorNo
2
Enter Your Roomid
t
Enter Your Name
Rina
{2t=Rina, 5q=Arpan}
Enter Your floorNo
7
Enter Your Roomid
x
Enter Your Name
Dory
{7x=Dory, 2t=Rina, 5q=Arpan}
Total Active Bookings: 3
Total Coins Collected: 3
Room 7x is booked by Dory
Room 2t is booked by Rina
Room 5q is booked by Arpan
Enter a RoomID For checking CustomerName :
2t
The name of the customer is Rina For the room: 2t
Enter a RoomID whose Customer Come for Checkout:
5q
The name of the released customer is Arpan
Total Active Bookings: 2
Total Coins Collected: 3

 */