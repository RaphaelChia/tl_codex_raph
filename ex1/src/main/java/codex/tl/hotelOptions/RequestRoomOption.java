package codex.tl.hotelOptions;

import codex.tl.Hotel;

public class RequestRoomOption extends Options {


    public RequestRoomOption(String option, String optionMessage) {
        super(option, optionMessage);
    }

    @Override
    public void doAction(Hotel h) {
        h.requestRoom();
    }
}
