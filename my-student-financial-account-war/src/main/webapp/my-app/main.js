'use strict';

define([
		'angular',
		'require',
		'./history/history',
		'./home/home',
		'./login/login',
		'./pay/pay',
		'./settings/settings',
		'./summary/summary',
		'./users/users',
		'ngRoute',
		'portal'
	],
	function(angular, require, history, home, login, pay, settings, summary, users ) {

		var app = angular.module('my-app', [
			'my-app.history',
			'my-app.home',
			'my-app.login',
			'my-app.pay',
			'my-app.settings',
			'my-app.summary',
			'my-app.users',
			'ngRoute',
			'portal'
		]);

	app.config(['$routeProvider', function($routeProvider) {
		$routeProvider
			.when('/history', history.route)
			.when('/home', home.route)
			.when('/login', login.route)
			.when('/pay', pay.route)
			.when('/settings', settings.route)
			.when('/summary/', summary.route)
			.when('/summary/:pvi*', summary.route)
			.when('/users', users.route)
			.otherwise({
				redirectTo: '/summary'
			});
	}]);

	app.directive('tabs', function() {
		return {
			restrict: 'E',
			templateUrl: require.toUrl('./partials/tabs.html')
		}
	});

	app.service('authorizedUsersService',['$http', function($http) {
		var getAuthorizedUsers = function(){
			return  $http.get('api/v1/authorized_users');
		};
		var addAuthorizedUser = function(user){
			return $http.post('api/v1/authorized_users/add', user)
				.success(function(data, status, headers, config) {
					// this callback will be called asynchronously
					// when the response is available
				})
				.error(function(data, status, headers, config) {
					// called asynchronously if an error occurs
					// or server returns response with an error status.
				});
		};
		return {
			getAuthorizedUsers: getAuthorizedUsers,
			addAuthorizedUser: addAuthorizedUser
		};
	}]);

	app.service('chargeService',[ '$http', function($http) {
		var doGetCharges = function(pvi){
			return $http.get('api/v1/charges/'+pvi);
		};
		return {
			getCharges: function(pvi){
				return doGetCharges(pvi);
			}
		}
	}]);

	return app;

});
