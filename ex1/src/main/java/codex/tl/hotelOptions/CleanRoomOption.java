package codex.tl.hotelOptions;

import codex.tl.Hotel;

public class CleanRoomOption  extends Options {
    public CleanRoomOption(String option, String optionMessage) {
        super(option, optionMessage);
    }

    @Override
    public void doAction(Hotel h) {
        h.cleanRoom();
    }
}
