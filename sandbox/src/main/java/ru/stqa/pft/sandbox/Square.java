package ru.stqa.pft.sandbox;

public class Square {

  public double l; // class description

  //public Square (double len) { //creating a constructor for calculating the sq.area
    //l = len;
   // this.l = len;
  public Square (double l)  {// rename 'len' to 'l'
    this.l = l; // THIS is a reference variable in Java that refers to the current object.
  }

  //public static double area (Square s )  {//transferred function  //step 6
    //return s.l * s.l;

  public double area ( )  { //Turned a previous function into a method
    return this.l * this.l;
  }
}

