package codex.tl.entity.states;

import codex.tl.HotelRoom;

public class Repair implements IHotelRoomState{

    private final HotelRoom hotelRoom;

    public Repair(HotelRoom hotelRoom){
        this.hotelRoom = hotelRoom;
    }

    @Override
    public void checkin() {
        System.out.println("Unable to check-in a room under Repair.");
    }

    @Override
    public void checkout() {
        System.out.println("Unable to check-out a room under Repair.");

    }

    @Override
    public void clean() {
        System.out.println("Unable to clean a room under Repair.");

    }

    @Override
    public void outOfService() {
        System.out.println("Unable to take a room under Repair out of service.");
    }

    @Override
    public void repaired() {
        hotelRoom.setCurrentState(hotelRoom.getVacant());
        System.out.println("Repaired room successfully! It is now Vacant. Remember to clean it!");
    }
}
