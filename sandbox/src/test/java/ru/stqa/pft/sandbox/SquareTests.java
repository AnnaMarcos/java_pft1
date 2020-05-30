package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SquareTests {

  @Test // Should mark that this is a test
  public void testArea() {
    Square s = new Square(5);
    //assert s.area() == 24;//assert is a Java keyword used to define an assert statement
                    // == operator used to compare objects to check equality
    Assert.assertEquals(s.area(), 25);// function showing the diff between expected and actual results
  }
}
