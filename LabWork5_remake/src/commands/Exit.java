package commands;

import java.util.concurrent.atomic.AtomicBoolean;

public class Exit extends Command{
    public Exit(){
        super("exit", "завершить программу (без сохранения в файл)");
    }

    @Override
    public void execute(AtomicBoolean l) {
        l.set(false);
    }
}
