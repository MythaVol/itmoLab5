package Commands;

import Collection.CollectionManager;

public class AddIfMaxCommand implements Command{
    private CollectionManager cm;
    public AddIfMaxCommand(CollectionManager cm){
        this.cm = cm;
    }
    @Override
    public void execute() {

    }

    @Override
    public boolean isParametrized() {
        return false;
    }
}
