var demoApp = angular.module('demoApp', ['ui.router','ngCookies']);

demoApp.run(['$rootScope', '$state', '$window','$location','$cookies',
    function($rootScope, $state, $window, $location, $cookies){
        var customer = $cookies.get('customer');
        if(customer != null){
            $rootScope.isLogin = false;
            $rootScope.isNotLogin = true;
            $rootScope.phoneCode = customer;
            $rootScope.isAdmin == true;
            $rootScope.isCustomer == false;
            if(customer == 'admin'){
                $rootScope.isAdmin == false;
                $rootScope.isCustomer == true;
            }
        }else{
            $rootScope.isLogin = true;
            $rootScope.isNotLogin = false;
            $rootScope.isAdmin == true;
            $rootScope.isCustomer == true;
        }
}]);

demoApp.config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider){
    //$urlRouterProvider.when('','/default');
    $stateProvider.state('default', {
        url : '/default',
        views : {
            'contain' : {
                controller : 'defaultController',
                templateUrl : '/taskweb/views/rview/default.html'
            }
        }
    }).state('login', {
        url : '/login',
        views : {
            'contain' : {
                controller : 'loginController',
                templateUrl : '/taskweb/views/rview/login.html'
            }
        }
    }).state('register', {
        url : '/register',
        views : {
            'contain' : {
                templateUrl : '/taskweb/views/rview/register.html'
            }
        }
    }).state('customerinfo', {
        url : '/customerinfo',
        views : {
            'contain' : {
                controller : 'customerInfoController',
                templateUrl : '/taskweb/views/rview/customerinfo.html'
            }
        }
    }).state('packinfo', {
        url : '/packinfo',
        views : {
            'contain' : {
                controller : 'packInfoController',
                templateUrl : '/taskweb/views/rview/packinfo.html'
            }
        }
    }).state('packpurinfo', {
        url : '/packpurinfo',
        views : {
            'contain' : {
                controller : 'packPurInfoController',
                templateUrl : '/taskweb/views/rview/packpurinfo.html'
            }
        }
    }).state('operator', {
        url : '/operator',
        views : {
            'contain' : {
                controller : 'operatorController',
                templateUrl : '/taskweb/views/rview/operator.html'
            }
        }
    }).state('telinfo', {
        url : '/telinfo',
        views : {
            'contain' : {
                controller : 'telInfoController',
                templateUrl : '/taskweb/views/rview/telinfo.html'
            }
        }
    }).state('message', {
        url : '/message',
        views : {
            'contain' : {
                controller : 'messageController',
                templateUrl : '/taskweb/views/rview/message.html'
            }
        }
    }).state('addpackinfo', {
        url : '/addpackinfo',
        views : {
            'contain' : {
                controller : 'addPackInfoController',
                templateUrl : '/taskweb/views/rview/addpackinfo.html'
            }
        }
    }).state('packinfoone', {
        url : '/packinfoone/:packInfoId',
        //params : {packInfoId:null},
        views : {
            'contain' : {
                controller : 'packInfoOneController',
                templateUrl : '/taskweb/views/rview/packinfoone.html'
            }
        }
    });
}]);
