import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a random interger :");
        int input = getInputCheck(scanner);

        System.out.println("Please enter your positive interger :");
        int[] numOfInput = getNumber(scanner,input);
        getCaracter(numOfInput);
    }

    public static int getInputCheck(Scanner scanner)
    {
        int num;
        while (true)
        {
            if(scanner.hasNextInt()) //先設立好檢查條件
            {
                num = scanner.nextInt(); //使用者再輸入
                if(num > 0)
                {
                    return num;
                }
                else
                {
                    System.out.println("Please enter the positive num!");
                }
            }
            else
            {
                System.out.println("Only accept Interger");
            }
        }
    }

    public static int[] getNumber(Scanner scanner, int input)
    {
        int[] numOfInput = new int[input]; //設立箱子的容量

        for(int i = 0; i < input ; i++)
        {
            // 為什麼這邊可以用getInputCheck? 不同域數?
            // 這是因為 getInputCheck 是靜態方法 (static)
            // 所以無論在哪個靜態方法中（如 main 或 getNumber）
            // 都可以直接使用它而不需要創建物件。
            int inputNum = getInputCheck(scanner);
            numOfInput[i] = inputNum;

            /*
            for(int j = 0; j < numOfInput[i] ; j++)
            {
                System.out.print("*");
            }

            System.out.println(); //換行
             */
        }
        return numOfInput;
    }

    //方法二
    //將列印星星 另外設立方法
    public static void getCaracter(int[] numOfInput)
    {
        for(int i = 0; i < numOfInput.length; i++)
        {
            for(int j = 0; j < numOfInput[i] ; j++)
            {
                System.out.print("*");
            }
            System.out.println(); //換行
        }

    }
}