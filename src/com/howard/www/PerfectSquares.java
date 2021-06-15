package com.howard.www;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/perfect-squares/
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 *
 * 给你一个整数 n ，返回和为 n 的完全平方数的 最少数量 。
 *
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/perfect-squares
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PerfectSquares {
    public int numSquares(int n) {
        int mark = (new Double(Math.sqrt(n))).intValue();
        if(mark*mark==n){
            return 1;
        }
        int point=mark;
        int temp;
        int sum_temp=0;
        for(temp=2;temp<=n;temp++){
            int[] countList=new int[temp];
            int[] subtraction=new int[temp];
            for(int loop=0;loop<temp;loop++){
                countList[loop]=point;
                subtraction[loop]=0;
            }
            while(subtraction[0]!=-1){
                sum_temp=0;
                for(int i=0;i<countList.length;i++) {
                    int value=countList[i]-subtraction[i];
                    sum_temp+=value*value;
                }
                if(sum_temp==n){
                    for(int i=0;i<countList.length;i++) {
                        int value=countList[i]-subtraction[i];
                        countList[i]=value;
                    }
                    System.out.println(Arrays.toString(countList));
                    break;
                }
                int end_cursor=subtraction.length-1;
                int c=subtraction[end_cursor];
                int value=c+1;
                while(value==point){
                    subtraction[end_cursor]=0;
                    if(end_cursor==0){
                        value=-1;
                    }else{
                        end_cursor--;
                        c=subtraction[end_cursor];
                        value=c+1;
                    }
                }
                subtraction[end_cursor]=value;
            }
            if(sum_temp==n){
                return temp;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        PerfectSquares solution=new PerfectSquares();
        System.out.println(solution.numSquares(210));
    }
}
