package systemdesign.designpattern.structural.DecoratorDesignPattern.component;

public class ItalicText extends TextDecorator {

    public ItalicText(TextComponent textComponent) {
        super(textComponent);
    }

    @Override
    public String getText() {
        return "<i>" + textComponent.getText() + "</i>";
    }
}
