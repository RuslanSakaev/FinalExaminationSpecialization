package nursery.accounting.system;

public class Counter {
    private int value;

    public Counter() {
        this.value = 0;
    }

    public void setCount(int count) {
        value = count;
    }

    public void add() {
        value++;
    }

    public void remove() {
        value--;
        if (value < 0) {
            value = 0; // Убеждаемся, что счетчик никогда не становится отрицательным
        }
    }

    public int getValue() {
        return value;
    }
}
