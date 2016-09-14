angular.module('penulisan')
  .controller('KebudayaanController', function($scope, KebudayaanService) {

    $scope.dataKebudayaan = {};

    KebudayaanService.getKebudayaans().success(function(data) {
      $scope.dataKebudayaan = data;
    });

  });
