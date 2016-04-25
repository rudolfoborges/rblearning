(function(){
	'use strict';
	
	angular
		.module('angular.rblearning.controllers')
		.controller('HomeController', ['$http', 'Lessions', 'Topics', HomeController]);
	
	function HomeController($http, Lessions, Topics){
		
		var ctrl = this;
		
		ctrl.lessions = [];
		ctrl.topics = [];
		
		var currentPage = 0;
		
		function _init(){
			ctrl.lessions = Lessions.data.lessions;
			ctrl.topics = Topics.data;
		}
		
		_init();
	}
	
	
})();