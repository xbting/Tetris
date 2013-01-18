/**********************************************************************
 * FILE                ：SetingSharedPref.java
 * PACKAGE			   ：com.example.testels
 * AUTHOR              ：xubt
 * DATE				   ：2013-1-18 下午2:53:21
 * FUNCTION            ：
 *
 * 杭州思伟版权所有
 *======================================================================
 * CHANGE HISTORY LOG
 *----------------------------------------------------------------------
 * MOD. NO.|  DATE    | NAME           | REASON            | CHANGE REQ.
 *----------------------------------------------------------------------
 *         |          | xubt        | Created           |
 *
 * DESCRIPTION:
 *
 ***********************************************************************/
package com.example.testels;

import java.util.ArrayList;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/**
 * 项目名称：TestELS
 * 类名称：SetingSharedPref
 * 类描述：
 * 创建人：xubt
 * 创建时间：2013-1-18 下午2:53:21
 * -------------------------------修订历史--------------------------
 * 修改人：xubt
 * 修改时间：2013-1-18 下午2:53:21
 * 修改备注：
 * @version：
 */
public class ScoreSharedPref {
	private final static String PREF_NAME="tetris";
	private static ArrayList<Integer> scoreList = new ArrayList<Integer>();
	private static ArrayList<String> userList = new ArrayList<String>();
	private static String[] scoreKey={"firstScore","secondScore","thirdScore","forthScore"};
	private static String[] userKey={"firstUser","secondUser","thirdUser","forthUser"};
	
	/**
	 * 
	 * @方法名：saveScore
	 * @功能描述：
	 * @创建人：xubt
	 * @创建时间：2013-1-18 下午4:36:09
	 * @参数：@param context
	 * @参数：@param score
	 * @参数：@param user
	 * @参数：@param ranking
	 * @返回：void
	 * @throws
	 */
	public static void saveScore(Context context,int score,String user,int ranking){
		SharedPreferences mPreferences = context.getSharedPreferences(PREF_NAME, 0);
		scoreList = getRankingScores(context);
		
		if(ranking>=scoreList.size()){//最后一位，直接保存
			Editor editor = mPreferences.edit();
			editor.putInt(scoreKey[ranking], score);
			editor.putString(userKey[ranking], user);
			editor.commit();
		}else{//不是最后一位
			ArrayList<Integer> tempScore = (ArrayList<Integer>) scoreList.subList(ranking, scoreList.size()-1);
			ArrayList<String> tempUser = (ArrayList<String>) userList.subList(ranking, scoreList.size()-1);
			tempScore.add(0, score);
			tempUser.add(0, user);
			for (int i = ranking; i < scoreList.size(); i++) {
//				scoreList.remove(i);
//				scoreList.add(i, tempScore.get(i-ranking));
//				userList.remove(i);
//				userList.add(i, tempUser.get(i-ranking));
				Editor editor = mPreferences.edit();
				editor.putInt(scoreKey[i], score);
				editor.putString(userKey[i], user);
				editor.commit();
			}
		}
		
	}
	
	/**
	 * 
	 * @方法名：getScores
	 * @功能描述：
	 * @创建人：xubt
	 * @创建时间：2013-1-18 下午4:09:39
	 * @参数：@param context
	 * @参数：@return
	 * @返回：List<Integer>
	 * @throws
	 */
	public static ArrayList<Integer> getRankingScores(Context context){
		scoreList.clear();
		SharedPreferences mPreferences = context.getSharedPreferences(PREF_NAME, 0);
		for (int i = 0; i < scoreKey.length; i++) {
			scoreList.add(mPreferences.getInt(scoreKey[i], 0));
		}
		return scoreList;
		
	}
	
	public static ArrayList<String> getRankingUsers(Context context){
		userList.clear();
		SharedPreferences mPreferences = context.getSharedPreferences(PREF_NAME, 0);
		for (int i = 0; i < userKey.length; i++) {
			userList.add(mPreferences.getString(userKey[i], ""));
		}
		return userList;
	}
	
	/**
	 * 
	 * @方法名：isRank
	 * @功能描述：判断是否入榜，返回-1不入榜，其他是名次
	 * @创建人：xubt
	 * @创建时间：2013-1-18 下午4:19:23
	 * @参数：@param context
	 * @参数：@param score
	 * @参数：@return
	 * @返回：int
	 * @throws
	 */
	public static int isRank(Context context,int score){
		scoreList = getRankingScores(context);
		if(scoreList.size()<4){
			return scoreList.size();
		}else{
			for (int i = 0; i < scoreList.size(); i++) {
				if(scoreList.get(i)<score){
					return i;
				}
			}
		}
		return -1;
	}

	
}
