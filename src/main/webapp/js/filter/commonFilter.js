demoApp.filter('isTrue', function(){
    return function(isTrue){
        return isTrue?'是':'否';
    }
});

demoApp.filter('translateDate', function(){
    return function(conversationTime){
        //将毫秒转换为秒
        var time = conversationTime%1000==0 ? conversationTime/1000 : conversationTime/1000+1;
        var hour = parseInt(time / 3600);
        var minutes = parseInt((time % 3600) / 60);
        var seconds = parseInt(time % 60);
        hour = hour < 10 ? "0" + hour : hour;
        minutes = minutes < 10 ? "0" + minutes : minutes;
        seconds = seconds < 10 ? "0" + seconds : seconds;
        return hour + ":" + minutes + ":" + seconds;
    }
});

demoApp.filter('translateUnit', function(){
    return function(unit){
        var text = "";
        switch (unit){
            case 1:
                text = "KB";
                break;
            case 2:
                text = "MB";
                break;
            case 3:
                text = "GB";
                break;
            case 4:
                text = "TB";
                break;
        }
        return text;
    }
});

demoApp.filter('translateCallType', function(){
    return function(callType){
        var text = "";
        switch (callType){
            case 1:
                text = "本地";
                break;
            case 2:
                text = "长途";
                break;
            case 3:
                text = "漫游";
                break;
        }
        return text;
    }
});

demoApp.filter('translateMessageType', function(){
    return function(messageType){
        var text = "";
        switch (messageType){
            case 0:
                text = "彩信";
                break;
            case 1:
                text = "短信";
                break;
        }
        return text;
    }
});