'use strict';

define([], function() {
    app.controller('PayController', function($scope, $rootScope) {
        $rootScope.activeTab = 'pay';
    });
    return {
        templateUrl: 'pay/pay.html',
        controller: 'PayController'
    };
});

