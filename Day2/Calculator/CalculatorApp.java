public class CalculatorApp{
public static void main(String[] args){
        if(args.length != 3){
            System.out.println("Invalid Operation");
		System.exit(0);
        }
        validateInputs(args[0], args[2], args[1]);
	float firstNumber = Float.parseFloat(args[0]);
	float secondNumber = Float.parseFloat(args[2]);
	float result = new Calculator(firstNumber,secondNumber,args[1].charAt(0)).getResult();
	System.out.println(args[0] + " " + args[1] + " " + args[2] + " = " + Float.toString(result));
	}
	public static void validateInputs(String number1,String number2,String operator){
        	if(!canParse(number1) || !canParse(number2)){
			System.out.println("Arguments can't be converted to Numbers"); 
			System.exit(0);
		}
		if(!(operator.equals("+") || operator.equals("-") || operator.equals("/") || operator.equals("x") || operator.equals("%"))){
			System.out.println("Invalid Operator"); 
			System.exit(0);
		}
	}
	public static boolean canParse(String value) {
		try {
			Float.parseFloat(value);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}
    
}