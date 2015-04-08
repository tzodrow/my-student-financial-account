'use strict';

define([], function() {
    app.controller('SummaryController', function($scope, $rootScope) {
        $rootScope.activeTab = 'summary';
    });
    return {
        templateUrl: 'summary/summary.html',
        controller: 'SummaryController'
    };
});

