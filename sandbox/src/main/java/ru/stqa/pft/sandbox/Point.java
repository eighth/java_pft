package ru.stqa.pft.sandbox;

/**
 * Created by Nechepurenko on 12.04.2017.
 */

public class Point {
  public double x;
  public double y;

  public Point(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public double distance(Point p2) {
    return Math.sqrt(Math.pow(p2.x - this.x, 2) + (Math.pow(p2.y - this.y, 2)));
  }
  /**
   * Даже если я меняю метода:
   * public double distance() {
   * внутри указываю Math.sqrt(Math.pow(this.x - this.x, 2) + (Math.pow(this.y - this.y, 2)));
   * И в main указываю:
   * Point p1 = new Point(10, 2);
   * Point p2 = new Point(4, 12);
   *
   * Всеравно не догоняю как можно передать p1.distance() и p2.distance(). А т.к. создан конструктор,
   * то я не могу просто создать объект, назвать его Point p и передавать его p.distance();
   *
   * System.out.println("Расстояния между двумя точками = " + distance());
   *
   * Полюбому где-то я тууплю...
   *
   */

}