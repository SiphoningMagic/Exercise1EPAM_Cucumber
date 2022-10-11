package stepdefinations;

import LinkedClasses.AccountDetails;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class stepImplementation {
    AccountDetails account= new AccountDetails();
    int totalAvailableBalance;
    int availableBalancePostWithdrawal;
    List<String> allAcounts= new ArrayList<>();
    @Given("I have a balance of {int} in my accountNumber {string}")
    public void i_have_a_balance_of_in_my_account_number(Integer TotalBalance, String AccountNumber) {
//        1. we will be fetching the Account NUmber and for the same Account number we will be adding the Total Amount as passed from feature file
//        2. Once we have added the total amount using the get method we will fetch the amount and assert if its what the user added
        account.setAccountNumber(AccountNumber);
        allAcounts.add(account.getAccountNumber());
        for(String eachAccount: allAcounts){
            if(eachAccount.equalsIgnoreCase(AccountNumber)){
                account.setAvaiableBalance(TotalBalance);
                totalAvailableBalance=account.getAvaiableBalance();
                System.out.println("Total Balance available in the Accout is "+ totalAvailableBalance);
                Assert.assertEquals(Optional.of(TotalBalance),Optional.of(totalAvailableBalance));
            }
            else{
                System.out.println("Something Incorrect about the ingested Account Number!! Please enter a valid Account Number");
            }
        }

    }
    @When("I request {int}")
    public void i_request(Integer amountWithdrawn) {
//        3. Now we have validated the total balance in GIVEN step so we will need to withdraw an amount coming from the feature file and deduct the same from total Balance
        availableBalancePostWithdrawal=totalAvailableBalance-amountWithdrawn;
        System.out.println("Amount "+amountWithdrawn+" has been withdrawn from total balance of "+totalAvailableBalance+" and thus the new available balance is "+availableBalancePostWithdrawal);
    }
    @Then("{int} should be dispensed")
    public void should_be_dispensed(Integer amountDispensed) {
//        4. this step is to to assert that the withdrawn and dispensed value are same.. Although the same has been validated in previous step itself
        int dispensedAmount= totalAvailableBalance-availableBalancePostWithdrawal;
        System.out.println(dispensedAmount);
        Assert.assertEquals(Optional.of(dispensedAmount),Optional.of(amountDispensed));

    }



}
