package hospital.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import hospital.model.User;

public class UserDAOImpl implements UserDAO {
	
private JdbcTemplate jdbcTemplate;
	
	public UserDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public User find(String username){
		String sql = "Select * from User WHERE = '" + username + "' ";
		
		return jdbcTemplate.query(sql, new ResultSetExtractor<User>(){

			@Override
			public User extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				if (rs.next()) {
					User user = new User();
					user.setIdUser(rs.getInt("idUser"));
					user.setUsername(rs.getString("username"));
					user.setPassword(rs.getString("password"));
					user.setRole(rs.getString("role"));

					return user;
				}
				
				return new User();
			}
			
		});
		
		
	}

}
