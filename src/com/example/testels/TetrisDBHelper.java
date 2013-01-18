
package com.example.testels;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * 项目名称：TestELS
 * 类名称：TetrisDBHelper
 * 类描述：
 * 创建人：xubt
 * 创建时间：2013-1-18 下午3:22:37
 * -------------------------------修订历史--------------------------
 * 修改人：xubt
 * 修改时间：2013-1-18 下午3:22:37
 * 修改备注：
 * @version：
 */
public class TetrisDBHelper extends SQLiteOpenHelper{
	private static final  String DB_NAME="tetris_db";
	private static final int DB_VRERSION = 1;
	private static final String TABLE_SCORE ="score_table";
	
	private static final String CREATE_TIME ="create_time";
	private static final String SCORE ="score";
	private static final String CREATE_NAME="create_name";
	/** 
	 * <p>Title: </p> 
	 * <p>Description: </p> 
	 * @param context
	 * @param name
	 * @param factory
	 * @param version 
	 */
	public TetrisDBHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}
	public TetrisDBHelper(Context context){
		super(context, DB_NAME, null, DB_VRERSION);
	}

	/** 
	 * @方法名：onCreate
	 * @功能描述：
	 * @参数：@param db
	 * @throws
	 */
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		
	}

	/** 
	 * @方法名：onUpgrade
	 * @功能描述：
	 * @参数：@param db
	 * @参数：@param oldVersion
	 * @参数：@param newVersion
	 * @throws
	 */
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}

}
