public class Complex {
	int real = 0;
	int imag = 0;
	public Complex(int real,int imag){
		this.real = real;
		this.imag = imag;
	}
	public void setReal(int real){
		this.real = real;
	}
	public void setImag(int imag){
		this.imag = imag;
	}
	public int getReal(){
		return this.real;
	}
	public int getImag(){
		return this.imag;
	}
	public Complex add(Complex complex){
		return new Complex(this.real + complex.real, this.imag + complex.imag);
	}
	public Complex subtract(Complex complex){
		return new Complex(this.real - complex.real, this.imag - complex.imag);
	}

}