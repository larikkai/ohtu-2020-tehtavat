
package laskin;

import javafx.scene.control.TextField;

public class TextFieldIO implements IO {
    
    private TextField tuloskentta; 
    private TextField syotekentta;
    
    public TextFieldIO(TextField t, TextField s) {
        this.tuloskentta = t;
        this.syotekentta = s;
    }

    @Override
    public String readString() {
        return syotekentta.getText();
    }

    @Override
    public void setResult(int value) {
        tuloskentta.setText("");
        tuloskentta.setText(""+value);
    }
    
    @Override
    public int getResult() {
        return Integer.parseInt(tuloskentta.getText());
    }

    
}
