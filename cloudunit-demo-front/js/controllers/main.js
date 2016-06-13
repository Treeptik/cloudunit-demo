'use strict';

/**
 * @ngdoc function
 * @name cloudunitDemoApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the cloudunitDemoApp
 */
angular.module('cloudunitDemoApp').controller('mainCtrl', function($scope, $stomp, $log) {
			
	var self = this;
	console.log("mainCtrl initialize ok");
			
	$scope.compagnies = [
   		{
			name: "3m Co",
			price: 0.76,
			change: 0.1,
			shares: 100,
			value: 19
		},
   		{
			name: "Microsoft",
			price: 0.76,
			change: 0.1,
			shares: 100,
			value: 19
		},
   		{
			name: "IBM",
			price: 0.76,
			change: 0.1,
			shares: 100,
			value: 19
		},		
	]		
			
	$stomp.setDebug(function (args) {
		$log.debug(args)
	})
	var connectHeaders = {"login":"superadmin","passcode":"12345678"};
	$stomp
	.connect('/endpoint', connectHeaders)

	// frame = CONNECTED headers
	.then(function (frame) {
		var subscription = $stomp.subscribe('/dest', function (payload, headers, res) {
		$scope.payload = payload
		}, {
		'headers': 'are awesome'
		})

		// Unsubscribe
		subscription.unsubscribe()

		// Send message
		$stomp.send('/dest', {
		message: 'body'
		}, {
		priority: 9,
		custom: 42 // Custom Headers
		})

		// Disconnect
		$stomp.disconnect(function () {
		$log.info('disconnected')
		})
	})
	
});
