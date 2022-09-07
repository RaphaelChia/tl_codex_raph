package codex.tl.hotelOptions;

import codex.tl.Hotel;

public class OutOfServiceOption  extends Options {
    public OutOfServiceOption(String option, String optionMessage) {
        super(option, optionMessage);
    }

    @Override
    public void doAction(Hotel h) {
        h.markRoomForRepair();
    }
}
