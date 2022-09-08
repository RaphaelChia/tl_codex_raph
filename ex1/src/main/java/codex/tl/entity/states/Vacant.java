package codex.tl.entity.states;

import codex.tl.HotelRoom;

public class Vacant implements IHotelRoomState{

    private final HotelRoom hotelRoom;

    public Vacant(HotelRoom hotelRoom){
        this.hotelRoom = hotelRoom;
    }

    @Override
    public void checkin() {
        System.out.println("Unable to check-in a vacant room.");
    }

    @Override
    public void checkout() {
        System.out.println("Unable to check-out a vacant room.");
    }

    @Override
    public void clean() {
        hotelRoom.setCurrentState(hotelRoom.getAvailable());
        System.out.println("Cleaned a vacant room successfully! It is now Available.");
    }

    @Override
    public void outOfService() {
        hotelRoom.setCurrentState(hotelRoom.getRepair());
        System.out.println("Took a vacant room out of service. It is now under Repair.");
    }

    @Override
    public void repaired() {
        System.out.println("Unable to repair a vacant room.");
    }
}
