'use strict';

define([], function() {

    app.controller('SummaryController',['authorizedUsersService', 'chargeService', '$http', '$routeParams', '$scope', '$rootScope',  function(authorizedUsersService, chargeService, $http, $routeParams, $scope, $rootScope) {

    	$rootScope.activeTab = 'summary';
        $scope.isSelected = function (user){
        	return $scope.selectedUser == user;
        };
        authorizedUsersService.getAuthorizedUsers().success(function(data) {
			$scope.authorizedUsers = data;
			if($scope.authorizedUsers.length > 0){
	        	if($routeParams.pvi != undefined){
	            	for(var i=0; i < $scope.authorizedUsers.length;i++ ){
	            		if($scope.authorizedUsers[i].pvi == $routeParams.pvi){
	            			$scope.selectedUser = $scope.authorizedUsers[i];
	            			$scope.authorizedUsers[i].selected = true;
	            		}else{
	            			$scope.authorizedUsers[i].selected = false;
	            		}
	            	}
	            }else{
	            	$scope.selectedUser = $scope.authorizedUsers[0];
	            	$scope.authorizedUsers[0].selected=true;
	            }
	        	chargeService.getCharges($scope.selectedUser.pvi).success(function(data) {
	            	$scope.charges = data;
	            });
	        }else{
	        	//error no authorized users found.
	        }
		});

    }]);

    return {
        templateUrl: 'summary/summary.html',
        controller: 'SummaryController'
    };
});

