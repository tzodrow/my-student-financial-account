'use strict';
define( [ 'history/history', 'home/home', 'login/login', 'pay/pay', 'settings/settings', 'summary/summary', 'users/users' ],
	function( history, home, login, pay, settings, summary, users ) {

	app.config(['$routeProvider', function($routeProvider) {
		$routeProvider
			.when('/history', history)
			.when('/home', home)
			.when('/login', login)
			.when('/pay', pay)
			.when('/settings', settings)
			.when('/summary/', summary)
			.when('/summary/:pvi*', summary)
			.when('/users', users)
			.otherwise({
				redirectTo: '/summary'
			});
	}]);

	app.directive('tabs', function() {
		return {
			restrict: 'E',
			templateUrl: 'partials/tabs.html'
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

});