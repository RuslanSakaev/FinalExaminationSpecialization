package nursery.accounting.system;

public class Counter implements AutoCloseable {
    private int value;

    public Counter() {
        this.value = 0;
    }

    public void add() {
        value++;
    }

    public int getValue() {
        return value;
    }

    @Override
    public void close() throws Exception {
        if (value > 0) {
            throw new IllegalStateException("Ресурс не был корректно закрыт. Значение: " + value);
        }
    }
}
