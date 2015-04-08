'use strict';

define([], function() {
    app.controller('HistoryController', function($scope, $rootScope) {
        $rootScope.activeTab = 'history';
    });
    return {
        templateUrl: '/history/history.html',
        controller: 'HistoryController'
    };
});
