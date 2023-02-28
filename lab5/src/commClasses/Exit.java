package commClasses;

public class Exit extends Command{
    public Exit(){
        super("exit", "завершить программу (без сохранения в файл)");
    }

    @Override
    public void execute() {
        System.exit(0);
    }
}
