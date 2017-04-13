package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Nechepurenko on 13.04.2017.
 * Тесты это методы в этом классе.
 */
public class SquareTests {
  @Test
  public void testArea(){
    Square s = new Square(5);
    Assert.assertEquals(s.area(),25.0);
  }
}
