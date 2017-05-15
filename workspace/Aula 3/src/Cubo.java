
public class Cubo extends Quadrado implements Volume {

	public Cubo(double base, double altura, double lado) {
		super(base, altura, lado);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calVolume() {
		// TODO Auto-generated method stub
		return getAltura()*getLado()*getBase();
	}

}
