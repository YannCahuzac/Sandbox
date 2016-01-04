'use strict';
 
App.factory('Srv1', ['$http', '$q', function($http, $q){
    return {
            fetchAllUsers: function() {
                    return $http.get('http://localhost:8080/yca-war/action/user/')
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while fetching users');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
            createUser: function(user){
                    return $http.post('http://localhost:8080/yca-war/action/createUser/', user)
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while creating user');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
            updateUser: function(user, id){
                    return $http.put('http://localhost:8080/yca-war/action/user/'+id, user)
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while updating user');
                                        return $q.reject(errResponse);
                                    }
                            );
            }         
    };
}]);