package hospital.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import hospital.model.Patient;


public class PatientDAOImpl implements PatientDAO{
	
	private JdbcTemplate jdbcTemplate;
	
	public PatientDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public void saveOrUpdate(Patient patient) {
		if (patient.getIdPatient() > 0) {
			// update
			String sql = "UPDATE Patient SET identityCard=?, CNP=?, "
						+ "address=?, name=? WHERE idPatient=?";
			jdbcTemplate.update(sql, patient.getIdentityCard(), patient.getCNP(),
					 patient.getAddress(), patient.getName(), patient.getIdPatient());
		} else {
			// insert
			String sql = "INSERT INTO Patient (identityCard, CNP, address, name)"
						+ " VALUES (?, ?, ?, ?)";
			jdbcTemplate.update(sql, patient.getIdentityCard(), patient.getCNP(),
					 patient.getAddress(), patient.getName());
		}
		
	}

	
	@Override
	public List<Patient> list(){
	
		String sql = "SELECT * FROM Patient";
		List<Patient> listPatient = jdbcTemplate.query(sql, new RowMapper<Patient>() {

			@Override
			public Patient mapRow(ResultSet rs, int rowNum) throws SQLException {
				Patient aPatient = new Patient();
	
				aPatient.setIdPatient(rs.getInt("idPatient"));
				aPatient.setIdentityCard(rs.getString("identityCard"));
				aPatient.setCNP(rs.getLong("CNP"));
				aPatient.setAddress(rs.getString("address"));
				aPatient.setName(rs.getString("name"));
			
				
				
				return aPatient;
			}
			
		});
		
		return listPatient;
	}
	
	@Override
	public Patient getId(int idPatient) {
		String sql = "SELECT * FROM Patient WHERE idPatient=" + idPatient;
		return jdbcTemplate.query(sql, new ResultSetExtractor<Patient>() {

			@Override
			public Patient extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				if (rs.next()) {
					Patient aPatient = new Patient();
					aPatient.setIdPatient(rs.getInt("idPatient"));
					aPatient.setIdentityCard(rs.getString("identityCard"));
					aPatient.setCNP(rs.getLong("CNP"));
					aPatient.setAddress(rs.getString("address"));
					aPatient.setName(rs.getString("name"));

					return aPatient;
				}
				
				return null;
			}
			
		});
	}

}
