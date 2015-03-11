'use strict';

var myControllers = angular.module('myApp.controllers',['nvd3ChartDirectives']);

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

  	$scope.xFunction = function(){
  	    return function(d) {
  	        return d.currencyCode;
  	    };
  	}
  	$scope.yFunction = function(){
  	    return function(d) {
  	        return d.count;
  	    };
  	}
  	
	//var dataForCurrencyFrom = getDataInChartFormat($scope.listCurrencyFrom);
    //var dataForCurrencyTo = getDataInChartFormat(data.currencyTo);
    //var dataForOriginCountry = getDataInChartFormat(data.originCountry);
    //var timeSeriesData = getDataInTimeSeriesFormat(data.createdOn);
    //generateDonutChart("#currencyFromChart", dataForCurrencyFrom);
    //generateDonutChart("#currencyToChart", dataForCurrencyTo);
    //generateDonutChart("#originCountry", dataForOriginCountry);
    //generateTimeSeriesChart("#createOn", timeSeriesData);
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

var generateDonutChart = function (binder, columns) {
    var chart = c3.generate({
        bindto: binder,
        data: {
            columns: columns,
            type: 'donut'
        }
    });

};



function getDataInChartFormat(currencyFrom) {
    var currencyColumns = [];
    currencyColumns = [{'currencyCode':'EUR', 'count':'8'},
                       {'currencyCode':'JPY', 'count':'4'},
                       {'currencyCode':'USD', 'count':'7'}
                       ];
    /*
    $.each(currencyFrom, function (index) {
        var data = [currencyFrom[index].currencyCode, currencyFrom[index].count];
        currencyColumns.push(data);
    });
    */
    return currencyColumns;
}