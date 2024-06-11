package systemdesign.designpattern.structural.DecoratorDesignPattern.component;

public class Main {
    public static void main(String[] args) {
        TextComponent textComponent = new PlainText("Hi This is Prem");
        textComponent = new BoldText(textComponent);
        textComponent = new ItalicText(textComponent);
        System.out.println(textComponent.getText());
    }
}
