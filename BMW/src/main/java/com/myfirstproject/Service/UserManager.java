package com.myfirstproject.Service;

import java.util.List;

import com.myfirstproject.entity.AdminDetail;
import com.myfirstproject.entity.Cmy_Mst;
import com.myfirstproject.entity.Location_Mst;
import com.myfirstproject.entity.Part_Mst;
import com.myfirstproject.entity.Print_Mst;
import com.myfirstproject.entity.Shift_Mst;
import com.myfirstproject.entity.Student;
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
public interface UserManager {
	public User getUser();
	public User getUser(String username);
	public void saveDeatil(WrkDetail wrk, AdminDetail admin);
	public void saveDeatilMapping(Student std);
	public Print_Mst getBarcodeDetails(String cmycd, String shift, String date, String value, String userid,String location);
	public boolean checkUserNamePresentOrNot(String userName);
	public boolean loginSuccessOrNot(String userName, String password);
	public User getActiveUser(String username);
	public User getUser(String username, boolean b);
	public void updateUser(User user);
	public List<Print_Mst> getPreviousRecords(String userid);
	public Print_Mst checkGeneratedBarcodeIsThereOrNot(String newbarcode, String oldbarcode,String slno);
	public Print_Mst addRecordToGlobalForPartMst();
	public Print_Mst printTheSelectedRecord(String barcode);
	public Cmy_Mst getCompany();
	public List<Shift_Mst> getShiftMasterList();
	public List<Location_Mst> getLocationMasterList();
	public Part_Mst savePartMaster(String partno, String drwrvsn, String partdes, String vncd, String brcd,String lock, String sts);
	public List<Part_Mst> getPreviousPartMaster();

}
