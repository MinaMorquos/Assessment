package org.example.PageView.UI;


public class CommonView extends BaseView {
    public void clickOnButton(String text, String type) {
        seleUtils.clickOnButtonWithTextAndType(text, type);
    }
    public void assertPageOpened(String pageName){
        seleUtils.assertPageOpened(pageName);
    }
}
