package Jbehave.mapper;

import Jbehave.steps.AlertMsgWaitSteps;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.CandidateSteps;
import org.jbehave.core.steps.InstanceStepsFactory;

import java.util.Arrays;
import java.util.List;

public class AlertMsgWaitConfiguration extends JUnitStories {

    public AlertMsgWaitConfiguration() {
        super();
        this.configuredEmbedder().candidateSteps().add(new AlertMsgWaitSteps());
    }

    @Override
    public org.jbehave.core.configuration.Configuration configuration() {
        return new MostUsefulConfiguration().useStoryLoader(new LoadFromClasspath(getClass().getClassLoader())).useStoryReporterBuilder(new StoryReporterBuilder().withFormats(Format.CONSOLE, Format.STATS, Format.HTML));
    }

    @Override
    public List<CandidateSteps> candidateSteps() {
        return new InstanceStepsFactory(configuration(), this).createCandidateSteps();
    }

    @Override
    protected List<String> storyPaths() {
        return Arrays.asList("JBehave/stories/alertMsgWaitStory.story");
    }
}
