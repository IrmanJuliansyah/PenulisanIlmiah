angular.module('penulisan')
        .controller('KebudayaanDetailController', function ($scope, KebudayaanService, $routeParams) {

            $scope.dataKebudayaan = {};

            KebudayaanService.getKebudayaan($routeParams.idKebudayaan).success(function (data) {
                $scope.dataKebudayaan = data;
            });

        });

