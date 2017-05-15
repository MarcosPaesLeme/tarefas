
public class Triangulo extends Poligono{
	
	public double lado1;
	public double lado2;
	public double getLado1() {
		return lado1;
	}

	public void setLado1(double lado1) {
		this.lado1 = lado1;
	}

	public double getLado2() {
		return lado2;
	}

	public void setLado2(double lado2) {
		this.lado2 = lado2;
	}

	public double getLado3() {
		return lado3;
	}

	public void setLado3(double lado3) {
		this.lado3 = lado3;
	}

	public double lado3;
	public Triangulo(double base, double altura,double lado1,double lado2, double lado3) {
		super(base, altura);
		setLado1(lado1);
		setLado2(lado2);
		setLado3(lado3);
	}

	@Override
	public double area() {
		// TODO Auto-generated method stub
		return (super.getAltura()*super.getBase())/2;
	}

	@Override
	public double perimetro() {
		// TODO Auto-generated method stub
		return getLado1()+getLado2()+getLado3();
	}

}
	