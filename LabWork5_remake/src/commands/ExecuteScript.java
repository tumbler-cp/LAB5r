package commands;

import terminal.Terminal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class ExecuteScript extends Command{
    String scriptfile = "";
    Terminal console;
    public ExecuteScript(Terminal terminal){
        super("execute_script file_name", "считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.");
        console = terminal;
    }

    @Override
    public void execute(AtomicBoolean lever){
        scriptfile = this.getArgs()[0];
        Scanner in = null;
        try {
            in = new Scanner(new FileReader(scriptfile));
        } catch (FileNotFoundException fnf) {System.out.println("Файл не найден: " + scriptfile);}
        String s = "";
        while (in.hasNextLine()) {
            s = in.nextLine();
            console.executor(s.split(" "), lever);
        }
    }
}
