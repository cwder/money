package com.cwd.money.core.arch

import android.annotation.SuppressLint
import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.cwd.money.mysql.DBHelper
import com.cwd.money.mysql.table.DeltaInfo
import com.cwd.money.mysql.table.ShareInfo
import com.cwd.money.utils.log
import com.cwd.money.utils.wrapShare
import java.sql.ResultSet

class DeltaWorker(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {

    var bLine:Int = 100

    @SuppressLint("RestrictedApi")
    override fun doWork(): Result {
        try {
            "begin".log()
            bLine = inputData.getInt("bLine",100)
            clean()
            findAll()
            "end".log()
            return Result.Success()
        } catch (e: Exception) {
            return Result.failure()
        }
    }




    fun findAll(){
        val tables = DBHelper.allTable()
        tables.size.log()
        for((index,item) in tables.withIndex()){
            index.log()
            item.log()
            bLine(item)
        }
        rs.close()
        DBHelper.close()

    }

    var data:MutableList<ShareInfo> = mutableListOf()
    lateinit var rs: ResultSet
    fun bLine(table:String):Boolean{
        data?.clear()
        val sql = "select * from $table order by date desc"
        rs = DBHelper.st.executeQuery(sql)
        while (rs.next()){
            "4".log()
            data.add(rs.wrapShare())
        }
        if(data[0].isST == 1){
            return false
        }
        var count = 0
        var turnTen:Float = 0f
        var turnTwn:Float = 0f
        var turnThirty:Float = 0f
        var turnOt:Float  = 0f
        var turnCount:Float = 0f
        for((index,item) in data.withIndex()){
            if(item.close < data[0].close){
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
        var max:Int = data.size / bLine
        if (count < max){
            log("name: " + data[0].code + " ok " + " max: " + max + " count: " + count)
            val data = DeltaInfo(count, turnTen, turnTwn, turnThirty, turnOt,data[0])
            addDelta(data)
            return true
        }else{
            return false
        }

    }

    fun clean(){
        DBHelper.st.executeUpdate("truncate TABLE delta")
    }

    fun addDelta(info: DeltaInfo){
        val date = info.shareInfo.date
        val sql = "insert into delta(date,code,low_count,turn_ten,turn_twn,turn_thirty,turn_ot,open,high,low" +
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
        sql.log()
        DBHelper.st.executeUpdate(sql)
    }


}