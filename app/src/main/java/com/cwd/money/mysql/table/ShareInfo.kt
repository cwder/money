package com.cwd.money.mysql.table

data class ShareInfo(
    var id:Int,
    var date:String,
    var code:String,
    var open:Float,
    var high:Float,
    var low:Float,
    var close:Float,
    var preclose:Float,
    var volume:Long,
    var amount:Long,
    var adjustflag:Int,
    var turn:Int,
    var tradestatus:Int,
    var pctChg:Int,
    var peTTM:Int,
    var pbMRQ:Int,
    var psTTM:Int,
    var pcfNcfTTM:Int,
    var isST:Int
    )