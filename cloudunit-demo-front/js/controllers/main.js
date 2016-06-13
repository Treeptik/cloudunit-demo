'use strict';

/**
 * @ngdoc function
 * @name cloudunitDemoApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the cloudunitDemoApp
 */
angular.module('cloudunitDemoApp').controller('mainCtrl', function($scope, $stomp, $log, CONFIG) {
			
	var self = this;
	$scope.sumValue = 0;
	$scope.sumShares = 0;
	
		
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

	$stomp
	.connect(CONFIG.baseUrl + '/my-socket')

	.then(function (frame) {
		var subscription = $stomp.subscribe('/topic/results', function (payload, headers, res) {
			console.log("Message reçu!");
			$scope.compagnies = res.body;
			//console.log($scope.compagnies);
			/*
			$.each($scope.compagnies,function(e) {
				$scope.sumValue += e.value;
			});*/
			
			console.log($scope.sumValue);
			
			$scope.$apply();
		})

		// Unsubscribe
		//subscription.unsubscribe()

		// Send message
		/*$stomp.send('/dest', {
		message: 'body'
		}, {
		priority: 9,
		custom: 42 // Custom Headers
		})*/
/*
		// Disconnect
		$stomp.disconnect(function () {
			$log.info('disconnected')
		})*/
	})
	
});
