package commands;

import java.util.concurrent.atomic.AtomicBoolean;

public abstract class Command {
    private String descriptionLeft;
    private String descriptionRight;
    private String[] args = {};
    public Command(){}
    public Command(String Description1, String Description2){
        this.descriptionLeft = Description1;
        this.descriptionRight = Description2;
    }

    public void setArgs(String[] args) {
        this.args = args;
    }

    public String[] getArgs() {
        return args;
    }

    public void execute(AtomicBoolean lever){}

    public String getName() {
        return descriptionLeft;
    }

    public String getDescription() {
        return descriptionRight;
    }
}
