package units;
import com.github.javafaker.Faker;

public class OrcBuilder {
    private String tribes;
    private String name;
    private String weapon;
    private String armor;
    private String banner;
    private String orcClass;

    Faker faker = new Faker();

    public OrcBuilder(String tribes, String weapon, String armor, String banner, String orcClass) {
        this.tribes = tribes;
        this.name = faker.ancient().god().substring(0, 3) +
                faker.ancient().hero().substring(0, 2);
        this.weapon = weapon;
        this.armor = armor;
        this.banner = banner;
        this.orcClass = orcClass;
    }

    public Orc createOrc(){
        int hp;
        int intel;
        int agi;
        int str;
        switch (this.tribes) {
            case "Mordor":
                hp = faker.number().numberBetween(50, 201);
                intel = faker.number().numberBetween(1, 21);
                agi = faker.number().numberBetween(1, 35);
                str = (int) (faker.number().numberBetween(1, 101)*1.3);
                break;
            case "Dol Guldur":
                hp = faker.number().numberBetween(80, 141);
                intel = faker.number().numberBetween(10, 16);
                agi = faker.number().numberBetween(8, 24);
                str = faker.number().numberBetween(30, 61);
                break;
            case "Misty Mountains":
                hp = faker.number().numberBetween(50, 201);
                intel = faker.number().numberBetween(1, 11);
                agi = (int) (faker.number().numberBetween(1, 101)*1.3);
                str = faker.number().numberBetween(1, 101);
                break;
            case "Grey Mountains":
                hp = faker.number().numberBetween(50, 101);
                intel = faker.number().numberBetween(1, 11);
                agi = faker.number().numberBetween(1, 26);
                str = faker.number().numberBetween(1, 56);
                break;
            default:
                hp = faker.number().numberBetween(50, 201);
                intel = faker.number().numberBetween(1, 51);
                agi = faker.number().numberBetween(1, 101);
                str = faker.number().numberBetween(1, 101);
        }

        Orc newOrc = new Orc(name, hp, intel, agi, str, this.weapon, this.armor, this.banner, this.orcClass, this.tribes);
        return newOrc;
    }
}
