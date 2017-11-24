demoApp.controller('indexController', function($scope, $cookies, customerFactory){
    $scope.customerExit = function(){
        var url = '../views/index.html';
        customerFactory.exit(url);
    }
});

demoApp.controller('defaultController', function($scope, baseFactory){
    //var data = {phoneCode:'18180784265',name:'123456'};
    //baseFactory.getDatas('index.do', data).then(function(msg) {
    //    var customer = msg.data;
    //    $scope.phoneCode = customer.name;
    //}, function(msg){
    //    console.log(msg);
    //});
});

demoApp.controller('customerInfoController', function($scope, $cookies, baseFactory){
    var url = '../customer/getCustomerAllInfo.do';
    var data = {'phoneCode':$cookies.get('customer')};
    baseFactory.getDatas(url,data).then(function(msg){
        $scope.customer = msg.data;
    }, function(msg){
        console.log(msg);
    });
});

demoApp.controller('packInfoController', function($scope, $cookies,$state, baseFactory){
    var url = '../packinfo/getPackageInformationList.do';
    var customer = $cookies.get('customer');
    $scope.isAdmin = true;
    $scope.isCustomer = false;

    if(customer != null && customer == 'admin'){
        $scope.isAdmin = false;
        $scope.isCustomer = true;
    }

    $scope.pageNow = 1;
    $scope.pageSize = 5;

    $scope.selectPage = function(page){
        if(page < 1 || page > $scope.pageCount){
            return ;
        }
        if(page > 2){
            //因为只显示5个页数，大于2页开始分页转换
            var newPageList = [];
            for(var i=(page-3); i<((page+2)>$scope.pageCount?$scope.pageCount:(page+2)); i++){
                $scope.pageList = newPageList;
            }
        }
        $scope.pageNow = page;
        $scope.isActivePage(page);

        var data = {'pageNow':$scope.pageNow,
            'pageSize':$scope.pageSize
        };
        var url = '../packinfo/getPackageInformationList.do';
        baseFactory.getDatas(url,data).then(function(msg){
            $scope.packInfoList = msg.data.packageInformationList;
            $scope.packInfoImage = msg.data.packInfoImageMap;
            var pageEntity = msg.data.page;
            $scope.pageCount = pageEntity.pageCount;
            $scope.pageList = [];
            //分页要repeat的数组
            for(var i=0; i<$scope.pageCount; i++){
                $scope.pageList.push(i+1);
            }
        }, function(msg){
            console.log(msg);
        });
    };

    var data = {'pageNow':$scope.pageNow,
        'pageSize':$scope.pageSize
    };

    $scope.isActivePage = function (page) {
        return $scope.pageNow == page;
    };

    $scope.previous = function(){
        $scope.selectPage($scope.pageNow-1);
    };
    $scope.next = function(){
        $scope.selectPage($scope.pageNow+1);
    }

    baseFactory.getDatas(url,data).then(function(msg){
        $scope.packInfoList = msg.data.packageInformationList;
        $scope.packInfoImage = msg.data.packInfoImageMap;
        var pageEntity = msg.data.page;
        $scope.pageCount = pageEntity.pageCount;
        $scope.pageList = [];
        //分页要repeat的数组
        for(var i=0; i<$scope.pageCount; i++){
            $scope.pageList.push(i+1);
        }
    }, function(msg){
        console.log(msg);
    });

    $scope.deletePackInfo = function(packInfoId){

    };

    $scope.buyPackInfo = function(packInfoId){
        var url = '../packpurinfo/buyPackInfo.do';
        var data = {'packInfoId': packInfoId,'phoneCode':$scope.phoneCode};
        baseFactory.getDatas(url,data).then(function(msg){
            alert(msg.data.result);
        },function(msg){
            console.log(msg);
        });
    };

    $scope.findPackInfo = function(packInfoId){
        $state.go('packinfoone',{packInfoId:packInfoId});
    }
});

demoApp.controller('packInfoOneController', function($scope, $stateParams, baseFactory){
    $scope.packInfoId = $stateParams.packInfoId;
    var url = '../packinfo/getPackInfo.do';
    var data = {'packInfoId': $stateParams.packInfoId};
    baseFactory.getDatas(url,data).then(function(msg){
        $scope.packInfo = msg.data;
    },function(msg){
        console.log(msg);
    });

    $scope.buyPackInfo = function(packInfoId){
        var url = '../packpurinfo/buyPackInfo.do';
        var data = {'packInfoId': packInfoId,'phoneCode':$scope.phoneCode};
        baseFactory.getDatas(url,data).then(function(msg){
            alert(msg.data.result);
        },function(msg){
            console.log(msg);
        });
    };
});

