package com.calc;

import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Math.*;

import static java.lang.Math.sqrt;

public class calc {

    public static void main(String[] args) {

        while (true) {


            Scanner reader = new Scanner(System.in);

            System.out.print("\nWelcome to the scientific calculator program. \n");
            System.out.print("Press E to evaluate an expression. Or H to see a list of commands.\n");

            char c = reader.next().charAt(0);

            if (c == 'E' | c == 'e') {
                System.out.println("Enter the expression:");
                Scanner scanner = new Scanner(System.in);
                String exp = scanner.nextLine();
                double result = expression.evaluate(exp);
                System.out.print("The result is " + result + "\n");

            }
            if(c == 'H' | c == 'h'){
                System.out.println("\nType two numbers with an operator such as +,-,* or / to perform basic arithmetic.");
                System.out.println("Trigonometric functions can be used by typing cos(x) or sin(x).");
                System.out.println("Type a ! operator at the end of a number to obtain its factorial.");
                System.out.println("\nPress any key to continue.");
                char k = reader.next().charAt(0);
                continue;

            }
        }
    }
}

class fact{

      static double factorial(double i) {
            if (i == 0)
                return 1;
            else
                return (i * factorial(i - 1));
        }
     }


class trig {

    static double sine(double x){
        Math.toRadians(x);
    return Math.sin(x);
    }

    static double cosine(double x) {

        Math.toRadians(x);
        return Math.cos(x);
    }
}


class expression{
    static double evaluate(String exp) {

        ArrayList<Double> results = new ArrayList<Double>();
        double result=0;

        StringBuilder sb = new StringBuilder(exp);

        int addition  = sb.indexOf(String.valueOf(('+')));
        if(addition != -1){
            double num1 = Double.parseDouble(sb.substring(0,addition));
            double num2 = Double.parseDouble(sb.substring(addition+1,sb.length()));
            result = num1+num2;
        }
        int subtraction  = sb.indexOf(String.valueOf(('-')));
        if(subtraction != -1){
            double num1 = Double.parseDouble(sb.substring(0,subtraction));
            double num2 = Double.parseDouble(sb.substring(subtraction+1,sb.length()));
            result = num1-num2;
        }
        int multiplication  = sb.indexOf(String.valueOf(('*')));
        if(multiplication != -1){
            double num1 = Double.parseDouble(sb.substring(0,multiplication));
            double num2 = Double.parseDouble(sb.substring(multiplication+1,sb.length()));
            result = num1*num2;
        }
        int division  = sb.indexOf(String.valueOf(('/')));
        if(division != -1){
            double num1 = Double.parseDouble(sb.substring(0,division));
            double num2 = Double.parseDouble(sb.substring(division+1,sb.length()));
            result = num1/num2;
        }

        int expon  = sb.indexOf(String.valueOf(('^')));
        if(expon != -1){
            double num1 = Double.parseDouble(sb.substring(0,expon));
            double num2 = Double.parseDouble(sb.substring(expon+1,sb.length()));
            result = num1/num2;
        }
        int sqrt = sb.indexOf("sqrt(");
        if(sqrt != -1){
            int end = sb.indexOf(String.valueOf(')'));
            double num1 = Double.parseDouble(sb.substring(sqrt+5, end));
            result = sqrt(num1);
        }

        int fact1 = sb.indexOf(String.valueOf('!'));
        if(fact1 != -1){
            double num1 = Double.parseDouble(sb.substring(0, fact1));
            result = fact.factorial(num1);
        }

        int cos1 = sb.indexOf("cos(");
        if(cos1 != -1){
            int end = sb.indexOf(String.valueOf(')'));
            double num1 = Double.parseDouble(sb.substring(cos1+4, end));
            result = trig.cosine(num1);
        }
        int sin1 = sb.indexOf("sin(");
        if(sin1 != -1){
            int end = sb.indexOf(String.valueOf(')'));
            double num1 = Double.parseDouble(sb.substring(sin1+4, end));
            result = trig.sine(num1);
        }

        return result;
    }
}