
package laskin;

import javafx.scene.control.TextField;


public interface IO {
    TextField print(int toPrint);
    String readString(String prompt);
    TextField readInt(int prompt);
}
