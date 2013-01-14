/**********************************************************************
 * FILE                ：Shape.java
 * PACKAGE			   ：com.example.testels
 * AUTHOR              ：xubt
 * DATE				   ：2013-1-10 上午11:57:58
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

/**
 * 项目名称：TestELS
 * 类名称：Shape
 * 类描述：
 * 创建人：xubt
 * 创建时间：2013-1-10 上午11:57:58
 * -------------------------------修订历史--------------------------
 * 修改人：xubt
 * 修改时间：2013-1-10 上午11:57:58
 * 修改备注：
 * @version：
 */
public class Shape {
	public final static int LEFT=1,RIGHT=2,DOWN=3,STATECHANGE=1,MOVE =2;
	public final int[][] map=null;
	
	public static int[][][]shape=new int[][][]{
		/**
		 * 第一种类型
		 */
		
		{	/**
		 	*  ####	
		 	*/
			{1,1,1,1},{0,0,0,0},{0,0,0,0},{0,0,0,0},
			
			/**
			 * 	#
			 * 	#
			 * 	#
			 *  #
			 */
			{0,1,0,0},{0,1,0,0},{0,1,0,0},{0,1,0,0},
			
		},
		/**
		 * 第二种类型
		 */
		{	
			/**
			 *    #
			 * 	 ### 
			 */
			{0,1,0,0},{1,1,1,0},{0,0,0,0},{0,0,0,0},
			/**
			 * 	#
			 * 	##
			 * 	#
			 */
			{1,0,0,0},{1,1,0,0},{1,0,0,0},{0,0,0,0},
			/**
			 * 	###
			 * 	 #
			 */
			{1,1,1,0},{0,1,0,0},{0,0,0,0},{0,0,0,0},
			/**
			 * 	 #
			 * 	##
			 * 	 #
			 */
			{0,1,0,0},{1,1,0,0},{0,1,0,0},{0,0,0,0}
		},
		/**
		 * 第三种类型
		 */
		{
			/**
			 * #
			 * ###
			 */
			{1,0,0,0},{1,1,1,0},{0,0,0,0},{0,0,0,0},
			
			/**
			 * ##
			 * #
			 * #
			 */
			{1,1,0,0},{1,0,0,0},{1,0,0,0},{1,0,0,0},
			/**
			 * ###
			 * 	 #	
			 */
			{1,1,1,0},{0,0,1,0},{0,0,0,0},{0,0,0,0},
			/**
			 * 	#
			 * 	#
			 * ##
			 * 
			 */
			{0,1,0,0},{0,1,0,0},{1,1,0,0},{0,0,0,0}
		},
		/**
		 * 第四种类型
		 * 
		 */
		{
			/**
			 *    #
			 *  ###   
			 */
			{0,0,1,0},{1,1,1,0},{0,0,0,0},{0,0,0,0},
			/**
			 * #
			 * #
			 * ##
			 */
			{1,0,0,0},{1,0,0,0},{1,1,0,0},{0,0,0,0},
			/**
			 * ###
			 * #
			 */
			{1,1,1,0},{1,0,0,0},{0,0,0,0},{0,0,0,0},
			/**
			 * ##
			 *  #
			 *  #
			 */
			{1,1,0,0},{0,1,0,0},{0,1,0,0},{0,0,0,0}
		},
		/**
		 * 第五种类型
		 */
		{
			/**
			 *	#
			 *  ##
			 *   #
			 */
			{1,0,0,0},{1,1,0,0},{0,1,0,0},{0,0,0,0},
			/**
			 * 	  ##
			 * 	 ##
			 */
			{0,1,1,0},{1,1,0,0},{0,0,0,0},{0,0,0,0}
		},
		/**
		 * 第六种
		 */
		{
			/**
			 * 
			 *   #
			 *  ##
			 *  #
			 * 
			 */
			{0,1,0,0},{1,1,0,0},{1,0,0,0},{0,0,0,0},
			
			/**
			 *  ##
			 *   ##
			 */
			{1,1,0,0},{0,1,1,0,0},{0,0,0,0},{0,0,0,0}
		},
		/**
		 * 第七种
		 * 		 ##
		 * 		 ##	
		 */
		{
			{1,1,0,0},{1,1,0,0},{0,0,0,0},{0,0,0,0}
		}
	};
	/**
	 * 
	 * @方法名：isBound
	 * @功能描述：判断是否到达边界（到达则不可变化或移动）
	 * @创建人：xubt
	 * @创建时间：2013-1-11 上午10:13:32
	 * @参数：@param type
	 * @参数：@param state
	 * @参数：@param cellLeft
	 * @参数：@param cellTop
	 * @参数：@param cellSize
	 * @参数：@param direction
	 * @参数：@param boundLeft
	 * @参数：@param bountRight
	 * @参数：@param boundTop
	 * @参数：@param boundBottom
	 * @参数：@param action
	 * @参数：@return
	 * @返回：boolean
	 * @throws
	 */
	public static boolean isBound(int type, int state, int cellLeft,
			int cellTop, int cellSize, int direction, int boundLeft,
			int bountRight, int boundTop, int boundBottom, int action) {
		
		if(action==STATECHANGE){
			state = stateChange(type, state);
			//state为变形后的形状，检验该形状是否合法（未出界）
			for (int j = state; j <state+4 ; j++) {
				for (int k = 0; k < 4;k++) {
					if(shape[type][j][k]==1){
						int cell_top = cellTop+(j-state)*cellSize;
						int cell_left = cellLeft+(k-2)*cellSize;
						
						int mapX= (cell_left-boundLeft)/cellSize;
						int mapY =(cell_top-boundTop)/cellSize;
					}
				}
			}
		}else if(action==MOVE){
			
		}
		
		return true;
	}
	
	/**
	 * 
	 * @方法名：stateChange
	 * @功能描述：变形
	 * @创建人：xubt
	 * @创建时间：2013-1-11 上午10:17:48
	 * @参数：@param type
	 * @参数：@param state
	 * @参数：@return
	 * @返回：int
	 * @throws
	 */
	public static int stateChange(int type,int state){
		int lenght = Shape.shape[type].length;
		
		return (state+4)%lenght;
	}
	
	/**
	 * 
	 * @方法名：moveLeft
	 * @功能描述：左移
	 * @创建人：xubt
	 * @创建时间：2013-1-11 上午10:19:54
	 * @参数：@param cellLeft
	 * @参数：@param cellSize
	 * @参数：@return
	 * @返回：int
	 * @throws
	 */
	public static int moveLeft(int cellLeft,int cellSize){
		cellLeft-=cellSize;
		return cellLeft;
	}
	
	/**
	 * 
	 * @方法名：moveRight
	 * @功能描述：右移
	 * @创建人：xubt
	 * @创建时间：2013-1-11 上午10:21:10
	 * @参数：@param cellLeft
	 * @参数：@param cellSize
	 * @参数：@return
	 * @返回：int
	 * @throws
	 */
	public static int moveRight(int cellLeft,int cellSize){
		cellLeft+=cellSize;
		return cellLeft;
	}
	
	/**
	 * 
	 * @方法名：moveDown
	 * @功能描述：下移
	 * @创建人：xubt
	 * @创建时间：2013-1-11 上午10:22:20
	 * @参数：@param cellTop
	 * @参数：@param cellSize
	 * @参数：@return
	 * @返回：int
	 * @throws
	 */
	public static int moveDown(int cellTop,int cellSize){
		cellTop+=cellSize;
		return cellTop;
	}
}
