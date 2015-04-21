'use strict';

define(['angular', 'require'], function(angular, require) {

    var app = angular.module('my-app.home', []);
    app.controller('HomeController', function($scope, $rootScope) {
        $rootScope.activeTab = 'home';
    });

    app.route = {
        templateUrl: require.toUrl('./home.html'),
        controller: 'HomeController'
    };

    return app;

});

