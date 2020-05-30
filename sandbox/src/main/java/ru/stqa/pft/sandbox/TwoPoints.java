package ru.stqa.pft.sandbox;

public class TwoPoints {
  //Homework//

      public static void main(String[] args) {

        Point p1 = new Point(5,5);// first point
        Point p2 = new Point(5,0);// second point
        System.out.println("Distance between two points: " + "P1 " + " = " + p1.distance(p2));
        System.out.println("Distance between two points: " + "P2 " + " = " + p2.distance(p1));
    }

  }

  class Point{ // this class represents a location in a two-dimensional (x, y) coordinate space.
    double x; //variables
    double y; //variables

    public Point(double x1, double y1) {
      this.x = x1; //"this" is a reference to the current object, whose method is being called upon.
      this.y = y1;
    }

    public double distance(Point p2){
      return Math.sqrt((p2.x - this.x) * (p2.x - this.x) + (p2.y - this.y) * (p2.y - this.y)); // instead of  this long function*(p2.x - this.x) * (p2.x - this.x)*
      // we can use .....(Math.pow(p2.x - this.x,2)......
    }

  }
