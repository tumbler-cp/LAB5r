package commands;

import terminal.Terminal;

import java.util.concurrent.atomic.AtomicBoolean;

public class Help extends Command{
    CommandManager commands;
    public Help(CommandManager commandManager){
        super("help", "вывести справку по доступным командам");
        this.commands = commandManager;
    }

    @Override
    public void execute(AtomicBoolean lever) {
        this.commands.get_map().values().forEach(command -> {
            System.out.println(Terminal.RED + command.getName() + " : " + Terminal.RESET + command.getDescription());
        });
    }
}