demoApp.controller('packPurInfoController', function($scope, $cookies, baseFactory){
    var url = '../packpurinfo/findPackPurInfoList.do';
    var customer = $cookies.get('customer');
    $scope.isAdmin = true;
    $scope.isCustomer = false;

    if(customer != null && customer == 'admin'){
        $scope.isAdmin = false;
        $scope.isCustomer = true;
    }

    $scope.pageNow = 1;
    $scope.pageSize = 5;

    $scope.selectPage = function(page){
        if(page < 1 || page > $scope.pageCount){
            return ;
        }
        if(page > 2){
            //因为只显示5个页数，大于2页开始分页转换
            var newPageList = [];
            for(var i=(page-3); i<((page+2)>$scope.pageCount?$scope.pageCount:(page+2)); i++){
                $scope.pageList = newPageList;
            }
        }
        $scope.pageNow = page;
        $scope.isActivePage(page);

        var data = {'pageNow':$scope.pageNow,
            'phoneCode':$scope.phoneCode
        };
        var url = '../packpurinfo/findPackPurInfoList.do';
        baseFactory.getDatas(url,data).then(function(msg){
            $scope.packPurInfoList = msg.data.packPurInformationList;
            var pageEntity = msg.data.page;
            $scope.pageNow = pageEntity.pageNow;
            $scope.pageCount = pageEntity.pageCount;
            $scope.pageList = [];
            //分页要repeat的数组
            for(var i=0; i<$scope.pageCount; i++){
                $scope.pageList.push(i+1);
            }
        }, function(msg){
            console.log(msg);
        });
    };

    var data = {'pageNow':$scope.pageNow,
        'phoneCode':$scope.phoneCode
    };

    $scope.isActivePage = function (page) {
        return $scope.pageNow == page;
    };

    $scope.previous = function(){
        $scope.selectPage($scope.pageNow-1);
    };
    $scope.next = function(){
        $scope.selectPage($scope.pageNow+1);
    }

    baseFactory.getDatas(url,data).then(function(msg){
        $scope.packPurInfoList = msg.data.packPurInformationList;
        var pageEntity = msg.data.page;
        $scope.pageNow = pageEntity.pageNow;
        $scope.pageCount = pageEntity.pageCount;
        $scope.pageList = [];
        //分页要repeat的数组
        for(var i=0; i<$scope.pageCount; i++){
            $scope.pageList.push(i+1);
        }
    }, function(msg){
        console.log(msg);
    });

    $scope.deletePackPurInfo = function(packPurInfoId,pageNow){
        var url = '../packpurinfo/deletePackPurInfo.do';
        var data = {
            'packPurInfoId': packPurInfoId,
            'phoneCode':$scope.phoneCode,
            'pageNow': pageNow};
        baseFactory.getDatas(url,data).then(function(msg){
            switch (msg.data.result){
                case "0":
                    alert("请登录");
                    break;
                case "-1":
                    alert("删除失败");
                    break;
                case "1":
                    $scope.packPurInfoList = msg.data.packPurInformationList;
                    var pageEntity = msg.data.page;
                    $scope.pageNow = pageEntity.pageNow;
                    $scope.pageCount = pageEntity.pageCount;
                    $scope.pageList = [];
                    //分页要repeat的数组
                    for(var i=0; i<$scope.pageCount; i++){
                        $scope.pageList.push(i+1);
                    }
                    alert("删除成功");
                    break;
            }
        }, function(msg){
            console.log(msg);
        });
    };
});

demoApp.controller('addPackInfoController', function($scope, fileReader){
    $scope.getFile = function(){
        fileReader.readAsDataUrl($scope.packInfoImage, $scope).then(
            function(result){
                alert(result);
            });
    };
    //$scope.packInfoVo = {};
    //$scope.addPackInfo = function(){
    //    var url = '../packinfo/addPackInfo.do';
    //    var data = $scope.packInfoVo;
    //    baseFactory.getDatas(url, data).then(function(msg){
    //
    //    },function(msg){
    //        console.log(msg);
    //    });
    //};
});

