package contact;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.ContactPage;

import static org.testng.Assert.assertEquals;

public class ContactTests extends BaseTests {
    @Test(priority = 1)
    public void testNullInputs(){
        ContactPage contactPage = homePage.clickContactPage();
        contactPage.clickSubmit();
        String headerErrorMessage = "We welcome your feedback - but we won't get it unless you complete the form correctly.";
        String foreNameErrorMessage = "Forename is required";
        String emailErrorMessage = "Email is required";
        String messageBoxErrorMessage = "Message is required";

        //Verify error messages
        assertEquals(contactPage.getHeaderErrorMessage(),headerErrorMessage);
        assertEquals(contactPage.getForeNameErrorMessage(),foreNameErrorMessage);
        assertEquals(contactPage.getEmailErrorMessage(),emailErrorMessage);
        assertEquals(contactPage.getMessageBoxErrorMessage(),messageBoxErrorMessage);


        //Validate errors are gone
        String foreName = "test";
        contactPage.setForeName(foreName);
        contactPage.setEmailName("test@email.com");
        contactPage.setMessage("test message");
        boolean isHeaderErrorMessagePresent = contactPage.pageText(" - but we won't get it unless you complete the form correctly.");
        assertEquals(isHeaderErrorMessagePresent, false);
        boolean isForeNameErrorMessagePresent = contactPage.pageText(foreNameErrorMessage);
        assertEquals(isForeNameErrorMessagePresent, false);
        boolean isEmailErrorMessagePresent = contactPage.pageText(emailErrorMessage);
        assertEquals(isEmailErrorMessagePresent, false);
        boolean isMessageBoxErrorMessagePresent = contactPage.pageText(messageBoxErrorMessage);
        assertEquals(isMessageBoxErrorMessagePresent, false);



    }

    @Test(priority = 2)
    public void testSuccessfulSubmit(){
        String foreName = "test";
        ContactPage contactPage = homePage.clickContactPage();
        contactPage.setForeName(foreName);
        contactPage.setEmailName("test@email.com");
        contactPage.setMessage("test message");
        contactPage.clickSubmit();
        assertEquals(contactPage.successMessage(),"Thanks "+foreName+", we appreciate your feedback.");

    }
}
