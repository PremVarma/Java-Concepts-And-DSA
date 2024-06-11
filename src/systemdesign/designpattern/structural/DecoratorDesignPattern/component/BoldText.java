package systemdesign.designpattern.structural.DecoratorDesignPattern.component;

import java.awt.*;

public class BoldText extends TextDecorator {

    public BoldText(TextComponent textComponent) {
        super(textComponent);
    }

    @Override
    public String getText() {
        return "<b>" + textComponent.getText() + "</b>";
    }
}
