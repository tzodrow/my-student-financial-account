'use strict';

define([], function() {

    app.controller('UsersController', ['authorizedUsersService', '$scope', '$rootScope', function(authorizedUsersService, $scope, $rootScope) {
        $rootScope.activeTab = 'users';

        $scope.authorize = function(user) {
            console.log(user);
            console.log(authorizedUsersService.addAuthorizedUser(user));
        }

    }]);

    return {
        templateUrl: 'users/users.html',
        controller: 'UsersController'
    };

});

