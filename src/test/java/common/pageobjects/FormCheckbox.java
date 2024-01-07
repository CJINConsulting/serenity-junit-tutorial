package common.pageobjects;

import org.openqa.selenium.By;

public class FormCheckbox {
    public static By withLabel(String label) {
        return By.xpath("//label[normalize-space(.) ='" + label + "']/input");
    }
}
