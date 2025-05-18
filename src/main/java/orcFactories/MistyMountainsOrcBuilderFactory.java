package orcFactories;

import gear.MistyMountainsGearFactory;
import units.Orc;
import units.OrcBuilder;

public class MistyMountainsOrcBuilderFactory implements OrcBuilderFactory{
    MistyMountainsGearFactory mmgf = new MistyMountainsGearFactory();

    @Override
    public Orc createOrcBuilder(String orcClass) {
        String weapon = mmgf.createWeapon();
        String armor = mmgf.createArmor();
        String banner = mmgf.createBanner();

        switch (orcClass){
            case "Scout":
                weapon = "Огенный лук";
                break;
            case "Leader":
                banner = "Знамя Лидера Клана Мглистые горы";
                break;
        }

        OrcBuilder ob = new OrcBuilder("Misty Mountains", weapon, armor, banner, orcClass);
        return ob.createOrc();
    }
}
