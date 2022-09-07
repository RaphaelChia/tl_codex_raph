package codex.tl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * ex1 code was designed around the idea of:
 * The application will always remain a hotel application (would not branch out to flight app, restaurant app)
 * The application should be able to have future enhancement for more options
 */
public class App 
{
    public static void main( String[] args ) throws IOException {

        Hotel myHotel = new Hotel();
        HotelCliApp hca = new HotelCliApp(myHotel,"Welcome to THE hotel!");
        hca.run();
    }
}
