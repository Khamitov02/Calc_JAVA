import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        flag=false;





        while(true) {
            Scanner scan = new Scanner(System.in);

            String str1 = scan.nextLine();
            System.out.println(calc(str1));

        }


    }
     static boolean flag; // Флаг, показывающий какие числа складываются. Если True, то римские, иначе арабские.
    static boolean flag2; // Флаг, показывающйи что некорректный ввод  чисел вида  2 + I
    public static String calc(String input) throws Exception {
        flag2 = false;flag = false;
    int result = 0; // результат работы калькулятора
    String[] str2 = input.split(" ");
    if(str2.length!=3) throw new Exception();
    for (int j=0; j<3;j++) {
        for (int i=0;i<str2[j].length();i++) {

            if (j != 1 && (!(str2[j].codePointAt(i) >= 48 && str2[j].codePointAt(i) <= 57) && (str2[j].codePointAt(i) != 73) && (str2[j].codePointAt(i) != 86) && (str2[j].codePointAt(i) != 73) && (str2[j].codePointAt(i) != 88))
            )
                throw new Exception();
            if (!(str2[1].equals("+") || str2[1].equals("-") || str2[1].equals("*") || str2[1].equals("/"))
            ) throw new Exception();
        }
    } // Отсеивание недопустимых символов

         for (int j=0; j<3;j++) {
            if (j!=1)
            for (int i=0;i<str2[j].length();i++) {
                if (!(str2[j].codePointAt(i) >= 48 && str2[j].codePointAt(i) <= 57)){ flag2 =true;break;}


            }
        if (flag2) break;
        }  // Проверка на все числа арабские
        if (flag2) {flag=true;flag2=false;
        for (int j=0; j<3;j++) {

            if (j!=1)
                for (int i=0;i<str2[j].length();i++) {
                    if ((str2[j].codePointAt(i) != 73) && (str2[j].codePointAt(i) != 86) && (str2[j].codePointAt(i) != 73) && (str2[j].codePointAt(i) != 88))
            { flag2 =true;break;}


                }
            if (flag2) {throw new Exception();}
        } } // Проверка на все числа римские
         int x=0; //первое слагаемое
         int y=0; //второе слагаемое
    if(!flag) {
        if (Integer.parseInt(str2[0]) > 10 || Integer.parseInt(str2[0]) == 0 || Integer.parseInt(str2[2]) > 10 || Integer.parseInt(str2[2]) == 0)
            throw new Exception();
        x=Integer.parseInt(str2[0]);
        y=Integer.parseInt(str2[2]);
    } else {
     x=translateFromRoman(str2[0]);
     y=translateFromRoman(str2[2]);

    }
        switch (str2[1]) {
            case "+":
                result = x + y;
                break;
            case "-":
                result = x - y;
                break;
            case "*":
                result = x * y;
                break;
            case "/":
                result = x / y;
                break;

        }

if (flag && result<=0) throw new Exception();// проверка на положительность римских чисел
    if (flag) return translateToRoman(result)+"";
    else return result+"";

    }

     static int translateFromRoman(String s) throws Exception{
        int result =0;// то что возвращаем
        switch (s){
            case "I":
                result = 1; break;
            case "II":
                result = 2; break;
            case "III":
                result = 3; break;
            case "IV":
                result = 4; break;
            case "V":
                result = 5; break;
            case "VI":
                result = 6; break;
            case "VII":
                result = 7; break;
            case "VIII":
                result = 8; break;
            case "IX":
                result = 9; break;
            case "X":
                result = 10; break;
            default:
                throw new Exception();  // несуществующее римское число

        }

         return result;
    }

    static String translateToRoman(int result) {
        int[] array = {1,4,5,9,10,40,50,90,100};
        String[] mas = {"I","IV","V","IX","X","XL","L","XC","C"};
       String s=""; //итоговая строка
        for (int i=8;i>=0;i--)
            while(result>=array[i])
            {
                s+=mas[i];
                result=result-array[i];
            }

        return s;
    }

}
