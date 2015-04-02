'use strict';

(function() {

	app.config(['$routeProvider', function($routeProvider) {
			$routeProvider.when('/default', {
				templateUrl: 'my-app.html'
			}).when('/history', {
				templateUrl: 'history/history.html'
			}).when('/login', {
				templateUrl: 'login/login.html'
			}).when('/pay', {
				templateUrl: 'pay/pay.html'
			}).when('/settings', {
				templateUrl: 'settings/settings.html'
			}).when('/summary', {
				templateUrl: 'summary/summary.html'
			}).when('/users', {
				templateUrl: 'users/users.html'
			}).otherwise({
				redirectTo: '/default'
			});
		}
	]);

})();