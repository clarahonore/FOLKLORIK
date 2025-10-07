package com.example.folklorik;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        FolklorikDbHelper dbHelper = new FolklorikDbHelper(this);

        // Gets the database. If it does not exist, this is where it will
        // also be created.
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        // Create insert entries
        ContentValues values = new ContentValues();
        values.put(FolklorikContract.Folklorik.COLUMN_NAME_NOM_SCENARIO, "Bretagne");
        values.put(FolklorikContract.Folklorik.COLUMN_NAME_DESCRIPTION_SCENARIO,
                "Scénario sur le thème de la Bretagne");
        values.put(FolklorikContract.Folklorik.COLUMN_NAME_AUDIO_ID, "1");

        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(
                FolklorikContract.Folklorik.TABLE_NAME,
                null,
                values);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
