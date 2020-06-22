
var device = Device.getMain();//获取当前主控设备对象
// var interval;//定时器
var count;//执行次数计数器

//定最右边坐标
var x1 = 893;
var y1 = 1504;
//浏览器右上角导航键
// var x2 = ;
// var y2 = ;
//浏览器刷新键
var x3 = 996;
var y3 = 119;
//确定键
var x4 = 540;
var y4 = 1692;
//领取成功弹窗
var x5 = 996;
var y5 = 119;
//已领取过弹窗
var x6 = 996;
var y6 = 119;

if(device) {
    var phone = "343434";
    run(phone);
}

//主程序
function run(phone) {
    if (count > 5) {
        //刷新浏览器
        count = 0;
        flushHTML();
    }
    //输入框最右边坐标
    device.click(x1,y1,sigmaConst.STATE_PRESS);
    //删除之前的输入
    deleteOldPhone();
    //输入新的号码
    device.inputText(phone + "");
    //点击确定
    device.click(x4,y4,sigmaConst.STATE_PRESS);
    sleep(1000);
    //获取弹出的信息,如果是 ... 那就停止操作
    // var message = getMessage();
    // if (message.indexOf("xxxxx") != -1 ) {
    //
    // }
    //关闭领取成功弹窗
    device.click(x5,y5,sigmaConst.STATE_PRESS);
    //关闭已领取过弹窗
    device.click(x6,y6,sigmaConst.STATE_PRESS);
    count = count + 1;

}


function flushHTML() {
    device.click(x3,y3,sigmaConst.STATE_PRESS);
    sleep(2500);
}

function sleep(millisecond){
    for(var t = Date.now();Date.now() - t <= millisecond;);
}

function getMessage() {
    // x1: 整型，屏幕搜索区域左上角 X 坐标
    // y1: 整型，屏幕搜索区域左上角 Y 坐标
    // x2: 整型，屏幕搜索区域右下角 X 坐标
    // y2: 整型，屏幕搜索区域右下角 Y 坐标
//     lang: 字符串，要搜索指定区域文字对应的语言,注意: TrainedData的文件名一定为{lang}.traineddata。如中文简体是chi_sim.traineddata；英语是eng.traineddata
//     mode: 字符串，搜索模式，有以下几种模式：
//
// singleline: 要找的字大小相同，并且在同一行以内。
// multiline: 要找的字大小相同，并且整齐排列在多行中。这个参数相当耗时，建议少用。
// singlechar:单个字母，不知道支持中文否......
//         singleword: 单个单词
//     singlecolumn: 要找的字大小相同，并且在同一列中
//     multicolumn: 要找的字大小相同，并且分布在多列中
//     number: 要找的是阿拉伯数字
//     noorder: 一堆杂乱的字
//     其余：如果mode值并非上面任何一个取值，那么analyzeText函数会根据图片的实际情况进行分析。
//     analyzeText(x1, y1, x2, y2, lang, mode)
    return device.analyzeText(x1, y1, x2, y2, chi_sim.traineddata,singleline);
}

function deleteOldPhone() {
    for (var i = 0; i < 15; i++) {//删除之前的输入
        device.send(sigmaConst.KEY_BACK_SPACE);
    }
}

function inputPhone(phone) {
    for (var i=0; i<phone.length; i++) {
        var char = phone[i];
        device.send(numberToKeyBord(char));
    }
}

function numberToKeyBord(number) {
    var i = 0;
    switch (number) {
        case 0:
            i = 48;
            break;
        case 1:
            i = 49;
            break;
        case 2:
            i = 50;
            break;
        case 3:
            i = 51;
            break;
        case 4:
            i = 52;
            break;
        case 5:
            i = 53;
            break;
        case 6:
            i = 54;
            break;
        case 7:
            i = 55;
            break;
        case 8:
            i = 56;
            break;
        case 9:
            i = 57;
            break;

    }
    return i;
}