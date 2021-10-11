import gear.Gear;
import gear.GearFactory;
import numbergenerator.GenerateRandomNumber;
import player.Player;
import weapon.Weapon;
import weapon.WeaponFactory;

/**
 * Driver class to run the program.
 * */
public class Driver {
  /**
   * The main method for driver class.
   * @param args Command line arguments*/
  public static void main(String[] args) {

    GenerateRandomNumber r = new GenerateRandomNumber();

    WeaponFactory wf = new WeaponFactory();
    Weapon f = wf.createWeapon("Flail");
    System.out.println(f.getWeaponDamage(r));
    Weapon s = wf.createWeapon("Broad Sword");
    System.out.println(s.getWeaponDamage(r));

    Player p1 = new Player(1,r);
    p1.setProperties();
    System.out.println(p1);

    GearFactory gf = new GearFactory();
    Gear hg = gf.createGears("headgear");
    hg.mountGear(p1);
    System.out.println(p1);

    Gear belt = gf.createGears("belts");
    belt.mountGear(p1);
    System.out.println(p1);

    Gear potion = gf.createGears("Potion");
    potion.mountGear(p1);
    System.out.println(p1);
  }
}
