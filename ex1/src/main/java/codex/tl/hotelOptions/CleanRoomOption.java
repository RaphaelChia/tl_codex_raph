package codex.tl.hotelOptions;

import codex.tl.Hotel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CleanRoomOption  extends Options {
    public CleanRoomOption(String option, String optionMessage) {
        super(option, optionMessage);
    }

    @Override
    public void doAction(Hotel h) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String room;
        try {
            room = reader.readLine();
        } catch (IOException e) {
            System.out.println("Didn't manage to clean the room. Please try again.");
            try {
                reader.close();
            } catch (IOException ignored) {

            }
            return;
        }
        h.cleanRoom(room);
    }
}
