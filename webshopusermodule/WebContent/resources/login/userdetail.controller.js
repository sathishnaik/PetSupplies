(function () {
    'use strict';

    var angularApp = angular.module("app");
	
	angularApp.controller("registerController",['$scope','$routeParams','UserService',
	                       function($scope, $routeParams, UserService){
		
		$scope.user={};
		$scope.user.userAddress={};
		$scope.states={};
		
		UserService.getStates( function(response) {
			 $scope.states = response
			 console.log($scope.states)
        });
		
		  $scope.saveUser = function(user){
			  console.log(user);
			  console.log(user.userAddress);
			  console.log(user.userAddress.state_id);
			  UserService.saveUser(user).success(function (data) {
		                $scope.status = 'User saved successfully!';
		                $scope.user.push(data);
		            }).error(function (error) {
		                $scope.status = 'Unable to save User: ' + error.message;
		            });
				}
	}]);
})();