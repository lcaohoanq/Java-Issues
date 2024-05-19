package model;

public class CalModel {
    private float firstValue;
    private float secondValue;
    private float result;

    // mặc định giá trị ban đầu của firstValue, secondValue, result là 0
    public CalModel() {
        this.firstValue = 0;
        this.secondValue = 0;
        this.result = 0;
    }

    public float getFirstValue() {
        return firstValue;
    }

    public void setFirstValue(float firstValue) {
        this.firstValue = firstValue;
    }

    public float getSecondValue() {
        return secondValue;
    }

    public void setSecondValue(float secondValue) {
        this.secondValue = secondValue;
    }

    public float getResult() {
        return result;
    }

    public void setResult(float result) {
        this.result = result;
    }

    // xử lí trong model thay vì trong view
    public void plus() {
        this.result = this.firstValue + this.secondValue;
    }

    public void minus() {
        this.result = this.firstValue - this.secondValue;
    }

    public void multiply() {
        this.result = this.firstValue * this.secondValue;
    }

    public void divide() {
        this.result = this.firstValue / this.secondValue;
    }

    public void power() {
        this.result = (float) Math.pow(this.firstValue, this.secondValue);
    }

    public void modulo() {
        this.result = this.firstValue % this.secondValue;
    }
}
