'use strict';

(function () {
    angular.module('app.users', [])
        .directive('users', function() {
            return {
                restrict: 'E',
                templateUrl: '/users/users.html'
            }
        })
})();