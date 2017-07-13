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
 * @author begarco
 */
public class CnesPythonRulesDefinitionTest {

    private CnesPythonRulesDefinition definition;
    private RulesDefinition.Context context;

    /**
     * Prepare for each test the basic attributes to use like the rules loader
     */
    @Before
    public void prepare() {
        RulesDefinitionXmlLoader rulesDefinitionXmlLoader = new RulesDefinitionXmlLoader();
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

        RulesDefinition.Repository repository = context.repository("Pylint");

        assertEquals("Pylint", repository.name());
        assertEquals("py", repository.language());
        assertEquals(22, repository.rules().size());

        RulesDefinition.Rule cnesCheckerRule = repository.rule("R5101");
        assertNotNull(cnesCheckerRule);
        assertEquals(RuleType.CODE_SMELL, cnesCheckerRule.type());
        assertEquals("More than one exit statement for this loop", cnesCheckerRule.name());


    }

    /**
     * Assert that multiple definition of the same rules do not impact
     * the plugin workflow.
     */
    @Test(expected = Exception.class)
    public void multipleRulesDefinitionsTest() throws Exception {

        // Calling definition multiple time should not lead to failure: thanks C# plugin !
        definition.define(new RulesDefinition.Context());

        // Calling definition multiple time should not lead to failure: thanks C# plugin !
        definition.define(new RulesDefinition.Context());

        throw new Exception();
    }

}
