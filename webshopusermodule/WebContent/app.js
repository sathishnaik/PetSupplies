
    'use strict';
    
    var appConfig = {
    		 serviceURI: "/webshopusermodule/rest/",
    		 userLoggedIn: '',
    		 categoryList:[]
    		 };
 
    angular
        .module('app', ['ngRoute','ngMessages','ngCookies', 'ngDialog']).
        config(['$routeProvider','$locationProvider', 'ngDialogProvider', function ($routeProvider, $locationProvider, ngDialogProvider) {
        	  $routeProvider.
            when('/', {
                controller: 'loginController',
                templateUrl: '/webshopusermodule/resources/login/login.html'
            })
            .when('/login', {
                controller: 'loginController',
                templateUrl: '/webshopusermodule/resources/login/login.html',
            })
            .when('/logout', {
                controller: 'LogoutCtrl',
                templateUrl: '/webshopusermodule/resources/login/login.html',
            })
             .when('/category', {
                controller: 'categoryDetailController',
                templateUrl: '/webshopusermodule/resources/category/category.html',
            })
            .when('/category/:id', {
                controller: 'categoryDetailController',
                templateUrl: '/webshopusermodule/resources/category/category.html',
            })
            .when('/register', {
                controller: 'registerController',
                templateUrl: '/webshopusermodule/resources/login/userRegister.html',
            })
             .when('/categories', {
                controller: 'categoryController',
                templateUrl: '/webshopusermodule/resources/category/categories.html',
            }).when('/products', {
                controller: 'productController',
                templateUrl: '/webshopusermodule/resources/products/products.html',
            }) .when('/product/:id', {
                controller: 'productDetailController',
                templateUrl: '/webshopusermodule/resources/products/product.html',
            }).when('/myCart', {
                controller: 'CartController',
                templateUrl: '/webshopusermodule/resources/cart/cart.html',
            }).when('/myOrders', {
                controller: 'OrderController',
                templateUrl: '/webshopusermodule/resources/order/orders.html',
            }).when('/order/:id', {
                controller: 'orderDetailController',
                templateUrl: '/webshopusermodule/resources/order/orderdetail.html',
            })
            .otherwise({ redirectTo: '/' });
        	  
        
}]).run(['$rootScope','$location', '$cookieStore', '$http',
          function ($rootScope, $location, $cookieStore, $http) {
    // keep user logged in after page refresh
    $rootScope.globals = $cookieStore.get('globals') || {};
    if ($rootScope.globals.currentUser) {
        $http.defaults.headers.common['Authorization'] = 'Basic ' + $rootScope.globals.currentUser.authdata; // jshint ignore:line
    }
     
    	$http.get(appConfig.serviceURI+"category").success(function(data){
    		$rootScope.categoryList =data;
		}).error(function(error){
			alert("Some Error Occurred!");
		});
    	

    $rootScope.$on('$locationChangeStart', function (event, next, current) {
        // redirect to login page if not logged in
    	var restrictedPage = $.inArray($location.path(), ['/login','/register', '/categories']) === -1;
    	var nonRestrictedPage =($location.path().indexOf("/category/")=== 0||$location.path().indexOf("/product/")===0);
    	appConfig.userLoggedIn = $rootScope.globals.currentUser;
    	$rootScope.userLoggedIn = $rootScope.globals.currentUser;
    	
        if (restrictedPage && !appConfig.userLoggedIn&&!nonRestrictedPage) {
            $location.path('/login');
        }
    });
}]);;