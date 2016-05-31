'use strict';
  
angular.module('app')
.factory('UserService',['$http', function ($http) {
        var service = {};
        service.getAllUsers = function (callback) {
        	$http.get(appConfig.serviceURI+"users").success(function(data){
    			 callback(data);
    		}).error(function(error){
    			alert("Some Error Occurred!");
    		});
        };
        
        service.getStates = function (callback) {
        	$http.get(appConfig.serviceURI+"users/states").success(function(data){
    			 callback(data);
    		}).error(function(error){
    			alert("Some Error Occurred!");
    		});
        };
        
        service.saveUser = function(user){
       	 return $http.post(appConfig.serviceURI+"users",user);
		}
       
       service.deleteUser = function(id){
      	 return $http.delete(appConfig.serviceURI+"users/"+id);
		}
       
       service.getUserById = function(id, callback){
       	if(id>0){
       	 $http.get(appConfig.serviceURI+"users"+"/"+id).success(function(data){
       		 callback(data);
    		}).error(function(error){
    			alert("Some Error Occurred!");
    		});
       	}
		}
        return service;
    }]);
  
