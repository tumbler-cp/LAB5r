package commClasses;

public abstract class Command {
    private String name;
    private String description;
    public Command(){}
    public Command(String NAME, String DESCRIPTION){
        this.name = NAME;
        this.description = DESCRIPTION;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public void execute(){}
}
