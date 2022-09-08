package codex.tl.entity.options.hotelOptions;

import codex.tl.Hotel;
import codex.tl.entity.options.Options;


/**
 * If we want to add more hotel options, we can simply create more options class that extends this HotelOptions class.
 */
public abstract class HotelOptions extends Options {

    private final Hotel hotel;

    public HotelOptions(String option, String optionMessage,Hotel hotel) {
        super(option, optionMessage);
        this.hotel = hotel;
    }

    public Hotel getHotel() {
        return hotel;
    }
}
