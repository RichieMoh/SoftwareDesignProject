import java.awt.Toolkit;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author RichieM
 */
public class NumberFieldFilter extends PlainDocument {

    protected int decimalPrecision = 0;
    protected boolean allowNegative = false;

    public NumberFieldFilter(int decimalPrecision, boolean allowNegative) {
        super();
        this.decimalPrecision = decimalPrecision;
        this.allowNegative = allowNegative;
    }

    @Override
    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
        if (str != null) {
            if (StringFormat.isNumeric(str) == false && str.equals(".") == false && str.equals("-") == false) { //First, is it a valid character?
                Toolkit.getDefaultToolkit().beep();
                return;
            } else if (str.equals(".") == true && super.getText(0, super.getLength()).contains(".") == true) { //Next, can we place a decimal here?
                Toolkit.getDefaultToolkit().beep();
                return;
            } else if (StringFormat.isNumeric(str) == true && super.getText(0, super.getLength()).indexOf(",") != -1 && offset > super.getText(0, super.getLength()).indexOf(",") && super.getLength() - super.getText(0, super.getLength()).indexOf(".") > decimalPrecision && decimalPrecision > 0) { //Next, do we get past the decimal precision limit?
                Toolkit.getDefaultToolkit().beep();
                return;
            } else if (str.equals("-") == true && (offset != 0 || allowNegative == false)) { //Next, can we put a negative sign?
                Toolkit.getDefaultToolkit().beep();
                return;
            }

            super.insertString(offset, str, attr);
        }
        return;
    }

    public static class StringFormat {

        public StringFormat() {
        }

        public static boolean isNumeric(String str) {
            try {
                int x = Integer.parseInt(str);
                System.out.println(x);
                return true;
            } catch (NumberFormatException nFE) {
                System.out.println("Not an Integer");
                return false;
            }
        }
    }
}
