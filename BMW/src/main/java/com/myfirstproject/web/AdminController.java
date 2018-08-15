package com.myfirstproject.web;

import java.net.SocketException;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.myfirstproject.Service.UserManager;
import com.myfirstproject.entity.Print_Mst;
import com.myfirstproject.entity.User;

@Controller
public class AdminController {

	@Autowired
	UserManager userManager;
	@Autowired(required = false)
	AuthenticationManager authManager;
	/* Authentication */
	boolean isAuthenticated(String username, String password) {
		Authentication request = new UsernamePasswordAuthenticationToken(username, password);
		Authentication result = authManager.authenticate(request);
		SecurityContextHolder.getContext().setAuthentication(result);
		return result.isAuthenticated();
	}

	/* Login Controller */
	public void loginLogoutStatus(ModelMap model) {
		String uName = null;
		if (SecurityContextHolder.getContext().getAuthentication() != null)

			uName = SecurityContextHolder.getContext().getAuthentication().getName();

		if (uName != null && !uName.equals("anonymousUser"))
			model.addAttribute("loggedin", true);
		else
			model.addAttribute("loggedin", false);
	}
	HashMap<String,String> cmyshft=new  HashMap<String,String>();
	@RequestMapping(value = "loginVerify.mm", method = { RequestMethod.GET, RequestMethod.POST })
	public String doLoginVerify(HttpServletRequest request, ModelMap model, HttpSession session,
			HttpServletResponse resp, @RequestParam(value = "username", required = false) String username,
			@RequestParam(value = "password", required = false) String password,
			@RequestParam(value = "cmycd", required = false) String cmycd,
			@RequestParam(value = "location", required = false) String location,
			@RequestParam(value = "shift", required = false) String shift,
			@RequestParam(value = "checked", required = false) String no) {
		String unmae = SecurityContextHolder.getContext().getAuthentication().getName();
		User details = userManager.getActiveUser(username);
		User user = userManager.getUser(username,true);
		if (details != null && StringUtils.isNotBlank(details.getPassword()) && details.getPassword().equals(password)) {
			isAuthenticated(username, password);
			cmyshft.put(user.getUserId().toString(), cmycd+"&&"+shift+"&&"+location);
			session.setAttribute("user", user);
			// String active = user.getAccountType();
			if (user != null ) {
				if(user !=null && !user.getAccountType().equalsIgnoreCase("User") && !user.getAccountType().equalsIgnoreCase("seller"))
				{
//					userManager.getLatestStoreAndCompanyCode();
				try {
					if (no.equals("no")) {
						return "redirect:addbarcode.mm";
					} else {
						Cookie con = new Cookie("cookieName", username);
						System.out.println("cookie is " + con.toString());
						con.setMaxAge(600 * 600);
						con.setPath("/");
						resp.addCookie(con);
						return "redirect:addbarcode.mm";
					}
				} catch (Exception e) {
					return "redirect:addbarcode.mm";
				}
			} 
				else {
						try {
							if (no.equals("no")) {
								return "redirect:addbarcode.mm";
							} else {
								Cookie con = new Cookie("cookieName", username);
								System.out.println("cookie is " + con.toString());
								con.setMaxAge(600 * 600);
								con.setPath("/");
								resp.addCookie(con);
								return "redirect:addbarcode.mm";

							}
						} catch (Exception e) {
							return "redirect:addbarcode.mm";
						}
				}
			}
		}
		Cookie[] cookies = request.getCookies();
		@SuppressWarnings("unused")
		String value = "";
		if (cookies != null) {
			for (Cookie c : cookies) {
				if (c.getName().equals("cookieName")) {
					value = c.getValue();
					c.setMaxAge(0);
					c.setPath("/");
					resp.addCookie(c);
				}

			}
		}
		return "redirect:login.mm";
	}
	@RequestMapping(value = "/addbarcode.mm", method = { RequestMethod.GET, RequestMethod.POST })
	public String barcode(ModelMap model, HttpServletRequest request,	@RequestParam(value = "loc", required = false) String loc, HttpSession session)	throws UnknownHostException, ParseException, SocketException {
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		if(userName==null || userName=="" || userName.equalsIgnoreCase("anonymousUser")) return "redirect:login.mm";
		User user = userManager.getUser(userName,true);
		String companysift=cmyshft.get(user.getUserId().toString());
		String s[]=companysift.split("&&");
		model.addAttribute("cmycd", s[0]);
		model.addAttribute("shift", s[1]);
		model.addAttribute("location", s[2]);
		model.addAttribute("userid", user.getUserId().toString());
		model.addAttribute("cdate",new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		return null;
	}
	@RequestMapping(value = "/barcode.mm", method = { RequestMethod.GET, RequestMethod.POST })
	public String barcodePrinter(ModelMap model, HttpServletRequest request,	@RequestParam(value = "loc", required = false) String loc, HttpSession session)	throws UnknownHostException, ParseException, SocketException {
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		if(userName==null || userName=="" || userName.equalsIgnoreCase("anonymousUser")) return "redirect:login.mm";
		User user = userManager.getUser(userName,true);
		Print_Mst pm=(Print_Mst)session.getAttribute("Print_Mst");
		String companysift=cmyshft.get(user.getUserId().toString());
		model.addAttribute("pm", pm);
		/*model.addAttribute("partbarcode", pm.getPnt_bar_cd());
		model.addAttribute("partdes", pm.getPnt_prt_des());
		model.addAttribute("slzno", pm.getPnt_srz_no());*/
		model.addAttribute("cdate",new SimpleDateFormat("yyyy-MM-dd").format(pm.getPnt_dt()));
		return null;
	}
	@RequestMapping(value = "/barcodeprint2.mm", method = { RequestMethod.GET, RequestMethod.POST })
	public String barcodeprint2(ModelMap model, HttpServletRequest request,	@RequestParam(value = "loc", required = false) String loc, HttpSession session)	throws UnknownHostException, ParseException, SocketException {
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		if(userName==null || userName=="" || userName.equalsIgnoreCase("anonymousUser")) return "redirect:login.mm";
		User user = userManager.getUser(userName,true);
		Print_Mst pm=(Print_Mst)session.getAttribute("Print_Mst");
		String companysift=cmyshft.get(user.getUserId().toString());
		model.addAttribute("pm", pm);
		/*model.addAttribute("partbarcode", pm.getPnt_bar_cd());
		model.addAttribute("partdes", pm.getPnt_prt_des());
		model.addAttribute("slzno", pm.getPnt_srz_no());*/
		model.addAttribute("cdate",new SimpleDateFormat("yyyy-MM-dd").format(pm.getPnt_dt()));
		return null;
	}
}
