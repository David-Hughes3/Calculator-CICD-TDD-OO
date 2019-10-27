package com.cs5800.calculator;

/**
 * Token Factory 
 */
public class TokenFactory{

    public static Token getInstanceToken(Object input){

        if(input instanceof String){
            return createInstanceToken((String)input);
        }
        else {
            return createInstanceToken((Double)input);
        }
    }



    private static Token createInstanceToken(String input){
        if(input == "" || input.trim() == ""){
            throw new IllegalArgumentException("Empty string passed to be Token");
        }

        if(isDouble(input)){
            return new OperandToken(input);
        }
        else if(input.length() == 1 && input.charAt(0) =='+' || input.charAt(0) =='-' || input.charAt(0) =='/' || input.charAt(0) =='*' || input.charAt(0) =='%'){
            return new OperatorToken(input.charAt(0));
        }
        else{
            throw new IllegalArgumentException("Unknown String Passed to Be Token: " + input);
        }
    }

    private static Token createInstanceToken(Double input){
        return new OperandToken(input);
    }
    
    private static boolean isDouble(String str){
        try{
            Double.parseDouble(str);
            return true;
        }
        catch(NumberFormatException e){
            return false;
        }
    }

}