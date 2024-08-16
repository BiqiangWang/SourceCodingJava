import java.util.Arrays;
import java.util.Scanner;

/**
 * @author wbq
 * @version 1.0
 * @title customInput
 * @description
 * @create 2024/7/5 0:00
 */

public class CustomInput {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numLen = in.nextInt();
        int[] numArr = new int[numLen];
        int i = 0;
        // note: hasNextInt会导致输入完成后仍在等待输入，因此明确输入个数时避免使用这一方法
        while(in.hasNextInt() && i < numLen){
            numArr[i++] = in.nextInt();
            System.out.println(i);
        }
        //读字符串
        int strLen = in.nextInt();
        in.nextLine(); //数字到字符串要换行
        String[] strArr = new String[strLen];
        //或者 strArr[] = in.nextLine().split(" ");
        int j = 0;
        while(in.hasNextLine() && j < strLen){
            strArr[j++] = in.nextLine();
        }
        System.out.println("input over");
        // 调用核心代码
        Solution solution = new Solution();
        String result = solution.process(numArr, strArr);
        // 输出
        System.out.println(result);
        // note: 四舍五入输出小数
        String str = String.format("%.2f",3.555);
        System.out.println(str);

        // case: 解析字符串数组
        //String[] inputs = line.split(" "); //用空格将line字符串分隔开，存入inputs数组中
        String[] inputs = {"A", "10"};
        char ch = inputs[0].charAt(0); // ch = 'A'
//        int n = Integer.parseInt(inputs[1]); // n = 10

        // case: 读取行
//        String nStr = in.nextLine();
//        int n = Integer.parseInt(nStr);
//        while (in.hasNextLine()) {
//            String line = in.nextLine();
//            System.out.println(line);
//        }


    }
}

// 核心代码模式
class Solution {
    public String process(int[] nums, String[] strs) {
        StringBuilder sb = new StringBuilder();
        sb.append(Arrays.toString(nums));
        sb.append(" && ");
        sb.append(Arrays.toString(strs));
        return sb.toString();
    }
}
