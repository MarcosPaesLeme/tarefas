
public class Esfera extends Circulo implements Volume{

	public Esfera(double raio) {
		super(raio);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calVolume() {
		// TODO Auto-generated method stub
		return (4/3)*Math.PI*Math.pow(getRaio(), 3);
	}

}
