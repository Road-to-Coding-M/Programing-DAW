import java.util.Random;
import java.util.Scanner;


public class Main {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String[] colors = {"ROJO","AZUL","VERDE","AMARILLO","NARANJA","BLANCO"};
        Random random = new Random();

      //to save the random color
        String[] selectColors = new String[4];

        int index = 0;  // 4 positions

        while(index < 4)
        {
            int randomIndex = random.nextInt(colors.length);
            String randomColor = colors[randomIndex];
            boolean checkRepeat = false; //NO REPEAT COLOR
            for (int i = 0; i < index; i++)
            {
                if (selectColors[i].equals(randomColor))
                {
                    checkRepeat = true; //REPEAT
                    break;
                }
            }
            if(!checkRepeat) //NO REPEAT
            {
                selectColors[index] = randomColor;
                index++;
            }
        }
        /*
        for(String colorName : selectColors)
        {
            System.out.println(colorName);
        }
        */


        int count_a = 0;
        int count_b = 0;
        int times = 10;
        boolean win = false;
        System.out.println("Introduce el color: ");

        while(times > 0 && !win)
        {
            String[] guessColor = new String[4]; //read user input
            count_a = 0;
            count_b = 0;
            for(int j = 0; j < guessColor.length; j++) //user guess color
            {
                guessColor[j] = scanner.next(); //save user inputs

                if(guessColor[j].equals(selectColors[j])) //same color same positon
                {
                    count_a ++;
                    if(count_a == 4)
                    {
                        System.out.println("Ganaste!! Enhorabuena!!");
                        win = true;
                    }
                }
                else
                {
                    for(int k = 0; k < selectColors.length; k++)
                    {
                        if(j != k && guessColor[j].equals(selectColors[k])) //same color wrong positon
                        {
                            count_b ++;
                            break;
                        }
                    }
                }

            }
            System.out.println("Muertos:" + count_a + " " + "Heridas:" + count_b);
            times --;
        }

        if(!win)
        {
            System.out.println("Ya ha perdido!" + " "); //lose
            System.out.println("La respuesta es:" + " "); //ans
            for(String colorName : selectColors)
            {
                System.out.println(colorName);
            }
        }
    }
}