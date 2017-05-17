package hospital.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import hospital.model.Doctor;

public class DoctorDAOImpl implements DoctorDAO{
	
	private JdbcTemplate jdbcTemplate;
	
	public DoctorDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public void delete(int idDoctor){
		String sql = "DELETE FROM Doctor WHERE idDoctor=?";
		jdbcTemplate.update(sql, idDoctor);
		
		String sqlUser = "DELETE FROM User WHERE idUser = ?";
		jdbcTemplate.update(sqlUser, idDoctor);
		
		String sqlUserRole = "DELETE FROM User_role WHERE idUser_role = ?";
		jdbcTemplate.update(sqlUserRole, idDoctor);
	}
	
	@Override
	public void saveOrUpdate(Doctor doctor){
		
		if (doctor.getIdDoctor() > 0) {
			// update
			String sql = "UPDATE Doctor SET name=?, username=?, password=?"
						+ " WHERE idDoctor=?";
			jdbcTemplate.update(sql, doctor.getName(), doctor.getUsername(),
					doctor.getPassword(), doctor.getIdDoctor());
			
			String sqlUser = "UPDATE User SET username = ? , "
					+ "password = ?, enabled = '1' WHERE idUser = ?";
			jdbcTemplate.update(sqlUser, doctor.getUsername(), 
					doctor.getPassword(), doctor.getIdDoctor());
			
			
			String sqlUserRole = "UPDATE User_role SET username = ?, role = 'ROLE_DOC' WHERE (idUser_role = ? AND role = 'ROLE_DOC')";
			jdbcTemplate.update(sqlUserRole, doctor.getUsername(), doctor.getIdDoctor());
		
		} else {
			// insert
			String sqlUser = "INSERT INTO User (username, password)" + "VALUES (?,?)";
			jdbcTemplate.update(sqlUser, doctor.getUsername(), doctor.getPassword());
			
			String sqlUserRole = "INSERT INTO User_role (idUser_role, username, role)" 
					+ "VALUES ((SELECT idUser FROM User WHERE username = ?),?,?)";
					jdbcTemplate.update(sqlUserRole, doctor.getUsername(), doctor.getUsername(), "ROLE_DOC");
			
			String sql = "INSERT INTO Doctor (idDoctor,name, username, password)"
						+ " VALUES ((SELECT idUser FROM User WHERE username = ?),?, ?, ?)";
			jdbcTemplate.update(sql,doctor.getUsername(),doctor.getName(), doctor.getUsername(),
					doctor.getPassword());
			
			String sqlConsult = "INSERT INTO Consultation (idDoctor, start)" + " VALUES ((SELECT idDoctor FROM Doctor WHERE username = ?),?)";
			for(int i = 8; i< 13;i++){
				
				jdbcTemplate.update(sqlConsult,doctor.getUsername(),i);
				
			}
			
			
			
		}
		
		
	}
	
	@Override
	public Doctor getId(int idDoctor){
		String sql = "SELECT * FROM Doctor WHERE idDoctor=" + idDoctor;
		return jdbcTemplate.query(sql, new ResultSetExtractor<Doctor>() {

			@Override
			public Doctor extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				if (rs.next()) {
					Doctor doctor = new Doctor();
					doctor.setIdDoctor(rs.getInt("idDoctor"));
					doctor.setName(rs.getString("name"));
					doctor.setUsername(rs.getString("username"));
					doctor.setPassword(rs.getString("password"));

					return doctor;
				}
				
				return null;
			}
			
		});
	}
	
	@Override
	public List<Doctor> list(){
		
		String sql = "SELECT * From Doctor";
		List<Doctor> doctors = jdbcTemplate.query(sql, new RowMapper<Doctor>() {
			@Override
			public Doctor mapRow(ResultSet rs, int rowNum) throws SQLException {
				Doctor aDoctor= new Doctor();
	
				aDoctor.setIdDoctor(rs.getInt("idDoctor"));
				aDoctor.setName(rs.getString("name"));
				aDoctor.setUsername(rs.getString("username"));
				aDoctor.setPassword(rs.getString("password"));
				
				
				return aDoctor;
			}
			
		});		
		return doctors;
	}
	

}
