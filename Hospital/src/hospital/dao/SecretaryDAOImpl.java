package hospital.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import hospital.model.Secretary;
import hospital.model.User;


public class SecretaryDAOImpl implements SecretaryDAO{

	private JdbcTemplate jdbcTemplate;
	
	public SecretaryDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void saveOrUpdate(Secretary secretary) {
		if (secretary.getIdSecretary() > 0) {
			// update
			String sql = "UPDATE Secretary SET name=?, username=?, password=?"
						+ " WHERE idSecretary=?";
			jdbcTemplate.update(sql, secretary.getName(), secretary.getUsername(),
					secretary.getPassword(), secretary.getIdSecretary());
			
			String sqlUser = "UPDATE User SET username = ? , "
					+ "password = ?, enabled = '1' WHERE idUser = ?";
			jdbcTemplate.update(sqlUser, secretary.getUsername(), 
					secretary.getPassword(), secretary.getIdSecretary());
			
			
			String sqlUserRole = "UPDATE User_role SET username = ?, role = 'ROLE_SEC' WHERE (idUser_role = ? AND role = 'ROLE_SEC')";
			jdbcTemplate.update(sqlUserRole, secretary.getUsername(), secretary.getIdSecretary());
		
		
		} else {
			// insert
			

			String sqlUser = "INSERT INTO User (username, password)" + "VALUES (?,?)";
			jdbcTemplate.update(sqlUser, secretary.getUsername(), secretary.getPassword());
			
			
			
			String sqlUserRole = "INSERT INTO User_role (idUser_role, username, role)" 
			+ "VALUES ((SELECT idUser FROM User WHERE username = ?),?,?)";
			jdbcTemplate.update(sqlUserRole, secretary.getUsername(), secretary.getUsername(), "ROLE_SEC");
			
			String sql = "INSERT INTO Secretary (idSecretary, name, username, password)"
						+ " VALUES ((SELECT idUser FROM User WHERE username = ?),?, ?, ?)";
			jdbcTemplate.update(sql,secretary.getUsername(), secretary.getName(), secretary.getUsername(),
					secretary.getPassword());
			
		}
		
	}

	@Override
	public void delete(int idSecretary) {
		String sql = "DELETE FROM Secretary WHERE idSecretary=?";
		jdbcTemplate.update(sql, idSecretary);
		
		String sqlUser = "DELETE FROM User WHERE idUser = ?";
		jdbcTemplate.update(sqlUser, idSecretary);
		
		String sqlUserRole = "DELETE FROM User_role WHERE idUser_role = ?";
		jdbcTemplate.update(sqlUserRole, idSecretary);
	}

	@Override
	public List<Secretary> list() {
		
		String sql = "SELECT * FROM Hospital.Secretary";
		List<Secretary> listSecretary = jdbcTemplate.query(sql, new RowMapper<Secretary>() {

			@Override
			public Secretary mapRow(ResultSet rs, int rowNum) throws SQLException {
				Secretary aSecretary = new Secretary();
	
				aSecretary.setIdSecretary(rs.getInt("idSecretary"));
				aSecretary.setName(rs.getString("name"));
				aSecretary.setUsername(rs.getString("username"));
				aSecretary.setPassword(rs.getString("password"));
				
				
				return aSecretary;
			}
			
		});
		
		return listSecretary;
	}

	@Override
	public Secretary getId(int idSecretary) {
		String sql = "SELECT * FROM Secretary WHERE idSecretary=" + idSecretary;
		return jdbcTemplate.query(sql, new ResultSetExtractor<Secretary>() {

			@Override
			public Secretary extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				if (rs.next()) {
					Secretary secretary = new Secretary();
					secretary.setIdSecretary(rs.getInt("idSecretary"));
					secretary.setName(rs.getString("name"));
					secretary.setUsername(rs.getString("username"));
					secretary.setPassword(rs.getString("password"));

					return secretary;
				}
				
				return null;
			}
			
		});
	}
	
	
}

