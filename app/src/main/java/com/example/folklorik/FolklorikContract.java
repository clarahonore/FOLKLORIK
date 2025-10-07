package com.example.folklorik;

import static java.security.AccessController.getContext;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public final class FolklorikContract {
    // Pour ne pas instancier par accident le contrat, on met le constructeur en privée
    private FolklorikContract() {}

    /* Inner class qui définie le contenu d'une table */
    public static class Folkloric implements BaseColumns {
        public static final String TABLE_NAME_SCENARIO = "Scenario";
        public static final String COLUMN_NAME_NOM_SCENARIO = "Nom Scenario";
        public static final String COLUMN_NAME_DESCRIPTION_SCENARIO= "Description";
        public static final String COLUMN_NAME_AUDIO_ID= "Piste Audio Id";

    }

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + Folkloric.TABLE_NAME_SCENARIO + " (" +
                    Folkloric._ID + " INTEGER PRIMARY KEY," +
                    Folkloric.COLUMN_NAME_NOM_SCENARIO + " TEXT," +
                    Folkloric.COLUMN_NAME_DESCRIPTION_SCENARIO + " TEXT," +
                    Folkloric.COLUMN_NAME_AUDIO_ID + " TEXT)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + Folkloric.TABLE_NAME_SCENARIO;

    public class FolklorikDbHelper extends SQLiteOpenHelper {
        // If you change the database schema, you must increment the database version.
        public static final int DATABASE_VERSION = 1;
        public static final String DATABASE_NAME = "Folklorik.db";

        public FolklorikDbHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(SQL_CREATE_ENTRIES);
        }
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            // This database is only a cache for online data, so its upgrade policy is
            // to simply to discard the data and start over
            db.execSQL(SQL_DELETE_ENTRIES);
            onCreate(db);
        }
        public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            onUpgrade(db, oldVersion, newVersion);
        }
    }

}
