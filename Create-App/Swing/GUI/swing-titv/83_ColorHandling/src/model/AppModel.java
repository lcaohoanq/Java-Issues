package model;

public class AppModel {
    private String text;

    public AppModel() {
        this.text = "Hello World!";
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
