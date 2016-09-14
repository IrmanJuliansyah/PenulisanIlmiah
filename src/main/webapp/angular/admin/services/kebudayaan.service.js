angular.module('penulisan')
    .service('KebudayaanService', function ($http, $base64, $cookies) {
        return {
            getKebudayaans: function () {
                return $http({
                    method: 'GET',
                    url: '/api/kebudayaan',
                    headers: {
                        'Content-Type': 'application/json',
                        'Authorization': 'Basic ' + $base64.encode($base64.decode($cookies.get('email')) + ':' + $base64.decode($cookies.get('password')))
                    }
                });
            },
            simpanKebudayaan: function (kebudayaan) {
                return $http({
                    method: 'POST',
                    url: '/api/kebudayaan',
                    headers: {
                        'Content-Type': 'application/json',
                        'Authorization': 'Basic ' + $base64.encode($base64.decode($cookies.get('email')) + ':' + $base64.decode($cookies.get('password')))
                    },
                    data: kebudayaan
                });
            },
            updateKebudayaan: function (kebudayaan) {
                return $http({
                    method: 'PUT',
                    url: '/api/kebudayaan',
                    headers: {
                        'Content-Type': 'application/json',
                        'Authorization': 'Basic ' + $base64.encode($base64.decode($cookies.get('email')) + ':' + $base64.decode($cookies.get('password')))
                    },
                    data: kebudayaan
                });
            },
            hapusKebudayaan: function (idKebudayaan) {
                return $http({
                    method: 'DELETE',
                    url: '/api/kebudayaan/' + idKebudayaan,
                    headers: {
                        'Content-Type': 'application/json',
                        'Authorization': 'Basic ' + $base64.encode($base64.decode($cookies.get('email')) + ':' + $base64.decode($cookies.get('password')))
                    }
                });
            }
        }
    });
