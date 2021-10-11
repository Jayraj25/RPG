import org.junit.Before;
import org.junit.Test;

import numbergenerator.GenerateRandomNumber;
import player.Player;

import static org.junit.Assert.assertEquals;

public class PlayerTest {

  GenerateRandomNumber g = new GenerateRandomNumber(7);
  Player p = new Player(3,g);

  @Before
  public void setUp() {
    p.setProperties();
  }

  @Test
  public void getPlayerID() {
    assertEquals(3,p.getPlayerID());
  }

  @Test
  public void getStrength() {
    assertEquals(14,p.getStrength());
  }

  @Test
  public void getConstitution() {
    assertEquals(11,p.getConstitution());
  }

  @Test
  public void getDexterity() {
    assertEquals(13,p.getDexterity());
  }

  @Test
  public void getCharisma() {
    assertEquals(16,p.getCharisma());
  }

  @Test
  public void testToString() {
    assertEquals("(Strength: 14, Constitution: 11, Dexterity: 13, Charisma: 16)",
            p.toString());
  }
}