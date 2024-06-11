package systemdesign.designpattern.structural.DecoratorDesignPattern.component;

public abstract class TextDecorator implements TextComponent {
    protected  TextComponent textComponent;

    public TextDecorator(TextComponent textComponent) {
        this.textComponent = textComponent;
    }

    public abstract String getText();
}
