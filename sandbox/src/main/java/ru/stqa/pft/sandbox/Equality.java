package ru.stqa.pft.sandbox;

/**
 * Created by Nechepurenko on 20.04.2017.
 */
public class Equality {
  public static void main(String[] args) {
    String s1 = "firefox";
    String s2 = "firefox";

    System.out.println(s1 == s2);
    System.out.println(s1.equals(s2));
  }
}
