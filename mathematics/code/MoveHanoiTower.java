package jdk.util;

import java.util.Scanner;

/**
 * �ƶ���ŵ������
 *    ���������ڵ����ӣ����ΪA,B,C��A�����ϴ��µ��ϰ�������״������n����ͬ��С��Բ�̣�
 *    Ҫ����������һ��һ���ƶ�������B�ϣ�����ÿ���ƶ�ͬһ�������϶����ܳ��ִ�������С�����Ϸ���
 *    ����������Ҫ���ٴ��ƶ���
 *
 * @author Suvan
 */
public class MoveHanoiTower {

    private int moveCount = 0;

    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("������ A ����Բ�̵�������");
        int number = sc.nextInt();

        System.out.println("***** �ݹ���� *****");

        MoveHanoiTower mht = new MoveHanoiTower();
        mht.move(number, 'A', 'B', 'C');

        System.out.println("***** ���� *****");
        System.out.println("Բ�̴� A ���� ---> C ���ӣ�һ��Ҫ�ƶ� " + mht.moveCount);
    }

    /**
     * �ݹ��ƶ�����
     *      - ����������� 2^n - 1
     *          - code��Math.pow(2, n) - 1
     *
     * @param n A ����Բ������
     * @param src Դ����
     * @param assist ��������
     * @param aim Ŀ������
     */
    private void move(int n, char src, char assist, char aim) {
        if (n == 1) {
            System.out.println("�ƶ�Բ�̣���������" + src + " ---> " + aim);
            moveCount ++;
            return;
        }

        move(n - 1, src, aim, assist);
        move(1, src, assist, aim);
        move(n - 1, assist, src, aim);
    }
}
