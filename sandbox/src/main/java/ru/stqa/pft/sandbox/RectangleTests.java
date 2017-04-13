package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Nechepurenko on 13.04.2017.
 */
public class RectangleTests {
  @Test
  public void area(){

    Rectangle r = new Rectangle(4, 6);
    Assert.assertEquals(r.area(), 24.0);
  }
}
