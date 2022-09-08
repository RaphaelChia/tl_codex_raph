package codex.tl.entity.options.hotelOptions;

import codex.tl.Hotel;
import codex.tl.utils.Constants;
import codex.tl.utils.InputOutput;

import java.io.IOException;


public class CheckoutOption extends HotelOptions {

    public CheckoutOption(String option, String optionMessage,Hotel hotel) {
        super(option, optionMessage,hotel);
    }

    @Override
    public void doAction() {
        try{
            System.out.print(Constants.promptCheckoutOption);
            String room = InputOutput.getInstance().readSingleLine();
            super.getHotel().checkoutRoom(room);
        } catch (IOException ex){
            System.out.println("Couldn't checkout room!");
        }
    }
}
