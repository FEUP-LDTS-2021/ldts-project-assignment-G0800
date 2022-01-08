package modelTest.menuTest;

import com.ldts.donkeykong.model.menu.Menu;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MenuTest {

    Menu menu;

    @BeforeEach
    public void helper() {
        menu = new Menu();
    }

    @Test
    public void constructorTest() {
        Assertions.assertEquals(3,menu.getNumberOfEntries());
        Assertions.assertEquals("Play",menu.getEntry(0));
        Assertions.assertNotEquals("Play",menu.getEntry(1));
        Assertions.assertEquals("Instructions",menu.getEntry(1));
        Assertions.assertEquals("Exit",menu.getEntry(2));
    }

    @Test
    public void nextEntryTest() {
        menu.nextEntry();
        Assertions.assertEquals(1,menu.getCurrentEntry());
        menu.nextEntry();
        Assertions.assertEquals(2,menu.getCurrentEntry());
        menu.nextEntry();
        Assertions.assertEquals(0,menu.getCurrentEntry());
        menu.nextEntry();
        Assertions.assertEquals(1,menu.getCurrentEntry());
    }

    @Test
    public void previousEntryTest() {
        menu.previousEntry();
        Assertions.assertEquals(2,menu.getCurrentEntry());
        menu.previousEntry();
        Assertions.assertEquals(1,menu.getCurrentEntry());
        menu.previousEntry();
        Assertions.assertEquals(0,menu.getCurrentEntry());
        menu.previousEntry();
        Assertions.assertEquals(2,menu.getCurrentEntry());
    }

    @Test
    public void isSelectedTest() {
        Assertions.assertTrue(menu.isSelected(menu.getCurrentEntry()));
        Assertions.assertFalse(menu.isSelected(1));
        menu.nextEntry();
        Assertions.assertTrue(menu.isSelected(menu.getCurrentEntry()));
    }

    @Test
    public void isSelectedStartTest() {
        Assertions.assertTrue(menu.isSelectedStart());
    }

    @Test
    public void isSelectedInstructionsTest() {
        Assertions.assertFalse(menu.isSelectedInstructions());
        menu.nextEntry();
        Assertions.assertTrue(menu.isSelectedInstructions());
    }

    @Test
    public void isSelectedExitTest() {
        Assertions.assertFalse(menu.isSelectedExit());
        menu.nextEntry();
        Assertions.assertFalse(menu.isSelectedExit());
        menu.nextEntry();
        Assertions.assertFalse(menu.isSelectedExit());
    }

    @Test
    public void getNumberOfEntriesTest() {
        Assertions.assertNotEquals(5,menu.getNumberOfEntries());
        Assertions.assertEquals(3,menu.getNumberOfEntries());
    }
}
