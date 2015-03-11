'use strict';
/* Services */

var services = angular.module('myApp.services', ['ngResource']);

services.service('popupService',function($window){
    this.showPopup=function(message){
        return $window.confirm(message);
    }
});

services.factory('ListFactory', function ($resource) {
    return $resource('/CurrencyFair/rest/services', {}, {
        query: { method: 'GET', isArray: true },
        create: { method: 'POST' }
    })
});

services.factory('CurrencyFromFactory', function ($resource) {
    return $resource('/CurrencyFair/rest/services/getCurrencyFromGroupByCode', {}, {
    	getCurrencyFrom: { method: 'GET', isArray: true }
    })
});

services.factory('CurrencyToFactory', function ($resource) {
    return $resource('/CurrencyFair/rest/services/getCurrencyToGroupByCode', {}, {
    	getCurrencyTo: { method: 'GET', isArray: true }
    })
});

services.factory('CountryFactory', function ($resource) {
    return $resource('/CurrencyFair/rest/services/getCountryGroupByCode', {}, {
    	getCountries: { method: 'GET', isArray: true }
    })
});

services.factory('NewRowFactory', function ($resource) {
    return $resource('/CurrencyFair/rest/services/getNewId', {}, {
    	getNewId: { method: 'GET' }
    })
});


services.factory('EntityFactory', function ($resource) {
    return $resource('/CurrencyFair/rest/services/:id', {}, {
        show: { method: 'GET' },
        updateRow: { method: 'PUT'},
        deleteRow: { method: 'DELETE', params: {id: '@id'} }
    })
});