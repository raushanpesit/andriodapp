package com.pes.training;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.webkit.WebView.FindListener;
import android.widget.Button;

public class LoginData {
	public static final String KEY_USER="User";
	public static final String KEY_PASS="password";
	public static final String KEY_PASSW="passwor";
			
		private static final String DATABASE_NAME="Logindb";
		private static final String DATABASE_TABLE="login";
		
		
		private static final int DATABASE_VERSION=3;
		
		private DbHelper ourHelper;
		private final Context ourContext;
		private SQLiteDatabase ourDatabase;
		Button call;
		
		
		private static class DbHelper extends SQLiteOpenHelper{
			
		

			public DbHelper(Context context) {
				super(context,DATABASE_NAME,null,DATABASE_VERSION);
				// TODO Auto-generated constructor stub
			}

			@Override
			public void onCreate(SQLiteDatabase db) {
				// TODO Auto-generated method stub
				db.execSQL("CREATE TABLE "+DATABASE_TABLE+" ("+KEY_USER+" TEXT NOT NULL,"+KEY_PASS+" TEXT NOT NULL"+")");			
				
				
			}

			@Override
			public void onUpgrade(SQLiteDatabase db, int oldVersion,
					int newVersion) {
				// TODO Auto-generated method stub
				
				db.execSQL("DROP TABLE IF EXISTS "+DATABASE_TABLE);
				onCreate(db);
				
			}}
			
			public LoginData(Context c)
			{
				ourContext = c;
				
			}
			public LoginData open() throws SQLException{
				ourHelper = new DbHelper(ourContext);
				ourDatabase = ourHelper.getWritableDatabase();
				return this;
			}
			public void close() {
				// TODO Auto-generated method stub
				ourHelper.close();
				
			}
		
			public long createuser(String username,String pwd) {
				// TODO Auto-generated method stub
				ContentValues cv1 = new ContentValues();
				cv1.put(KEY_USER,username);
				cv1.put(KEY_PASS,pwd);
				
				return ourDatabase.insert(DATABASE_TABLE, null, cv1);
			
			
			}
			
			
			
			
			
		
			
		
			public String getData4(String s2,String s3)
			{
				String[] columns = new String[] {KEY_PASS,KEY_USER};
				String query ="SELECT * FROM login" ;
				Cursor c = ourDatabase.rawQuery(query, null);
				//int result = "";
				int ipwd = c.getColumnIndex(KEY_PASS);
				//int idetails = c.getColumnIndex(KEY_DETAILS);
				String result="";
				for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
					result =c.getString(ipwd);
					
				}
				return result;
				
				}
			
			
			
}
