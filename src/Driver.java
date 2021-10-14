import java.util.List;

import battleground.Armory;
import battleground.BagOfEquipments;
import battleground.BattleModel;
import battleground.PlayerModel;
import gear.BeltTypes;
import gear.Gear;
import gear.GearCategory;
import gear.GearFactory;
import numbergenerator.GenerateRandomNumber;
import player.Player;
import weapon.Weapon;
import weapon.WeaponFactory;
import weapon.WeaponTypes;

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
    Weapon f = wf.createWeapon(WeaponTypes.FLAIL);
    System.out.println(f.getWeaponDamage(r));
    Weapon s = wf.createWeapon(WeaponTypes.BROADSWORD);
    System.out.println(s.getWeaponDamage(r));

    Player p1 = new Player(1,r);
    p1.setProperties();
    System.out.println(p1);

    GearFactory gf = new GearFactory();
    Gear hg = gf.createGears("HG1", GearCategory.HEADGEAR);
    hg.mountGear(p1);
    System.out.println(p1);

    Gear belt = gf.createGears("B1",GearCategory.BELT);
    belt.mountGear(p1);
    System.out.println(p1);

    Gear potion = gf.createGears("P1",GearCategory.POTION);
    potion.mountGear(p1);
//    System.out.println(potion.toString());
    System.out.println("For Player 1: " + p1);

    BagOfEquipments bag = new BagOfEquipments();
    List<Gear> equipments = bag.getEquipments();
//    System.out.println(bag.toString());

    p1.equipGears();
    List<Gear> p1Gears = p1.getEquippedGears();
//    System.out.println(p1.getEquippedGears());

    Player p2 = new Player(2,r);
    p2.setProperties();
    System.out.println("For player 2: " + p2);

    p2.equipGears();
    List<Gear> p2Gears = p2.getEquippedGears();

//    for (Gear x : p1Gears) {
//      if (p2Gears.contains(x)) {
//        throw new IllegalAccessError("Not allowed");
//      }
//    }
    Armory a = new Armory();
    List<Weapon> armory = a.generateArmory();
    p1.equipWeapon(armory);
    p2.equipWeapon(armory);
    System.out.println("Player 1 Weapon: " + p1.getWeaponEquippedType());
    System.out.println("Player 2 Weapon: " + p2.getWeaponEquippedType());
    p1.makeChangesInAbilities();
    p2.makeChangesInAbilities();
    System.out.println("Player 1: " + p1.getAbilitiesMap());
    System.out.println("Player 1: " + p1.getUpdatedAbilitiesMap());
    System.out.println("Player 2: " + p2.getAbilitiesMap());
    System.out.println("Player 2: " + p2.getUpdatedAbilitiesMap());

    BattleModel battleModel = new BattleModel(p1,p2);
    battleModel.battle();
    System.out.println("The winner is: P" + battleModel.getWinner().getPlayerID());
//    System.out.println(p2.getEquippedGears());
  }
}
