package com.cwd.money.mysql

import org.ktorm.database.Database

object MysqlHelper {
    val database by lazy {
        Database.connect(
            url = "jdbc:mysql://47.101.129.61:3306/eyes",
            driver = "com.mysql.jdbc.Driver",
            user = "root",
            password = "de468b87db95db61"
        )
    }



}

