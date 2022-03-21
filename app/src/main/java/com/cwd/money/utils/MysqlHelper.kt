package com.cwd.money.utils

import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet

object MysqlHelper {
    val diver = "com.mysql.jdbc.Driver"
    val url = "jdbc:mysql://47.101.129.61:3306/eyes?serverTimezone=GMT%2B8&autoReconnect=true"
    val user = "root"
    val password = "de468b87db95db61"


    fun getConn(): Connection {
        Class.forName(diver);
        val conn:Connection = DriverManager.getConnection(url,user,password);//获取连接
        return conn
    }

    suspend fun conn(){
        var conn: Connection? = getConn()
        val sql = "select * from zygote limit 1"
        val st = conn!!.createStatement()
        val rs:ResultSet = st.executeQuery(sql)
        Log.e("aaa", "bb  $rs")
        while (rs.next()){
            Log.e("aaa",rs.getString("code"))
        }
    }

    fun begin(){
        GlobalScope.launch{
            conn()
        }
    }

}