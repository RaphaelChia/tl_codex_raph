package codex.tl.options.hotelOptions;

import codex.tl.Hotel;

public class listVacantRoomOption extends HotelOptions{
    public listVacantRoomOption(String option, String optionMessage, Hotel h) {
        super(option, optionMessage, h);
    }

    @Override
    public void doAction() {
        super.getHotel().listVacantRooms();
    }
}
