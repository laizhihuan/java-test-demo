package com.kojavaee.pagerank;

/**
 * 赌钱的游戏:
 * 有甲、乙、丙三个人赌钱，他们的输赢关系如下：
 * 
 * 甲的钱输给乙和丙
 * 乙的钱输给丙
 * 丙的钱输给甲
 * 
 * 甲输给乙50元、输给丙50元
 * 乙输给丙100元
 * 丙输给甲100元
 * 
 * 
 * 总结：世界的很多东西都是零和游戏，就像炒股，股民赚的钱也就是机构亏的钱，机构赚的钱也就是股民亏的钱，
 * 也许股民们应该研究一下PageRank算法，看看股市起起落落的背后是不是收敛了，
 * 收敛了说明炒下去永远别想解套，而且机构永远不会亏。
 * 
 * @see http://www.infoq.com/cn/articles/gamble-and-pagerank
 * @author zhihuanglai
 *
 */
public class Gamble {
	
	private static double x1 = 1.0,x2 = 1.0,x3 = 1.0;
	
	private static void playgame() {
		double x2_income = x1/2.0;
		double x3_income = x1/2.0 + x2;
		double x1_income = x3;
		
		x1=x1_income;
		x2=x2_income;
		x3=x3_income;
		
		System.out.println("x1 : " + x1 + ", x2: " + x2 + ", x3: " + x3);
		
		//可能你都没想到会有这么个规律，这样一直赌下去，虽然各人每轮有输有赢，
		//但是多轮后的输赢结果居然保持平衡，维持不变了。
		//用技术术语来说就是多轮迭代后产生了收敛，
		//用俗话来讲，就是玩下去甲和丙是不亏的，乙不服输再继续赌下去，也不会有扳本的机会的。
		
		//从107轮后，各人的输赢结果就一直是
		//x1:1.2000000000000002, x2:0.6000000000000001, x3:1.2000000000000002
	}
	
	public static void main(String[] args) {
		for(int i=0; i<500; i++) {
			System.out.println("第"+i+"轮 ");
			playgame();
		}
		
	}
}
