angular.module('demo', [])
.controller('Hello', function($scope, $http) {
    $http.get('http://localhost:8090/greeting/').
        then(function(response) {
            $scope.greeting = response.data;
        });
});
