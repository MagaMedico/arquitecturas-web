package imodel;

import java.util.List;

import org.apache.commons.csv.CSVParser;

import model.Career;

/*
	@author Cecilia Carl�n: ceciliacarlon2@gmail.com
			Magal� M�dico: magamedico@gmail.com
			Magal� Mench�n: magalimenchon@gmail.com	
	@version unica
	@description Interfaz que especifica qu� l�gica de comportamiento deber�
	describir aquella clase que la implemente.
*/
public interface ICareer {
	
	/**
	 * 
	 * @param em del tipo EntityManager para poder establecer la conexi�n
	 * @return del tipo List<Career>
	 * @description obtiene todas las carreras ordenadas por la cantidad de estudiantes que estas tengan.
	 */
	public List<Career> getCareersOrderByStudents();

}
