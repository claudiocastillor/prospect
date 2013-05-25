<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<%@ taglib uri="/struts-dojo-tags" prefix="sx"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

  <head>
    <meta charset="utf-8">
    <title>Prospect-CRM CIISA</title>
    <meta name="description" content="">
    <meta name="author" content="Claudio Castillo">
	 
	<script src="assets/FusionCharts/FusionCharts.js"></script>
	
    <!-- Le styles -->
    
    <link href="assets/css/bootstrap.css" rel="stylesheet">
    <style type="text/css">
      body {
        padding-top: 60px;
        padding-bottom: 40px;
      }
      .sidebar-nav {
        /*padding: 9px 0;*/
      } 
    
    </style>
    <!--[if gte IE 9]>
		<style>
			.ie_show { display:block }
			.ie_hide { display:none }
		</style>
	<![endif]-->
	
    <link href="assets/css/bootstrap-responsive.css" rel="stylesheet"> 
    <link href="assets/css/bootstrap-modal-print.css" rel="stylesheet"> 
    
    
    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <!-- Le fav and touch icons -->
    <link rel="shortcut icon" href="assets/ico/favicon.ico" type="image/x-icon">
	<link rel="icon" href="assets/ico/favicon.ico" type="image/x-icon">
    
    <sb:head/>
     
  </head>
 
<body>

<div class="navbar navbar-fixed-top" style="height:40px; max-height: 40px;">
	<div class="navbar-inner" style="height:40px; max-height: 40px;">
	    <div class="container" style="height:40px; max-height: 40px;">
	      <a href="#" class="brand">Prospect-CRM</a>
	      	<%@ include file="navbar.jsp" %>
	    </div>
	</div>
</div>
<div class="container">
	<div class="row" style="min-height: 450px;">