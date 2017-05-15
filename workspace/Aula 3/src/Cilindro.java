
public class Cilindro extends Circulo implements Volume{
	public double altura;
	public Retangulo ret;
	public Cilindro(double raio,double height) {
		super(raio);
		setAltura(height);
		// TODO Auto-generated constructor stub
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	@Override
	public double calVolume() {
		// TODO Auto-generated method stub
		return Math.PI*getRaio()*getAltura();
	}
	
}