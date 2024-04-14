package org.example.PageView.UI;

import org.example.common.base.BaseBrowser;
import org.example.common.utils.FileUtils;
import org.example.common.utils.SeleUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class BaseView {

    protected final BaseBrowser baseBrowser = new BaseBrowser();

    protected final WebDriver driver = baseBrowser.getDriver();
    private final Duration TIMEOUT=Duration.ofSeconds(15);
    private final Duration POLLING=Duration.ofMillis(500);
    protected final SeleUtils seleUtils = new SeleUtils();
    protected final FileUtils fileUtils = new FileUtils();

    public WebDriverWait wait = new WebDriverWait(driver,TIMEOUT,POLLING);

}
