package interfaces;

import com.javalesson.oop.Size;

public class InetrfaceRunner {
    public static void main(String[] args) {
        Deliverable pizza=new Pizza("Neapolitana",1,20, Size.SMALL);
        Deliverable phone=new CallPhone("Motorola","S550",3,400);
        Deliverable frige=new Frige("LG","510", 4,600);

        printDeliveryPrice(pizza);
        printDeliveryPrice(phone);
        printDeliveryPrice(frige);
    }
    private static void printDeliveryPrice(Deliverable del) {
        System.out.println("Delivery price: "+del.calcDeliveryPrice());
    }
}
