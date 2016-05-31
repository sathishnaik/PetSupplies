(function () {
    'use strict';

    var angularApp = angular.module("app");
	
	angularApp.controller("productDetailController",['$rootScope', '$scope','$routeParams','ProductService','CategoryService','CartService',
	                       function($rootScope, $scope, $routeParams, ProductService, CategoryService,CartService){
		
		$scope.product={};
		$scope.cart={};
		
		ProductService.getProductById($routeParams.id, function(product) {
			 $scope.product = product;
			 CategoryService.getCategoryById(product.categoryId, function(categoryresponse) {
				 $scope.product.category = categoryresponse;
		         });
         });
		
		 
		  
		  $scope.addToCart = function(cart, product){
			  cart.product=product;
			  cart.userId= $rootScope.userLoggedIn.userid;
			  cart.totalPrice = cart.productQuantity * product.productPrice;
			  cart.cartCreatedDate=Date.now();
			  cart.cartStatus = 'CART_CREATED';
				  CartService.saveCart(cart).success(function (data) {
					  $scope.status = 'User Cart saved! for product: '+product.productName;
		                $scope.push(data);
			            }).error(function (error) {
			                $scope.status = 'Unable to save Cart: ' + error.message;
			            });
					}
	}]);
})();