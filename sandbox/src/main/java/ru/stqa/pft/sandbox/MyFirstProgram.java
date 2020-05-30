package ru.stqa.pft.sandbox;

public class MyFirstProgram {

    public static void main(String[] args) {
        hello (); // created function
        hello (" world"); //set new value for argument
        hello (" Anna");
        hello (" Students");
        String somebody = "world";// create variable 'somebody'


        System.out.println("Hello , " + somebody + "!"); // use variable 'somebody'

        //int l = 8;
        //int s = l*l;

        //System.out.println("Area of the square with the side of " + l + " = " + s);// int l -l; (l * l ) -s
        //Square s = new Square(); // Creating an object of a given type // step 3
        Square s = new Square(5); // using constructor Sq.area // step 5


        //double l = 5;
        //s.l = 5; // set attribute value // step 4
        // after step 5 we do not have to set attributes separate

        //System.out.println("Square area with side " + l + " = " + area(l));
        //System.out.println("Square area with side " + s.l + " = " + area(s));// transfer a given object to a function // step 4
        System.out.println("Square area with side " + s.l + " = " + s.area()); // Step 7


        Rectangle r = new Rectangle(4 , 6);
        //double a = 4;
        //r.a = 4;
        //double b = 6;
       // r.b = 6;

        //System.out.println("Rectangle area with sides " + a + " and " + b + " = " + area( a ,b ));
        System.out.println("Rectangle area with sides " + r.a + " and " + r.b + " = " + r.area());
    }


    public static void hello()  {//create function which using for duplicated expressions.... help to avoid typing the same code several times
        System.out.println("Hello , world !");

    }
    public static void hello (String somebody) { // created argument or function parameter where we can set any value to 'somebody'
        System.out.println("Hello  ," + somebody + "!");
    }

    //public static double area (double len)  {
    //public static double area (Square s)  { //object creation // step 1
        //return s.l * s.l; // access to the created object // step 2
    //Step 6 - Turning a function into a method
    //}
    //public static double area (double a, double b)  {
    //public static double area (Rectangle r ) {
        //return a*b;
      //  return r.a * r.b;

    }

