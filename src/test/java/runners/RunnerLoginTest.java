package runners;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features/",
		glue = ("steps"), 
		plugin = {"pretty", "json:target/report.json"},
		monochrome = false,
		snippets = SnippetType.CAMELCASE,
		dryRun = false,
		strict = false
		)

public class RunnerLoginTest {
	
	 @AfterClass
	 	//implementação para geração de relatório através do json gerado
	    public static void generateReport() {
	        File reportOutputDirectory = new File("target");
	        List<String> jsonFiles = new ArrayList<>();
	        jsonFiles.add("./target/report.json");

	        Configuration configuration = new Configuration(reportOutputDirectory, "SauceDemo");
	        configuration.setBuildNumber("1");
	        configuration.addClassifications("Platform", "Windows");
	        configuration.addClassifications("Browser", "Chrome");
	        configuration.addClassifications("Branch", "feature/automation");

	        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
	        reportBuilder.generateReports();
	    }

}
