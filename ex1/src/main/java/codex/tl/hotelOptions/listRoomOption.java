package codex.tl.hotelOptions;

import codex.tl.Hotel;

public class listRoomOption extends Options{
    public listRoomOption(String option, String optionMessage) {
        super(option, optionMessage);
    }

    @Override
    public void doAction(Hotel h) {
        h.listAvailableRooms();
    }
}
