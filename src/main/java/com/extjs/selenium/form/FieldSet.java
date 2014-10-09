package com.extjs.selenium.form;

import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FieldSet extends WebLocator {
    private static final Logger logger = LoggerFactory.getLogger(FieldSet.class);

    public FieldSet() {
        setClassName("FieldSet");
        setBaseCls("x-fieldset");
        setTag("fieldset");
        setExcludeClasses("x-hide-display", "x-masked");
        setTemplate("text", "count(.//*[normalize-space(text())='%s']) > 0");
    }

    public FieldSet(WebLocator container) {
        this();
        setContainer(container);
    }

    public FieldSet(WebLocator container, String text) {
        this(container);
        setText(text);
    }

    public FieldSet(WebLocator container, String cls, String text) {
        this(container, text);
        setClasses(cls);
    }

    // methods
    public boolean isCollapsed() {
        String cls = getAttribute("class");
        return cls != null && cls.contains("x-panel-collapsed");
    }

    public boolean expand() {
        WebLocator legendElement = new WebLocator(this).setText(getText());
        boolean expanded = !isCollapsed() || legendElement.click();
        if (expanded) {
            Utils.sleep(500);
        }
        return expanded;
    }
}
