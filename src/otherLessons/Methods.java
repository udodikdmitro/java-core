package otherLessons;

public class Methods {

    public static void main(String[] args) {
        printMessage("Dima");
        System.out.println("Square of rectangle = " + Square(15, 20));
        System.out.println("Square of square: " + SquareSquare(25));
        String timeOut = GoodBye("23.00");
        System.out.println("Bye-bye, time is " + timeOut + " o'clock!!!");

        String str1 = "I like black coffee";
        System.out.println(str1.toUpperCase());
        System.out.println(str1.toLowerCase());

        String str2 = "I like coffee";
        boolean b = str1 == str2;
        System.out.println(b);
//        Operator == shows: are str1 and str2 same strings?
        String str3 = "I like coffee!!!";
        String s = str3.substring(0, 13);
        System.out.println(s);
        boolean c = str2 == s;
        System.out.println(c);
        String str4= new String("I like coffee");
        boolean d = str2==s;
        System.out.println("New string:"+d);
        boolean e = str2.equals(s);
        System.out.println("e: "+e);
        boolean b1 = str1.startsWith(" like",1);
        System.out.println("b1: "+b1);
        boolean b2 = str1.endsWith("fee");
        System.out.println("b2: "+b2);
        System.out.println("Replace colour: "+str1.replace("black", "white"));
        System.out.println("Place of start _!!!_: "+str3.indexOf("!!!"));
    }

    static void printMessage(String name) {
        System.out.println("hello, " + name);
    }

    static int Square(int x, int y) {
        return x * y;

    }

    static String GoodBye(String time) {
        return time;
    }

    static int SquareSquare(int c) {
        return c * c;
    }


}
