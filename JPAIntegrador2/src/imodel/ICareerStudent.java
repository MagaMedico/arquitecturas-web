package imodel;

import java.util.List;

import javax.persistence.EntityManager;
import org.apache.commons.csv.CSVParser;

import model.Career;
import model.Student;

public interface ICareerStudent {
	
	public void career_studentPersistence(EntityManager em, CSVParser parserCareerStudent);
	public void addStudent(EntityManager em, Student student, Career career);
	public List<Student> getStudentsByCareerFilterCity(EntityManager em, Long career_id, String city);
}
