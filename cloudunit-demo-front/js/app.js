'use strict';

/**
 * @ngdoc overview
 * @name cloudunitDemoApp
 * @description
 * # cloudunitDemoApp
 *
 * Main module of the application.
 */
angular
  .module('cloudunitDemoApp', [
      'ngRoute', 'ngMaterial', 'ngStomp', 'ngMdIcons', 'data-table'
  ])
	.constant('CONFIG', {
     baseUrl: 'http://127.0.0.1:8080'

  })
  .config(function ($routeProvider, $mdThemingProvider) {
		$mdThemingProvider.theme('default')
    	.primaryPalette('light-blue')
    	.accentPalette('light-blue');
		
		$routeProvider.when('/', {
			templateUrl : 'views/main.html',
			controller : 'mainCtrl',
			controllerAs: 'controller'
	}).otherwise('/');

	//$httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';

  });
