
public class Circulo extends Figura{
	public double raio;
	public Circulo (double raio){
		setRaio(raio);
	}
	public double getRaio() {
		return raio;
	}
	public void setRaio(double raio) {
		this.raio = raio;
	}
	@Override
	public double area() {
		// TODO Auto-generated method stub
		return getRaio()*3.141516;
	}
	@Override
	public double perimetro() {
		// TODO Auto-generated method stub
		return (2*getRaio())*Math.PI;
	}

}
