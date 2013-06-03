package net.tokyoenvious.droid.hengbandmonsters;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class ListActivity extends Activity implements SimpleCursorAdapter.ViewBinder, AdapterView.OnItemClickListener {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        SQLiteDatabase database = new MonstersDbHelper(this).getReadableDatabase();
        String[] columns = MonstersTable.ALL_COLUMNS;
        String[] fromColumns = {
            MonstersTable.COLUMN_NAME_NUMBER,
            MonstersTable.COLUMN_NAME_SYMBOL,
            MonstersTable.COLUMN_NAME_NAME_JA,
            MonstersTable.COLUMN_NAME_COLOR
        };
        int[] toViews = {
            R.id.textViewNumber,
            R.id.textViewSymbol,
            R.id.textViewName,
            R.id.textViewSymbol
        };

        Cursor cursor = database.query(MonstersTable.TABLE_NAME, columns, null, null, null, null, null, null);
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.list_item, cursor, fromColumns, toViews, 0);
        adapter.setViewBinder(this);

        ListView listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public boolean setViewValue(View view, Cursor cursor, int columnIndex) {
        if (columnIndex == cursor.getColumnIndex(MonstersTable.COLUMN_NAME_SYMBOL)) {
            TextView textViewSymbol = (TextView)view;
            textViewSymbol.setText(cursor.getString(columnIndex));
            return true;
        } else if (columnIndex == cursor.getColumnIndex(MonstersTable.COLUMN_NAME_COLOR)) {
            TextView textViewSymbol = (TextView)view;
            textViewSymbol.setTextColor(TermColors.charToColor(cursor.getString(columnIndex)));
            return true;
        }
        return false;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        ListView listView = (ListView) adapterView;
        Cursor cursor = (Cursor) listView.getItemAtPosition(i);
        int id = cursor.getInt(cursor.getColumnIndex(MonstersTable._ID));

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("id", id);
        startActivity(intent);
    }
}
