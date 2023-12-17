package lista2_q2;

public class Lista2_Q2 {
    
    /*
    Como o sistema permite modificar dinamicamente o aspecto das palavras, 
    o padrão Decorador pode ser uma boa opção para ser usada na implementação do sistema descrito. 
    Isso se deve pelo fato de que um dos objetivos desse padrão é atribuir responsabilidade aos objetos em tempo de execução, 
    além de utilizar a capacidade da herança de forma mais flexível, 
    podendo herdar uma subclasse dinamicamente ou não dependendo da execução da aplicação.
    
    O problema é semelhante com o exemplo dado em sala da pizza. 
    Da mesma forma que a pizza pode receber diferentes sabores dependendo da escolha do cliente, 
    o texto pode receber diferentes aspectos, sendo um texto normal, negrito, itálico ou uma combinação deles. 
    */

    public static interface Text {
        String render();
        String text();
    }

    // Classe abstrata para decoradores de texto
    public static abstract class TextDecorator implements Text {
        protected Text textComponent;
        public TextDecorator(Text textComponent) {
            this.textComponent = textComponent;
        }
        @Override
        public String render() {
            return textComponent.render();
        }
        @Override
        public String text() {
            return textComponent.text();
        }
    }
    
    // Implementação concreta do componente de texto
    public static class ConcreteText implements Text {
        private String content;
        public ConcreteText(String content) {
            this.content = content;
        }
        @Override
        public String render() {
            return "<span>" + content + "</span>";
        }
        @Override
        public String text() {
            return content;
        }
    }

    // Montar texto em negrito
    public static class BoldDecorator extends TextDecorator {
        public BoldDecorator(Text textComponent) {
            super(textComponent);
        }
        @Override
        public String render() {
            return "<b>" + textComponent.render() + "</b>";
        }
    }

    // Montar texto em itálico
    public static class ItalicDecorator extends TextDecorator {
        public ItalicDecorator(Text textComponent) {
            super(textComponent);
        }
        @Override
        public String render() {
            return "<i>" + textComponent.render() + "</i>";
        }
    }

    // Montar texto sublinhado
    public static class UnderlineDecorator extends TextDecorator {
        public UnderlineDecorator(Text textComponent) {
            super(textComponent);
        }
        @Override
        public String render() {
            return "<u>" + textComponent.render() + "</u>";
        }
    }

    public static void main(String[] args) {
        Text normalText = new ConcreteText("Normal text");
        Text boldText = new BoldDecorator(new ConcreteText("Bold text"));
        Text italicText = new ItalicDecorator(new ConcreteText("Italic text"));
        Text underlineText = new UnderlineDecorator(new ConcreteText("Underline text"));
        Text boldItalicText = new BoldDecorator(new ItalicDecorator(new ConcreteText("Bold and italic text")));
        Text ItalicUnderlineText = new ItalicDecorator(new UnderlineDecorator(new ConcreteText("Italic and underline text")));

        System.out.println(normalText.render());
        System.out.println(boldText.render());
        System.out.println(italicText.render());
        System.out.println(underlineText.render());
        System.out.println(boldItalicText.render());
        System.out.println(ItalicUnderlineText.render());
    }
}
