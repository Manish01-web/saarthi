package entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class rowmappersearch implements RowMapper<searchform> {

	@Override
	public searchform mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		searchform se=new searchform();
		
		se.setRoute(rs.getString(2));
		se.setFrom(rs.getString(3));
		se.setTo(rs.getString(4));
		
		return se;
	}
	
	
}
