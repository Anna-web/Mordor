package gear;

public class GreyMountainsGearFactory implements OrcGearFactory{
    @Override
    public String createWeapon() {
        return "Лук";
    }

    @Override
    public String createArmor() {
        return "Тряпичная броня";
    }

    @Override
    public String createBanner() {
        return "Знамя с убегающим орком";
    }
}
