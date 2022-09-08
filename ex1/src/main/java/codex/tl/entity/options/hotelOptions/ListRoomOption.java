package codex.tl.entity.options.hotelOptions;

import codex.tl.Hotel;

public class ListRoomOption extends HotelOptions{
    public ListRoomOption(String option, String optionMessage, Hotel hotel) {
        super(option, optionMessage, hotel);
    }

    @Override
    public void doAction() {
        super.getHotel().listAvailableRooms();
    }
}
