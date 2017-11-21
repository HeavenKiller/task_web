demoApp.factory('baseFactory', function ($http, $q) {
    var service = {};
    service.getDatas = function(url, data){
        var defer = $q.defer();

        $http({
            method: 'post',
            url : url,
            data : data
        }).then(function successCallback(response){
                defer.resolve(response);
            }, function errorCallback(response){
                defer.reject("error");
        });

        return defer.promise;
    }
    return service;
});

demoApp.factory('fileReader', ['$q', function($q){
    var onLoad = function (reader, deferred, scope) {
        return function(){
            scope.$apply(function(){
                deferred.resolve(reader.result);
            });
        }
    };

    var onError = function(reader, deferred, scope){
        return function(){
            scope.$apply(function(){
                deferred.reject(reader.result);
            });
        }
    };

    var getReader = function(defferred, scope){
        var reader = new FileReader();
        reader.onload = onLoad(reader,defferred,scope);
        reader.onerror = onError(reader,defferred,scope);

        return reader;
    };

    var readAsDataURL = function(file, scope){
        var deferred = $q.defer();
        var reader = getReader(deferred, scope);
        reader.readAsDataURL(file);
        return deferred.promise();
    };

    return {
        readAsDataUrl : readAsDataURL()
    };

}]);
















