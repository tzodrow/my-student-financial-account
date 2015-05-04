'use strict';

define(['angular', 'require'], function(angular, require) {

	var app = angular.module('my-app.pay', []);
    app.controller('PayController', function($scope, $rootScope) {
        $rootScope.activeTab = 'pay';
    });

    app.route = {
        templateUrl: require.toUrl('./pay.html'),
        controller: 'PayController'
    };

    return app;

});

