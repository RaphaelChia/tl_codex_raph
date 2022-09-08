package codex.tl.entity.options.hotelOptions;

import codex.tl.Hotel;

public class ListVacantRoomOption extends HotelOptions{
    public ListVacantRoomOption(String option, String optionMessage, Hotel hotel) {
        super(option, optionMessage, hotel);
    }

    @Override
    public void doAction() {
        super.getHotel().listVacantRooms();
    }
}
