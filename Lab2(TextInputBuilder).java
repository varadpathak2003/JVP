public class UserInputBuilder {
    public static class TextInputBuilder {
        StringBuilder value=new StringBuilder();
        public void add(char c) {
            value.append(c);
        }
        public String getValue() {
            return value.toString();
        }
    }
    public static class NumericInputBuilder extends TextInputBuilder{
        
        public void add(char c) {
            if (Character.isDigit(c)) super.add(c) ;
        }
    }
    public static class OddNumericInputBuilder extends NumericInputBuilder{
        public void add(char c) {
            int numValue=c-'0';
            if (Character.isDigit(c) && numValue%2==1) super.add(c) ;
        }
    }
    public static class EvenNumericInputBuilder extends NumericInputBuilder{
        public void add(char c) {
            int numValue=c-'0';
            if (Character.isDigit(c) && numValue%2==0) super.add(c) ;
        }
    }
   public static void main(String[] args) {
        TextInputBuilder textInput = new TextInputBuilder();
        textInput.add('1');
        textInput.add('a');
        System.out.println("TextInputBuilder: " + textInput.getValue());
    
        TextInputBuilder numericInput = new NumericInputBuilder();
        numericInput.add('1');
        numericInput.add('a');
        numericInput.add('0');
        System.out.println("NumericInputBuilder: " + numericInput.getValue());
        TextInputBuilder oddInput = new OddNumericInputBuilder();
        oddInput.add('1');
        oddInput.add('2');
        oddInput.add('3');
        System.out.println("OddNumericInputBuilder: " + oddInput.getValue()); 
    
        TextInputBuilder evenInput = new EvenNumericInputBuilder();
        evenInput.add('0');
        evenInput.add('1');
        evenInput.add('2');
        System.out.println("EvenNumericInputBuilder: " + evenInput.getValue());
    }
}
