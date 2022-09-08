package codex.tl.options;

/**
 * The Options class is made reusable in the event that we want to branch out to a different app,
 * for e.g. an airplane seat booking app, we can create an AirplaneSeatOptions that extends this
 * class
 */
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

    public abstract void doAction();
}
