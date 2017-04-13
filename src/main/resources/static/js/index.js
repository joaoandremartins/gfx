angular.module('gfx', [])
    .controller('home', function($scope, $http) {
        $http.get('/').success(function(data) {
            $scope.orders = data;
        })
    })