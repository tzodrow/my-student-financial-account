'use strict';

define([], function() {
    app.controller('UsersController', function($scope, $rootScope) {
        $rootScope.activeTab = 'users';
    });
    return {
        templateUrl: 'users/users.html',
        controller: 'UsersController'
    };
});

