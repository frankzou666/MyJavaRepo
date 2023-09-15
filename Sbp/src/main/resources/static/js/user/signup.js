/**
 * 
 */

 //load function
 
 $(function(){
	 //update button click
	$("#signupbyRest").click(function(event){
		signupUser();
		
	});


	 
 });
 
 
 //update user
 function signupUser(){
	 //user jquery,get data from form;
	 var signup_form = $("#signup-form").serializeArray();
	 $.ajax({
		 url:"/user/signup/rest",
		 type:"POST",
		 data:signup_form,
		 datetype:"json",
		 cache:false
	 }).done(function(data){
		 if (data.result==90){
			 alert("signup user valid error")
		 }
		 //alert("signup user done!");
		// window.location.href="/login";
	 }).fail(function(data){
		 alert("update user fail");
	 }).always(function(){
		 
	 })
	 
 };
 
 
