import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("How many students?");
        int numOfStudents = getInputCheck(scanner);
        // funtion參數有兩個 這邊也要帶入兩個
        String[] names = getStudentNames(scanner, numOfStudents);
        /*
        System.out.println("Sudents names are :");
        for(String name: names)
        {
            System.out.println(name);
        }
        */
        int[] scores = new int[numOfStudents];
        System.out.println("How many questions?");
        int numOfQuestion = getInputCheck(scanner);
        char[] answers = getCorrectAnswers(scanner, numOfQuestion);

        //getStudentAnswers 放在main 也顯示學生名字
        char[][] stu_answer = getStudentAnswers(scanner, numOfQuestion,numOfStudents, names,answers, scores);
        /*
        for(char[] stu: stu_answer)
        {
            System.out.println(stu);
        }
        */

        showMenu();
        int option = getInputCheck(scanner);
        boolean keepRunning = true;
        do
        {
            if(option >= 1 && option <= 4)
            {
                handleMenuOption(scanner, option, names, scores, answers, stu_answer);
                showMenu();
                option = getInputCheck(scanner);
            }
            else if (option == 5)
            {
                handleMenuOption(scanner, option, names, scores, answers, stu_answer);
                keepRunning = false;
            } else
            {
                System.out.println("Wrong input! Please enter from 1~5");
                showMenu();
                option = getInputCheck(scanner);
                scanner.nextLine();
            }
        }while(keepRunning);  // 一直循環直到用戶選擇退出

    }
    // array of students' name
    public static String[] getStudentNames(Scanner scanner, int numOfStudents)
        {
            String[] students = new String[numOfStudents]; // set 3 students

            for(int i=0; i < students.length; i++)
            {
                System.out.println("Please enter your name" + " "+ (i+1) +":");
                students[i] = scanner.next();
            }
            return students;
        }

        // to input the correct number
        public static char[] getCorrectAnswers(Scanner scanner, int numOfQuestion)
        {
            char[] correctAnswer = new char[numOfQuestion]; // correct answer 有幾像

            for(int i=0; i < numOfQuestion; i++)
            {
                System.out.println("Enter the correct answer for question" + " " + (i+1) + ":");
                correctAnswer[i] = scanner.next().toUpperCase().charAt(0); // to read the first character

                // to check if it is valid the answer
                while (correctAnswer[i] < 'A' || correctAnswer[i] > 'E')
                {
                    System.out.println("Invalid number! Please enter again!");
                    // 報錯後 必須重新讀取用戶新輸入的值
                    // 不然while會爆掉
                    correctAnswer[i] = scanner.next().toUpperCase().charAt(0);
                }
            }
            return  correctAnswer;
        }

        // check the students'questions and correct answers
        public static char[][] getStudentAnswers(Scanner scanner, int numOfQuestion, int numOfStudents, String[] names, char[] answers, int[] scores)
        {
            char[][] studentAnswer = new char[numOfStudents][numOfQuestion];

            for(int i=0; i < numOfStudents; i++) //each students
            {
                int score = 0;  //每個學生的起始點都是0
                System.out.println("Enter answer for student" + " " + names[i]);
                for(int j = 0; j < numOfQuestion; j++ ) //one of students - questions
                {
                    System.out.println("Questions" + " " + (j+1) + ":");
                    studentAnswer[i][j] = scanner.next().toUpperCase().charAt(0);

                    //to check if it is valid the answer
                    while( studentAnswer[i][j] <'A' || ( studentAnswer[i][j] >'E'))
                    {
                        System.out.println("Invalid number! Please enter again!");
                        studentAnswer[i][j] = scanner.next().toUpperCase().charAt(0);
                    }

                    // studentAnswer[j].equals(answers[i]) 不可以這樣比
                    // 因為studentAnswer是char 不是字符串
                    // 用 ==
                    if(studentAnswer[i][j] == (answers[j]))
                    {
                        score ++;
                    }
                }
                // 將分數儲存在陣列中
                scores[i] = score;
            }
            return studentAnswer;
        }

        //memu
        public static void showMenu()
        {
            System.out.println("The menu:");
            System.out.println("Option 1 Grades.");
            System.out.println("Option 2 Medias.");
            System.out.println("Option 3 Students' grade.");
            System.out.println("Option 4 Answer rate");
            System.out.println("Option 5 Exit.");
        }

        public static void handleMenuOption(Scanner scanner,int option,String[] names, int[] scores, char[] answers,char[][] stu_answer)
        {

            switch (option)
            {

                case 1:
                    System.out.println("The grades of all students:" + " ");
                    for (int i = 0; i < names.length; i++)
                    {
                        System.out.println(names[i] + " " + scores[i] + " " + "points");
                    }
                    break;

                case 2:
                    double sum = 0;
                    for (int i = 0; i < names.length; i++)
                    {
                        sum += scores[i];
                    }
                    double media = (sum / names.length);
                    System.out.println("The media grade is" + " ");
                    System.out.println(media);
                    break;

                case 3:
                    boolean found = false;
                    System.out.println("Please enter the student's name:");
                    String input = scanner.next();

                    for(int i=0; i < names.length; i++)
                    {
                        if(input.equals(names[i]))  //String 可以用equal 其他的用 ==
                        {
                            System.out.println("The grade is" + " " + scores[i]);
                            found = true;
                            break;
                        }
                    }
                    if(!found)
                    {
                        System.out.println("Can't find this student!");
                        found = true;
                    }
                    break;

                case 4:
                    int[] count = new int[answers.length];
                    //int maxAccurate = count[0];  //count[0] = 0
                    int maxAccurate = -1; // 為了避免導致錯誤 設一個不可能的數 //為什麼一定要負的?
                    int maxQuestionIndex = 0;
                    for(int i = 0; i < names.length; i++)
                    {
                        for(int j=0; j < answers.length; j++)
                        {
                            if(stu_answer[i][j] == answers[j])
                            {
                                count[j] ++;

                                if(count[j] > maxAccurate)
                                {
                                    maxAccurate = count[j];
                                    maxQuestionIndex = j + 1 ; //j要加1!!!!!  因為j是從0開始
                                }
                            }
                        }
                    }
                    //return count; 為什麼不能用?
                    System.out.println("The accurate answers is the question" + " " + ": " + maxQuestionIndex);

                    //System.out.println(Arrays.toString(count)); //[1, 3, 0]
                    break;

                case 5:
                    System.out.println("Thanks for using this program!");
                    break;

                default:
                    System.out.println("Wrong number!! Only from 1-5!");
            }

        }

        //check the users' inputs
        //public static int getInputCheck(Scanner scanner, String prompt)
        public static int getInputCheck(Scanner scanner)
        {
            int num;
            while(true)
            {
                // System.out.println(prompt);
                if(scanner.hasNextInt())  //public boolean hasNextInt()
                {
                    num = scanner.nextInt();
                    if(num > 0)
                    {
                        return num; //如果符合條件，返回這個數字並結束方法
                    }
                    else
                    {
                        System.out.println("Please enter a positive num!");
                    }
                }
                else
                {
                    System.out.println("Invalid input! Please enter again!");
                    scanner.next(); //它會讀取並清空使用者輸入的「錯誤內容」
                }
            }
        }
}