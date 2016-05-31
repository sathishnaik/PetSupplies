'use strict';
  
angular.module('app')
.factory('CartService',['$http', function ($http) {
        var service = {};
        service.getCartsByUserId = function (userid, callback) {
        	$http.get(appConfig.serviceURI+"UserCart/userid/"+userid).success(function(data){
    			 callback(data);
    		}).error(function(error){
    			alert("Some Error Occurred!");
    		});
        };
        
        service.saveCart = function(cart){
        	 return $http.post(appConfig.serviceURI+"UserCart",cart);
		}
        
        service.deleteCart = function(id){
       	 return $http.delete(appConfig.serviceURI+"UserCart/"+id);
		}
        
        service.getCartById = function(id,callback){
        	if(id>0){
        	 $http.get(appConfig.serviceURI+"UserCart"+"/"+id).success(function(data){
        		 callback(data);
     		}).error(function(error){
     			alert("Some Error Occurred!");
     		});
        	}
		}
        
       
        return service;
    }]);
  
