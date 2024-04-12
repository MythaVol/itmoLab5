package Commands;

import Collection.CollectionManager;
import CommandControl.CommandController;
import CommandControl.CommandExecutor;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ExecuteScriptCommand implements CommandWithParametr{
    private CollectionManager collectionManager;
    private ArrayList<String> scriptNames = new ArrayList<>();
    private String parameter;

    public ExecuteScriptCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute() {
        File file = new File(parameter);
        CommandController commandController = new CommandController(collectionManager){
            @Override
            public void run() {
                try {
                    Scanner scanner = new Scanner(file);
                    CommandExecutor commandExecutor = new CommandExecutor();
                    while (true) {
                        System.out.println("Введите команду:");
                        String command = scanner.nextLine();
                        System.out.println(command);
                        if (command.equals("exit")) {
                            break;
                        } else {
                            String[] s = command.split(" ");
                            if (s.length == 1) {
                                try {
                                    commandExecutor.executeCommand(getCommands().get(s[0]));
                                } catch (Exception e) {
                                    System.out.println("Команда введена неверно");
                                }
                            } else if (s.length == 2) {
                                if (getCommands().get(s[0]).isParametrized()) {
                                    if (s[0].equals("execute_script") && scriptNames.contains(s[1])) {
                                        System.out.println("Нельзя запускать уже запущенные файлы");
                                        continue;
                                    }
                                    try {
                                        commandExecutor.executeCommandWithParameter((CommandWithParametr) getCommands().get(s[0]), s[1]);
                                    } catch (Exception e) {
                                        System.out.println("Команда введена неверно");
                                    }
                                } else System.out.println("У этой команды нет аргументов");
                            } else System.out.println("Команда введена неверно");
                        }

                    }
                }catch (Exception e){
                    System.out.println("File not found");
                }
            }
        };

        commandController.run();

    }

    @Override
    public boolean isParametrized() {
        return true;
    }

    @Override
    public void setParameter(String parameter) {
        this.parameter = parameter;
    }
}
