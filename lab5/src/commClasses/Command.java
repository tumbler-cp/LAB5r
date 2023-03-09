package commClasses;

public abstract class Command {
    protected String name;
    protected String description;
    protected String argsText = "";
    protected String[] args;
    public Command(){}
    public Command(String NAME, String DESCRIPTION){
        this.name = NAME;
        this.description = DESCRIPTION;
    }
    public Command(String NAME, String DESCRIPTION, String ARGS){
        this(NAME, DESCRIPTION);
        this.argsText = ARGS;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }

    public String getArgsText() {
        return argsText;
    }

    public void setArgs(String[] args) {
        this.args = args;
    }

    public void execute() {}
}
