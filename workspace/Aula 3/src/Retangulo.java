
public class Retangulo extends Poligono implements Diagonal{

	public Retangulo(double base, double altura) {
		super(base, altura);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double area() {
		// TODO Auto-generated method stub
		return base*altura;
	}
	
	@Override
	public double quadradoDiagonal()
	{
		return Math.sqrt(Math.pow(getAltura(), 2)+Math.pow(getBase(), 2));
	}

	@Override
	public double perimetro() {
		// TODO Auto-generated method stub
		return (2*getBase())*(2*getAltura());
	}

}
