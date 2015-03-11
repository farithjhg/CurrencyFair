'use strict';

var myControllers = angular.module('myApp.controllers',['nvd3ChartDirectives']);

myApp.controller('ListController', ['$scope','$location','EntityFactory', 'ListFactory', 'popupService','$window',
                                  function ($scope, $location, EntityFactory, ListFactory, popupService, $window){
   
	// callback for ng-click 'createNewCurrencyFare':
    $scope.createNewCurrencyFare = function () {
        $location.path('/newCurrencyFare');
    };  
	
	// callback for ng-click 'deleteRow':
    $scope.deleteRow = function (id) {
    	if (popupService.showPopup('Really delete this?')) {
    		EntityFactory.deleteRow({ id: id });
        	$window.location.href = ''; //redirect to home
	     }    	
    };
        
	$scope.listCurrency = ListFactory.query();
}]);

myApp.controller('GraphController', ['$scope','$location','CurrencyFromFactory', 'CurrencyToFactory', 'CountryFactory','popupService','$window',
                                    function ($scope, $location, CurrencyFromFactory, CurrencyToFactory, CountryFactory, popupService, $window){
  	
    
    $scope.listCurrencyFrom = CurrencyFromFactory.getCurrencyFrom();
  	$scope.listCurrencyTo = CurrencyToFactory.getCurrencyTo();
  	$scope.listCountries = CountryFactory.getCountries();

  	$scope.xFunction = function(){
  	    return function(d) {
  	        return d.currencyCode;
  	    };
  	}
  	
  	$scope.zFunction = function(){
  	    return function(d) {
  	        return d.countryCode;
  	    };
  	}
  	
  	$scope.yFunction = function(){
  	    return function(d) {
  	        return d.count;
  	    };
  	}
}]);


myApp.controller('CurrencyFareCreateController', ['$scope','ListFactory', '$location', 
                  function ($scope, ListFactory, $location){
	// callback for ng-click 'saveNewCurrencyFare':
	$scope.saveNewCurrencyFare = function(newCurrencyFare) {
		if(newCurrencyFare.$valid){
			ListFactory.create($scope.currencyFare);
			$scope.listCurrency = ListFactory.query();
	        $location.path('#/list');
		}
	};
  
}]);