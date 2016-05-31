(function () {
    'use strict';

    var angularApp = angular.module("app");
	
	angularApp.controller("categoryDetailController",['$scope','$location','$routeParams','CategoryService',
	                       function($scope, $location,$routeParams, CategoryService){
		
		$scope.category={};
		$scope.categoryProductList=[];
		var fileName;
		  CategoryService.getCategoryById($routeParams.id,function(response) {
			 $scope.category = response
			 $scope.categoryProductList = $scope.category.products;
         });
		  
		  $scope.file_changed = function(element) {
			     $scope.$apply(function(scope) {
			         var photofile = element.files[0];
			         fileName=photofile.name;
			         alert(photofile.name);
			         var reader = new FileReader();
			         reader.onload = function(e) {
			            // handle onload
			         };
			         reader.readAsDataURL(photofile);
			     });
			};
		  
		  $scope.saveCategory = function(category){
			 if(!angular.isUndefined(fileName)){
				  category.categoryImagePath = fileName;
			 }
				 CategoryService.saveCategory(category).success(function (data) {
		                $scope.status = 'Category saved successfully!';
		                $scope.category.push(data);
		            }).
		            error(function (error) {
		                $scope.status = 'Unable to save Category: ' + error.message;
		            });
			}
		  
		  $scope.itemToDeleteId;
		  $scope.openModal = function (itemId) {
			    $scope.itemToDeleteId = itemId;
			    ngDialog.openConfirm({template: 'modalDialogId',
			    	className: 'ngdialog-theme-default',
					scope: $scope //Pass the scope object if you need to access in the template
					})
			};
			
			$scope.editProduct = function(id){
				$location.path('/product/'+id);
				}
	}]);
})();