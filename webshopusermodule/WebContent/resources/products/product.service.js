'use strict';
  
angular.module('app')
.factory('ProductService',['$http', function ($http) {
        var service = {};
        service.getAllProducts = function (callback) {
        	$http.get(appConfig.serviceURI+"products").success(function(data){
    			 callback(data);
    		}).error(function(error){
    			alert("Some Error Occurred!");
    		});
        };
        
       service.getProductById = function(id, callback){
       	if(id>0){
       	 $http.get(appConfig.serviceURI+"products"+"/"+id).success(function(data){
       		 callback(data);
    		}).error(function(error){
    			alert("Some Error Occurred!");
    		});
       	}
		}
       
       service.getProductByUserId = function(id, callback){
          	if(id>0){
          	 $http.get(appConfig.serviceURI+"products"+"/"+id).success(function(data){
          		 callback(data);
       		}).error(function(error){
       			alert("Some Error Occurred!");
       		});
          	}
   		}
        return service;
    }]);
  
