package com.javalesson.oop;

public class Dog {
    //    private, package-private(default), protected, public - access modifiers.
    public static final int PAWS = 4;
    public static final int TAIL = 1;
    private String name;
    private String breed;
    private Size size = Size.UNDEFINED;
    private static int dogCount;

    public Dog() {
        dogCount++;
        System.out.println("Dog's count is " + dogCount);
    }

    public static int getDogCount() {
        return dogCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public void bark() {
        switch (size) {
            case BIG:
            case VERY_BIG:
                System.out.println("Wof - wof!!");
                break;
            case AVEAGE:
                System.out.println("Raf - raf!!!");
                break;
            case SMALL:
            case VERY_SMALL:
                System.out.println("Tiaf - tiaf!!!");
                break;
            default:
                System.out.println("Dog's size is undefined!!!");
        }
    }

    public void bite() {
        if (dogCount < 3) {
            System.out.println("Barking!!!");
        } else {
            System.out.println("Bitting!!!");
        }
    }
}