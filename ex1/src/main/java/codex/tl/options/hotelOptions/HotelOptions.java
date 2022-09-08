package codex.tl.options.hotelOptions;

import codex.tl.Hotel;
import codex.tl.options.Options;


/**
 * If we want to add more hotel options, we can just extend this HotelOptions class.
 */
public abstract class HotelOptions extends Options {

    private Hotel hotel;

    public HotelOptions(String option, String optionMessage,Hotel h) {
        super(option, optionMessage);
        this.hotel =h;
    }

    public Hotel getHotel() {
        return hotel;
    }
}
