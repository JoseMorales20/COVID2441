package cl.inacap.examenespreventivos.helpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class PacientesSQLiteHelper extends SQLiteOpenHelper {
    private final String sqlcreate = "CREATE TABLE pacientes(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL" +
            ",nombre TEXT" +
            ",apellido TEXT"+
            ",run TEXT"+
            ",fecha TEXT" +
            ",area TEXT" +
            ",sintomas NUMERIC" +
            ",temperatura INTEGER" +
            ",tos NUMERIC" +
            ",presion INTEGER)";

    public PacientesSQLiteHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqlcreate);
        db.execSQL("INSERT INTO pacientes(nombre,apellido,run,fecha,area,sintomas,temperatura,tos,presion)" +
                " VALUES('Raul','Mendez','19488915-1','16/10/1996','desarrollo','no',37,'si',120)");
        db.execSQL("INSERT INTO pacientes(nombre,apellido,run,fecha,area,sintomas,temperatura,tos,presion)" +
                " VALUES('Jose','Morales','20530241-7','13/12/2000','desarrollo','si',39,'si',140)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS pacientes");
        db.execSQL(sqlcreate);
        db.execSQL("INSERT INTO pacientes(nombre,apellido,run,fecha,area,sintomas,temperatura,tos,presion)" +
                " VALUES('Raul','Mendez','19488915-1','16/10/1996','desarrollo','no',37,'si',120)");
        db.execSQL("INSERT INTO pacientes(nombre,apellido,run,fecha,area,sintomas,temperatura,tos,presion)" +
                " VALUES('Jose','Morales','20530241-7','13/12/2000','desarrollo','si',39,'si',140)");

    }
}
