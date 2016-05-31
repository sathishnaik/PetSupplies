(function () {
    'use strict';

    var angularApp = angular.module("app");
	
	angularApp.controller("orderDetailController",[ '$scope','$routeParams','OrderService',
	                       function( $scope, $routeParams, OrderService){
		
		$scope.orderDetailList=[];
		OrderService.getOrderDetailsByOrderId($routeParams.id, function(list) {
			 $scope.orderDetailList = list;
         });
		
	}]);
})();