'use strict';

define(['angular', 'require'], function(angular, require) {

    var app = angular.module('my-app.settings', []);
    app.controller('SettingsController', function($scope, $rootScope) {
        $rootScope.activeTab = 'settings';
    });

    app.route = {
        templateUrl: require.toUrl('./settings.html'),
        controller: 'SettingsController'
    };

    return app;

});

