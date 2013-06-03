package net.tokyoenvious.droid.hengbandmonsters;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.JsonReader;
import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;

/**
 * Created by motemen on 2013/05/27.
 */
public class MonstersDbHelper extends SQLiteOpenHelper {
    static final String TAG = "MonstersDbHelper";

    public static final int DATABASE_VERSION = 5;
    public static final String DATABASE_NAME = "monsters.db";

    InputStream is;

    public MonstersDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        is = context.getResources().openRawResource(R.raw.r_info);
        Log.d(TAG, "MonstersDbHelper");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(TAG, "onCreate");

        db.execSQL(
            "CREATE TABLE monsters (" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "number INT," +
                "symbol CHAR," +
                "name_ja STRING," +
                "color CHAR," +
                "description_ja TEXT," +
                "recall_ja TEXT" +
            ")"
        );

        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line);
                sb.append("\n");
            }
            JSONObject jsonObject = new JSONObject(sb.toString());
            JSONArray monsters = jsonObject.getJSONArray("monsters");
            for (int i = 0; i < monsters.length(); i++) {
                JSONObject monster = monsters.getJSONObject(i);

                ContentValues values = new ContentValues();
                values.put("number",  monster.getInt("number"));
                values.put("symbol",  monster.getString("symbol"));
                values.put("name_ja", monster.getString("name_ja"));
                values.put("color",   monster.getString("color"));
                values.put("description_ja", monster.has("description_ja") ? monster.getString("description_ja") : "");
                values.put("recall_ja",      monster.has("recall_ja")      ? monster.getString("recall_ja") : "");
                db.insertOrThrow("monsters", null, values);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS monsters");
        onCreate(db);
    }
}
