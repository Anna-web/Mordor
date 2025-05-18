package orcFactories;

import gear.MordorGearFactory;
import units.Orc;
import units.OrcBuilder;

public class MordorOrcBuilderFactory implements OrcBuilderFactory{
    MordorGearFactory mgf = new MordorGearFactory();

    @Override
    public Orc createOrcBuilder(String orcClass) {
        String weapon = mgf.createWeapon();
        String armor = mgf.createArmor();
        String banner = mgf.createBanner();

        switch (orcClass){
            case "Scout":
                weapon = "Огненный лук";
                break;
            case "Leader":
                banner = "Знамя Лидера Клана Мордор";
                break;
        }

        OrcBuilder ob = new OrcBuilder("Mordor", weapon, armor, banner, orcClass);
        return ob.createOrc();
    }
}
