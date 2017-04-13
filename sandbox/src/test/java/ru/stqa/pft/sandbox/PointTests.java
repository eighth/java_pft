package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Nechepurenko on 13.04.2017.
 */
public class PointTests {

  @Test
  public void testDistance(){
    Point p1 = new Point(10, 2);
    Point p2 = new Point(4, 12);
    Assert.assertEquals(p1.distance(p2), 11.661903789690601);
  }
  @Test
  public void testDistance2(){
    Point p1 = new Point(1024, 764);
    Point p2 = new Point(1280, 1024);
    Assert.assertEquals(p1.distance(p2), 364.87806182339875);
  }
}
