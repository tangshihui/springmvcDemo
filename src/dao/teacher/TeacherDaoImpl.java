package dao.teacher;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Teacher;

public class TeacherDaoImpl implements TeacherDao {

	final String DRIVER = "com.mysql.jdbc.Driver";
	final String CONNECTIONSTR = "jdbc:mysql://localhost:3306/School";
	final String USER = "root";
	final String PWD = "1212";

	DaoHelper dao = null;

	@Override
	public Teacher Get(int id) {

		ResultSet resultSet = null;
		Teacher teacher = new Teacher();

		try {
			dao = DaoHelper.GetInstance();
			dao.registerDriver();
			dao.getConnection();
			dao.createStatement();

			resultSet = dao.executeQuery("select * from teacher where id=" + String.valueOf(id));

			while (resultSet.next()) {
				teacher.setId(resultSet.getInt("id"));
				teacher.setName(resultSet.getString("name"));
				teacher.setAddress(resultSet.getString("address"));

			}

		} catch (Exception ex) {

			ex.printStackTrace();
		} finally {
			if (dao != null) {
				try {
					dao.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return teacher;
	}

	@Override
	public List<Teacher> GetAll() {

		ResultSet resultSet = null;
		List<Teacher> list = new ArrayList<Teacher>();

		try {
			dao = DaoHelper.GetInstance();
			dao.registerDriver();
			dao.getConnection();
			dao.createStatement();
			resultSet = dao.executeQuery("select * from teacher; ");

			while (resultSet.next()) {
				Teacher teacher = new Teacher();
				teacher.setId(resultSet.getInt("id"));
				teacher.setName(resultSet.getString("name"));
				teacher.setAddress(resultSet.getString("address"));

				list.add(teacher);
			}

		} catch (Exception ex) {
			String msg = ex.getMessage();

			ex.printStackTrace();

		} finally {
			if (dao != null) {
				try {
					dao.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return list;
	}

	@Override
	public Boolean Insert(Teacher teacher) throws SQLException, ClassNotFoundException {

		try {
			if (teacher != null) {
				dao = DaoHelper.GetInstance();
				dao.init();

				PreparedStatement pStatement = null;
				pStatement = dao.prepareStatement("insert into teacher(id,name,address) values(?,?,?);");
				pStatement.setInt(1, teacher.getId());
				pStatement.setString(2, teacher.getName());
				pStatement.setString(3, teacher.getAddress());

				return pStatement.executeUpdate() > 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dao.close();
		}
		return false;
	}
	
	@Override
	public Boolean Delete(int id) throws SQLException, ClassNotFoundException {

		try {
				dao = DaoHelper.GetInstance();
				dao.init();

				PreparedStatement pStatement = null;
				pStatement = dao.prepareStatement("delete from teacher where id=?;");
				pStatement.setInt(1, id);

				return pStatement.executeUpdate() > 0;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dao.close();
		}
		return false;
	}

}
