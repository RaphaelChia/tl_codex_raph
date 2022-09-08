package codex.tl.options.hotelOptions;

import codex.tl.Hotel;

public class listRoomOption extends HotelOptions{
    public listRoomOption(String option, String optionMessage, Hotel h) {
        super(option, optionMessage, h);
    }

    @Override
    public void doAction() {
        super.getHotel().listAvailableRooms();
    }
}
