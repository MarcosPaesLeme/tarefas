
public class Losango extends Poligono {
	public double baseMaior;
	public Losango(double base, double altura) {
		super(base, altura);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double area() {
		// TODO Auto-generated method stub
		return getBase()*getAltura();
	}

	@Override
	public double perimetro() {
		// TODO Auto-generated method stub
		return 4*getBase();
	}

}
