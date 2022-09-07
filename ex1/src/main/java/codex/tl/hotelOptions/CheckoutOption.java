package codex.tl.hotelOptions;

import codex.tl.Hotel;

public class CheckoutOption extends Options {

    public CheckoutOption(String option, String optionMessage) {
        super(option, optionMessage);
    }

    @Override
    public void doAction(Hotel h) {
        h.checkoutRoom("");
    }
}
