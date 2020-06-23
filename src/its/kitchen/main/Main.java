package its.kitchen.main;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Locale;

import its.kitchen.ingredients.Ingredient;
import its.kitchen.io.Load;
import its.kitchen.modes.CompletelyRandom;
import its.kitchen.modes.ParameterRandom;

public class Main{

    public static String data_version = null;
    public static String version = "0.1_testing";
    //public static String dataPath = "ingredients.txt";
    public static String dataPath = "/home/max/ingredients.txt";

    public static ArrayList<Ingredient> ingerdients;

    public static int mode = 0;//1;
    public static ParameterRandom paramRand;

    public static boolean verbose = false;

    public static void main(String[] args){
        int i = 0;
        paramRand = new ParameterRandom();
        /**
         * -f Specifies the data-file. If not present, look in current directory for ingredients.txt.
         * -m Specifies the mode, this program should use.
         * -v Specifies if the user wants more output.
         * -s Specifies the maximum number of steps, the user wants to make.
         * -i Specifies the maximum number of ingredients, the user wants to use.
         * -u Specifies the units that are used in th program. If not specified the local locale will be used.
         * -h displays a help-page.
         * */
        for (i = 0; i < args.length; i++){
            if(args[i].equals("-h")){

                System.out.println("Kitchen Bravery v." + version + " help.");
                System.out.printf("%-2s %s\n", "-f", "Specifies the data-file. If not present, look in current directory for ingredients.txt.");
                System.out.printf("%-2s %s\n", "-m", "Specifies the mode, this program should use.");
                System.out.printf("%-2s %s\n", "-v", "Enables verbose output");
                System.out.printf("%-2s %s\n", "-s", "How much steps you want to do at maximum.");
                System.out.printf("%-2s %s\n", "-i", "How many ingredients you want to use.");
                System.out.printf("%-2s %s\n", "-u", "What units you use. If not specified, the system-language will be used.");
                System.out.printf("%-2s %s\n", "-h", "Displays this help message.");

                System.exit(0);
            }else if(args[i].equals("-f")){
                if(i + 1 >= args.length){
                    System.err.println("No file specified!\nUsing ingredients.txt");
                }else if(args[i + 1].contains("-")) System.err.println("No file specified!\nUsing ingredients.txt");
                else{
                    dataPath = args[i + 1];
                    i++;
                }
            }else if(args[i].equals("-m")){
                if(i + 1 >= args.length){ //these 2 can't be merged! DON'T EVEN THINK ABOUT IT!
                    System.err.println("No mode specified!\nProceeding with parameter-mode: 5(max) steps, 10(max) ingredients.");
                    mode = MODE_PARAMETER_RANDOM;
                    paramRand.setMaxSteps(5);
                    paramRand.setMaxIngredients(10);
                }else if(args[i + 1].contains("-")){
                    System.err.println("No mode specified!\nProceeding with parameter-mode: 5 steps, 10 ingredients.");
                    mode = MODE_PARAMETER_RANDOM;
                    paramRand.setMaxSteps(5);
                    paramRand.setMaxIngredients(10);
                }else{
                    if(args[i + 1].equalsIgnoreCase("random")){
                        mode = MODE_COMPLETELY_RANDOM;
                        i++;
                    }else if(args[i + 1].equalsIgnoreCase("parameter")){
                        mode = MODE_PARAMETER_RANDOM;
                        i++;
                    }else if(args[i + 1].equalsIgnoreCase("lying") && i + 2 >= args.length){
                        if(args[i + 2].equalsIgnoreCase("around"))
                            mode = MODE_LYING_AROUND; //we don't want an index out of bounds
                        else{
                            mode = MODE_PARAMETER_RANDOM;
                            paramRand.setMaxSteps(5);
                            paramRand.setMaxIngredients(10);
                        }
                        i += 2;
                    }
                }
            }else if(args[i].equals("-v")){
                verbose = true;
            }else if(args[i].equals("-s")){
                if(i + 1 >= args.length){
                    System.err.println("No number of steps specified!\nGoing with maximum 5 steps.");
                    paramRand.setMaxSteps(5);
                    continue;
                }else if(args[i + 1].contains("-")){
                    System.err.println("No number of steps specified!\nGoing with maximum 5 steps.");
                    paramRand.setMaxSteps(5);
                    continue;
                }
                try{
                    paramRand.setMaxSteps(Integer.valueOf(args[i + 1]));
                } catch (Exception e){
                    System.err.println(args[i + 1] + " is not a number!\nProceeding with 5 steps.");
                    paramRand.setMaxSteps(5);
                }
                i++;
            }else if(args[i].equals("-i")){
                if(i + 1 >= args.length){
                    System.err.println("No maximum number of ingredients specified!\nProceeding with 10 ingredients.");
                    paramRand.setMaxIngredients(10);
                    continue;
                }else if(args[i + 1].contains("-")){
                    System.err.println("No maximum number of ingredients specified!\nProceeding with 10 ingredients.");
                    paramRand.setMaxIngredients(10);
                    continue;
                }
                try{
                    paramRand.setMaxIngredients(Integer.valueOf(args[i+1]));
                }catch (Exception e){
                    System.err.println(args[i+1] + " is not a number!\nProceeding with 10 ingredients.");
                    paramRand.setMaxIngredients(10);
                }
                i++;
            }else if(args[i].equals("-u")){
                if(i + 1 >= args.length)
                    System.err.println("No language specified!\nGoing with " + Locale.getDefault().getLanguage() + ".");
                else{
                    /*HIER CODE EINFÜGEN*/
                }
            }
            System.out.println(args[i]);
        }
        try{
            ingerdients = Load.readIngredients(dataPath);
        } catch (FileNotFoundException e){

        }
        for (i = 0; i < ingerdients.size(); i++){
            ingerdients.get(i).displayIngredient();
        }
        if(mode == MODE_COMPLETELY_RANDOM){

            CompletelyRandom.generateRecipe();

        }

    }

    public static final int MODE_COMPLETELY_RANDOM = 0;
    public static final int MODE_PARAMETER_RANDOM = 1;
    public static final int MODE_LYING_AROUND = 2;

}
