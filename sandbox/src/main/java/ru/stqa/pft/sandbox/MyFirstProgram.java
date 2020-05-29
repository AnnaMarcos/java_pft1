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

        double l = 5;//
        System.out.println("Square area with side " + l + " = " + area(l));

        double a = 4;
        double b = 6;
        System.out.println("Rectangle area with sides " + a + " and " + b + " = " + area( a ,b ));
    }


    public static void hello()  {//create function which using for duplicated expressions.... help to avoid typing the same code several times
        System.out.println("Hello , world !");

    }
    public static void hello (String somebody) { // created argument or function parameter where we can set any value to 'somebody'
        System.out.println("Hello  ," + somebody + "!");
    }

    public static double area (double len)  {
        return len*len;
    }
    public static double area (double a, double b)  {
        return a*b;

    }
}
