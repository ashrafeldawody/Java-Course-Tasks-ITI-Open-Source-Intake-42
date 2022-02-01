public class Calculator {
    private float firstNumber;
    private float secondNumber;
    private char operator;
    private float result;
    public Calculator(){}
    public Calculator(float firstNumber,float secondNumber,char operator){
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.operator = operator;
        calculate();
    }

    public float getResult(){
        return result;
    }
    public void calculate(){
        switch(operator){
            case '+':
                add();
                break;
            case '-':
                subtract();
                break;
            case 'x':
                multiply();
                break;
            case '/':
                divide();
                break;      
            case '%':
                mod();
                break;  
            default:
                System.out.println("Undefined Operation");    
        }
    }
    private void add(){
        result = firstNumber + secondNumber;
    }
    private void subtract(){
        result = firstNumber - secondNumber;
    }
    private void multiply(){
        result = firstNumber * secondNumber;
    }
    private void divide(){
        if(secondNumber == 0){
            System.out.println("Undefined");
            System.exit(0);
        }
        result = firstNumber / secondNumber;
    }
    private void mod(){
        result = firstNumber % secondNumber;
    }
}
