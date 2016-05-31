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
        
        service.saveProduct = function(product){
       	 return $http.post(appConfig.serviceURI+"products",product);
		}
       
       service.deleteProduct = function(id){
      	 return $http.delete(appConfig.serviceURI+"products/"+id);
		}
       
       service.getProductById = function(id, callback){
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
  
