package codex.tl.entity.options.hotelOptions;

import codex.tl.Hotel;

public class RequestRoomOption extends HotelOptions {

    public RequestRoomOption(String option, String optionMessage,Hotel hotel) {
        super(option, optionMessage, hotel);
    }

    @Override
    public void doAction() {
        super.getHotel().requestRoom();
    }
}
