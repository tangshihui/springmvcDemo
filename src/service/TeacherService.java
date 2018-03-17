package service;

import java.sql.SQLException;
import java.util.List;

import dao.teacher.TeacherDao;
import dao.teacher.TeacherDaoImpl;
import model.Teacher;

public class TeacherService {

	private static TeacherService instance;
	TeacherService() {}
	public static TeacherService GetInstance() {
		if (instance==null) {
			instance=new TeacherService();
		}
		return instance;
	}
	
	TeacherDao dao=new TeacherDaoImpl();
	
	public Teacher Get(int id) {
		return dao.Get(id);
	}
	
	public List<Teacher> GetAll(){
		return dao.GetAll();
	}
	
	public Boolean Insert(Teacher teacher) {
		try {
			return dao.Insert(teacher);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public Boolean Delete(int id) {
		try {
			return dao.Delete(id);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
