'use strict';

define([], function() {
    app.controller('HomeController', function($scope, $rootScope) {
        $rootScope.activeTab = 'home';
    });
    return {
        templateUrl: 'home/home.html',
        controller: 'HomeController'
    };
});
