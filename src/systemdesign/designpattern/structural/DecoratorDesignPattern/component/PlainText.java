package systemdesign.designpattern.structural.DecoratorDesignPattern.component;

public class PlainText implements TextComponent {
    private String text;

    public PlainText(String text) {
        this.text = text;
    }

    @Override
    public String getText() {
        return text;
    }
}
