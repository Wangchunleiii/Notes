package com.pikachu.record.sql.data;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import com.pikachu.record.sql.table.Account;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * DAO for table "ACCOUNT".
*/
public class AccountDao extends AbstractDao<Account, Long> {

    public static final String TABLENAME = "ACCOUNT";

    /**
     * Properties of entity Account.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Budget = new Property(1, boolean.class, "budget", false, "BUDGET");
        public final static Property Title = new Property(2, String.class, "title", false, "TITLE");
        public final static Property HowMuch = new Property(3, float.class, "howMuch", false, "HOW_MUCH");
        public final static Property Text = new Property(4, String.class, "text", false, "TEXT");
        public final static Property Item = new Property(5, String.class, "item", false, "ITEM");
    }


    public AccountDao(DaoConfig config) {
        super(config);
    }
    
    public AccountDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"ACCOUNT\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"BUDGET\" INTEGER NOT NULL ," + // 1: budget
                "\"TITLE\" TEXT," + // 2: title
                "\"HOW_MUCH\" REAL NOT NULL ," + // 3: howMuch
                "\"TEXT\" TEXT," + // 4: text
                "\"ITEM\" TEXT);"); // 5: item
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"ACCOUNT\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Account entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindLong(2, entity.getBudget() ? 1L: 0L);
 
        String title = entity.getTitle();
        if (title != null) {
            stmt.bindString(3, title);
        }
        stmt.bindDouble(4, entity.getHowMuch());
 
        String text = entity.getText();
        if (text != null) {
            stmt.bindString(5, text);
        }
 
        String item = entity.getItem();
        if (item != null) {
            stmt.bindString(6, item);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Account entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindLong(2, entity.getBudget() ? 1L: 0L);
 
        String title = entity.getTitle();
        if (title != null) {
            stmt.bindString(3, title);
        }
        stmt.bindDouble(4, entity.getHowMuch());
 
        String text = entity.getText();
        if (text != null) {
            stmt.bindString(5, text);
        }
 
        String item = entity.getItem();
        if (item != null) {
            stmt.bindString(6, item);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public Account readEntity(Cursor cursor, int offset) {
        Account entity = new Account( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.getShort(offset + 1) != 0, // budget
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // title
            cursor.getFloat(offset + 3), // howMuch
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // text
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5) // item
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Account entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setBudget(cursor.getShort(offset + 1) != 0);
        entity.setTitle(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setHowMuch(cursor.getFloat(offset + 3));
        entity.setText(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setItem(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(Account entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(Account entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(Account entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
