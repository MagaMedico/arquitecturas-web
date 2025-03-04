package dao;

import java.util.List;

import javax.persistence.EntityManager;

import emf.EMF;
import imodel.ICareer;
import model.Career;
/**
 * 
 * @author Cecilia Carl�n: ceciliacarlon2@gmail.com
		   Magal� M�dico: magamedico@gmail.com
		   Magal� Mench�n: magalimenchon@gmail.com	
	@version unica
	@description Implementa la l�gica de comportamiento de los m�todos especificados
	en la interfaz @see ICarrer. De esta forma define el los m�todos relacionados
	con la base de datos de la entidad @see Career
 *
 */
public class CareerDAO implements ICareer{
	/**
	 * Constantes de la clase
	 */
	final static String NAME = "name";
	final static String LENGTH = "length";
	
	/** 
	 * Atributos de la clase
	 */
	private EntityManager em = EMF.createEntityManager();
	private static CareerDAO career;
	
	/**
	 * Constructor vac�o necesario para JPA
	 */
	public CareerDAO() { }
	
	/**
	 * Constructor
	 */
	public CareerDAO(EntityManager em) { 
		this.em = em;
	}

	/**
	 * Retorna una lista de @see Career mediante una consulta de
	 * JPQL, seleccionando las distintas carreras por medio de la entidad
	 * @see Career obteniendo la cantidad de estudiantes de cada una
	 * y ordenandolas por esta especificaci�n.
	 * @see EntityManager
	 */
	@Override
	public List<Career> getCareersOrderByStudents() {
		this.em.getTransaction().begin();
		@SuppressWarnings("unchecked")
		List<Career> careers = this.em.createQuery("SELECT DISTINCT c FROM Career c JOIN c.students s WHERE size(s) > 0 ORDER BY size(s)").getResultList();
		this.em.getTransaction().commit();
		return careers;
	}
	
	public static CareerDAO getInstance() {
		if(career == null)
			career = new CareerDAO();
		return career;
	}
	
}
