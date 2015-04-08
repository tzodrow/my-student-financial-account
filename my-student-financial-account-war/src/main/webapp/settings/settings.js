'use strict';

define([], function() {
    app.controller('SettingsController', function($scope, $rootScope) {
        $rootScope.activeTab = 'settings';
    });
    return {
        templateUrl: 'settings/settings.html',
        controller: 'SettingsController'
    };
});

