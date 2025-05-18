package orcFactories;

import gear.GreyMountainsGearFactory;
import units.Orc;
import units.OrcBuilder;

public class GreyMountainsOrcBuilderFactory implements OrcBuilderFactory{
    GreyMountainsGearFactory gmgf = new GreyMountainsGearFactory();

    @Override
    public Orc createOrcBuilder(String orcClass) {
        String weapon = gmgf.createWeapon();
        String armor = gmgf.createArmor();
        String banner = gmgf.createBanner();

        switch (orcClass){
            case "Scout":
                weapon = "Огненный лук";
                break;
            case "Leader":
                banner = "Знамя Лидера Клана Серые Горы";
                break;
        }

        OrcBuilder ob = new OrcBuilder("Grey Mountains", weapon, armor, banner, orcClass);
        return ob.createOrc();
    }
}
