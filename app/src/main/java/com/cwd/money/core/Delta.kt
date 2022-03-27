package com.cwd.money.core

import com.cwd.money.mysql.DBHelper
import com.cwd.money.mysql.table.DeltaInfo
import com.cwd.money.mysql.table.ShareInfo
import com.cwd.money.utils.log

object Delta :Base() {
    suspend fun bLine(table:String):Boolean{

        val data = DBHelper.singleTable(table)
        val target:ShareInfo = data[0]
        data.removeAt(0)
        var max:Int = 50
        var count = 0
        for((index,item) in data.withIndex()){
            if(item.close < target.close){
                count++
            }
        }

        if (count < max){
            log("name: " + target.code + " ok " + " max: " + max + " count: " + count)
            val data = DeltaInfo(count, target)
            DBHelper.addDelta(data)
            return true
        }else{
            return false
        }

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


}