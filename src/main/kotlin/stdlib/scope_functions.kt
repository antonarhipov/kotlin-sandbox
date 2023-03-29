package stdlib

class BasicDataSource {
    var driverClassName: String = ""
    var url: String = ""
    var username: String = ""
    var password: String = ""
    var maxTotal: Int = 0
    var maxIdle: Int = 0
    var minIdle: Int = 0
}


val dataSource = BasicDataSource().apply {
    driverClassName = "com.mysql.jdbc.Driver"
    url = "jdbc:mysql://domain:3306/db"
    username = "username"
    password = "password"
    maxTotal = 40
    maxIdle = 40
    minIdle = 4
}

