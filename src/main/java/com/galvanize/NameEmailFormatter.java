package com.galvanize;

public class NameEmailFormatter {

    public static void main(String[] args) {

        if (args.length == 0)
            System.out.println("Please specify a name and email");
        else if (args.length == 1)
            System.out.println("Please specify an email for " + args[0]);
        else {
            String firstArgument = args[0];   // arg1
            String secondArgument = args[1];  // arg2

            System.out.println(args[0] + " <" + args[1] + ">");
        }
    }

}