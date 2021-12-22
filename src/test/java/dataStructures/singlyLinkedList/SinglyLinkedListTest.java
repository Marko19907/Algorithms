package dataStructures.singlyLinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SinglyLinkedListTest {

  @Test
  @DisplayName("Test adding to the front of the list")
  public void testAddingToFront() {
    // Arrange
    SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
    list.add(0);
    list.add(1);
    list.add(2);

    // Act
    list.addFirst(42);

    // Assert
    assertEquals(42, list.get(0).getData());
    assertEquals(4, list.size());
  }

  @Test
  @DisplayName("Test adding to the back of the list")
  public void testAddingToBack() {
    // Arrange
    SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
    list.add(0);
    list.add(1);
    list.add(2);

    // Act
    list.addLast(42);

    // Assert
    assertEquals(42, list.get(3).getData());
    assertEquals(4, list.size());
  }

  @Test
  @DisplayName("Test inserting into the list")
  public void testInserting() {
    // Arrange
    SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
    list.add(0);
    list.add(1);
    list.add(2);

    // Act
    list.insert(1, 42);

    // Assert
    assertEquals(42, list.get(1).getData());
    assertEquals(4, list.size());
  }

  @Test
  @DisplayName("Test inserting to the front of the list")
  public void testInsertingToFront() {
    // Arrange
    SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
    list.add(0);
    list.add(1);
    list.add(2);

    // Act
    list.insert(0, 42);

    // Assert
    assertEquals(42, list.get(0).getData());
    assertEquals(4, list.size());
  }

  @Test
  @DisplayName("Test inserting to the back of the list")
  public void testInsertingToBack() {
    // Arrange
    SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
    list.add(0);
    list.add(1);
    list.add(2);

    // Act
    list.insert(2, 42);

    // Assert
    assertEquals(42, list.get(2).getData());
    assertEquals(4, list.size());
  }

  @Test
  @DisplayName("Test inserting into the list beyond it's total length")
  public void testInsertingBeyondLength() {
    // Arrange
    SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
    boolean exceptionThrown = false;
    list.add(0);
    list.add(1);
    list.add(2);

    // Act
    try {
      list.insert(5, 42);
    }
    catch (IndexOutOfBoundsException e) {
      exceptionThrown = true;
    }

    // Assert
    assertTrue(exceptionThrown);
    assertEquals(3, list.size());
  }

  @Test
  @DisplayName("Test finding a negative element in the list")
  public void testFindingNegativeElement() {
    // Arrange
    SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
    boolean exceptionThrown = false;

    // Act
    try {
      list.get(-2);
    }
    catch (IndexOutOfBoundsException e) {
      exceptionThrown = true;
    }

    // Assert
    assertTrue(exceptionThrown);
  }

  @Test
  @DisplayName("Test setting an element to a given element in the list")
  public void testInsertingSetting() {
    // Arrange
    SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
    list.add(0);
    list.add(1);
    list.add(2);

    // Act
    list.set(1, 42);

    // Assert
    assertEquals(42, list.get(1).getData());
    assertEquals(3, list.size());
  }

  @Test
  @DisplayName("Test setting an element to the front of a list")
  public void testInsertingSettingAtFront() {
    // Arrange
    SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
    list.add(0);
    list.add(1);
    list.add(2);

    // Act
    list.set(0, 42);

    // Assert
    assertEquals(42, list.get(0).getData());
    assertEquals(3, list.size());
  }

  @Test
  @DisplayName("Test setting an element to the end of a list")
  public void testInsertingSettingAtBack() {
    // Arrange
    SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
    list.add(0);
    list.add(1);
    list.add(2);

    // Act
    list.set(2, 42);

    // Assert
    assertEquals(42, list.get(2).getData());
    assertEquals(3, list.size());
  }

  @Test
  @DisplayName("Test setting an element beyond the length of a list")
  public void testInsertingSettingBeyondLength() {
    // Arrange
    SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
    boolean exceptionThrown = false;
    list.add(0);
    list.add(1);
    list.add(2);

    // Act
    try {
      list.set(5, 42);
    }
    catch (IndexOutOfBoundsException e) {
      exceptionThrown = true;
    }

    // Assert
    assertTrue(exceptionThrown);
    assertEquals(3, list.size());
  }

  @Test
  @DisplayName("Test finding the last element in the list")
  public void testFindingLastElement() {
    // Arrange
    SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

    // Act
    list.add(0);
    list.add(1);
    list.add(2);

    // Assert
    assertEquals(2, list.get(2).getData());
    assertEquals(3, list.size());
  }

  @Test
  @DisplayName("Test clearing the list")
  public void testClearing() {
    // Arrange
    SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
    list.add(0);
    list.add(1);
    list.add(2);
    assertFalse(list.isEmpty());

    // Act
    list.clear();

    // Assert
    assertEquals(0, list.size());
    assertTrue(list.isEmpty());
  }

  @Test
  @DisplayName("Test empty list detection")
  public void testEmptyListDetection() {
    // Arrange
    SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
    assertTrue(list.isEmpty());

    // Act
    list.add(0);
    list.add(1);
    list.add(2);

    // Assert
    assertEquals(3, list.size());
    assertFalse(list.isEmpty());
  }
}