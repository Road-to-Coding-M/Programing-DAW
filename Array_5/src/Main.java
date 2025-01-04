//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args)
    {
        int[][] matrix = {{1,2,3} ,{4,5,6}, {7,8,8}};

        // 第一種解法
        int a = matrix[0][0] , b = matrix[0][1], c = matrix[0][2];
        int d = matrix[1][0] , e = matrix[1][1], f = matrix[1][2];
        int g = matrix[2][0] , h = matrix[2][1], i = matrix[2][2];

        int[] value = {a,b ,c ,d ,e, f, g, h,i};
        int answer_2 = getValue(value);
        System.out.println(answer_2);

        // 第二種解法
        int answer = getMatrix(matrix);
        System.out.println(answer);
    }

    public static int getValue(int[] value)
    {
        int result_2 = (value[0]*value[4]*value[8])+(value[1]*value[5]*value[6])+(value[2]*value[3]*value[7])-((value[0]*value[5]*value[7])+(value[1]*value[3]*value[8])+(value[2]*value[4]*value[6]));
        return result_2;
    }

    public static int getMatrix(int[][] matrix)
    {

        int result = (matrix[0][0]*matrix[1][1]*matrix[2][2])+(matrix[0][1]*matrix[1][2]*matrix[2][0])+(matrix[0][2]*matrix[1][0]*matrix[2][1])-((matrix[0][0]*matrix[1][2]*matrix[2][1])+(matrix[0][1]*matrix[1][0]*matrix[2][2])+(matrix[0][2]*matrix[1][1]*matrix[2][0]));
        return result;
    }
    
}