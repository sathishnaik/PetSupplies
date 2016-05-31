'use strict';
  
angular.module('app')
.factory('CategoryService',['$http', function ($http) {
        var service = {};
        service.getAllCategories = function (callback) {
        	$http.get(appConfig.serviceURI+"category").success(function(data){
    			 callback(data);
    		}).error(function(error){
    			alert("Some Error Occurred!");
    		});
        };
        
        service.saveCategory = function(category){
        	 return $http.post(appConfig.serviceURI+"category",category);
		}
        
        service.deleteCategory = function(id){
       	 return $http.delete(appConfig.serviceURI+"category/"+id);
		}
        
        service.getCategoryById = function(id,callback){
        	if(id>0){
        	 $http.get(appConfig.serviceURI+"category"+"/"+id).success(function(data){
        		 callback(data);
     		}).error(function(error){
     			alert("Some Error Occurred!");
     		});
        	}
		}
        
       
        return service;
    }]);
  
