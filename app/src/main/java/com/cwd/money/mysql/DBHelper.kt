package com.cwd.money.mysql

import com.cwd.money.mysql.table.ShareInfo
import com.cwd.money.utils.wrapShare
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.Statement

object DBHelper {
    val diver = "com.mysql.jdbc.Driver"
    val url = "jdbc:mysql://47.101.129.61:3306/eyes?serverTimezone=GMT%2B8&autoReconnect=true"
    val user = "root"
    val password = "de468b87db95db61"




    val st:Statement by lazy {
        Class.forName(diver);
        val conn = DriverManager.getConnection(url,user,password);//获取连接
        conn.createStatement()
    }

    suspend fun allTable():List<String>{
        val sql = "show tables"
        val list = mutableListOf<String>()
        val rs: ResultSet = st.executeQuery(sql)
        while (rs.next()){
            val name = rs.getString(1)
            if(name != "delta" && name != "zygote"){
                list.add(name)
            }
        }
        rs.close()
        return list
    }

    suspend fun singleTable(name:String):MutableList<ShareInfo>{
        val sql = "select * from $name order by date desc"
        val list = mutableListOf<ShareInfo>()
        val rs: ResultSet = st.executeQuery(sql)
        while (rs.next()){
            val info = rs.wrapShare()
            list.add(info)
        }
        rs.close()
        return list
    }





}