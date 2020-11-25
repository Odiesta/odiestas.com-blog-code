package sample;

import javafx.scene.text.Text;

public enum WriteType {
    FILE("\uE048"),
    PRINT("\uE10a"),
    TRASH("\uE12c");

    private final String c;

    WriteType(String c) {
        this.c = c;
    }

    /**
     *
     * @return a Text object with chosen character
     */
    Text buildGraphics() {
        Text text = new Text(c);
        text.setStyle("-fx-font-family: 'LigatureSymbols'; -fx-font-size: 25;");
        return text;
    }
}
