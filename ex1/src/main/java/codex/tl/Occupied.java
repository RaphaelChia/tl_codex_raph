package codex.tl;

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
        hr.currentState=hr.getVacant();
        System.out.println("Checked out successfully! It is now vacant.");
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
