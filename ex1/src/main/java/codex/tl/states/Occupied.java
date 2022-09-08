package codex.tl.states;

import codex.tl.HotelRoom;

public class Occupied implements IHotelRoomState{

    private HotelRoom hr;

    public Occupied(HotelRoom hr){
        this.hr = hr;
    }
    @Override
    public void checkin() {
        System.out.println("Unable to check-in an occupied room.");
    }

    @Override
    public void checkout() {
        hr.setCurrentState(hr.getVacant());
        System.out.printf("Checked out %s successfully! It is now vacant. Remember to clean it!%n",hr.getRoomName());
    }

    @Override
    public void clean() {
        System.out.println("Unable to clean an occupied room.");

    }

    @Override
    public void outOfService() {
        System.out.println("Unable to take an occupied room out of service.");

    }

    @Override
    public void repaired() {
        System.out.println("Unable to repair an occupied room.");

    }
}
