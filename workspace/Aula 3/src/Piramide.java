
public class Piramide extends Triangulo implements Volume{
	
	public Piramide(double base, double altura, double lado1, double lado2, double lado3) {
		super(base, altura, lado1, lado2, lado3);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calVolume() {
		// TODO Auto-generated method stub
		return 1/3*(getAltura()*getLado1()*getLado2());
	}
}
