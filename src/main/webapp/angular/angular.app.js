(function(){
	'use strict';
	
	angular
		.module('angular.rblearning', ['angular.rblearning.controllers', 'ui.router'])
		.config(['$locationProvider', '$stateProvider', '$urlRouterProvider', '$httpProvider', config])
		.run(['$rootScope', '$anchorScroll', run]);
	
	angular
		.module('angular.rblearning.controllers', []);
	
	
	function config($locationProvider, $stateProvider, $urlRouterProvider, $httpProvider) {
		$locationProvider.html5Mode(false).hashPrefix('!');
		
		$stateProvider
		
			.state('home', {
				url: "/home",
		      	cache: false,
		    	templateUrl: "views/home.html",
		    	controller: 'HomeController as ctrl',
		    	resolve: {
		    		Lessions: function($http, $rootScope){
		    			return $http.get($rootScope.apiURL('home/lessions/0'));
		    		},
		    		Topics: function($http, $rootScope){
		    			return $http.get($rootScope.apiURL('home/topics'));
		    		}
		    	}
		    });
		
		$urlRouterProvider.otherwise("/home");
	}
	
	function run($rootScope, $anchorScroll){
		
		$rootScope.apiURL = function(version, endpoint){
			if(typeof version === 'string'){
				return 'api/v' + 1 + '/' + version; 
			}
			return 'api/v' + version + '/' + endpoint;
		}
		
		$rootScope.$on("$locationChangeSuccess", function() {
            $anchorScroll();
		});
	}
	
})();