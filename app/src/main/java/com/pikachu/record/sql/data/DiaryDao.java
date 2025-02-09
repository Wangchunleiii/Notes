package com.pikachu.record.sql.data;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.pikachu.record.sql.table.Diary;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * DAO for table "DIARY".
*/
public class DiaryDao extends AbstractDao<Diary, Long> {

    public static final String TABLENAME = "DIARY";

    /**
     * Properties of entity Diary.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Title = new Property(1, String.class, "title", false, "TITLE");
        public final static Property Text = new Property(2, String.class, "text", false, "TEXT");
        public final static Property Weather = new Property(3, String.class, "weather", false, "WEATHER");
        public final static Property ImagePath = new Property(4, String.class, "imagePath", false, "IMAGE_PATH");
        public final static Property Time = new Property(5, String.class, "time", false, "TIME");
    }


    public DiaryDao(DaoConfig config) {
        super(config);
    }
    
    public DiaryDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"DIARY\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"TITLE\" TEXT," + // 1: title
                "\"TEXT\" TEXT," + // 2: text
                "\"WEATHER\" TEXT," + // 3: weather
                "\"IMAGE_PATH\" TEXT," + // 4: imagePath
                "\"TIME\" TEXT);"); // 5: time
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"DIARY\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Diary entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String title = entity.getTitle();
        if (title != null) {
            stmt.bindString(2, title);
        }
 
        String text = entity.getText();
        if (text != null) {
            stmt.bindString(3, text);
        }
 
        String weather = entity.getWeather();
        if (weather != null) {
            stmt.bindString(4, weather);
        }
 
        String imagePath = entity.getImagePath();
        if (imagePath != null) {
            stmt.bindString(5, imagePath);
        }
 
        String time = entity.getTime();
        if (time != null) {
            stmt.bindString(6, time);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Diary entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String title = entity.getTitle();
        if (title != null) {
            stmt.bindString(2, title);
        }
 
        String text = entity.getText();
        if (text != null) {
            stmt.bindString(3, text);
        }
 
        String weather = entity.getWeather();
        if (weather != null) {
            stmt.bindString(4, weather);
        }
 
        String imagePath = entity.getImagePath();
        if (imagePath != null) {
            stmt.bindString(5, imagePath);
        }
 
        String time = entity.getTime();
        if (time != null) {
            stmt.bindString(6, time);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public Diary readEntity(Cursor cursor, int offset) {
        Diary entity = new Diary( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // title
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // text
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // weather
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // imagePath
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5) // time
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Diary entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setTitle(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setText(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setWeather(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setImagePath(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setTime(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(Diary entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(Diary entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(Diary entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
