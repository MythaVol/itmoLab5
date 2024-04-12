import Collection.CollectionManager;
import CommandControl.CommandController;

public class Main {
    public static void main(String[] args){
        CollectionManager cm = new CollectionManager();
        CommandController commandController = new CommandController(cm, System.in);
        commandController.run();
    }
}