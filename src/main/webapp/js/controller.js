'use strict';

var myControllers = angular.module('myApp.controllers',[]);

myApp.controller('ListController', ['$scope','$location','EntityFactory', 'ListFactory','popupService','$window',
                                  function ($scope, $location, EntityFactory, ListFactory, popupService, $window){
    // callback for ng-click 'createNewCurrencyFare':
    $scope.createNewCurrencyFare = function () {
        $location.path('/newCurrencyFare');
    };  
	
	$scope.listCurrency = ListFactory.query();
}]);

myApp.controller('GraphController', ['$scope','$location','CurrencyFromFactory', 'CurrencyToFactory', 'CountryFactory','popupService','$window',
                                    function ($scope, $location, CurrencyFromFactory, CurrencyToFactory, CountryFactory, popupService, $window){
  	
  	$scope.listCurrencyFrom = CurrencyFromFactory.getCurrencyFrom();
  	$scope.listCurrencyTo = CurrencyToFactory.getCurrencyTo();
  	$scope.listCountries = CountryFactory.getCountries();
}]);


myApp.controller('CurrencyFareCreateController', ['$scope','ListFactory', '$location', 
                  function ($scope, ListFactory, $location){
	// callback for ng-click 'saveNewCurrencyFare':
	$scope.saveNewCurrencyFare = function() {
		ListFactory.create($scope.currencyFare);
		$scope.listCurrency = ListFactory.query();
        $location.path('#/list');
	};
  
}]);

function getDataInChartFormat(currencyFrom) {
    var currencyColumns = [];
    $.each(currencyFrom, function (index) {
        var data = [currencyFrom[index].currencyCode, currencyFrom[index].count];
        currencyColumns.push(data);
    });
    return currencyColumns;
}