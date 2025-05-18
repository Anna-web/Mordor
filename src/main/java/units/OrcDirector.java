package units;

import orcFactories.DolGuldurOrcBuilderFactory;
import orcFactories.GreyMountainsOrcBuilderFactory;
import orcFactories.MistyMountainsOrcBuilderFactory;
import orcFactories.MordorOrcBuilderFactory;


public class OrcDirector {
    MordorOrcBuilderFactory mobf = new MordorOrcBuilderFactory();
    DolGuldurOrcBuilderFactory dbobf = new DolGuldurOrcBuilderFactory();
    MistyMountainsOrcBuilderFactory mmobf = new MistyMountainsOrcBuilderFactory();
    GreyMountainsOrcBuilderFactory gmobf = new GreyMountainsOrcBuilderFactory();

    public Orc createBasicOrk(String tribes, String orcClass){
        return switch (tribes) {
            case "Mordor" -> mobf.createOrcBuilder(orcClass);
            case "Dol Guldur" -> dbobf.createOrcBuilder(orcClass);
            case "Misty Mountains" -> mmobf.createOrcBuilder(orcClass);
            case "Grey Mountains" -> gmobf.createOrcBuilder(orcClass);
            default -> null;
        };
    }

}
