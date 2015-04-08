'use strict';

define([], function() {
    app.controller('LoginController', function($scope, $rootScope) {
        $rootScope.activeTab = 'login';
    });
    return {
        templateUrl: 'login/login.html',
        controller: 'LoginController'
    };
});

