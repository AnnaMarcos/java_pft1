package ru.stqa.pft.sandbox;

public class Rectangle {
  public double a;// class description
  public double b;// class description

  public Rectangle (double a, double b) {

    this.a = a;
    this.b = b;
  }

  //public static double area (Rectangle r ) {//Turning a function into a method
    //return r.a * r.b;
  public double area () { //Turned a previous function into a method
    return  this.a * this.b;
  }
}
