'use strict';
  
angular.module('app')
.factory('OrderService',['$http', function ($http) {
        var service = {};
        
        service.saveOrder = function(order){
        	 return $http.post(appConfig.serviceURI+"UserOrder",order);
		}
        
        service.saveOrderDetail = function(orderDetail){
       	 return $http.post(appConfig.serviceURI+"UserOrder/detail",orderDetail);
		}
        
        service.getCartsByUserId = function (userid, callback) {
        	$http.get(appConfig.serviceURI+"UserCart/userid/"+userid).success(function(data){
    			 callback(data);
    		}).error(function(error){
    			alert("Some Error Occurred!");
    		});
        };
        
        service.getAllOrders = function (callback) {
        	$http.get(appConfig.serviceURI+"UserOrder").success(function(data){
    			 callback(data);
    		}).error(function(error){
    			alert("Some Error Occurred!");
    		});
        };
        
        service.getOrderDetailsByOrderId = function (orderid, callback) {
        	$http.get(appConfig.serviceURI+"UserOrder/orderid/"+orderid).success(function(data){
    			 callback(data);
    		}).error(function(error){
    			alert("Some Error Occurred!");
    		});
        };
        
        
        return service;
    }]);
  
