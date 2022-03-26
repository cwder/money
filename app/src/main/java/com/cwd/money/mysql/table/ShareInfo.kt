package com.cwd.money.mysql.table

import org.ktorm.schema.Table
import org.ktorm.schema.float
import org.ktorm.schema.int
import org.ktorm.schema.varchar

object ShareInfo : Table<Nothing>("sh600000"){
    val id = int("id").primaryKey()
    val date = varchar("date")
    val code = varchar("code")
    val open = float("open")
    val high = float("high")
    val preclose = float("preclose")
    val volume = int("volume")
    val amount = int("amount")
    val adjustflag = int("adjustflag")
    val turn = int("turn")
    val tradestatus = int("tradestatus")
    val pctChg = int("pctChg")
    val peTTM = int("peTTM")
    val pbMRQ = int("pbMRQ")
    val psTTM = int("psTTM")
    val pcfNcfTTM = int("pcfNcfTTM")
    val isST = int("isST")
    val create_time = int("create_time")

}