package org.saavy.db

class Test {

    String col1
    String col2
    Date   date1
    Date   date2

    static constraints = {
        col1 nullable: true
        col2 nullable: true
        date1 nullable: true
        date2 nullable: true
    }
}
