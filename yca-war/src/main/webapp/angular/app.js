'use strict';

var App = angular.module('ycaAngular', ['ui.router']);

App.config(function($stateProvider, $urlRouterProvider) {

    $stateProvider
    .state('home', {
        url: '/',
        templateUrl: 'Service1/Ctrl.html',
        controller: 'Ctrl'
    });

	$urlRouterProvider.otherwise('/');

});