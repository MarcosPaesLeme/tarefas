
public class Trapezio extends Poligono {
	public double baseMaior;
	public double lado1;
	public double lado2;
	public Trapezio(double base, double altura,double baseMaior, double lado1,double lado2) {
		super(base, altura);
		setBaseMaior(baseMaior);
		setLado1(lado1);
		setLado2(lado2);
		// TODO Auto-generated constructor stub
	}

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

	public double getBaseMaior() {
		return baseMaior;
	}

	public void setBaseMaior(double baseMaior) {
		this.baseMaior = baseMaior;
	}

	@Override
	public double area() {
		// TODO Auto-generated method stub
		return ((super.getBase()+getBaseMaior())*super.getAltura())/2;
	}

	@Override
	public double perimetro() {
		// TODO Auto-generated method stub
		return getBase()+getBaseMaior()+getLado1()+getLado2();
	}
}