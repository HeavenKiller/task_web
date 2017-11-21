demoApp.factory('customerFactory', function($cookies, $rootScope, $state, baseFactory){
    var customerEntity = {};
    customerEntity.sex;
    customerEntity.login = function(url, data, goUrl){
        baseFactory.getDatas(url,data).then(function(msg){
            $cookies.put('customer', msg.data.phoneCode);
            $rootScope.isLogin = false;
            $rootScope.isNotLogin = true;
            $rootScope.phoneCode = msg.data.phoneCode;
            window.open(goUrl,'_self');
        }, function(msg){
            console.log(msg);
        });
    };

    customerEntity.exit = function(url){
        $cookies.remove('customer');
        $rootScope.isAdmin == true;
        $rootScope.isCustomer == true;
        window.open(url,'_self');
    }

    return customerEntity;
});
