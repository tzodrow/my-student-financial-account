'use strict';

(function () {
    angular.module('app.history', [])
        .directive('history', function() {
            return {
                restrict: 'E',
                templateUrl: '/history/history.html'
            }
        })
})();