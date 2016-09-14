angular.module('penulisan')
    .controller('UserController', function ($scope, UserService) {
        $scope.dataUser = {};
        $scope.inputUser = {};


        $scope.tambahUser = function () {
            $scope.enable = true;
            $scope.inputUser = {};
        };

        $scope.simpanUser = function (k) {
            UserService.simpanUser(k).success(function (data) {
                alert(data.Info);
            });
        };
 });