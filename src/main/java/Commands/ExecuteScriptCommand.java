package Commands;

import Collection.CollectionManager;
import CommandControl.CommandController;
import CommandControl.CommandExecutor;
import CommandControl.ConsoleMessage;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ExecuteScriptCommand implements CommandWithParametr{
    private CollectionManager collectionManager;
    private static ArrayList<String> scriptNames = new ArrayList<>();
    private String parameter;

    public ExecuteScriptCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public void execute() {
        File file = new File(parameter);
        ExecuteScriptCommand.getScriptNames().add(parameter);
        try {
            CommandController commandController = new CommandController(collectionManager, new FileInputStream(file)) {
                @Override
                public void run() {
                    try {
                        Scanner scanner = new Scanner(file);
                        CommandExecutor commandExecutor = new CommandExecutor();
                        while (true) {
                            ConsoleMessage.message("Введите команду:");
                            String command = scanner.nextLine();
                            ConsoleMessage.message(command);
                            if (command.equals("exit")) {
                                break;
                            } else {
                                String[] s = command.split(" ");
                                if (s.length == 1) {
                                    try {
                                        commandExecutor.executeCommand(getCommands().get(s[0]));
                                    } catch (Exception e) {
                                        ConsoleMessage.message("Команда введена неверно");
                                    }
                                } else if (s.length == 2) {
                                    if (getCommands().get(s[0]).isParametrized()) {
                                        if (s[0].equals("execute_script")) {
                                            if(ExecuteScriptCommand.getScriptNames().contains(s[1])) {
                                                ConsoleMessage.message("Нельзя запускать уже запущенные файлы");
                                                continue;
                                            }
                                            ExecuteScriptCommand.getScriptNames().add(s[1]);
                                        }
                                        try {
                                            commandExecutor.executeCommandWithParameter((CommandWithParametr) getCommands().get(s[0]), s[1]);
                                        } catch (Exception e) {
                                            ConsoleMessage.message("Команда введена неверно");
                                        }
                                    } else ConsoleMessage.message("У этой команды нет аргументов");
                                } else ConsoleMessage.message("Команда введена неверно");
                            }

                        }
                    } catch (FileNotFoundException e) {
                        ConsoleMessage.message("File not found");
                    }
                }
            };

            commandController.run();

        }catch (Exception e){
            ConsoleMessage.message("File not found");
        }
        scriptNames.clear();
    }

    public static ArrayList<String> getScriptNames() {
        return scriptNames;
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
