
public class Quadrado extends Poligono implements Diagonal{
	public double lado;
	public Quadrado(double base,double altura,double lado)
	{
		super(base,altura);
		setLado(lado);
	}
	@Override
	public double area() {
		// TODO Auto-generated method stub
		return getLado()*getLado();
	}
	
	public double quadradoDiagonal()
	{
		return getLado()*Math.sqrt(2);
	}
	public double getLado() {
		return lado;
	}
	public void setLado(double lado) {
		this.lado = lado;
	}
	@Override
	public double perimetro() {
		// TODO Auto-generated method stub
		return 4*getLado();
	}

}
