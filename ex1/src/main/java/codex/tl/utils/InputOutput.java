package codex.tl.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * This inputoutput class is based on a Thread-Safe Singleton pattern.
 * Because bufferedReader is always used time and time again, we save some resources
 * by only creating 1 bufferedReader object in the entire lifetime of the applicaton,
 * and destroying it when is being deconstructed.
 */

public class InputOutput {
    public static InputOutput instance;
    private final BufferedReader reader;
    private InputOutput(BufferedReader reader){
        this.reader = reader;
    }

    public static synchronized InputOutput getInstance(){
        if(instance==null)
            instance = new InputOutput(new BufferedReader(new InputStreamReader(System.in)));
        return instance;
    }

    /**
     * Usage:   To use this function from elsewhere, below shows and example of how it can be done:
     *          String line = InputOutput.getInstance().readSingleLine();
     * @return  a string of user input
     * @throws IOException default built-in IOException
     */
    public String readSingleLine() throws IOException{
        String line;
        line = reader.readLine();
        return line;
    }

    public static void clearScreen(){
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (InterruptedException | IOException ignored) {
        }
    }

    @Override
    protected void finalize() throws IOException {
        if(reader!=null)reader.close();
    }
}
