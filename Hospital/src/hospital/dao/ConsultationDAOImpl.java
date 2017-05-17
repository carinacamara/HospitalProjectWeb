package hospital.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import hospital.model.Consultation;

public class ConsultationDAOImpl implements ConsultationDAO{
	
	private JdbcTemplate jdbcTemplate;
	
	public ConsultationDAOImpl(DataSource dataSource){
		 jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Consultation> getDoc(int idDoctor){
		String sql = "SELECT * From Consultation WHERE idDoctor = " + idDoctor;
		List<Consultation> consultations = jdbcTemplate.query(sql, new RowMapper<Consultation>() {
			@Override
			public Consultation mapRow(ResultSet rs, int rowNum) throws SQLException {
				Consultation cons= new Consultation();
	
				cons.setIdConsultation(rs.getInt("idConsultation"));
				cons.setIdDoctor(rs.getInt("idDoctor"));
				cons.setIdPatient(rs.getInt("idPatient"));
				cons.setStart(rs.getInt("start"));
				cons.setDone(rs.getBoolean("done"));
				cons.setObservations(rs.getString("observations"));
				
				return cons;
			}
			
		});		
		return consultations;
		
				
	}
	
	
	@Override
	public List<Consultation> getDocName(String username){
		String sql = "SELECT * From Consultation WHERE idDoctor = (SELECT idDoctor From Doctor WHERE username = '"
				+ username + "')";
		List<Consultation> consultations = jdbcTemplate.query(sql, new RowMapper<Consultation>() {
			@Override
			public Consultation mapRow(ResultSet rs, int rowNum) throws SQLException {
				Consultation cons= new Consultation();
	
				cons.setIdConsultation(rs.getInt("idConsultation"));
				cons.setIdDoctor(rs.getInt("idDoctor"));
				cons.setIdPatient(rs.getInt("idPatient"));
				cons.setStart(rs.getInt("start"));
				cons.setDone(rs.getBoolean("done"));
				cons.setObservations(rs.getString("observations"));
				
				return cons;
			}
			
		});		
		return consultations;
		
				
	}
	
	
	
	@Override
	public List<Consultation> getPatient(int idPatient){
		
		String sql = "SELECT * From Consultation WHERE idPatient = " + idPatient;
		List<Consultation> consultations = jdbcTemplate.query(sql, new RowMapper<Consultation>() {
			@Override
			public Consultation mapRow(ResultSet rs, int rowNum) throws SQLException {
				Consultation cons= new Consultation();
	
				cons.setIdConsultation(rs.getInt("idConsultation"));
				cons.setIdDoctor(rs.getInt("idDoctor"));
				cons.setIdPatient(rs.getInt("idPatient"));
				cons.setStart(rs.getInt("start"));
				cons.setDone(rs.getBoolean("done"));
				cons.setObservations(rs.getString("observations"));
				
				return cons;
			}
			
		});		
		return consultations;
		
		
		
	}
	
	@Override
	public List<Consultation> list(){
		String sql = "SELECT * From Consultation";
		List<Consultation> consultations = jdbcTemplate.query(sql, new RowMapper<Consultation>() {
			@Override
			public Consultation mapRow(ResultSet rs, int rowNum) throws SQLException {
				Consultation cons= new Consultation();
	
				cons.setIdConsultation(rs.getInt("idConsultation"));
				cons.setIdDoctor(rs.getInt("idDoctor"));
				cons.setIdPatient(rs.getInt("idPatient"));
				cons.setStart(rs.getInt("start"));
				cons.setDone(rs.getBoolean("done"));
				cons.setObservations(rs.getString("observations"));
				
				return cons;
			}
			
		});		
		return consultations;
		
	}
	
	@Override
	public void saveOrUpdate(Consultation cons){
		
		if (cons.getIdConsultation() > 0) {
			// update
			String sql = "UPDATE Consultation SET idDoctor=?, idPatient=?, "
						+ "start=?, done=?, observations=? WHERE idConsultation=?";
			jdbcTemplate.update(sql, cons.getIdDoctor(), cons.getIdPatient(),
					cons.getStart(), cons.isDone(), cons.getObservations(), cons.getIdConsultation());
		} else {
			// insert
			String sql = "INSERT INTO Consultation (idDoctor, idPatient, start, done, observations)"
						+ " VALUES (?, ?, ?, ?, ?)";
			jdbcTemplate.update(sql, cons.getIdDoctor(), cons.getIdPatient(),
					cons.getStart(), cons.isDone(), cons.getObservations());
		}
		
	}

	
	@Override
	public Consultation getId(int idConsultation){
		String sql = "SELECT * FROM Consultation WHERE idConsultation=" + idConsultation;
		return jdbcTemplate.query(sql, new ResultSetExtractor<Consultation>() {

			@Override
			public Consultation extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				if (rs.next()) {
					Consultation cons = new Consultation();
					cons.setIdConsultation(rs.getInt("idConsultation"));
					cons.setIdDoctor(rs.getInt("idDoctor"));
					cons.setIdPatient(rs.getInt("idPatient"));
					cons.setStart(rs.getInt("start"));
					cons.setDone(rs.getBoolean("done"));
					cons.setObservations(rs.getString("observations"));
					
					return cons;
				}
				
				return null;
			}
			
		});
	}
	
	@Override
	public void sendStuff(int idPatient){
		String sql = "UPDATE Consultation SET observations= 'Patient is here.' WHERE idPatient=" +idPatient
				+" AND done = 0";
		jdbcTemplate.update(sql);
	}
}
