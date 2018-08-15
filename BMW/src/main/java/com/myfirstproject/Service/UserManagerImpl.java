package com.myfirstproject.Service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.log4j.Logger;
import org.directwebremoting.annotations.RemoteMethod;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.security.authentication.AuthenticationManager;

import com.myfirstproject.dao.UserDAO;
import com.myfirstproject.entity.AdminDetail;
import com.myfirstproject.entity.Cmy_Mst;
import com.myfirstproject.entity.Location_Mst;
import com.myfirstproject.entity.Part_Mst;
import com.myfirstproject.entity.Print_Mst;
import com.myfirstproject.entity.Shift_Mst;
import com.myfirstproject.entity.Student;
import com.myfirstproject.entity.StudentDetail;
import com.myfirstproject.entity.User;
import com.myfirstproject.entity.WrkDetail;

/**
 * @author s6
 *
 */
/**
 * @author s6
 *
 */
public class UserManagerImpl implements UserManager {

	@Autowired
	UserDAO userDao;


	// ******************************************************************************************
	@Autowired(required = false)
	AuthenticationManager authManager;
	private Logger LOG = Logger.getLogger(UserManager.class);
	Session session = null;
	private static HibernateTemplate ht;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.ht = new HibernateTemplate(sessionFactory);
		session = sessionFactory.openSession();
	}
	@Override
	public User getUser() {
		return null;
	}

	@Override
	public void saveDeatil(WrkDetail wrk, AdminDetail admin) {
		ht.save(wrk);
		ht.save(admin);
	}

	@Override
	public void saveDeatilMapping(Student std) {
		Long id=(Long) ht.save(std);
		Student st=ht.get(Student.class,id);
		StudentDetail stdt=ht.get(StudentDetail.class,id);
	}
	public User getUser(String username) {
		List<User> users = ht.find("FROM User  WHERE userName = ?", username);
		if (users != null && !users.isEmpty()) 	return users.get(0);
		return null;
	}
	public User getActiveUser(String username) {
		List<User> users = ht.find("FROM User WHERE active = ? and userName = ?", true, username);
		if (users != null && !users.isEmpty()) return users.get(0);
		return null;
	}
	public User getUser(String username, boolean status) {
		List<User> users = ht.find("FROM User WHERE userName = ? and active=?",username,true);
		if (users!=null && !users.isEmpty() ) return users.get(0);
		return null;
	}
	@Override
	public void updateUser(User user) {
	ht.saveOrUpdate(user);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@SuppressWarnings("unchecked")
	@Override
	public Print_Mst getBarcodeDetails(String cmycd, String shift, String date, String value,String userid,String location) {
		String year=date.substring(0, 4),month=date.substring(5, 7),day=date.substring(8, 10);
		String str="select part_no,part_revson,part_vndr_cd,day_cd,month_cd,year_cd,shift_nm,loc_cd,max(pnt_no),part_desc,part_lock from part_mst inner join day_mst on (day_sno=\'"+day+"\' and day_sts=true) inner join month_mst on (month_sno=\'"+month+"\' and month_sts=true)  inner join year_mst on (year=\'"+year+"\' and year_sts=true) inner join cmy_mst on (cmy_cd=\'"+cmycd+"\' and cmy_sts=true) inner join shift_mst on (shift_nm=\'"+shift+"\') inner join loc_mst on (loc_nm=\'"+location+"\' and loc_sts=true) left join print_mst on (part_no=pnt_prt_no and pnt_cmy_cd=\'"+cmycd+"\' and pnt_dt=\'"+date+"\') where part_bar_cd=\'"+value+"\'";
		Print_Mst pm=new Print_Mst();
		List<Object[]> query=session.createSQLQuery(str).list();
		if(query!=null && !query.isEmpty()){
			Object obj[]=query.get(0);
			if(obj[0]!=null)  	pm.setPnt_prt_no(obj[0].toString());
			else				pm.setPnt_prt_no("");
			if(obj[1]!=null)  	pm.setPnt_drwg_rvsn(obj[1].toString());
			else				pm.setPnt_drwg_rvsn("");
			if(obj[2]!=null)  	pm.setPnt_vn_cd(obj[2].toString());
			else				pm.setPnt_vn_cd("");
			if(obj[3]!=null)  	pm.setPnt_day_cd(obj[3].toString());
			else				pm.setPnt_day_cd("");
			if(obj[4]!=null)  	pm.setPnt_mnth_cd(obj[4].toString());
			else				pm.setPnt_mnth_cd("");
			if(obj[5]!=null)  	pm.setPnt_yr_cd(obj[5].toString());
			else				pm.setPnt_yr_cd("");
			if(obj[6]!=null)  	pm.setPnt_shft(obj[6].toString());
			else				pm.setPnt_shft("");
			if(obj[7]!=null)  	pm.setPnt_loc_cd(obj[7].toString());
			else				pm.setPnt_loc_cd("");
			if(obj[8]!=null)  	pm.setPnt_no(Long.parseLong(obj[8].toString())+1);
			else				pm.setPnt_no((long)1);
			if(obj[9]!=null)  	pm.setPnt_prt_des(obj[9].toString());
			else				pm.setPnt_prt_des("");
			if(obj[10]!=null)  	pm.setPnt_prt_lock(obj[10].toString());
			else				pm.setPnt_prt_lock("0");
			if(pm.getPnt_no()<9) pm.setPnt_srz_no("00"+(pm.getPnt_no()));
			else if(pm.getPnt_no()<99) pm.setPnt_srz_no("0"+(pm.getPnt_no()));
			else if(pm.getPnt_no()<998) pm.setPnt_srz_no(""+(pm.getPnt_no()));
			else  pm.setPnt_srz_no(""+(pm.getPnt_no()));
			pm.setPnt_cmy_cd(cmycd);
			pm.setPnt_day(day);
			pm.setPnt_mnth(month);
			pm.setPnt_yr(year);
			pm.setPnt_prt_bar_cd(value);
			java.util.Date dt=new java.util.Date();
			try {
				dt=new SimpleDateFormat("yyyy-MM-dd").parse(date);
			} catch (Exception e) {
			}
			pm.setPnt_dt( new java.sql.Date(dt.getTime()));
			String gbarcode=pm.getPnt_prt_no()+pm.getPnt_drwg_rvsn()+pm.getPnt_vn_cd()+pm.getPnt_day_cd()+pm.getPnt_mnth_cd()+pm.getPnt_yr_cd()+pm.getPnt_shft()+cmycd+pm.getPnt_srz_no();
			List<Print_Mst> oldpmlist=ht.find("from Print_Mst where pnt_bar_cd=?",gbarcode);
			if(oldpmlist!=null && !oldpmlist.isEmpty()){
				int count=0;
				while (count==0) {
					pm.setPnt_no(pm.getPnt_no()+1);
					if(pm.getPnt_no()<9) pm.setPnt_srz_no("00"+(pm.getPnt_no()));
					else if(pm.getPnt_no()<99) pm.setPnt_srz_no("0"+(pm.getPnt_no()));
					else if(pm.getPnt_no()<998) pm.setPnt_srz_no(""+(pm.getPnt_no()));
					gbarcode=pm.getPnt_prt_no()+pm.getPnt_drwg_rvsn()+pm.getPnt_vn_cd()+pm.getPnt_day_cd()+pm.getPnt_mnth_cd()+pm.getPnt_yr_cd()+pm.getPnt_shft()+cmycd+pm.getPnt_srz_no();
					oldpmlist=ht.find("from Print_Mst where pnt_bar_cd=?",gbarcode);
					if(oldpmlist==null || oldpmlist.isEmpty()) count=1;
				}
			}
		pm.setPnt_bar_cd(gbarcode);
		pm.setPnt_usr_id(userid);
		}
		if(pm.getPnt_prt_no()!=null && !pm.getPnt_prt_no().equalsIgnoreCase(""))	ht.saveOrUpdate(pm);
		else  return null;
		return pm;
	}

	@Override
	public boolean checkUserNamePresentOrNot(String userName) {
		List<User> user=ht.find("from User where userName=?",userName);
		if(user!=null && !user.isEmpty()) return true;
		return false;
	}

	@Override
	public boolean loginSuccessOrNot(String userName, String password) {
		List<User> user=ht.find("from User where userName=? and password=?",userName,password);
		if(user!=null && !user.isEmpty()) return true;
		return false;
	}
	@Override
	public List<Print_Mst> getPreviousRecords(String userid) {
		String date = "";
		java.util.Date dt = new java.util.Date();
		java.sql.Date sqldt=new java.sql.Date(dt.getTime());
//		List<Print_Mst> pm=ht.find("from Print_Mst where pnt_dt=?",sqldt);
		List<Print_Mst> pm=ht.find("from Print_Mst order by pnt_sno desc");
		if(pm!=null && !pm.isEmpty()){
			for (Print_Mst pk : pm) {
				date=new SimpleDateFormat("yyyy-MM-dd").format(pk.getPnt_dt());
				pk.setDummydate(date);
			}
		}
		return pm;
	}
	@Override
	public Print_Mst checkGeneratedBarcodeIsThereOrNot(String newbarcode, String oldbarcode,String slno) {
		List<Print_Mst> pmlist=ht.find("from Print_Mst where pnt_bar_cd=?",newbarcode);
		Print_Mst pm=new Print_Mst();
		if(pmlist==null || pmlist.isEmpty()){
			List<Print_Mst> oldpmlist=ht.find("from Print_Mst where pnt_bar_cd=?",oldbarcode);
			if(oldpmlist!=null && !oldpmlist.isEmpty()){
				pm=oldpmlist.get(0);
				pm.setPnt_bar_cd(newbarcode);
				pm.setPnt_srz_no(slno);
				pm.setPnt_no(Long.parseLong(slno));
				ht.saveOrUpdate(pm);
				return pm;
			}
		}
		return null;
	}
	@Override
	public Print_Mst addRecordToGlobalForPartMst() {
		List<Print_Mst> pm=ht.find("from Print_Mst order by pnt_sno desc limit 1");
		if(pm!=null && !pm.isEmpty()) return pm.get(0);
		return null;
	}
	@Override
	public Print_Mst printTheSelectedRecord(String barcode) {
		List<Print_Mst> pmlist=ht.find("from Print_Mst where pnt_bar_cd=?",barcode);
		return pmlist.get(0);
	}
	@Override
	public Cmy_Mst getCompany() {
		List<Cmy_Mst> cm=ht.find("from Cmy_Mst where cmy_sts=?",true);
		if(cm!=null && !cm.isEmpty()) return cm.get(0);
		return null;
	}
	@Override
	public List<Shift_Mst> getShiftMasterList() {
		List<Shift_Mst> sf =ht.find("from Shift_Mst where shift_sts=?",true);
		return sf;
	}
	@Override
	public List<Location_Mst> getLocationMasterList() {
	List<Location_Mst> loc=ht.find("from Location_Mst where loc_sts=?",true);
		return loc;
	}
	//******************************  Master Start By M.Chandra Shekar  ***************************************************
	@Override
	public Part_Mst savePartMaster(String partno, String drwrvsn, String partdes, String vncd, String brcd,	String lock, String sts) {
		List<Part_Mst> pl=ht.find("from Part_Mst where part_no=? and part_bar_cd=?",partno,brcd);
		Part_Mst  pm=null;
		if(pl!=null && !pl.isEmpty()){
			pm=pl.get(0);
			pm.setPart_revson(drwrvsn);
			pm.setPart_desc(partdes);
			pm.setPart_vndr_cd(vncd);
			pm.setPart_lock(lock.equalsIgnoreCase("1"));
			pm.setPart_sts(sts.equalsIgnoreCase("1"));
			pm.setPart_dt(new java.sql.Date((new java.util.Date()).getTime()));
		}
		else{
			pm=new Part_Mst();
			pm.setPart_no(partno);
			pm.setPart_revson(drwrvsn);
			pm.setPart_desc(partdes);
			pm.setPart_vndr_cd(vncd);
			pm.setPart_bar_cd(brcd);
			pm.setPart_lock(lock.equalsIgnoreCase("1"));
			pm.setPart_sts(sts.equalsIgnoreCase("1"));
			pm.setPart_dt(new java.sql.Date((new java.util.Date()).getTime()));
		}
		try{
			ht.saveOrUpdate(pm);
			return pm;
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	//******************************  Master End By M.Chandra Shekar  ***************************************************
	@Override
	public List<Part_Mst> getPreviousPartMaster() {
//		List<Part_Mst>  pm =ht.find("from Part_Mst where part_sts=? order by part_sno desc",true );
		List<Part_Mst>  pm =ht.find("from Part_Mst where part_sts=?",true );
		return pm;
	}
}
