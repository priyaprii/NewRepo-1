<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<sec:authorize ifNotGranted="IS_AUTHENTICATED_ANONYMOUSLY">
	<c:redirect url="/login.mm"/>
</sec:authorize>
<sec:authorize ifAllGranted="IS_AUTHENTICATED_ANONYMOUSLY">
	<c:redirect url="/login.mm"/>
</sec:authorize>	



