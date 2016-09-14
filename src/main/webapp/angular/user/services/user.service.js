angular.module('penulisan')
        .service('UserService', function ($http) {
            return {
                simpanUser: function (user) {
                    return $http.post('/api/user', user);
                }
            };
        });