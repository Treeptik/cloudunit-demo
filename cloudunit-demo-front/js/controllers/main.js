'use strict';

/**
 * @ngdoc function
 * @name cloudunitDemoApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the cloudunitDemoApp
 */
angular.module('cloudunitDemoApp').controller('mainCtrl', function($scope, $stomp, $log, $mdToast) {
			
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
	

  
   $scope.options = {
    rowHeight: 50,
    headerHeight: 50,
    footerHeight: false,
    scrollbarV: false
  };

  $scope.data = [
	{
		name: "5m Co",
		price: 0.76,
		change: 0.1,
		shares: 100,
		value: 10
	},
	{
		name: "3m Co",
		price: 0.6,
		change: 0.1,
		shares: 100,
		value: 10
	},
  ];
	 $scope.nutritionList = [
            {
                id: 601,
                name: 'Frozen joghurt',
                calories: 159,
                fat: 6.0,
                carbs: 24,
                protein: 4.0,
                sodium: 87,
                calcium: '14%',
                iron: '1%'
            },
            {
                id: 602,
                name: 'Ice cream sandwitch',
                calories: 237,
                fat: 9.0,
                carbs: 37,
                protein: 4.3,
                sodium: 129,
                calcium: '84%',
                iron: '1%'
            },
            {
                id: 603,
                name: 'Eclair',
                calories: 262,
                fat: 16.0,
                carbs: 24,
                protein: 6.0,
                sodium: 337,
                calcium: '6%',
                iron: '7%'
            },
            {
                id: 604,
                name: 'Cupkake',
                calories: 305,
                fat: 3.7,
                carbs: 67,
                protein: 4.3,
                sodium: 413,
                calcium: '3%',
                iron: '8%'
            },
            {
                id: 605,
                name: 'Gingerbread',
                calories: 356,
                fat: 16.0,
                carbs: 49,
                protein: 2.9,
                sodium: 327,
                calcium: '7%',
                iron: '16%'
            },
            {
                id: 606,
                name: 'Jelly bean',
                calories: 375,
                fat: 0.0,
                carbs: 94,
                protein: 0.0,
                sodium: 50,
                calcium: '0%',
                iron: '0%'
            },
            {
                id: 607,
                name: 'Lollipop',
                calories: 392,
                fat: 0.2,
                carbs: 98,
                protein: 0,
                sodium: 38,
                calcium: '0%',
                iron: '2%'
            },
            {
                id: 608,
                name: 'Honeycomb',
                calories: 408,
                fat: 3.2,
                carbs: 87,
                protein: 6.5,
                sodium: 562,
                calcium: '0%',
                iron: '45%'
            },
            {
                id: 609,
                name: 'Donut',
                calories: 452,
                fat: 25.0,
                carbs: 51,
                protein: 4.9,
                sodium: 326,
                calcium: '2%',
                iron: '22%'
            },
            {
                id: 610,
                name: 'KitKat',
                calories: 518,
                fat: 26.0,
                carbs: 65,
                protein: 7,
                sodium: 54,
                calcium: '12%',
                iron: '6%'
            }
        ];	
	/*		
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
	})*/
	
});
