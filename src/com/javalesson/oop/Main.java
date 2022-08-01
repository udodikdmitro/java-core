package com.javalesson.oop;

public class Main {
    public static void main(String[] args) {
        Dog lab = new Dog();
        lab.setName("Charley");
        lab.setBreed("lab");
        lab.setSize(Size.AVEAGE);
        lab.bark();
        lab.bite();
        System.out.println("Lab's name is " + lab.getName());

        Dog sheppard = new Dog();
        sheppard.setName("Mike");
        sheppard.setBreed("Sheppard");
        sheppard.setSize(Size.BIG);
        sheppard.bark();
        sheppard.bite();
        System.out.println("Sheppard's name is " + sheppard.getName());

        Dog doberman= new Dog();
        doberman.setName("Jack");
        doberman.setBreed("doberman");
        doberman.setSize(Size.BIG);
        doberman.bark();
        doberman.bite();
        System.out.println("Doberman's name is "+doberman.getName());


        Size s = Size.SMALL;
        Size s1 = Size.valueOf("BIG");
        System.out.println(s1);

        Size [] values=Size.values();
        for (int i=0; i<values.length; i++) {
            System.out.println(values[i]);
        }

    }

}

