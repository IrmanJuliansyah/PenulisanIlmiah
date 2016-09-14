angular.module('penulisan', ['ngRoute', 'ngSanitize'])
        .config(['$locationProvider', '$routeProvider', function config($locationProvider, $routeProvider) {

                $routeProvider
                        .when('/', {
                            templateUrl: '/angular/user/template/index.html',
                            controller: 'KebudayaanController'
                        })
                        .when('/kebudayaan/:idKebudayaan', {
                            templateUrl: '/angular/user/template/detailKebudayaan.html',
                            controller: 'KebudayaanDetailController'
                        })
                        .when('/register', {
                            templateUrl: '/angular/user/template/register.html',
                            controller: 'UserController'
                        })
                        .otherwise('/');

            }]);