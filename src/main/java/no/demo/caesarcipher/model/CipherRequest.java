package no.demo.caesarcipher.model;

public class CipherRequest {
    private String text;
    private int shiftKey;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getShiftKey() {
        return shiftKey;
    }

    public void setShiftKey(int shiftKey) {
        this.shiftKey = shiftKey;
    }
}
