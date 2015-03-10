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
	    .when('/newRegion', {
	        controller: 'RegionCreateController',
	        templateUrl: 'view/newRegion.html'
	    })
	    .when('/region-detail/:id', {
	        controller: 'RegionEditController',
	        templateUrl: 'view/region-detail.html'
	    })	    
        .when('/view1', {
            controller: 'dummyController',
            templateUrl: 'Partials/view1.html'
        })
        .when('/view2', {
            controller: 'dummyController',
            templateUrl: 'Partials/view2.html'
        })
        .otherwise({redirectTo: '/list'});
});