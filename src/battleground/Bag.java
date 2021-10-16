package battleground;

import gear.Gear;

import java.util.List;

/**
 * This is used to create a bag of equipments in which one fourth of gears decrease
 * at least one ability and player will pick equipments from it.
 */
public interface Bag {

  /**
   * Get the bag of equipments in which 25% of gears decreases at least one ability of player.
   * @return list of gears.
   * */
  List<Gear> getEquipments();

  @Override
  String toString();
}
