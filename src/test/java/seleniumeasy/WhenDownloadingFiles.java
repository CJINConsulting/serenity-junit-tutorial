package seleniumeasy;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.annotations.Steps;
import net.thucydides.model.configuration.SessionLocalTempDirectory;
import org.awaitility.Awaitility;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import common.actions.NavigateActions;
import seleniumeasy.pageobjects.DownloadPage;
import common.pageobjects.FormPages;

import java.io.File;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//@ExtendWith(SerenityJUnit5Extension.class)
public class WhenDownloadingFiles {

    @Managed
    WebDriver driver;

    @Steps
    NavigateActions navigate;

    DownloadPage downloadPage;

    @Test
    public void weCanDownloadAFileToOurHardDrive() {

        navigate.to(FormPages.DownloadPage);

        downloadPage.downloadSampleFile();

        File downloadedFile = SessionLocalTempDirectory
                .forTheCurrentSession()
                .resolve("sample.png")
                .toFile();

        Awaitility.await().atMost(15, TimeUnit.SECONDS)
                        .until(downloadedFile::exists);

        assertThat(downloadedFile).exists();
    }
}
