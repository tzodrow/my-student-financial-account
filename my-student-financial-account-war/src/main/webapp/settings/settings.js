'use strict';

(function () {
    angular.module('app.settings', [])
        .directive('settings', function() {
            return {
                restrict: 'E',
                templateUrl: '/settings/settings.html'
            }
        })
})();