import java.util.List;

import battleground.BagOfEquipments;
import gear.BeltTypes;
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
   * @param args Command line arguments
   * */
  public static void main(String[] args) throws IllegalAccessException {

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
    Gear hg = gf.createGears("HG1","headgear");
    hg.mountGear(p1);
    System.out.println(p1);

    Gear belt = gf.createGears("B1","belt");
    belt.mountGear(p1);
    System.out.println(p1);

    Gear potion = gf.createGears("P1","Potion");
    potion.mountGear(p1);
    System.out.println(potion.toString());
    System.out.println(p1);

    BagOfEquipments bag = new BagOfEquipments();
    List<Gear> equipments = bag.getEquipments();
    System.out.println(bag.toString());
    Gear x = equipments.get(16);
//    System.out.println(x.getBeltType());
  }
}
