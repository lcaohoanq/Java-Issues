package model;

public class ButtonModel {

    private String text; // text to be displayed

    public ButtonModel() {
        text = "-----"; // stimulate empty
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
