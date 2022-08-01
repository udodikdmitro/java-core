package interfaces;

public class Frige extends Electronics{
    @Override
    public int calcDeliveryPrice(){
        if (getPrice()>=300){
            return 0;
        }else {
            return 25;
        }
    }

    public Frige(String make, String model, int quantity, int price) {
        super(make, model, quantity, price);
    }

    @Override
    public int calcOrderPrice() {
        return getQuantity()*getPrice();
    }
}
