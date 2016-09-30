eventsApp.factory('eventData', function($resource) {
	var res = $resource('data/event/:id',{id:'@id'},{"getAll": {method: "GET", isArray: true, params: {something: "foo"}}})
    return {
        /*getEvent: function(){
			return $resource({method:'GET',url:'data/event/1'});
		}*/
    	getEvent: function(eventId){
			return res.get({id:eventId});
		},
		saveEvent: function(event){
			event.id = 999;
			return res.save(event);
		},
		getAllEvents: function(){
			return res.query();
		}
    };
});