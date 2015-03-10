  'use strict';
    
var myApp = angular.module('myApp', ['ngRoute', 'ngResource', 'myApp.services', 'myApp.controllers']);

myApp.config(function($routeProvider) {
    $routeProvider
	    .when('/list', {
	        controller: 'ListController',
	        templateUrl: 'view/list.html',
        	resolve: {
        	      // I will cause a 1 second delay
        	      delay: function($q, $timeout) {
        	        var delay = $q.defer();
        	        $timeout(delay.resolve, 500);
        	        return delay.promise;
        	      }
        	}
	    })
	    .when('/graphs', {
	        controller: 'GraphController',
	        templateUrl: 'view/graphs.html'
	    })
	    .when('/newCurrencyFare', {
	        controller: 'CurrencyFareCreateController',
	        templateUrl: 'view/newCurrencyFare.html'
	    })	    
        .otherwise({redirectTo: '/list'});
});