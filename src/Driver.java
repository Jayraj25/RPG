import numbergenerator.PredictableRandomGenerator;
import numbergenerator.RandomGenerator;
import numbergenerator.UnknownRandomGenerator;
import player.Player;
import weapon.SwordTypes;
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
    RandomGenerator rg1 = new UnknownRandomGenerator();
    RandomGenerator rg2 = new PredictableRandomGenerator();
    WeaponFactory wf = new WeaponFactory();
    Weapon f = wf.createWeapon("Flails", null);
    System.out.println(f.getWeaponDamage(rg1));
    Weapon s = wf.createWeapon("Swords", SwordTypes.BROAD_SWORDS);
    System.out.println(s.getWeaponDamage(rg1));

    Player p1 = new Player(1,rg1);
    p1.setProperties();
    System.out.println(p1.toString());
  }
}
