/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author RichieM
 */
public class Calculator {
    public static void main(String[] args) {
        ModelCalc model = new ModelCalc();
    	ViewInterface view = new ViewInterface();
        ControllerCalc control = new ControllerCalc(view,model);
        view.setVisible(true);
    }
}
