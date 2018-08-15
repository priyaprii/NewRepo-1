
package com.myfirstproject.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Service;

import com.myfirstproject.Service.UserManager;
import com.myfirstproject.entity.Part_Mst;
import com.myfirstproject.entity.Print_Mst;
import com.myfirstproject.util.MailManager;

/**
 * This class is a controller to handle the Ajax requests from the Admin UI. It
 * leverages Direct Web Remoting (DWR) to simplify the Ajax coding.
 * 
 * @param <shoppingCartItems>
 */

@Service
@RemoteProxy(name = "AjaxController")
public class AjaxController<shoppingCartItems> {
	private static final Logger logger = Logger.getLogger(UserController.class.getName());
	@Autowired
	private UserManager userManager;
	@Autowired
	private MailManager mailManager;
	@Autowired(required = false)
	AuthenticationManager authManager;
	@Autowired
	HttpSession session;
	Print_Mst globalForPartMst = new Print_Mst();
	List<Print_Mst> globalForPartMstList = new ArrayList<Print_Mst>();
	@RemoteMethod
	public Print_Mst getBarcodeDetails(String cmycd, String shift, String date, String value, String userid,String location) {
		Print_Mst pm = new Print_Mst();
		pm = userManager.getBarcodeDetails(cmycd, shift, date, value, userid, location);
		if (pm != null) {
			globalForPartMst = pm;
			session.setAttribute("Print_Mst", pm);
		}
		return pm;
	}

	@RemoteMethod
	public boolean checkUserName(String userName) {
		boolean isPresent = userManager.checkUserNamePresentOrNot(userName);
		return isPresent;
	}

	@RemoteMethod
	public boolean loginSuccessOrNot(String userName, String password) {
		boolean isloginsuccess = userManager.loginSuccessOrNot(userName, password);
		return isloginsuccess;
	}

	@RemoteMethod
	public List<Print_Mst> getPreviousRecords(String userid) {
		List<Print_Mst> records = userManager.getPreviousRecords(userid);
		globalForPartMstList.clear();
		globalForPartMstList.addAll(records);
		return records;
	}

	@RemoteMethod
	public Print_Mst getPreviousRecord(String userid) {
		Print_Mst pm = new Print_Mst();
		 if(globalForPartMst==null || globalForPartMst.getPnt_bar_cd()==null)
		 globalForPartMst=userManager.addRecordToGlobalForPartMst();
		return globalForPartMst;
	}

	@RemoteMethod
	public List<Print_Mst> getSearchReasult(String field, String text) {
		List<Print_Mst> records = new ArrayList<Print_Mst>();
		if (field.equalsIgnoreCase("cmycd")) {
			for (Print_Mst pk : globalForPartMstList) {
				if (StringUtils.containsIgnoreCase(pk.getPnt_cmy_cd(), text)) records.add(pk);
			}
		}
		if (field.equalsIgnoreCase("gbrcd")) {
			for (Print_Mst pk : globalForPartMstList) {
				if (StringUtils.containsIgnoreCase(pk.getPnt_bar_cd(), text)) records.add(pk);
			}
		}
		if (field.equalsIgnoreCase("brcd")) {
			for (Print_Mst pk : globalForPartMstList) {
				if (StringUtils.containsIgnoreCase(pk.getPnt_prt_bar_cd(), text)) records.add(pk);
			}
		}
		if (field.equalsIgnoreCase("prtno")) {
			for (Print_Mst pk : globalForPartMstList) {
				if (StringUtils.containsIgnoreCase(pk.getPnt_prt_no(), text)) 	records.add(pk);
			}
		}
		if (field.equalsIgnoreCase("des")) {
			for (Print_Mst pk : globalForPartMstList) {
				if (StringUtils.containsIgnoreCase(pk.getPnt_prt_des(), text))	records.add(pk);
			}
		}
		if (field.equalsIgnoreCase("revison")) {
			for (Print_Mst pk : globalForPartMstList) {
				if (StringUtils.containsIgnoreCase(pk.getPnt_drwg_rvsn(), text)) 	records.add(pk);
			}
		}
		if (field.equalsIgnoreCase("vendor")) {
			for (Print_Mst pk : globalForPartMstList) {
				if (StringUtils.containsIgnoreCase(pk.getPnt_vn_cd(), text)) 	records.add(pk);
			}
		}
		if (field.equalsIgnoreCase("date")) {
			for (Print_Mst pk : globalForPartMstList) {
				if (StringUtils.containsIgnoreCase(pk.getDummydate(), text))	records.add(pk);
			}
		}
		if (field.equalsIgnoreCase("shift")) {
			for (Print_Mst pk : globalForPartMstList) {
				if (StringUtils.containsIgnoreCase(pk.getPnt_shft(), text)) 	records.add(pk);
			}
		}
		return records;
	}

