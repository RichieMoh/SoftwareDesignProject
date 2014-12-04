/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author RichieM
 */
public class ModelCalc {
    private double resultVal;
    public void addNumbers(double num1, double num2){
        resultVal = num1+num2;
    }
    public void multiplyNumbers(double num1, double num2){
        resultVal = num1*num2;
    }
    public void subtractNumbers(double num1, double num2){
        resultVal = num1-num2;
    }
    public void divideNumbers(double num1, double num2){
        resultVal = num1/num2;
    }

    /**
     *
     * @return
     */
    public double getResultVal(){
        return resultVal;
    }

}
