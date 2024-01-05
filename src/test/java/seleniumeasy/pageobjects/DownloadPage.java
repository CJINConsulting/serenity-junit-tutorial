package seleniumeasy.pageobjects;

import org.openqa.selenium.By;

public class DownloadPage extends SeleniumEasyForm {

    private static final By SAMPLE_FILE_LINK = By.linkText("sample.png");
    public void downloadSampleFile() {
        $(SAMPLE_FILE_LINK).click();
    }
}
