package com.myfirstproject.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.util.UrlUtils;
import org.springframework.util.Assert;

import com.myfirstproject.Service.UserManager;
import com.myfirstproject.entity.User;



public class AuthFailureHandler implements AuthenticationFailureHandler  {
	 protected final Log logger = LogFactory.getLog(getClass());

	    private String defaultFailureUrl;
	    private boolean forwardToDestination = false;
	    private boolean allowSessionCreation = true;
	    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	    public AuthFailureHandler() {
	    }

	    public AuthFailureHandler(String defaultFailureUrl) {
	        setDefaultFailureUrl(defaultFailureUrl);
	    }
	@Autowired
	private UserManager adminManager;
	
	
	
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException exception) throws IOException, ServletException{
		
		String username = request.getParameter("j_username");
//enable only the down line
		User user = adminManager.getUser(username);
		Integer count = null;
//		if(user != null){
//		count = user.getLoginFailureCount();
//		 if (count == null){
//		 count=1;
//		 }else{
//		 count = count +1;
//		 }
//		user.setLoginFailureCount(count);
//		userManager.mergeUser(user);
//		}
		 if (defaultFailureUrl == null) {
	            logger.debug("No failure URL set, sending 401 Unauthorized error");

	            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Authentication Failed: " + exception.getMessage());
	        } else {
	        	String failureUrl = defaultFailureUrl +"1";
	        	if(count != null && count >= 3){
	        		failureUrl  = defaultFailureUrl +"3";
	        	}
	        	
	            saveException(request, exception);

	            if (forwardToDestination) {
	                logger.debug("Forwarding to " + failureUrl);

	                request.getRequestDispatcher(failureUrl).forward(request, response);
	            } else {
	                logger.debug("Redirecting to " + failureUrl);
	                redirectStrategy.sendRedirect(request, response, failureUrl);
	            }
	        }
	}
	 protected final void saveException(HttpServletRequest request, AuthenticationException exception) {
	        if (forwardToDestination) {
	            request.setAttribute(WebAttributes.AUTHENTICATION_EXCEPTION, exception);
	        } else {
	            HttpSession session = request.getSession(false);

	            if (session != null || allowSessionCreation) {
	                request.getSession().setAttribute(WebAttributes.AUTHENTICATION_EXCEPTION, exception);
	            }
	        }
	    }

	    /**
	     * The URL which will be used as the failure destination.
	     *
	     * @param defaultFailureUrl the failure URL, for example "/loginFailed.jsp".
	     */
	    public void setDefaultFailureUrl(String defaultFailureUrl) {
	        Assert.isTrue(UrlUtils.isValidRedirectUrl(defaultFailureUrl),
	                "'" + defaultFailureUrl + "' is not a valid redirect URL");
	        this.defaultFailureUrl = defaultFailureUrl;
	    }

	    protected boolean isUseForward() {
	        return forwardToDestination;
	    }

	    /**
	     * If set to <tt>true</tt>, performs a forward to the failure destination URL instead of a redirect. Defaults to
	     * <tt>false</tt>.
	     */
	    public void setUseForward(boolean forwardToDestination) {
	        this.forwardToDestination = forwardToDestination;
	    }

	    /**
	     * Allows overriding of the behaviour when redirecting to a target URL.
	     */
	    public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
	        this.redirectStrategy = redirectStrategy;
	    }

	    protected RedirectStrategy getRedirectStrategy() {
	        return redirectStrategy;
	    }

	    protected boolean isAllowSessionCreation() {
	        return allowSessionCreation;
	    }

	    public void setAllowSessionCreation(boolean allowSessionCreation) {
	        this.allowSessionCreation = allowSessionCreation;
	    }
			
	
	
}
