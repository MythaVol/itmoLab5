package Commands;

import Collection.CollectionManager;
import MusicBands.MusicBand;

public class FilterStartsWithNameCommand implements CommandWithParametr{
    private String parameter;
    private CollectionManager collectionManager;

    public FilterStartsWithNameCommand(CollectionManager cm){
        collectionManager = cm;
    }
    @Override
    public void execute() {
        for(MusicBand musicBand: collectionManager.getMusicBands()){
            if(musicBand.getName().startsWith(parameter)){
                System.out.println(musicBand);
            }
        }
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
