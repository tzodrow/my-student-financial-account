'use strict';

define(['angular', 'require'], function(angular, require) {

    var app = angular.module('my-app.users', []);
    app.controller('UsersController', ['authorizedUsersService', '$scope', '$rootScope', function(authorizedUsersService, $scope, $rootScope) {
        $rootScope.activeTab = 'users';
        $scope.authorize = function(user) {
            console.log(user);
            console.log(authorizedUsersService.addAuthorizedUser(user));
        }
    }]);

    app.route = {
        templateUrl: require.toUrl('./users.html'),
        controller: 'UsersController'
    };

    return app;

});

