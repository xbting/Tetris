
package com.example.testels;

import java.util.HashMap;
import java.util.Map;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.media.AudioManager;
import android.media.SoundPool;
import android.provider.ContactsContract.CommonDataKinds.Nickname;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;

/**
 * 项目名称：TestELS
 * 类名称：TetrisSufaceView
 * 类描述：
 * 创建人：xubt
 * 创建时间：2013-1-11 上午10:47:14
 * -------------------------------修订历史--------------------------
 * 修改人：xubt
 * 修改时间：2013-1-11 上午10:47:14
 * 修改备注：
 * @version：
 */
public class TetrisSufaceView extends  SurfaceView implements Callback,Runnable{
	private Context context;
	private TetrisMoveRunnable tetrisMoveRunnable;
	private Thread tetrisMoveThread;
	private int sleep=50;
	private int duration ;
	private boolean isPause; //游戏是否处于暂停状态
	private boolean isOver;  //游戏是否结束
	private boolean isNew;   //图形是否是刚开始从boundTop位置开始
	
	private int valueKeyDown =0;//按下的键值
	private static final int VALUE_LEFT_KEY=1,VALUE_RIGHT_KEY=2,VALUE_UP_KEY=3,VALUE_DOWN_KEY=4;
	private static final int DIALOG_GAME =1,DIALOG_BACK =2;
	private boolean long_press = false;
	
	
	/**
	 * 
	 * 测试github修改
	 */
	private int testCount=1;
	
	
	private Thread surfaceViewDrawThread;
	private SurfaceHolder surfaceHolder;
	private Canvas canvas;
	private Paint paint,paint1,paintBg;
	
	private static int rows=21,cols = 10;  //把屏幕分成21行，10列
	
	private int screenWidth,ScreenHeight;  //屏幕分辨率
	private int boundLeft,boundRight,boundTop,boundBotttom;  //游戏框四边的坐标
	private int cellSize;   //一个小方块的单元大小
	private Bitmap red_brick_bmp,green_brick_bmp,yellow_brick_bmp;
	private NinePatch red_brick_np,green_brick_np,yellow_brick_np;
	private int cell_top,cell_left;
	private int score;
	private int type,state,nextType,nextState;
	
	private SoundPool soundPool;
	private Map<String, Integer> soundPoolMap;
	private float volum;
	
	
	public TetrisSufaceView(Context context) {
		super(context);
		this.context = context;
		setKeepScreenOn(true);
		surfaceHolder = this.getHolder();
		surfaceHolder.addCallback(this);
		score = 0;
	}
	
	private void initSound(){
		soundPool = new SoundPool(3, AudioManager.STREAM_MUSIC, 0);
		AudioManager audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
		soundPoolMap = new HashMap<String, Integer>();
		soundPoolMap.put("move", soundPool.load(context, R.raw.move, 0));
		soundPoolMap.put("getScore", soundPool.load(context, R.raw.getscore, 0));
		soundPoolMap.put("down", soundPool.load(context, R.raw.down, 0));
	}

	/** 
	 * @方法名：run
	 * @功能描述：
	 * @参数：
	 * @throws
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	/** 
	 * @方法名：surfaceCreated
	 * @功能描述：
	 * @参数：@param holder
	 * @throws
	 */
	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		
	}

	/** 
	 * @方法名：surfaceChanged
	 * @功能描述：
	 * @参数：@param holder
	 * @参数：@param format
	 * @参数：@param width
	 * @参数：@param height
	 * @throws
	 */
	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		// TODO Auto-generated method stub
		
	}

	/** 
	 * @方法名：surfaceDestroyed
	 * @功能描述：
	 * @参数：@param holder
	 * @throws
	 */
	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		
	}

}
