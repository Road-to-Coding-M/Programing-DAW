import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce todos alumnos:");
        int input = scanner.nextInt();
        int sumOfHeight = 0;
        double averageHeight = 0;
        int tall = 0;
        int short_Height = 0;

        if(input>0)
        {
            int i =0;
            double[] person = new double[input];
            System.out.println("Introduce la altura:");
            // this for: to save the input's datas and calculate sumOfHeight
            for(i = 0; i<input; i++)
            {
                person[i] = scanner.nextDouble();

                sumOfHeight += person[i];
            }
            averageHeight = (double) sumOfHeight / input;

            // and this for: to compare which is taller or shorter
            // be careful about the j <person.lenth
            // not the j < person[i], because i already is 4
            for(int j = 0; j<person.length; j++)
            {
                if(person[j] >averageHeight)
                {
                    tall ++;
                }
                else if (person[j] < averageHeight)
                {
                    short_Height++;
                }
            }
            System.out.println("average height is" +" "+ averageHeight);
            System.out.println("Hay"+" " + tall + " " +"personas a las que más de medioaltura.");
            System.out.println("Hay" + " " +short_Height +" " + "personas a las que menos de medioaltura.");
        }
        else
        {
            System.out.println("El número tiene que mayor que 0");
        }
    }

}