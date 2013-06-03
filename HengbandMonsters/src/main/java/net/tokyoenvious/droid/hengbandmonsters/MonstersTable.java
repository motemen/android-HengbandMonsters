package net.tokyoenvious.droid.hengbandmonsters;

import android.provider.BaseColumns;

/**
 * Created by motemen on 2013/05/27.
 */
public class MonstersTable implements BaseColumns {
    public static final String TABLE_NAME          = "monsters";
    public static final String COLUMN_NAME_NUMBER  = "number";
    public static final String COLUMN_NAME_SYMBOL  = "symbol";
    public static final String COLUMN_NAME_NAME_JA = "name_ja";
    public static final String COLUMN_NAME_COLOR   = "color";
    public static final String COLUMN_NAME_DESCRIPTION_JA = "description_ja";
    public static final String COLUMN_NAME_RECALL_JA      = "recall_ja";

    public static final String[] ALL_COLUMNS = {
        _ID, COLUMN_NAME_NUMBER, COLUMN_NAME_SYMBOL, COLUMN_NAME_NAME_JA, COLUMN_NAME_COLOR,
            COLUMN_NAME_DESCRIPTION_JA, COLUMN_NAME_RECALL_JA
    };
}
