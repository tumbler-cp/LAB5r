package commClasses;

import java.io.FileNotFoundException;

public abstract class Command {
    private String name;
    private String description;
    private String args = "";
    public Command(){}
    public Command(String NAME, String DESCRIPTION){
        this.name = NAME;
        this.description = DESCRIPTION;
    }
    public Command(String NAME, String DESCRIPTION, String ARGS){
        this(NAME, DESCRIPTION);
        this.args = ARGS;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }

    public String getArgs() {
        return args;
    }

    public void execute() {}
}
