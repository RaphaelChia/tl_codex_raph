package codex.tl;

import codex.tl.entity.options.hotelOptions.*;
import codex.tl.utils.InputOutput;

import java.io.IOException;

/**
 * ex1 code was designed around the idea that:
 * This application have the possibility to expand further, into maybe an airplane booking application.
 * This application should be able to easily have future enhancement for more options to be added to the menu
 */
public class App 
{
    public static void main( String[] args ) throws IOException {

        Hotel hotel = new Hotel();
        CliApp cliApp = new CliApp("Welcome to Tele-Comfy hotel!");
        cliApp
            .addOptionToList(new RequestRoomOption("1","Request for a room",hotel))
            .addOptionToList(new CheckoutOption("2","Checkout a room",hotel))
            .addOptionToList(new CleanRoomOption("3","Clean a room",hotel))
            .addOptionToList(new OutOfServiceOption("4","Mark a room for repair",hotel))
            .addOptionToList(new RepairOption("5","Repair a room",hotel))
            .addOptionToList(new ListRoomOption("6","List Available rooms",hotel))
            .addOptionToList(new ListVacantRoomOption("7","List Vacant rooms",hotel))
            .run();
        InputOutput.getInstance().closeResources();
    }
}
