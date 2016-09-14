angular.module('penulisan')
        .service('KebudayaanService', function ($http) {
            return {
                getKebudayaans: function () {
                    return $http.get('/api/kebudayaan');
                },
                getKebudayaan: function (id) {
                    return $http.get('/api/kebudayaan/' + id);
                }
            }
        });

