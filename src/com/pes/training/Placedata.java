package com.pes.training;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class Placedata {
	
	
	public static final String KEY_NAME="pname";
	public static final String KEY_DETAIL="pdetail";
	public static final String KEY_DATE="pdate";
	public static final String KEY_LOCATION="plocation";
	public static final String KEY_YEAR="pyear";
	public static final String KEY_PER="Cgpa";
	private static final String DATABASE_NAME="Placedatadb";
	private static final String DATABASE_TABLE="place";
	private static final int DATABASE_VERSION=1;
	private DbHelper ourHelper;
	private final Context ourContext;
	private SQLiteDatabase ourDatabase;
	private static class DbHelper extends SQLiteOpenHelper{

	public DbHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
			// TODO Auto-generated constructor stub
		}
		// TODO Auto-generated constructor stub

		@Override
		public void onCreate(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			db.execSQL("CREATE TABLE "+DATABASE_TABLE+" ("+KEY_NAME+" TEXT NOT NULL,"+KEY_DETAIL+" TEXT NOT NULL,"+KEY_DATE+" TEXT NOT NULL,"
			+KEY_LOCATION+" TEXT NOT NULL,"+KEY_YEAR+" TEXT NOT NULL,"+KEY_PER+" TEXT NOT NULL"+")");
			
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub
			db.execSQL("DROP TABLE IF EXISTS"+DATABASE_TABLE);
			onCreate(db);
			
		}
	}
	
	public Placedata(Context c){
		ourContext=c;
		
	}
	public Placedata open()throws SQLException{
		ourHelper=new DbHelper(ourContext);
		ourDatabase=ourHelper.getWritableDatabase();
		return this;
	}
	public void close(){
		ourHelper.close();
	}
	public long createEntry(String name, String detail,String date,String location, String year,String cgpa) {
		// TODO Auto-generated method stub
		ContentValues cv=new ContentValues();
		cv.put(KEY_NAME,name);
		cv.put(KEY_DETAIL, detail);
		cv.put(KEY_DATE, date);
		cv.put(KEY_LOCATION, location);
		cv.put(KEY_YEAR,year);
		cv.put(KEY_PER,cgpa);
		return ourDatabase.insert(DATABASE_TABLE, null, cv);
	}
	public String getData() {
		// TODO Auto-generated method stub
		String[] columns=new String[]{KEY_NAME,KEY_DETAIL,KEY_DATE,KEY_LOCATION,KEY_YEAR,KEY_PER};
		Cursor c=ourDatabase.query(DATABASE_TABLE, columns, null,null,null,null,null);
		String result="";
		
		int iName=c.getColumnIndex(KEY_NAME);
		int iDETAIL=c.getColumnIndex(KEY_DETAIL);
		int iDATE=c.getColumnIndex(KEY_DATE);
		int iLOCATION=c.getColumnIndex(KEY_LOCATION);
		int iYEAR=c.getColumnIndex(KEY_YEAR);
		int iCGPA=c.getColumnIndex(KEY_PER);
		for(c.moveToFirst(); !c.isAfterLast();c.moveToNext()){
			result=result +c.getString(iName)+"  "+c.getString(iDETAIL)+"  "+c.getString(iDATE)+"  "+c.getString(iLOCATION)+"  "
					+c.getString(iYEAR)+"  "+c.getString(iCGPA)+"\n";
		}
		
		return result;
	}

	public String getData1( String s) {
		// TODO Auto-generated method stub
		
		String[] columns=new String[]{KEY_NAME,KEY_DETAIL,KEY_DATE,KEY_LOCATION,KEY_YEAR};
		Cursor c=ourDatabase.query(DATABASE_TABLE, columns, KEY_YEAR + "=" +s,null,null,null,null);
		String result="";
		int iName=c.getColumnIndex(KEY_NAME);
		int iDETAIL=c.getColumnIndex(KEY_DETAIL);
		int iDATE=c.getColumnIndex(KEY_DATE);
		int iLOCATION=c.getColumnIndex(KEY_LOCATION);
		for(c.moveToFirst(); !c.isAfterLast();c.moveToNext()){
			result=result +c.getString(iName)+"  "+c.getString(iDETAIL)+"  "+c.getString(iDATE)+"  "+c.getString(iLOCATION)+"\n";
		}
		
		return result;
		
		
	}
	public String getData3(String s2, String s3) {
		// TODO Auto-generated method stub
		String[] columns=new String[]{KEY_NAME,KEY_DETAIL,KEY_DATE,KEY_LOCATION};
		String query="SELECT * FROM place WHERE Cgpa="+"'"+s3+"' AND pyear="+"'"+s2+"'";
		Cursor c=ourDatabase.rawQuery(query, null);
		String result="";
		int iName=c.getColumnIndex(KEY_NAME);
		int iDETAIL=c.getColumnIndex(KEY_DETAIL);
		int iDATE=c.getColumnIndex(KEY_DATE);
		int iLOCATION=c.getColumnIndex(KEY_LOCATION);
		for(c.moveToFirst(); !c.isAfterLast();c.moveToNext()){
			result=result +c.getString(iName)+"  "+c.getString(iDETAIL)+"  "+c.getString(iDATE)+"  "+c.getString(iLOCATION)+"\n";
		}
		
		return result;
	

	}}
