package interfaces;

import com.javalesson.oop.Size;

public class InetrfaceRunner {
    public static void main(String[] args) {
        Pricable pizza=new Pizza("Neapolitana",1,20, Size.SMALL);
        Pricable phone=new CallPhone("Motorola","S550",3,400);
        Pricable fridge=new Fridge("LG","510", 4,600);

        printDeliveryPrice(pizza);
        printDeliveryPrice(phone);
        printDeliveryPrice(fridge);
    }
    private static void printDeliveryPrice(Pricable del) {
        System.out.println("Delivery price: "+del.calcDeliveryPrice());
        System.out.println("Order price: "+del.calcOrderPrice());
    }
}
