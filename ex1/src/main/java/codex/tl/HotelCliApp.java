package codex.tl;

import codex.tl.options.*;
import codex.tl.options.hotelOptions.*;
import codex.tl.utils.InputOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static codex.tl.utils.Constants.errUnrecognizedCommand;

/**
 * The idea of this class is based on the decorator design pattern.
 * We shouldn't be using cliApp, we should be creating our own cliApp and extending from this cliApp.
 * This cliApp serves as a
 */
public class HotelCliApp {
    public BufferedReader reader;
    private String welcomeMessage;
    private Hotel hotel;
    private List<Options> optionsList;
    private static final String EXITCODE="0";

    public HotelCliApp(Hotel hotel,String welcomeMessage){
        this.hotel=hotel;
        this.optionsList = new ArrayList<>();
        this.reader = new BufferedReader(new InputStreamReader(System.in));
        this.welcomeMessage = welcomeMessage;

        optionsList.add(new RequestRoomOption("1","Request for a room",hotel));
        optionsList.add(new CheckoutOption("2","Checkout a room",hotel));
        optionsList.add(new CleanRoomOption("3","Clean a room",hotel));
        optionsList.add(new OutOfServiceOption("4","Mark a room for repair",hotel));
        optionsList.add(new RepairOption("5","Repair a room",hotel));
        optionsList.add(new listRoomOption("6","List Available rooms",hotel));
        optionsList.add(new listVacantRoomOption("7","List vacant rooms",hotel));
    }

    private void printWelcomeMessage(){
        System.out.println(welcomeMessage);
    }

    private void printCommandPromptMessage(){
        System.out.printf("%nPlease pick an option:%n");
        System.out.printf("%s) Exit%n",EXITCODE);
        for(Options o:optionsList){
           o.displayMessage();
        }
    }

    public void run() throws IOException {
        String command = "";
        InputOutput.clearScreen();
        printWelcomeMessage();
        do{
            boolean commandRecognized = false;
            printCommandPromptMessage();
            command = reader.readLine();
            if(command.equals(EXITCODE)){
                System.out.println("Goodbye!");
               break;
            }
            // Matching the commands
            for(Options o:optionsList){
                if(o.isMatch(command)) {
                    o.doAction();
                    commandRecognized=true;
                }
            }
            if(!commandRecognized)System.out.println(errUnrecognizedCommand);
        }while(true);
    }

    @Override
    protected void finalize() throws IOException {
        this.reader.close();
    }
}
