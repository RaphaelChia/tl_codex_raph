package codex.tl;

import codex.tl.hotelOptions.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

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

        optionsList.add(new RequestRoomOption("1","Request for a room"));
        optionsList.add(new CheckoutOption("2","Checkout a room"));
        optionsList.add(new CleanRoomOption("3","Clean a room"));
        optionsList.add(new OutOfServiceOption("4","Mark a room for repair"));
        optionsList.add(new RepairOption("5","Repair a room"));
        optionsList.add(new listRoomOption("6","List available rooms"));
    }

    private void printWelcomeMessage(){
        System.out.println(welcomeMessage);
    }

    private void printCommandPromptMessage(){
        for(Options o:optionsList){
           o.displayMessage();
        }
    }

    public void run() throws IOException {
        String command = "";
        printWelcomeMessage();

        do{
            printCommandPromptMessage();
            command = reader.readLine();
            // Matching the commands
            for(Options o:optionsList){
                if(o.isMatch(command)) {
                    o.doAction(hotel);
                }
            }
        }while(!command.equals(EXITCODE));

//        do{
//            try {
//                printCommandPromptMessage();
//                command = reader.readLine();
//                if(command.equals("0")) break;
//                switch (command){
//                    case "1":
//                        break;
//                    case "2":
//                        break;
//                    case "3":
//                        break;
//                    case "4":
//                        break;
//                    case "9":
//                        hotel.listAvailableRooms();
//                        break;
//                    default:
//                        System.out.println(errUnrecognizedCommand);
//                }
//            } catch (IOException e) {
//                System.out.println(errUnrecognizedCommand);
//            }
//        }while(true);
    }

    @Override
    protected void finalize() throws IOException {
        this.reader.close();
    }
}
