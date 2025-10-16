package listeners;

import java.util.Comparator;
import java.util.List;

import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.xml.XmlSuite;

public class ExecutionOrderReporter implements IReporter 
{
    @Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
        for (ISuite suite : suites) {
            for (ISuiteResult result : suite.getResults().values()) {
                ITestContext context = result.getTestContext();
                System.out.println("Executed Test Methods in order:");
                context.getPassedTests().getAllResults().stream()
                    .sorted(Comparator.comparingLong(tr -> tr.getEndMillis()))
                    .forEach(tr -> System.out.println(tr.getName()));
            }
        }
    }
}
