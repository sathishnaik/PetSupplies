(function () {
    'use strict';

    var angularApp = angular.module("app");
	
	angularApp.controller("OrderController",['$location','$scope','$rootScope','OrderService',
	                     function($location,$scope,$rootScope, OrderService){

		$scope.orderList = {};
		
		$scope.viewOrder = function(id){
			$location.path('/order/'+id);
			}
		
		OrderService.getAllOrdersByUserId($rootScope.userLoggedIn.userid, function(orderList) {
			 $scope.orderList = orderList;
        });
		
	}]);
	
})();