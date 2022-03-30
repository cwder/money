package com.cwd.money.core

import com.cwd.money.mysql.DBHelper
import com.cwd.money.mysql.table.DeltaInfo
import com.cwd.money.mysql.table.ShareInfo
import com.cwd.money.utils.log

object Delta : Base() {

    /*
    * create table delta (id int primary key auto_increment,date date,
                              code varchar(15),low_count int,turn_ten int ,turn_twn int ,turn_thirty int ,turn_ot int ,open float,high float,
                              low float,close float,preclose float,volume int unsigned,amount int unsigned,adjustflag tinyint,turn float,
                              tradestatus tinyint,pctChg float,peTTM float,pbMRQ float,psTTM float,
                              pcfNcfTTM float,isST int,create_time datetime NOT NULL DEFAULT NOW())
    * */


    suspend fun bLine(table:String):Boolean{

        val data = DBHelper.singleTable(table)
        val target:ShareInfo = data[0]

        var count = 0

        var turnTen:Int = 0
        var turnTwn:Int = 0
        var turnThirty:Int = 0
        var turnOt:Int  = 0
        var turnCount:Int = 0

        for((index,item) in data.withIndex()){
            if(item.close < target.close){
                count++
            }
            turnCount += item.turn
            when (index){
                9 -> turnTen = turnCount
                19 -> turnTwn = turnCount
                29 -> turnThirty = turnCount
                49 -> turnOt = turnCount
            }
        }
        if(data.size < 1500){
            return false
        }
        var max:Int = data.size / 100
        if (count < max){
            log("name: " + target.code + " ok " + " max: " + max + " count: " + count)
            val data = DeltaInfo(count, turnTen, turnTwn, turnThirty, turnOt,target)
            addDelta(data)
            return true
        }else{
            return false
        }

    }



    suspend fun updataTurn(code:String,turn_ten:Int,turn_twn:Int,turn_thirty:Int){
        val sql =
            "update delta set turn_ten='$turn_ten', turn_twn='$turn_twn', turn_thirty='$turn_thirty'+ ' where code='$code'";
        DBHelper.st.executeUpdate(sql)
    }

    suspend fun findAll(){
        val res = mutableListOf<String>()


        tables().forEach { name->
            name.log()
            bLine(name).takeIf {
                res.add(name)
            }
        }

        res.forEach {
            it.log()
        }
    }

    suspend fun addDelta(info: DeltaInfo){
        val date = info.shareInfo.date
        val sql = "insert into delta(date,code,low_count,turn_ten,turn_twn,turn_thirty,turn_ot,low_count,open,high,low" +
                ",close,preclose,volume,amount,adjustflag,turn,tradestatus" +
                ",pctChg,peTTM,pbMRQ,psTTM,pcfNcfTTM,isST)values('" + info.shareInfo.date +
                "','" + info.shareInfo.code +
                "','" + info.count +
                "','" + info.turn_ten +
                "','" + info.turn_twn +
                "','" + info.turn_thirty +
                "','" + info.turn_ot +
                "','" + info.shareInfo.open +
                "','" + info.shareInfo.high +
                "','" + info.shareInfo.low +
                "','" + info.shareInfo.close +
                "','" + info.shareInfo.preclose +
                "','" + info.shareInfo.volume +
                "','" + info.shareInfo.amount +
                "','" + info.shareInfo.adjustflag +
                "','" + info.shareInfo.turn +
                "','" + info.shareInfo.tradestatus +
                "','" + info.shareInfo.pctChg +
                "','" + info.shareInfo.peTTM +
                "','" + info.shareInfo.pbMRQ +
                "','" + info.shareInfo.psTTM +
                "','" + info.shareInfo.pcfNcfTTM +
                "','"+ info.shareInfo.isST + "')";

        DBHelper.st.executeUpdate(sql)
    }



}