	@RemoteMethod
	public boolean checkGeneratedBarcodeIsThereOrNot(String newbarcode, String oldbarcode, String slno) {
		Print_Mst pm = userManager.checkGeneratedBarcodeIsThereOrNot(newbarcode, oldbarcode, slno);
		if (pm != null) {
			globalForPartMst = pm;
			return true;
		}
		return false;
	}

	@RemoteMethod
	public boolean printTheSelectedRecord(String barcode) {
		Print_Mst pm = userManager.printTheSelectedRecord(barcode);
		if (pm != null) {
			globalForPartMst = pm;
			session.setAttribute("Print_Mst", pm);
			return true;
		}
		return false;
	}
	
	//******************************  Master Start By M.Chandra Shekar  ***************************************************
	//******************************  Part_Mst Start By M.Chandra Shekar  ***************************************************
	List<Part_Mst> partMstGlobalList=new ArrayList<Part_Mst>();
	@RemoteMethod
	public List<Part_Mst> getPreviousPartMaster(){
		List<Part_Mst> pm=userManager.getPreviousPartMaster();
		partMstGlobalList.clear();
		if(pm!=null && !pm.isEmpty()) partMstGlobalList.addAll(pm);
		return partMstGlobalList;
	}
	@RemoteMethod
	public List<Part_Mst> savePartMaster(String partno,String drwrvsn,String partdes,String vncd,String brcd,String lock,String sts){
		Part_Mst  pm=userManager.savePartMaster(partno,drwrvsn,partdes,vncd,brcd,lock,sts);
		List<Part_Mst> pmli=userManager.getPreviousPartMaster();
		partMstGlobalList.clear();
		if(pmli!=null && !pmli.isEmpty()) partMstGlobalList.addAll(pmli);
		return partMstGlobalList;
	}
	@RemoteMethod
	public List<Part_Mst> searchPartMaster(String field, String text) {
		List<Part_Mst> records = new ArrayList<Part_Mst>();
		if (field.equalsIgnoreCase("partno")) {
			for (Part_Mst pm : partMstGlobalList) {
				if (StringUtils.containsIgnoreCase(pm.getPart_no(), text)) records.add(pm);
			}
		}
		if (field.equalsIgnoreCase("drwrev")) {
			for (Part_Mst pm : partMstGlobalList) {
				if (StringUtils.containsIgnoreCase(pm.getPart_revson(), text)) records.add(pm);
			}
		}
		if (field.equalsIgnoreCase("vendrcd")) {
			for (Part_Mst pm : partMstGlobalList) {
				if (StringUtils.containsIgnoreCase(pm.getPart_vndr_cd(), text)) records.add(pm);
			}
		}
		if (field.equalsIgnoreCase("partdes")) {
			for (Part_Mst pm : partMstGlobalList) {
				if (StringUtils.containsIgnoreCase(pm.getPart_desc(), text)) records.add(pm);
			}
		}
		if (field.equalsIgnoreCase("barcd")) {
			for (Part_Mst pm : partMstGlobalList) {
				if (StringUtils.containsIgnoreCase(pm.getPart_bar_cd(), text)) records.add(pm);
			}
		}
		if (field.equalsIgnoreCase("lock")) {
			for (Part_Mst pm : partMstGlobalList) {
				if (StringUtils.containsIgnoreCase(Boolean.toString(pm.isPart_lock()), text)) records.add(pm);
			}
		}
		if (field.equalsIgnoreCase("sts")) {
			for (Part_Mst pm : partMstGlobalList) {
				if (StringUtils.containsIgnoreCase(Boolean.toString(pm.isPart_sts()), text)) records.add(pm);
			}
		}
		return records;
	}

	//******************************  Part_Mst End By M.Chandra Shekar  ***************************************************
	//******************************  Master End By M.Chandra Shekar  ***************************************************
/*	@RemoteMethod
	public String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 4) { // length of the random string.
        	int i=(int) (Math.random() * ( 35 ));
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(i));
        }
        String saltStr = salt.toString();
        return saltStr;

    }*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
