package ru.stqa.pft.sandbox;

/**
 * Created by Nechepurenko on 11.04.2017.
 *
 * Класс описывающий структуру объектов хранящих информацю(атрибуты) о Прямоугольниках.
 */
public class Rectangle {
  //Необходимо описать атрибуты которыми обладает объект этого типа

  public double a;//Одна сторона
  public double b;//Вторая сторона

  public Rectangle(double a, double b) {
    //Значение первого атрибута равно значению первого параметра
    this.a = a;
    //Значение второго атрибута равно значению второго параметра
    this.b = b;
  }

  public double area() {
    return this.a * this.b;
  }

}
