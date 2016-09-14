angular.module('penulisan', ['ngRoute', 'base64', 'ngCookies', 'ngSanitize'])
    .config(['$locationProvider', '$routeProvider', function config($locationProvider, $routeProvider) {

        $routeProvider
            .when('/', {
                templateUrl: '/angular/admin/template/home.html'
            })
            .when('/kebudayaan', {
                templateUrl: '/angular/admin/template/kebudayaan.html',
                controller: 'KebudayaanController'
            })
            .otherwise('/');

    }]);
