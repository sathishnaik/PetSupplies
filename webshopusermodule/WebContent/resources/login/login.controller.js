(function(){
	
	var angularApp = angular.module("app").controller('loginController',
		    ['$scope', '$rootScope', '$location', 'AuthenticationService','CategoryService',
		    function ($scope, $rootScope, $location, AuthenticationService,CategoryService) {
		        // reset login status
		        AuthenticationService.ClearCredentials();
		        
		        $scope.categoryList = getAllCategories();
		  
		        $scope.login = function (user) {
		            $scope.dataLoading = true;
		            AuthenticationService.Login(user.username, user.password, function(response) {
		                if(response.success) {
		                    AuthenticationService.SetCredentials(user.username, user.password,response.user.id);
		                    $scope.userLoggedIn = true;
		                    $location.path('/categories');
		                } else {
		                	$scope.status  = response.message;
		                    $scope.dataLoading = false;
		                }
		            });
		        };
		        
		        $scope.logout = function () {
		            $scope.dataLoading = false;
		            $scope.userLoggedIn = false;
		            AuthenticationService.ClearCredentials();
		            $location.path('/login');
		        };
		        
		        $scope.rigister = function () {
		  		  $location.path('/register');
		       };
		       
		       function getAllCategories(){
		  		 CategoryService.getAllCategories(function(response) {
		  			$scope.categoryList = response;
		          });
		  	}
		       
		    }]);
	
	
	
	
	
	/*function getAllUsers($scope,$http){
		$http.get(serviceURI+"users").success(function(data){
			alert(serviceURI+"users");
			alert(data);
			$scope.users = data;
		}).error(function(error){
			alert("Some Error Occurred!");
		});
	}*/
	
})();