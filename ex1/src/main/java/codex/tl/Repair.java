package codex.tl;

public class Repair implements IHotelRoomState{

    private HotelRoom hr;

    public Repair(HotelRoom hr){
        this.hr = hr;
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
        hr.currentState = hr.getVacant();
        System.out.println("Repaired room successfully! It is now Vacant.");
    }
}
