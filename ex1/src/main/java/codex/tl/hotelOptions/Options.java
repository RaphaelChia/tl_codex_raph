package codex.tl.hotelOptions;

import codex.tl.Hotel;

public abstract class Options {
    private String option;
    private String optionMessage;

    public Options(String option,String optionMessage){
        this.option=option;
        this.optionMessage =optionMessage;
    }

    public void displayMessage(){
        System.out.printf("%s) %s%n",option,optionMessage);
    }

    public boolean isMatch(String opt){
        return option.equals(opt);
    }

    public abstract void doAction(Hotel h);
}
