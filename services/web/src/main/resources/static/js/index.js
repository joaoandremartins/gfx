var module = angular.module('gfx', []);
module.controller('listBuyOrders', function($scope, $http) {
    $http.get('/listBuyOrders').success(function(data) {
        $scope.orders = data;
    })
});

module.controller('listSellOrders', function($scope, $http) {
    $http.get('/listSellOrders').success(function(data) {
        $scope.orders = data;
    })
})