'use strict';

eventsApp.controller('EventController',function EventController($scope,eventData,$log,$anchorScroll,$routeParams){

	$scope.snippet = '<span style="color:red;">Hi there!</span>';
	$scope.snippetStyle = {color:'red',padding:'10px'};
	$scope.boolVal = true;
	$scope.event = eventData.getEvent($routeParams.eventId).
		$promise
			.then(
				function(event){
					$scope.event = event;
				}).
			catch(
				function(data,status,headers,config){
					$log.warn(data,status,headers(),config);
				}
			);
	/*eventData.getEvent().
		success(function(event){
			$scope.event = event;
		}).
		error(function(data,status,headers,config){
			$log.warn(data,status,headers(),config);
		});*/
	
	$scope.upVoteSession = function(session){
		session.upVoteCount++;
	};
	
	$scope.downVoteSession = function(session){
		session.upVoteCount--;
	};
	
	$scope.scrollToSession = function(){
		$anchorScroll();
	}
});
