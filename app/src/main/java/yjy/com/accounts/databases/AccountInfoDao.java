package yjy.com.accounts.databases;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import yjy.com.accounts.databases.AccountInfo;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "ACCOUNT_INFO".
*/
public class AccountInfoDao extends AbstractDao<AccountInfo, Long> {

    public static final String TABLENAME = "ACCOUNT_INFO";

    /**
     * Properties of entity AccountInfo.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Cost = new Property(1, double.class, "cost", false, "COST");
        public final static Property Paymethod = new Property(2, String.class, "paymethod", false, "PAYMETHOD");
        public final static Property Usage = new Property(3, String.class, "usage", false, "USAGE");
        public final static Property Remark = new Property(4, String.class, "remark", false, "REMARK");
        public final static Property Date = new Property(5, java.util.Date.class, "date", false, "DATE");
    };


    public AccountInfoDao(DaoConfig config) {
        super(config);
    }
    
    public AccountInfoDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"ACCOUNT_INFO\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"COST\" REAL NOT NULL ," + // 1: cost
                "\"PAYMETHOD\" TEXT NOT NULL ," + // 2: paymethod
                "\"USAGE\" TEXT NOT NULL ," + // 3: usage
                "\"REMARK\" TEXT NOT NULL ," + // 4: remark
                "\"DATE\" INTEGER NOT NULL );"); // 5: date
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"ACCOUNT_INFO\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, AccountInfo entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindDouble(2, entity.getCost());
        stmt.bindString(3, entity.getPaymethod());
        stmt.bindString(4, entity.getUsage());
        stmt.bindString(5, entity.getRemark());
        stmt.bindLong(6, entity.getDate().getTime());
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public AccountInfo readEntity(Cursor cursor, int offset) {
        AccountInfo entity = new AccountInfo( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.getDouble(offset + 1), // cost
            cursor.getString(offset + 2), // paymethod
            cursor.getString(offset + 3), // usage
            cursor.getString(offset + 4), // remark
            new java.util.Date(cursor.getLong(offset + 5)) // date
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, AccountInfo entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setCost(cursor.getDouble(offset + 1));
        entity.setPaymethod(cursor.getString(offset + 2));
        entity.setUsage(cursor.getString(offset + 3));
        entity.setRemark(cursor.getString(offset + 4));
        entity.setDate(new java.util.Date(cursor.getLong(offset + 5)));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(AccountInfo entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(AccountInfo entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
}
