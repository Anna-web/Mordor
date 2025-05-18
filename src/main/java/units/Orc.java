package units;

public class Orc {
    private String name;
    private String weapon;
    private String armor;
    private String banner;
    
    private String orcClass; 
    private String tribe;

    private int strength;
    private int agility;
    private int intelligence;
    private int health;

    public Orc(String name, int health, int intelligence, int agility, int strength, String weapon, String armor, String banner, String orcClass, String tribe) {
        this.name = name;
        this.health = health;
        this.intelligence = intelligence;
        this.agility = agility;
        this.strength = strength;
        this.weapon = weapon;
        this.armor = armor;
        this.banner = banner;
        this.orcClass = orcClass;
        this.tribe = tribe;
    }

    public String getorcClass() {
        return orcClass;
    }

    public void setorcClass(String orcClass) {
        this.orcClass = orcClass;
    }

    public String getTribe() {
        return tribe;
    }

    public void setTribe(String tribe) {
        this.tribe = tribe;
    }
    

    public String getName() {
        return name;
    }

    public String getWeapon() {
        return weapon;
    }

    public String getArmor() {
        return armor;
    }

    public String getBanner() {
        return banner;
    }

    public int getStrength() {
        return strength;
    }

    public int getAgility() {
        return agility;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getHealth() { return health; }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public void setArmor(String armor) {
        this.armor = armor;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public String toString() {
        return name;
    }
    

}