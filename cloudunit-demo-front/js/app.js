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
      'ngRoute', 'ngMaterial', 'ngStomp'
  ])
  .config(function ($routeProvider) {
	$routeProvider.when('/', {
		templateUrl : 'views/main.html',
		controller : 'mainCtrl',
		controllerAs: 'controller'
	}).otherwise('/');

	//$httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';

  });
