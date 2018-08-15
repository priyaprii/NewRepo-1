package com.myfirstproject.web;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.myfirstproject.Service.UserManager;
import com.myfirstproject.entity.Cmy_Mst;
import com.myfirstproject.entity.Location_Mst;
import com.myfirstproject.entity.Part_Mst;
import com.myfirstproject.entity.Shift_Mst;
import com.myfirstproject.util.MailManager;

@Controller
public class UserController {
	private Logger LOG = Logger.getLogger(UserManager.class);
	@Autowired
	UserManager userManager;
	@Autowired
	AjaxController ajaxController;
	@Autowired
	MailManager mailManager;
	@Autowired
	AdminController adminController;
	@Autowired(required = false)
	AuthenticationManager authManager;
	@Autowired
	private HttpSession session;
	@RequestMapping(value = "/homePage.mm", method = { RequestMethod.GET, RequestMethod.POST })
	public void doHomePage(ModelMap model, HttpServletRequest request,@RequestParam(value = "loc", required = false) String loc, HttpSession session) throws UnknownHostException, ParseException, SocketException {}
	@RequestMapping(value = "/logincredentials.mm", method = { RequestMethod.GET, RequestMethod.POST })
	public void dologincredentials(ModelMap model, HttpServletRequest request,@RequestParam(value = "name", required = false) String username,@RequestParam(value = "email", required = false) String useremail,HttpSession session) throws UnknownHostException, ParseException, SocketException {}
	@RequestMapping(value = "/login.mm", method = { RequestMethod.GET, RequestMethod.POST })
	public void loginpage(ModelMap model, HttpServletRequest request, HttpSession session)	throws UnknownHostException, ParseException, SocketException {
		Cmy_Mst cm=userManager.getCompany();
		model.addAttribute("cmy", cm);
		List<Shift_Mst> sf=userManager.getShiftMasterList();
		model.addAttribute("shftmst", sf);
		List<Location_Mst> loc=userManager.getLocationMasterList();
		model.addAttribute("locmst", loc);
	}
	
	
	
	@RequestMapping(value = "/master.mm", method = { RequestMethod.GET, RequestMethod.POST })
	public void masterpage(ModelMap model, HttpServletRequest request,@RequestParam(value = "loc", required = false) String loc, HttpSession session) throws UnknownHostException, ParseException, SocketException {
		List<Part_Mst> pm=userManager.getPreviousPartMaster();
		model.addAttribute("partmst", pm);
	}
}
