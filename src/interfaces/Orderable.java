package interfaces;

public interface Orderable {
    int calcOrderPrice();

    default int sum(int a, int b) {
        return a + b;
    }
}
