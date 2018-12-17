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

import fr.cnes.sonar.plugins.python.CnesPythonRulesDefinition;
import org.junit.Before;
import org.junit.Test;
import org.sonar.api.rules.RuleType;
import org.sonar.api.server.rule.RulesDefinition;
import org.sonar.api.server.rule.RulesDefinitionXmlLoader;

import static org.junit.Assert.*;

/**
 * Test for the CnesPythonRulesDefinition class
 * @author lequal
 */
public class CnesPythonRulesDefinitionTest {

	/**
	 * Rules' number expected to be added by the plugin
	 */
    private static final int PLUGIN_RULES_NUMBER = 16;
	/**
	 * RulesDefinition for testing
	 */
    private CnesPythonRulesDefinition definition;
    /**
     * Stubbed context for testing
     */
    private RulesDefinition.Context context;

    /**
     * Prepare for each test the basic attributes to use like the rules loader
     */
    @Before
    public void prepare() {
    	final RulesDefinitionXmlLoader rulesDefinitionXmlLoader = new RulesDefinitionXmlLoader();
        definition = new CnesPythonRulesDefinition(rulesDefinitionXmlLoader);
        context = new RulesDefinition.Context();
    }

    /**
     * Assert that the rules are correctly loaded by checking that
     * the number of rules is correct
     * the first rule is correctly filled out
     */
    @Test
    public void definitionRuleTest() {
        definition.define(context);

        final RulesDefinition.Repository repository = context.repository("Pylint");

        assertEquals("Pylint", repository.name());
        assertEquals("py", repository.language());
        assertEquals(PLUGIN_RULES_NUMBER, repository.rules().size());

        final RulesDefinition.Rule cnesCheckerRule = repository.rule("R5101");
        assertNotNull(cnesCheckerRule);
        assertEquals(RuleType.CODE_SMELL, cnesCheckerRule.type());
        assertEquals("More than one exit statement for this loop", cnesCheckerRule.name());


    }

    /**
     * Assert that multiple definition of the same rules do not impact
     * the plugin workflow.
     */
    public void multipleRulesDefinitionsTest() throws Exception {

        // Calling definition multiple time should not lead to failure: thanks C# plugin !
        definition.define(new RulesDefinition.Context());

        // Calling definition multiple time should not lead to failure: thanks C# plugin !
        definition.define(new RulesDefinition.Context());

        assert(definition.equals(definition));
    }

}
