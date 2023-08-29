databaseChangeLog = {
    changeSet(author: "Saavy (generated)", id: "1693325218815-1") {
        createTable(tableName: "test") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(nullable: "false", primaryKey: "true")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "col1", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "date2", type: "datetime") {
                constraints(nullable: "false")
            }

            column(name: "col2", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }

            column(name: "date1", type: "datetime") {
                constraints(nullable: "false")
            }
        }
    }
}
