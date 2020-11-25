package sample;

import javafx.css.CssMetaData;
import javafx.css.Styleable;
import javafx.css.StyleableObjectProperty;
import javafx.css.StyleablePropertyFactory;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;

import java.util.List;

public class WriteIcon extends Label {

    private static final String STYLE_CLASS = "write-icon";

    // Custom class that will be used in css
    private static final String WRITE_PROP_NAME = "-fx-write";

    // Instance that will be used create CSSMetaData
    private static final StyleablePropertyFactory<WriteIcon> STYLEABLE_PROPERTY_FACTORY =
            new StyleablePropertyFactory<>(Region.getClassCssMetaData());

    // CSSMetaData that this class used
    private static final CssMetaData<WriteIcon, WriteType> WRITE_TYPE_METADATA =
            STYLEABLE_PROPERTY_FACTORY.createEnumCssMetaData(
                    WriteType.class, WRITE_PROP_NAME, x -> x.writeTypeProperty
            );

    public WriteIcon() {
        getStyleClass().setAll(STYLE_CLASS);
    }

    /**
     * Property that will manage style for this class
     */
    private StyleableObjectProperty<WriteType> writeTypeProperty = new StyleableObjectProperty<>() {
        @Override
        public Object getBean() {
            return WriteIcon.this;
        }

        @Override
        public String getName() {
            return WRITE_PROP_NAME;
        }

        @Override
        public CssMetaData<? extends Styleable, WriteType> getCssMetaData() {
            return WRITE_TYPE_METADATA;
        }

        // Will called when there is a change e.g adding new class from css
        @Override
        protected void invalidated() {
            WriteType writetype = get();
            setGraphic(writetype.buildGraphics());
            setText(get().toString());
        }
    };

    /**
     *
     * @return CSSMetaData of WriteIcon
     */
    @Override
    public List<CssMetaData<? extends Styleable, ?>> getControlCssMetaData() {
        return List.of(WRITE_TYPE_METADATA);
    }
}
