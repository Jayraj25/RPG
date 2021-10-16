import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import battleground.Bag;
import battleground.BagOfEquipments;
import gear.Gear;

import static org.junit.Assert.assertEquals;

/**
 * Tests regarding the validation of values passed when creating a bag of equipments
 * and also test if the bag is created correctly.
 */
public class BagOfEquipmentsTest {

  Bag bag;

  @Test
  public void testBagCreation() {
    assertEquals("Bag created successfully", new BagOfEquipments(
            7,7,20,20).toString());
  }

  @Test (expected = IllegalArgumentException.class)
  public void testMinHeadGearLessThan5() {
    new BagOfEquipments(2,5,5,5);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testMinFootwearLessThan5() {
    new BagOfEquipments(7,3,5,5);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testMinBeltsLessThan15() {
    new BagOfEquipments(6,8,5,5);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testMinPotionsLessThan15() {
    new BagOfEquipments(6,8,25,5);
  }

  @Test
  public void getEquipments() {
    bag = new BagOfEquipments(7,7,23,23);
    List<Gear> temp = bag.getEquipments();
    List<String> actual = new ArrayList<>();
    for (Gear s : temp) {
      actual.add(s.getName());
    }
    List<String> expected = new ArrayList<>() {
      {
        add("Head Gear1");add("Head Gear2");add("Head Gear3");add("Head Gear4");add("Head Gear5");
        add("Head Gear6");add("Head Gear7");add("Footwear 1");add("Footwear 2");add("Footwear 3");
        add("Footwear 4");add("Footwear 5");add("Footwear 6");add("Footwear 7");add("Belt 1");
        add("Belt 2");add("Belt 3");add("Belt 4");add("Belt 5");add("Belt 6");add("Belt 7");
        add("Belt 8");add("Belt 9");add("Belt 10");add("Belt 11");add("Belt 12");add("Belt 13");
        add("Belt 14");add("Belt 15");add("Belt 16");add("Belt 17");add("Belt 18");add("Belt 19");
        add("Belt 20");add("Belt 21");add("Belt 22");add("Belt 23");add("Potion 1");
        add("Potion 2");add("Potion 3");add("Potion 4");add("Potion 5");add("Potion 6");
        add("Potion 7");add("Potion 8");add("Potion 9");add("Potion 10");add("Potion 11");
        add("Potion 12");add("Potion 13");add("Potion 14");add("Potion 15");add("Potion 16");
        add("Potion 17");add("Potion 18");add("Potion 19");add("Potion 20");add("Potion 21");
        add("Potion 22");add("Potion 23");
      }
    };
    assertEquals(expected,actual);
  }

  @Test
  public void testToString() {
  }
}