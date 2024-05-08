package ar.edu.unju.fi.ejercicio6.main;

import ar.edu.unju.fi.ejercicio6.interfaces.funcionales.Converter;
import ar.edu.unju.fi.ejercicio6.model.FelinoDomestico;
import ar.edu.unju.fi.ejercicio6.model.FelinoSalvaje;

public class Main {

	public static void main(String[] args) {
		
		FelinoSalvaje tigre = new FelinoSalvaje("Tanner",(byte)20,186f);
		
		if(Converter.isNotNull(tigre)) {
		Converter<FelinoSalvaje, FelinoDomestico> converter = x -> new FelinoDomestico(x.getNombre(),x.getEdad(), x.getPeso());
		
		FelinoDomestico felinodomestico1 = converter.convert(tigre);
		
		converter.mostrarObjeto(felinodomestico1);
		}else {
			System.out.println("el objeto esta vacio");
		}
		
		

	}

}
