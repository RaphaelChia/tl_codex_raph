package codex.tl.options.hotelOptions;

import codex.tl.Hotel;

public class RequestRoomOption extends HotelOptions {

    public RequestRoomOption(String option, String optionMessage,Hotel h) {
        super(option, optionMessage, h);
    }

    @Override
    public void doAction() {
        super.getHotel().requestRoom();
    }
}
