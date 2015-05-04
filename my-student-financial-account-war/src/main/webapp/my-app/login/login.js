'use strict';

define(['angular', 'require'], function(angular, require) {

    var app = angular.module('my-app.login', []);
    app.controller('LoginController', function($scope, $rootScope) {
        $rootScope.activeTab = 'login';
    });

    app.route = {
        templateUrl: require.toUrl('./login.html'),
        controller: 'LoginController'
    };

    return app;

});

