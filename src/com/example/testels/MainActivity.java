package com.example.testels;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.view.Menu;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends Activity {
	private TetrisSufaceView mTetrisSufaceView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		playGame();
	}
	private void playGame(){
		mTetrisSufaceView = new TetrisSufaceView(this);
		setContentView(mTetrisSufaceView);
	}
	
	Handler mHandler = new Handler(){
		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
			case TetrisSufaceView.DIALOG_GAMEOVER:
				showDialog(TetrisSufaceView.DIALOG_GAMEOVER);
				break;
			case TetrisSufaceView.DIALOG_BACK:
				showDialog(TetrisSufaceView.DIALOG_BACK);
				break;
			default:
				break;
			}
		};
	};
	@Override
	protected Dialog onCreateDialog(int id) {
		Dialog dialog = null;
		switch (id) {
		case TetrisSufaceView.DIALOG_GAMEOVER:
			Builder builder = new AlertDialog.Builder(this);
			builder.setTitle("游戏结束");
			builder.setMessage("游戏已经结束，是否重玩?");
			builder.setPositiveButton("重玩", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					playGame();
				}
			})
			.setNegativeButton("退出", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					System.exit(0);
				}
			});
			dialog = builder.create();
			break;
		case TetrisSufaceView.DIALOG_BACK:
			builder = new AlertDialog.Builder(this);
			builder.setTitle("退出游戏");
			builder.setMessage("你确定要退出游戏?");
			builder.setPositiveButton("是", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					System.exit(0);
				}
			})
			.setNegativeButton("否", null);
			dialog = builder.create();
			break;
		default:
			break;
		}
		return dialog;
	}
	
	
}
