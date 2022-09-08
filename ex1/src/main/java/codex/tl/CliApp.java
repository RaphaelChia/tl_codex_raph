package codex.tl;

import codex.tl.entity.options.Options;
import codex.tl.entity.options.hotelOptions.*;
import codex.tl.utils.InputOutput;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static codex.tl.utils.Constants.errUnrecognizedCommand;

/**
 * This app is the main component of the infinite loop menu option based CLI
 * To use this class, call the constructor with a welcomeMessage.
 * To reuse this class for other apps, simply use the 'new' keyword to create a CliApp class,
 * and start populating the options list with AddOptionToList(), then call the run().
 */
public class CliApp {
    private final String welcomeMessage;
    private final List<HotelOptions> optionsList;
    private final String EXITCODE="0";

    public CliApp(String welcomeMessage){
        this.optionsList = new ArrayList<>();
        this.welcomeMessage = welcomeMessage;
    }

    public CliApp addOptionToList(HotelOptions opt){
        this.optionsList.add(opt);
        return this;
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
        String command;
        InputOutput.clearScreen();
        printWelcomeMessage();
        do{
            boolean commandRecognized = false;
            printCommandPromptMessage();
            command = InputOutput.getInstance().readSingleLine();

            //Kill switch
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


}
