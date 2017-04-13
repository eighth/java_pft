package ru.stqa.pft.sandbox;

public class MyFirstProgram {
  public static void main(String[] args) {
    hello("world");
    hello("user");
    hello("Igor");

    //Создаем объект типа квадрат
    Square s = new Square(5);
    System.out.println("Площадь квадрата со стороной " + s.l + " = " + s.area());

    Rectangle r = new Rectangle(4, 6);
    System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + " = " + r.area());

    //Создаем объект типа Point
    Point p1 = new Point(10, 2);
    Point p2 = new Point(4, 12);
    System.out.println("Расстояния между двумя точками = " + p1.distance(p2));

  }

  public static void hello(String somebody) {
    System.out.println("Hello, " + somebody + "!!!");
  }
}