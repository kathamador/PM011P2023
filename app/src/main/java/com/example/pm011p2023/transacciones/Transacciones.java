package com.example.pm011p2023.transacciones;

public class Transacciones {
    //nombre de la base de datos
    public static final String NameDatabase = "PM01DB";
    //tablas de la base de datos
    public static final String tablapersonas = "personas";

    //Transacciones de la base de datos PM01DB
    public static final String CreateTBPersonas =
            "CREATE TABLE personas (id INTEGER PRIMARY KEY AUTOINCREMENT, nombres TEXT," +
            "apellidos TEXT, edad TEXT, correo TEXT)";

    public static final String DropTablePersonas = "DROP TABLE IF EXISTS personas";

    //Helpers
    public static final String Empty = "";
}
