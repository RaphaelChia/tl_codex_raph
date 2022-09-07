package codex.tl;

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

    public HotelRoom requestRoom(){
        return null;
    }

    public void checkoutRoom(){

    }

    public void cleanRoom(){

    }

    public void repairRoom(){

    }

    public void listAvailableRooms(){
        System.out.println("Available rooms:");
        for(HotelRoom room:rooms){
            if(room.currentState instanceof Available){
                System.out.printf("%s ",room.getRoomName());
            }
        }
        System.out.println("\n");
    }

}