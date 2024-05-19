package model;

public class CounterModel {
    private int value;

    public CounterModel() {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void increment() {
        value++;
    }

    public void decrement() {
        value--;
    }

    public void reset() {
        value = 0;
    }
}
