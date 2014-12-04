import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author RichieM
 */
public class ControllerCalc {

    private final ViewInterface view;
    private final ModelCalc model;

    public ControllerCalc(ViewInterface view, ModelCalc model) {
        this.view = view;
        this.model = model;
        this.view.addButtonListener((ActionListener) new addListener());
        this.view.subtractButtonListener((ActionListener) new subtractListener());
        this.view.multiplyButtonListener((ActionListener) new multiplyListener());
        this.view.divideButtonListener((ActionListener) new divideListener());
    }

    class addListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            double num1, num2 = 0;
            try {
                num1 = view.getNumber1();
                num2 = view.getNumber2();
                model.addNumbers(num1, num2);
                view.setResult(model.getResultVal());
            } catch (NumberFormatException ex) {
                System.out.println(ex);
                view.errorDisplay("Enter 2 Numbers");
            }

        }

    }

    class subtractListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            double num1, num2 = 0;
            try {
                num1 = view.getNumber1();
                num2 = view.getNumber2();
                model.subtractNumbers(num1, num2);
                view.setResult(model.getResultVal());
            } catch (NumberFormatException ex) {
                System.out.println(ex);
                view.errorDisplay("Enter 2 Numbers");
            }
        }
    }

    class multiplyListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            double num1, num2 = 0;
            try {
                num1 = view.getNumber1();
                num2 = view.getNumber2();
                model.multiplyNumbers(num1, num2);
                view.setResult(model.getResultVal());
            } catch (NumberFormatException ex) {
                System.out.println(ex);
                view.errorDisplay("Enter 2 Numbers");
            }
        }
    }

    class divideListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            double num1, num2 = 0;
            try {
                num1 = view.getNumber1();
                num2 = view.getNumber2();
                model.divideNumbers(num1, num2);
                view.setResult(model.getResultVal());
            } catch (NumberFormatException ex) {
                System.out.println(ex);
                view.errorDisplay("Enter 2 Numbers");
            }
        }
    }
}
