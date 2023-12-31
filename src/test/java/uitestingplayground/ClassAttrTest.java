package uitestingplayground;

import com.microsoft.playwright.Dialog;
import common.TestBase;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ClassAttrTest extends TestBase {

    @Test
    void clickDynamicIdButton() {
        ClassAttrPage classAttrPage = new ClassAttrPage(page);
        classAttrPage.openPage();

        AtomicBoolean primaryButtonDialogShown = new AtomicBoolean(false);
        Consumer<Dialog> onPrimaryButtonDialog = dialog -> {
            assertEquals( "Primary button pressed", dialog.message());
            primaryButtonDialogShown.set(true);
            dialog.accept();
        };
        page.onDialog(onPrimaryButtonDialog);

        classAttrPage.clickPrimaryButton();

        assertTrue(primaryButtonDialogShown.get());
    }
}