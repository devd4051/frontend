'use strict';

var eventsApp = angular.module('eventsApp', ['ngSanitize','ngResource','ngRoute'])
	.config(function($routeProvider,$locationProvider){
		$routeProvider.when('/newEvent',{
			templateUrl : 	'/static/templates/NewEvent.html',
			controller 	:	'EditEventController' 
		});
		$routeProvider.when('/events',{
			templateUrl : 	'/static/templates/EventList.html',
			controller 	:	'EventListController' 
		});
		$routeProvider.when('/event/:eventId',{
	        templateUrl: '/static/templates/EventDetails.html',
	        controller: 'EventController',
	    });
		
		$routeProvider.otherwise({redirectTo:'/'});
		
		$locationProvider.html5Mode(true);
	});
