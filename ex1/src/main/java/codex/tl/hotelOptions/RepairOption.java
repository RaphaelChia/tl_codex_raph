package codex.tl.hotelOptions;

import codex.tl.Hotel;

public class RepairOption  extends Options {
    public RepairOption(String option, String optionMessage) {
        super(option, optionMessage);
    }

    @Override
    public void doAction(Hotel h) {
        h.repairRoom();
    }
}
