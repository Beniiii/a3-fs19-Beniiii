package uieng.businessapplication.presentationmodel;

import com.dlsc.formsfx.model.structure.*;
import com.dlsc.formsfx.model.util.BindingMode;
import com.dlsc.formsfx.model.util.ResourceBundleService;
import com.dlsc.formsfx.model.validators.DoubleRangeValidator;
import com.dlsc.formsfx.model.validators.StringLengthValidator;
import com.dlsc.formsfx.view.util.ColSpan;

import java.util.Locale;
import java.util.ResourceBundle;

public class FormsPM {

    /**
     * These are the resource bundles for german and english.
     */
    private ResourceBundle rbDE = ResourceBundle.getBundle("demo-locale", Locale.GERMAN);
    private ResourceBundle rbEN = ResourceBundle.getBundle("demo-locale", Locale.ENGLISH);

    /**
     * The default locale is English, thus the {@code ResourceBundleService} is
     * initialised with it.
     */
    private ResourceBundleService rbs = new ResourceBundleService(rbDE);

    // all controls
    private Form formInstance;
    private SongPM model;
    
    FormsPM(SongPM model) {
        this.model = model;
    }

    /**
     * Creates or simply returns to form singleton instance.
     *
     * @return Returns the form instance.
     */
    public Form getFormInstance() {

        if (formInstance == null) {
            createForm();

        }
        return formInstance;

    }

    /**
     * Creates a new form instance with the required information.
     */
    private void createForm() {
        formInstance = Form.of(
                Group.of(
                        Field.ofStringType(model.titleProperty())
                                .required("required_error_message")
                                .label("title_label")
                                .span(ColSpan.HALF)
                                .validate(StringLengthValidator.atLeast(1, "required_error_message")),
                        Field.ofStringType(model.albumProperty())
                                .required("required_error_message")
                                .label("album_label")
                                .span(ColSpan.HALF)
                                .validate(StringLengthValidator.atLeast(1, "required_error_message")),
                        Field.ofStringType(model.artistProperty())
                                .required("required_error_message")
                                .validate(StringLengthValidator.atLeast(1, "required_error_message"))
                                .label("artist_label")
                                .span(ColSpan.HALF),
                        Field.ofDoubleType(model.durationProperty())
                                .label("duration_label")
                                .span(ColSpan.HALF)
                                .placeholder("duration_placeholder")
                                .validate(DoubleRangeValidator.between(0.0, 100000.0, "format_error_message")),
                        Field.ofStringType(model.genreProperty())
                                .label("genre_label")
                                .span(ColSpan.HALF),
                        Field.ofDoubleType(model.hotnessProperty())
                                .label("hotness_label")
                                .span(ColSpan.HALF)
                                .placeholder("hotness_placeholder")
                                .validate(DoubleRangeValidator.between(0.0, 2.0, "format_error_message"))
                        
                )


        )
        		.title("form_label")
                .i18n(rbs);
    }


    /**
     * Sets the locale of the form.
     *
     * @param language The language identifier for the new locale. Either DE or EN.
     */
    public void translate(String language) {
        switch (language) {
            case "EN":
                rbs.changeLocale(rbEN);
                break;
            case "DE":
                rbs.changeLocale(rbDE);
                break;
            default:
                throw new IllegalArgumentException("Not a valid locale");
        }
    }

    public void setupValueChangeListener() {

    }
}


