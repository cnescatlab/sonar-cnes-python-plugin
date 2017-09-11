package fr.sonar.plugins.python.tests;

import fr.cnes.sonar.plugins.python.CnesPythonPlugin;
import org.junit.Before;
import org.junit.Test;
import org.sonar.api.Plugin;
import org.sonar.api.SonarQubeSide;
import org.sonar.api.SonarRuntime;
import org.sonar.api.internal.SonarRuntimeImpl;
import org.sonar.api.utils.Version;

import static org.junit.Assert.assertEquals;

/**
 * Test for the CnesCxxPlugin class
 * @author lequal
 */
public class CnesPythonPluginTest {

    /**
     * Instance of the plugin to test
     */
    private CnesPythonPlugin cnesPythonPlugin;

    /**
     * Prepare each test by creating a new CnesPythonPlugin
     */
    @Before
    public void prepare() {
        cnesPythonPlugin = new CnesPythonPlugin();
    }

    /**
     * Assert that the plugin subscribe correctly to SonarQube
     * by checking the good number of extensions.
     */
    @Test
    public void sonarqubePluginDefinitionTest() {
        SonarRuntime runtime = SonarRuntimeImpl.forSonarQube(Version.create(6,3), SonarQubeSide.SERVER);
        Plugin.Context context = new Plugin.Context(runtime);
        cnesPythonPlugin.define(context);
        assertEquals(context.getExtensions().size(), 1);
    }

}
