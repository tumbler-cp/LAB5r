package commClasses;

import terminal.Terminal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class ExecuteScript extends Command {
    Terminal terminal;
    private String filename;
    private FileReader file;
    private Scanner input;
    private List<String> workingFiles;

    public ExecuteScript(Terminal TERMINAL){
        super("execute_script", "считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.", "file_name");
        this.terminal = TERMINAL;
    }

    public void setFilename(String filename)  throws FileNotFoundException {
        this.file = new FileReader(filename);
        this.input = new Scanner(file);
        this.filename = filename;
    }

    @Override
    public void execute() {
        String line;
        while (input.hasNextLine()){
            line = input.nextLine();
            String comm = line.split(" ")[0];
            var splitting = line.split(" ");
            final int argSize = splitting.length - 1;
            String[] arguments = new String[argSize];
            for (int i =0;i<argSize;i++){
                arguments[i] = splitting[i+1];
            }
            if (Objects.equals(comm, "execute_script")){
                var i = new ExecuteScript(terminal);
                try {
                    i.setFilename(arguments[0]);
                } catch (FileNotFoundException f){
                    System.out.println("Файла " + arguments[0] + " нет");
                }
                i.execute();
            }
            else terminal.executeCommand(comm, arguments);
        }
    }
}
