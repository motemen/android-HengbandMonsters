package net.tokyoenvious.droid.hengbandmonsters;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        int id = intent.getIntExtra("id", -1);

        SQLiteDatabase database = new MonstersDbHelper(this).getReadableDatabase();

        Cursor cursor = database.query(
            MonstersTable.TABLE_NAME,
            MonstersTable.ALL_COLUMNS,
            MonstersTable._ID + " = ?",
            new String[] { Integer.toString(id) },
            null, null, null, "1"
        );
        cursor.moveToFirst();

        String symbol = cursor.getString(cursor.getColumnIndexOrThrow(MonstersTable.COLUMN_NAME_SYMBOL));
        String name   = cursor.getString(cursor.getColumnIndexOrThrow(MonstersTable.COLUMN_NAME_NAME_JA));
        String color  = cursor.getString(cursor.getColumnIndexOrThrow(MonstersTable.COLUMN_NAME_COLOR));
        String description = cursor.getString(cursor.getColumnIndexOrThrow(MonstersTable.COLUMN_NAME_DESCRIPTION_JA));
        String recall      = cursor.getString(cursor.getColumnIndexOrThrow(MonstersTable.COLUMN_NAME_RECALL_JA));

        TextView textViewSymbol = (TextView)findViewById(R.id.textViewSymbol);
        textViewSymbol.setText(symbol);
        textViewSymbol.setTextColor(TermColors.charToColor(color));

        ((TextView)findViewById(R.id.textViewDescription)).setText(description);
        ((TextView)findViewById(R.id.textViewRecall)).setText(recall);

        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setTitle(name);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
