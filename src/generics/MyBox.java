package generics;

public class MyBox<X> {

    X someField;
    public <T> MyBox(T param, X param2){
        System.out.println(param.getClass().getSimpleName());
        someField = param2;
    }

    public static <U> U returnValue(U param){
        return param;
    }
}
