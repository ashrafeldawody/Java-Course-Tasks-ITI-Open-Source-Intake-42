class ComplexCalculator {
	public static void main(String[] args){
		Complex complexNumber1 = new Complex(4,5);
		Complex complexNumber2 = new Complex(3,6);
		System.out.println("Add Complex");

		printComplex(complexNumber1.add(complexNumber2));

		System.out.println("Subtract Complex");
		printComplex(complexNumber1.subtract(complexNumber2));
	}
	public static void printComplex(Complex c){
		if(c.imag > 0)
			System.out.println(c.real + "+" + c.imag + "i");
		else
			System.out.println(c.real + "" + c.imag + "i");
	}
}