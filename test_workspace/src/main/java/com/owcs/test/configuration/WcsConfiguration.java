package com.owcs.test.configuration;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.LoadFromRelativeFile;
import org.jbehave.core.junit.JUnitStory;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.reporters.StoryReporterBuilder.Format;
import org.jbehave.core.steps.CandidateSteps;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.junit.Test;

import com.owcs.test.steps.WcsLoginSteps;
public class WcsConfiguration extends JUnitStory {
	
	@Override
	public Configuration configuration() {
		URL storyURL = null;
		try {
			
			System.out.println("####"+System.getProperty("user.dir")+"+++++");
			
			storyURL = new URL("file://G:/automation/Sites/11.1.1.8.0/export/envision/test_workspace/src/main/java/");
			System.out.println(storyURL);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return new MostUsefulConfiguration().useStoryLoader(
				new LoadFromRelativeFile(storyURL)).useStoryReporterBuilder(
				new StoryReporterBuilder().withDefaultFormats().withFormats(Format.HTML));
	}

	@Override
	public List<CandidateSteps> candidateSteps() {
		return new InstanceStepsFactory(configuration(), new WcsLoginSteps())
				.createCandidateSteps();
	}
	
	@Override
	@Test
	public void run() {
		try {
			super.run();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

}