package saarthi;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import entity.District;
import entity.resultset;

import entity.rowmappersearch;
import entity.rowmapperstop;
import entity.searchform;
import entity.stopage;
import entity.userdata;

@Repository
public class databasework {
	
	@Autowired
	private JdbcTemplate jd;

	public JdbcTemplate getJd() {
		return jd;
	}

	public void setJd(JdbcTemplate jd) {
		this.jd = jd;
	}
	
	public int singupd(userdata us) {
		 String q="insert into regis (fullname,email,pass,username) values (?,?,?,?)";
		 int i=jd.update(q, us.getFull_name(), us.getEmail_id(), us.getPasswored(), us.getUsername());
		return i;
	}
	
	public userdata  getlogind(userdata us) {
		String q="select * from regis where  username=? and pass=? ";
		RowMapper<userdata> map=new resultset();
		userdata data=jd.queryForObject(q, map,us.getUsername(), us.getPasswored());
		return data;
	}
	
	public List<searchform> getroute(searchform search) {
		String q="select * from route where From_Station_En=? AND TO_Station_En=?";
		RowMapper<searchform> map=new rowmappersearch();
		List<searchform> se=jd.query(q,map,search.getFrom(), search.getTo());
		return se;
	}
	
	public List<stopage> findestope(String name){
		String q="select * from "+name;
		RowMapper<stopage> map=new rowmapperstop();
		List<stopage>  sto=jd.query(q, map);
		return sto;
	}
	
	public List<searchform> getuturoute(searchform search) {
		
		String q="select * from route where From_Station_En=?";
		RowMapper<searchform> map=new rowmappersearch();
		List<searchform> se=jd.query(q,map,search.getFrom());
		return se;
	}
	
	
	District dis=new District();
	public void set_District(String name) {
		dis.setDistrict(name);
	}
	
	public String get_district() {
		return dis.getDistrict();
	}
	
	
	
	
	
	
	
}
