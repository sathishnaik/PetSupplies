
    'use strict';
    
    var appConfig = {
    		 serviceURI: "/webmodule/rest/",
    		  userLoggedIn: ''
    		 };
 
    angular
        .module('app', ['ngRoute','ngMessages','ngCookies', 'ngDialog']).
        config(['$routeProvider','$locationProvider', 'ngDialogProvider', function ($routeProvider, $locationProvider, ngDialogProvider) {
        	  $routeProvider.
            when('/', {
                controller: 'loginController',
                templateUrl: '/webmodule/resources/login/login.html'
            })
            .when('/login', {
                controller: 'loginController',
                templateUrl: '/webmodule/resources/login/login.html',
            })
            .when('/logout', {
                controller: 'LogoutCtrl',
                templateUrl: '/webmodule/resources/login/login.html',
            })
             .when('/product', {
                controller: 'productDetailController',
                templateUrl: '/webmodule/resources/product/product.html',
            }).when('/product/:id', {
                controller: 'productDetailController',
                templateUrl: '/webmodule/resources/product/product.html',
            })
             .when('/category', {
                controller: 'categoryDetailController',
                templateUrl: '/webmodule/resources/category/category.html',
            })
            .when('/category/:id', {
                controller: 'categoryDetailController',
                templateUrl: '/webmodule/resources/category/category.html',
            })
            .when('/user', {
                controller: 'userDetailController',
                templateUrl: '/webmodule/resources/user/user.html',
            })
            .when('/user/:id', {
                controller: 'userDetailController',
                templateUrl: '/webmodule/resources/user/user.html',
            })
            .when('/categories', {
                controller: 'categoryController',
                templateUrl: '/webmodule/resources/category/categories.html',
            })
            .when('/products', {
                controller: 'productController',
                templateUrl: '/webmodule/resources/product/products.html',
            })
            .when('/users', {
                controller: 'userController',
                templateUrl: '/webmodule/resources/user/users.html',
            }).when('/orders', {
                controller: 'OrderController',
                templateUrl: '/webmodule/resources/order/orders.html',
            }).when('/order/:id', {
                controller: 'orderDetailController',
                templateUrl: '/webmodule/resources/order/orderdetail.html',
            })
            .otherwise({ redirectTo: '/' });
        	  
        
}]).run(['$rootScope','$location', '$cookieStore', '$http',
          function ($rootScope, $location, $cookieStore, $http) {
    // keep user logged in after page refresh
    $rootScope.globals = $cookieStore.get('globals') || {};
    if ($rootScope.globals.currentUser) {
        $http.defaults.headers.common['Authorization'] = 'Basic ' + $rootScope.globals.currentUser.authdata; // jshint ignore:line
    }

    $rootScope.$on('$locationChangeStart', function (event, next, current) {
        // redirect to login page if not logged in
    	var restrictedPage = $.inArray($location.path(), ['/login', '/home']) === -1;
    	appConfig.userLoggedIn = $rootScope.globals.currentUser;
    	$rootScope.userLoggedIn = $rootScope.globals.currentUser;
        if (restrictedPage && !appConfig.userLoggedIn) {
            $location.path('/login');
        }
    });
}]);;