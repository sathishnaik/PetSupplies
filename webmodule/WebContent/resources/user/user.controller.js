(function () {
    'use strict';

    var angularApp = angular.module("app");
	
	angularApp.controller("userController",['$location','$scope','$http','ngDialog','UserService',
	                     function($location,$scope,$http,ngDialog, UserService){

		$scope.userList = getAllUsers();
		$scope.itemToDeleteId;
		
		$scope.editUser = function(id){
			$location.path('/user/'+id);
			}
		
		$scope.openModal = function (itemId) {
		    $scope.itemToDeleteId = itemId;
		    ngDialog.openConfirm({
		    	template: 'modalDialogId',
		    	className: 'ngdialog-theme-default',
				scope: $scope //Pass the scope object if you need to access in the template
				})
			};
		
		$scope.deleteUser = function () {
			alert("deleteUser"+$scope.itemToDeleteId);
			UserService.deleteUser($scope.itemToDeleteId).success(function (data) {
				$scope.UserList = getAllUsers();
                $scope.status = 'Deleted User! Refreshing User list.';
            }).error(function (error) {
                $scope.status = 'Unable to delete User: ' + error.message;
            });
		    };
		
		function getAllUsers(){
			UserService.getAllUsers(function(response) {
				$scope.userList = response;
	         });
			}
	}]);
	
})();