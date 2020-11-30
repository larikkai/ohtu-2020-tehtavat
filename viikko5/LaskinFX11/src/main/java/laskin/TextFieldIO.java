
package laskin;

import javafx.scene.control.TextField;

public class TextFieldIO implements IO {
    private TextField tuloskentta; 
    private TextField syotekentta;
    
    public TextFieldIO(TextField t, TextField s) {
        this.syotekentta = s;
    }

    @Override
    public TextField print(int toPrint) {
        syotekentta.setText("");
        tuloskentta.setText("" + toPrint);
        return tuloskentta;
    }

    @Override
    public TextField readInt(int prompt) {
        return syotekentta;
    }
    
    @Override
    public String readString() {
        return syotekentta.getText();
    }

}
