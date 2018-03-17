package dao.teacher;


import java.sql.SQLException;
import java.util.List;

import model.Teacher;

public interface TeacherDao {

	Teacher Get(int id);
	List<Teacher> GetAll();
	Boolean Insert(Teacher teacher) throws SQLException, ClassNotFoundException;
	Boolean Delete(int id) throws SQLException, ClassNotFoundException;
}
