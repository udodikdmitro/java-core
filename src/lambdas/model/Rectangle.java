package lambdas.model;

public class Rectangle implements Shape {
    public Rectangle(){
        System.out.println("Create rectangle");
    }

    @Override
    public double calcSquare() {
        return 3;
    }
}
