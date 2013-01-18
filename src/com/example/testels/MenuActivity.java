
package com.example.testels;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

/**
 * 项目名称：TestELS
 * 类名称：MenuActivity
 * 类描述：
 * 创建人：xubt
 * 创建时间：2013-1-18 上午10:32:55
 * -------------------------------修订历史--------------------------
 * 修改人：xubt
 * 修改时间：2013-1-18 上午10:32:55
 * 修改备注：
 * @version：
 */
public class MenuActivity extends Activity{
	private TextView playTxt;
	private TextView rankingTxt;
	private TextView indroduceTxt;
	/** 
	 * @方法名：onCreate
	 * @功能描述：
	 * @参数：@param savedInstanceState
	 * @throws
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		Typeface font = Typeface.createFromAsset(getAssets(), "fonts/hkgirl.ttf");
		setContentView(R.layout.menu_main_layout);
		playTxt = (TextView) findViewById(R.id.paly_txt);
		rankingTxt = (TextView) findViewById(R.id.ranking_txt);
		indroduceTxt = (TextView) findViewById(R.id.introduce_txt);
		playTxt.setTypeface(font);
		rankingTxt.setTypeface(font);
		indroduceTxt.setTypeface(font);
		playTxt.setOnClickListener(listener);
		rankingTxt.setOnClickListener(listener);
		indroduceTxt.setOnClickListener(listener);
	}
	private View.OnClickListener listener = new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.paly_txt:
				Intent intent = new Intent(MenuActivity.this, MainActivity.class);
				startActivity(intent);
				break;
			case R.id.ranking_txt:
				
				break;
			case R.id.introduce_txt:
				
				break;

			default:
				break;
			}
		}
	};
}
