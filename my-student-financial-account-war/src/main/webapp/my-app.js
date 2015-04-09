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
			.when('/summary', summary)
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

});