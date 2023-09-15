/**
 * 
 */

 //load function
 
 $(function(){
	 //update button click
	$("#btn-update").click(function(event){
		updateUser();
		
	});

	$("#btn-delete").click(function(event){
		deleteUser();
		
	});

	 
 });
 
 
 //update user
 function updateUser(){
	 //user jquery,get data from form;
	 var userDetailForm = $("#user-detail-form").serializeArray();
	 $.ajax({
		 url:"/user/update",
		 type:"PUT",
		 data:userDetailForm,
		 datetype:"json",
		 cache:false
	 }).done(function(data){
		 alert("update user done!");
		 window.location.href="/user/list";
	 }).fail(function(){
		 alert("update user fail");
	 }).always(function(){
		 
	 })
	 
 };
 
 
 //delete user
 function deleteUser(){
	  var userdetailform = $("#user-detail-form").serializeArray();
	  $.ajax({
		  type:"post",
		  dataType:"JSON",
		  data:userdetailform,
		  url:"/user/delete",
		  cache:false
	  }).done(function(data){
		  console.log(data);
		  alert("delete user done");
		  window.location.href="/user/list";
	  }).fail(function(){
		  alert("delete user faile");
	  }).always(function(){
		  
	  })
	 
	 
 };