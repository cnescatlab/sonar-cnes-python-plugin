/*
 * This file is part of cnespython.
 *
 * cnespython is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * cnespython is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with cnespython.  If not, see <http://www.gnu.org/licenses/>.
 */
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
        final SonarRuntime runtime = SonarRuntimeImpl.forSonarQube(Version.create(6,3), SonarQubeSide.SERVER);
        final Plugin.Context context = new Plugin.Context(runtime);
        cnesPythonPlugin.define(context);
        assertEquals(context.getExtensions().size(), 1);
    }

}
