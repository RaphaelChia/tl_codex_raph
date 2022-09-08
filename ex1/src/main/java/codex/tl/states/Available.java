package codex.tl.states;

import codex.tl.HotelRoom;

public class Available implements IHotelRoomState{

    private HotelRoom hr;

    public Available(HotelRoom hr){
        this.hr = hr;
    }
    @Override
    public void checkin() {
        hr.setCurrentState(hr.getOccupied());
        System.out.printf("You've got room %s!%n",hr.getRoomName());
        System.out.println("Checked in successfully! It is now occupied.");
    }

    @Override
    public void checkout() {
        System.out.println("Unable to check-out an available room.");
    }

    @Override
    public void clean() {
        System.out.println("Unable to clean an available room.");
    }

    @Override
    public void outOfService() {
        System.out.println("Unable to take an available room out of service");
    }

    @Override
    public void repaired() {
        System.out.println("Unable to repair an available room.");
    }
}
