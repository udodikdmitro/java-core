package interfaces;

public interface Pricable extends Deliverable, Orderable{

    default int CalcPrice(){
     return calcOrderPrice()+calcDeliveryPrice();
    }
}
