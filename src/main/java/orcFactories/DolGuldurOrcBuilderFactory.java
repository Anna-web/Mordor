package orcFactories;

import gear.DolGuldurGearFactory;
import units.Orc;
import units.OrcBuilder;

public class DolGuldurOrcBuilderFactory implements OrcBuilderFactory{
    DolGuldurGearFactory dggf = new DolGuldurGearFactory();

    @Override
    public Orc createOrcBuilder(String orcClass) {
        String weapon = dggf.createWeapon();
        String armor = dggf.createArmor();
        String banner = dggf.createBanner();

        switch (orcClass){
            case "Scout":
                weapon = "Огненный лук";
                break;
            case "Leader":
                banner = "Знамя Лидера Клана Дол Гулдур";
                break;
        }

        OrcBuilder ob = new OrcBuilder("Dol Guldur", weapon, armor, banner, orcClass);
        return ob.createOrc();
    }
}
