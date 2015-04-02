'use strict';

(function () {
    angular.module('app.summary', [])
        .directive('summary', function() {
            return {
                restrict: 'E',
                templateUrl: '/summary/summary.html'
            }
        })
})();