'use strict';

(function () {
    angular.module('app.pay', [])
        .directive('pay', function() {
            return {
                restrict: 'E',
                templateUrl: '/pay/pay.html'
            }
        })
})();