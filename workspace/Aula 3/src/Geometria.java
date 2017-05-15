import java.util.ArrayList; 
public class Geometria {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Figura> figura = new ArrayList<>();
		figura.add(new Circulo(2.00)); 
		figura.add(new Triangulo(3.00, 7.00,1.00,2.00,3.00));   
		figura.add(new Losango(2.00, 3.00));  
		figura.add(new Retangulo(2.00, 5.00)); 
		figura.add(new Quadrado(2.00, 5.00,3.00)); 
		figura.add(new Trapezio(2.00,5.00,6.00,4.00,4.00));
		figura.add(new Cubo(2.00,5.00,2.00));
		figura.add(new Cilindro(2.00,6.00));
		figura.add(new Esfera(2.00));
		figura.add(new Piramide(1.00,2.00,3.00,4.00,5.00));
		for(Figura fig:figura){
			System.out.println(fig.area());    
			System.out.println(fig.perimetro());   
			if(fig instanceof Diagonal){    
				System.out.println(((Diagonal)fig).quadradoDiagonal());   
				}
			if(fig instanceof Volume){
				System.out.println(((Volume)fig).calVolume());
			}
		} 
	} 
	 
}
