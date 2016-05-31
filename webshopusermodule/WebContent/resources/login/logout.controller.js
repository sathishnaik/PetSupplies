(function(){
    'use strict';
    
    angular.module('app').controller('LogoutCtrl', LogoutCtrl);
    
    LogoutCtrl.$inject = ['$location', 'AuthenticationService'];
    
    function LogoutCtrl($location, AuthenticationService){
        (function logout(){
        	AuthenticationService.ClearCredentials();
            $location.path('/login');
        })();
    }
})();