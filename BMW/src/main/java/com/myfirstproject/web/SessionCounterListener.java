package com.myfirstproject.web;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
 
public class SessionCounterListener implements HttpSessionListener {
	
  private static int totalActiveSessions;
 
  public static int getTotalActiveSession(){
	return totalActiveSessions;
  }
 
  @Override
  public void sessionCreated(HttpSessionEvent arg0) {
	totalActiveSessions++;
	System.out.println("sessionCreated - add one session into counter");
  }

@Override
public void sessionDestroyed(HttpSessionEvent arg0) {
	// TODO Auto-generated method stub
	
}
 
 /* @Override
  public void sessionDestroyed(HttpSessionEvent arg0) {
	totalActiveSessions--;
	System.out.println();
	HttpSession session = arg0.getSession(); 
	if(session != null && session.getAttribute("userName") != null){
	String userName = session.getAttribute("userName").toString();
	 printCounter(arg0, userName);
	
	}
	
	System.out.println("sessionDestroyed - deduct one session from counter");
  }	*/
  
/*  private void printCounter(HttpSessionEvent sessionEvent, String userName){
	  
      HttpSession session = sessionEvent.getSession();

      ApplicationContext ctx = 
            WebApplicationContextUtils.
                  getWebApplicationContext(session.getServletContext());

      UserManager userManager = 
                  (UserManager) ctx.getBean("userManager");
      User user = null;
      user = userManager.getUser(userName);
      user.setOnline(false);
      userManager.mergeUser(user);
      //counterService.printCounter(totalActiveSessions);
}
  */
}