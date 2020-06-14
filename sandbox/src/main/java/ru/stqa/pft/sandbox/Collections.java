package ru.stqa.pft.sandbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collections {
  public static void main(String[] args) { // function array
    //String[] langs =  new String[4];
    //langs[0] = "Java";
    //langs[1] = "C#";
    //langs[2] = "Python";
    //langs[3] = "PHP"; or we can write the same array
    String[] langs = {"Java", "C#", "Python", "PHP"};

    //ArrayList method
    List<String> languages = new ArrayList<String>();
    languages.add("Java");
    languages.add("C#");
    languages.add("Python");
    languages.add("PHP");

    //Arrays.asList method
    List<String> languagesL = Arrays.asList("Java", "C#", "Python", "PHP");



    //1st variation
    for (int i = 0; i < langs.length; i++) {
      System.out.println("I'd like to learn " + langs[i]);
    }// 2nd variation
    for (String l : langs) {
      System.out.println("I'd like to learn " + l);
    }
    for (String l : languages) {
      System.out.println("I'd like to learn " + l);
    }

    for (String l : languagesL) {
    System.out.println("I'd like to learn " + l);
    }
    //for (int i = 0; i < languagesL.size(); i ++) {
     // System.out.println("I'd like to learn " + languagesL.get(i));

    }
  }

