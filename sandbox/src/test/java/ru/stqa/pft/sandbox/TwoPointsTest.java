package ru.stqa.pft.sandbox;

  import org.testng.Assert;
  import org.testng.annotations.Test;

  public class TwoPointsTest {
    @Test
    public void testDistance() {

      Point p1 = new Point(5,5);
      Point p2 = new Point(5,0);
      Assert.assertEquals((p1.distance(p2)), 5);




    }
  }

  class TwoPointsTest2 {
    @Test
    public void testDistance() {

      Point p1 = new Point(9, 3);
      Point p2 = new Point(2, 5);
      Assert.assertEquals((p2.distance(p1)), 11);

    }

  }