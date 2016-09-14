angular.module('penulisan')
    .controller('KebudayaanController', function ($scope, KebudayaanService) {

        $scope.dataKebudayaan = {};
        $scope.inputDataKebudayaan = {};

        KebudayaanService.getKebudayaans().success(function (data) {
            $scope.dataKebudayaan = data;
        });

        function refreshData() {
            KebudayaanService.getKebudayaans().success(function (data) {
                $scope.dataKebudayaan = data;
            });
        }

        $scope.tambahKebudayaan = function () {
            $scope.enable = true;
            $scope.inputDataKebudayaan = {};
        };

        $scope.simpanKebudayaan = function (k) {
            KebudayaanService.simpanKebudayaan(k).success(function (data) {
                alert(data.Info);
                refreshData();
            });
        };

        $scope.editKebudayaan = function (k) {
            $scope.inputDataKebudayaan.idKebudayaan = k.idKebudayaan;
            $scope.inputDataKebudayaan.judulKebudayaan = k.judulKebudayaan;
            $scope.inputDataKebudayaan.kategori = k.kategori;
            $scope.inputDataKebudayaan.provinsi = k.provinsi;
            $scope.enable = false;
        };

        $scope.updateKebudayaan = function (k) {
            KebudayaanService.updateKebudayaan(k).success(function (data) {
                alert(data.Info);
                refreshData();
            });
        };

        $scope.hapusKebudayaan = function (id) {
            KebudayaanService.hapusKebudayaan(id).success(function (data) {
                alert(data.Info);
                refreshData();
            });
        };

    });