demoApp.controller('operatorController', function($scope,$interval, baseFactory){
    $scope.findFriendList = function(){
        var url = '../customer/getCustomerList.do';
        var data = {phoneCode:$scope.phoneCode};
        baseFactory.getDatas(url,data).then(function(msg){
            $scope.friendList = msg.data;
        }, function(msg){
            console.log(msg);
        });
    };

    $scope.timeIndex = 0;
    $scope.t = null;
    $scope.setTime = function(){
        var hour = parseInt($scope.timeIndex / 3600);
        var minutes = parseInt(($scope.timeIndex % 3600) / 60);
        var seconds = parseInt($scope.timeIndex % 60);
        hour = hour < 10 ? "0" + hour : hour;
        minutes = minutes < 10 ? "0" + minutes : minutes;
        seconds = seconds < 10 ? "0" + seconds : seconds;
        $scope.conversationTime = hour + ":" + minutes + ":" + seconds;
        $scope.timeIndex++;
    }

    $scope.startSum = function(){
        var regex = /dateTime=(\d+)/;
        var src = location.toString();
        if(src.match(regex)){
            $scope.timeIndex = src.match(regex)[1];
        }
        $scope.setTime();
        $scope.t = $interval($scope.setTime, 1000);
    };

    $scope.stopSum = function (){
        $interval.cancel($scope.t);
        $scope.timeIndex = -1;
        $scope.setTime();
    };

    $scope.findFriendList();
    $scope.isStop = false;

    $scope.addTelInfo = function(){
        var url = '../telinfo/addTelInfo.do';
        var data = {
            answerCustomerId:$scope.selectValue,
            phoneCode:$scope.phoneCode
        };

        baseFactory.getDatas(url,data).then(function(msg){
            //1-未接听，2-接听, 3-停机
            //0-当前对象已失效
            //-1-添加信息失败
            switch (msg.data.result){
                case 1:
                    alert("您拨打的号码无人接听，请稍后再拨");
                    break;
                case 2:
                    $scope.isStop = true;
                    $scope.startSum();
                    break;
                case 3:
                    alert("您拨打的号码已停机");
                    break;
                case 0:
                    alert("您太久未操作，请重新登录");
                    break;
                case -1:
                    alert("您拨打的号码无人接听，请稍后再拨");
                    break;
            }
        }, function(msg){
            console.log(msg);
        });
    };

    $scope.updateTelInfo = function(){
        var url = '../telinfo/updateTelInfo.do';
        var data = {phoneCode:$scope.phoneCode};
        baseFactory.getDatas(url,data).then(function(msg){
            $scope.stopSum();
            $scope.isStop = false;
            alert(msg.data.result);
        }, function(msg){
            console.log(msg);
        });
    };
    $scope.dialTel = function(){

        $scope.addTelInfo();
    };
    $scope.stopTel = function(){
        $scope.updateTelInfo();
    };

    $scope.sendMessage = function() {
        var url = '../message/addMessage.do';
        var data = {
            phoneCode : $scope.phoneCode,
            receiveCustomerId : $scope.selectValue,
            messageType : $scope.messageType,
            messageContent : $scope.messageContent
        };

        baseFactory.getDatas(url,data).then(function(msg){
            //1-发送失败，2-成功
            //0-当前对象已失效
            switch (msg.data.result){
                case 1:
                    alert("发送失败");
                    break;
                case 2:
                    alert("发送成功");
                    $scope.messageContent = "";
                    break;
                case 0:
                    alert("您太久未操作，请重新登录");
                    break;
            }
        }, function(msg){
            console.log(msg);
        });
    };
});

demoApp.controller('telInfoController', function($scope, baseFactory){
    $scope.findTelInfoList = function(){
        var url = '../telinfo/findTelInfoList.do';
        var data = {phoneCode:$scope.phoneCode};
        baseFactory.getDatas(url,data).then(function(msg){

            switch (msg.data.result){
                case "0":
                    alert("请登录");
                    break;
                case "1":
                    $scope.telInfoList = msg.data.telInfoList;
                    break;
            }
        }, function(msg){
            console.log(msg);
        });
    };

    $scope.deleteTelInfo = function(telInfoId){
        var url = '../telinfo/deleteTelInfo.do';
        var data = {
            phoneCode:$scope.phoneCode,
            telInfoId : telInfoId
        };
        baseFactory.getDatas(url,data).then(function(msg){
            alert(msg.data.result);
            $scope.findTelInfoList();
        }, function(msg){
            console.log(msg);
        });
    };

    $scope.findTelInfoList();
});

demoApp.controller('messageController', function($scope, baseFactory){
    $scope.findMessageList = function(){
        var url = '../message/findMessageList.do';
        var data = {phoneCode:$scope.phoneCode};
        baseFactory.getDatas(url,data).then(function(msg){
            switch (msg.data.result){
                case "0":
                    alert("请登录");
                    break;
                case "1":
                    $scope.messageList = msg.data.messageList;
                    break;
            }
        }, function(msg){
            console.log(msg);
        });
    };

    $scope.deleteMessage = function(messageId){
        var url = '../message/deleteMessage.do';
        var data = {
            phoneCode:$scope.phoneCode,
            messageId : messageId
        };
        baseFactory.getDatas(url,data).then(function(msg){
            alert(msg.data.result);
            $scope.findMessageList();
        }, function(msg){
            console.log(msg);
        });
    };

    $scope.findMessageList();
});

demoApp.controller('loginController', function($scope, $state, $cookies, customerFactory){
    $scope.customerLogin = function(){
        var customer = {
            phoneCode : $scope.phoneCode
        };

        var url = '../customer/login.do';
        var goUrl = '/taskweb/views/index.html';

        customerFactory.login(url, customer, goUrl);
    }
});
