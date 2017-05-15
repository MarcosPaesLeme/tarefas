
public abstract class Poligono extends Figura {
	public double base;
	public double altura;
	
	public Poligono(double base,double altura)
	{
		this.base = base;
		this.altura=altura;
	}

	public double getBase() {
		return base;
	}

	public void setBase(double base) {
		this.base = base;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}
	
	public abstract double area();
	
	public abstract double perimetro();	
}
