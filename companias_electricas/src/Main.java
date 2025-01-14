import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        double preciokWh = 0.3720;
        String salir;

        do  //先用do 至少可以先跑一遍
        {
            System.out.println("Introduce el nombre de cliente: ");
            String nombre = scanner.next();
            String contrato = numContrato(scanner);
            double potencia = potContratada(scanner);
            double consumirKw = kwConsumidos(scanner);
            double incremento = calculaIncremento(consumirKw);
            // 用前面的變數 來取代參數
            double importe = calculaImporte(potencia, consumirKw, preciokWh);

            System.out.println("Cliente: " + nombre);
            System.out.println("El numero de contrato es: " + contrato);
            System.out.println("La Potencia contratada es: " + potencia + " kw ");
            System.out.println("El total de Kw consumidos son: " + consumirKw + " kw ");
            System.out.println("El  Incremento a pagar es de: " + incremento);
            System.out.println("El Total del Importe facturado es de: " + (importe + incremento) + " € ");

            do
            {
                System.out.println("¿Desea procesar mas clientes? si/no: ");
                salir = scanner.next();
            }
            while(!salir.equalsIgnoreCase("si") && !salir.equalsIgnoreCase("no"));
        }
        while(salir.equalsIgnoreCase("si"));
    }

    public static String numContrato(Scanner scanner)
    {
        boolean valid = false;
        String input = " ";


        while(!valid)
        {
            System.out.println("Introduce el numero de contrato: ");
            input = scanner.next();
            Pattern pat = Pattern.compile("\\d{3}-\\d{4}");  //指定抓取範圍
            Matcher mat = pat.matcher(input);  //從用戶輸入讀取是否match

            valid = mat.matches();
            if(valid == false)
            {
                System.out.println("Formato incorrecto!");
            }
        }
        return input;
    }

    public static double potContratada(Scanner scanner)
    {
        boolean valid = false;
        double input = 0;

        while(!valid)
        {
            System.out.println("Introduce tu potencia contratada: ");
            System.out.println("2.30 , 3.45, 4.60, 5.75 , 6.90, 8.05");
            input = getDoubleCheck(scanner);

            if(input == 2.30 || input == 3.45 || input == 4.60 || input ==5.75 ||
                input == 6.90 || input == 8.05)
            {
                valid = true;
            }
            else
            {
                System.out.println("Formato incorrecto! Deberia introducir potencia contratada: ");
            }
        }
        return input;
    }

    public static double getDoubleCheck(Scanner scanner)
    {
        double num;
        while(true)
        {
            if(scanner.hasNextDouble()) //先設條件 非double直接到else
            {
                num = scanner.nextDouble(); //使用者者奢入
                if(num > 0) // 確定double後 更進一步做判斷
                {
                    return num;
                }
                else
                {
                    System.out.println("Deberia ser mas mayor que 0");
                }
            }
            else
            {
                System.out.println("Deberia ser interger double");
                scanner.next();
            }
        }
    }

    public static double kwConsumidos(Scanner scanner)
    {
        double lecAnterior, lecActual;
        double kwkwTotal = -1;

        boolean valid = false;
        while(!valid)
        {
            System.out.println("Introduce la lectura anterior :");
            lecAnterior = getDoubleCheck(scanner);

            System.out.print("Introduce la lectura actual : ");
            lecActual = getDoubleCheck(scanner);

            kwkwTotal = lecActual-lecAnterior;

            if(lecAnterior > lecActual)
            {
                System.out.println("La lectura anterior no puede ser mayor que la de actual.");
            }
            else
            {
                valid = true;
            }
        }
        return kwkwTotal;
    }

    public static double calculaIncremento(double kw)
    {
        double incremento;  //incremento不用初始化 因為有else if非常明確的階級
        if(kw > 0 && kw < 150)
        {
            incremento = (kw * 0);
        }
        else if(kw > 150 && kw < 300)
        {
            incremento = (kw * 0.05);
        }
        else if(kw > 300 && kw < 400)
        {
            incremento = (kw * 0.08);
        }
        else
        {
            incremento = (kw * 0.12);
        }
        return incremento;
    }

    public static double calculaImporte(double potencia, double kwh, double preciokWh)
    {
        double importe, tarifaFija = 0;
        if(potencia == 2.3)
        {
            tarifaFija = 7.29;
        }
        else if(potencia == 3.45)
        {
            tarifaFija = 10.94;
        }
        else if(potencia == 4.60)
        {
            tarifaFija = 14.58;
        }
        else if(potencia == 5.75)
        {
            tarifaFija = 18.23;
        }
        else if(potencia == 6.90)
        {
            tarifaFija = 21.87;
        }
        else if(potencia == 8.05)
        {
            tarifaFija = 25.52;
        }

        importe = (preciokWh * kwh) + tarifaFija;
        return importe;
    }
}



