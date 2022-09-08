package codex.tl;

import codex.tl.exceptions.InvalidHotelRoomException;
import codex.tl.states.Available;
import codex.tl.states.Vacant;
import codex.tl.utils.Constants;
import static codex.tl.utils.InputOutput.clearScreen;

/**
 * This is the hotel that contains the hotelrooms.
 * This hotel has afew method to support the day to day operations of the hotel.
 *
 */
public class Hotel {
    public HotelRoom[] rooms;

    public Hotel() {
        int maxNumPrefix    = 4;
        char maxCharPostfix = 'E';
        int numRooms        = maxNumPrefix*((int)maxCharPostfix-64);
        this.rooms          = new HotelRoom[numRooms];

        // Initializing the room with 'new' keyword and respective room names
        int roomIdx=0;
        for(int i=1;i<=maxNumPrefix && roomIdx<numRooms;i++){
            for(int j=4;j>=0;j--){
                this.rooms[roomIdx]=new HotelRoom(String.format("%d%c",i,maxCharPostfix-j));
                roomIdx++;
            }
        }
    }

    /**
     * Function will take in no argument, look for the nearest empty room, and automatically
     * assign the room, and changes its state to occupied.
     * Function uses an o(n) time complexity traversal to look for the nearest available room
     */
    public void requestRoom(){
        boolean roomFound = false;
        for(HotelRoom room:rooms){
            if(room.getCurrentState() instanceof Available){
                room.getCurrentState().checkin();
                roomFound=true;
                break;
            }

        }
        if(!roomFound){
            System.out.println(Constants.errNoAvailableRooms);
        }
    }

    /**
     * Function takes in a room name, get the room object associated with the room name,
     * and checks it out.
     * @param roomName then room name in this format e.g. 2E
     */
    public void checkoutRoom(String roomName){
        try{
            HotelRoom room = getRoomFromName(roomName);
            room.getCurrentState().checkout();
        }catch(InvalidHotelRoomException ihrEx){
            System.out.println(ihrEx.getMessage());
        }
    }

    /**
     * Function takes in a room name, get the room object associated with the room name,
     * and cleans it.
     * @param roomName
     */
    public void cleanRoom(String roomName){
        try{
            HotelRoom room = getRoomFromName(roomName);
            room.getCurrentState().clean();
        }catch(InvalidHotelRoomException ihrEx){
            System.out.println(ihrEx.getMessage());
        }

    }

    /**
     * Function takes in a room name, get the room object associated with the room name,
     * and mark it for repair
     * @param roomName
     */
    public void markRoomForRepair(String roomName){
        try{
            HotelRoom room = getRoomFromName(roomName);
            room.getCurrentState().outOfService();
        }catch(InvalidHotelRoomException ihrEx){
            System.out.println(ihrEx.getMessage());
        }

    }

    /**
     * Function takes in a room name, get the room object associated with the room name,
     * and repairs room
     * @param roomName
     */
    public void repairRoom(String roomName){
        try{
            HotelRoom room = getRoomFromName(roomName);
            room.getCurrentState().repaired();
        }catch(InvalidHotelRoomException ihrEx){
            System.out.println(ihrEx.getMessage());
        }

    }

    public void listAvailableRooms(){
        clearScreen();
        System.out.println("Available rooms:");
        for(HotelRoom room:rooms){
            if(room.getCurrentState() instanceof Available){
                System.out.printf("%s ",room.getRoomName());
            }
        }
        System.out.println("");
    }

    public void listVacantRooms(){
        clearScreen();
        System.out.println("Vacant rooms:");
        for(HotelRoom room:rooms){
            if(room.getCurrentState() instanceof Vacant){
                System.out.printf("%s ",room.getRoomName());
            }
        }
        System.out.println("");
    }

    /**
     * To retrieve a room object from the list starting from the nearest to the door.
     * It uses a normal list traversal with complexity o(n).
     * @param roomName the name of the room e.g. 2E
     * @return HotelRoom object if found, else null
     */
    private HotelRoom getRoomFromName(String roomName) throws InvalidHotelRoomException {
        for(HotelRoom room:rooms){
            if(room.getRoomName().equals(roomName)){
                return room;
            }
        }
        throw new InvalidHotelRoomException(Constants.errInvalidRoomName);
    }

}
