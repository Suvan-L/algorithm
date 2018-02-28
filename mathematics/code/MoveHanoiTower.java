package jdk.util;

import java.util.Scanner;

/**
 * 移动汉诺塔问题
 *    有三根相邻的柱子，标号为A,B,C，A柱子上从下到上按金字塔状叠放着n个不同大小的圆盘，
 *    要把所有盘子一个一个移动到柱子B上，并且每次移动同一根柱子上都不能出现大盘子在小盘子上方，
 *    请问至少需要多少次移动？
 *
 * @author Suvan
 */
public class MoveHanoiTower {

    private int moveCount = 0;

    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入 A 柱中圆盘的数量：");
        int number = sc.nextInt();

        System.out.println("***** 递归计算 *****");

        MoveHanoiTower mht = new MoveHanoiTower();
        mht.move(number, 'A', 'B', 'C');

        System.out.println("***** 结束 *****");
        System.out.println("圆盘从 A 柱子 ---> C 柱子，一共要移动 " + mht.moveCount);
    }

    /**
     * 递归移动函数
     *      - 次数满足规律 2^n - 1
     *          - code：Math.pow(2, n) - 1
     *
     * @param n A 柱中圆盘数量
     * @param src 源柱子
     * @param assist 辅助柱子
     * @param aim 目标柱子
     */
    private void move(int n, char src, char assist, char aim) {
        if (n == 1) {
            System.out.println("移动圆盘（单个）：" + src + " ---> " + aim);
            moveCount ++;
            return;
        }

        move(n - 1, src, aim, assist);
        move(1, src, assist, aim);
        move(n - 1, assist, src, aim);
    }
}
