'use strict';

(function () {
    angular.module('app.login', [])
        .directive('login', function() {
            return {
                restrict: 'E',
                templateUrl: '/login/login.html'
            }
        })
})();