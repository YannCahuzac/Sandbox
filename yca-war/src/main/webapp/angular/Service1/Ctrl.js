'use strict';

App.controller('Ctrl', [ '$scope', 'Srv1', function($scope, Srv1) {

	$scope.name = 'test1';
	$scope.error = 'Pas d\'erreur en cours!';

	$scope.users = [];

	$scope.fetchAllUsers = function() {
		Srv1.fetchAllUsers().then(function(d) {
			$scope.users = d;
		}, function(errResponse) {
			$scope.error = errResponse.statusText;
		});
	};

	$scope.createUser = function(nom, prenom) {
		
		var user = {
				lib1 : nom,
				lib2 : prenom
		};
		
		Srv1.createUser(user).then(function(d) {
			$scope.users = d;
		}, function(errResponse) {
			$scope.error = errResponse.statusText;
		});
	};

	$scope.fetchAllUsers();

} ]);