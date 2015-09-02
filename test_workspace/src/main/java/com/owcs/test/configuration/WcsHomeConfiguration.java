package com.owcs.test.configuration;
import java.util.Arrays;
import java.util.List;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.junit.Test;

import com.owcs.test.steps.WcsHomeSteps;

/**
 * @author When user click on Metadata tab Ready
 * 
 */
public class WcsHomeConfiguration extends JUnitStories {

    @Override
    public Configuration configuration() {

        final Configuration configuration = new MostUsefulConfiguration();

        configuration.storyReporterBuilder()
                .withFormats(Format.HTML_TEMPLATE, Format.ANSI_CONSOLE) 
                .withFailureTrace(true) //
                .withMultiThreading(true);

        configuration.storyControls().doSkipScenariosAfterFailure(false).doResetStateBeforeStory(true);
         return configuration; 
        
    }

    @Override
    public InjectableStepsFactory stepsFactory() {
        return new InstanceStepsFactory(configuration(), new WcsHomeSteps());
    }

    @Override
    protected List<String> storyPaths() {
        return new StoryFinder().findPaths(CodeLocations.codeLocationFromClass(this.getClass()).getFile(),
            Arrays.asList("**/wcs_homeConfiguration.story"), null);
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