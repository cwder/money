package com.cwd.money.mysql

import com.cwd.money.mysql.table.ShareInfo
import com.cwd.money.utils.wrapShare
import java.sql.DriverManager
import java.sql.ResultSet

object DBHelper {
    val diver = "com.mysql.jdbc.Driver"
    val url = "jdbc:mysql://47.101.129.61:3306/eyes?serverTimezone=GMT%2B8&autoReconnect=true"
    val user = "root"
    val password = "de468b87db95db61"

    val database by lazy {
        Class.forName(diver);
        DriverManager.getConnection(url,user,password);//获取连接
    }

    suspend fun allTable():List<String>{
        val sql = "show tables"
        val list = mutableListOf<String>()
        val st = database.createStatement()
        val rs: ResultSet = st.executeQuery(sql)
        while (rs.next()){
            val name = rs.getString(1)
            list.add(name)
        }
        return list
    }

    suspend fun singleTable(name:String):List<ShareInfo>{
        val sql = "select * from $name"
        val list = mutableListOf<ShareInfo>()
        val st = database.createStatement()
        val rs: ResultSet = st.executeQuery(sql)
        while (rs.next()){
            val info = rs.wrapShare()
            list.add(info)
        }
        return list
    }

}