package fr.cnes.sonar.plugins.python;

import com.google.common.base.Charsets;
import org.sonar.api.server.rule.RulesDefinition;
import org.sonar.api.server.rule.RulesDefinitionXmlLoader;

/**
 * Define the additional rules needed by CNES for code python.
 * This file is largely inspired by the class PylintRuleRepository
 * from the SonarPython plugin.
 * @author begarco
 */
public class CnesPythonRulesDefinition implements RulesDefinition {

    /**
     * Just the name Pylint
     */
    static final String PYLINT = "Pylint";
    /**
     * Name of the repository where we want to add the new rules
     */
    private static final String REPOSITORY_NAME = PYLINT;
    /**
     * Key of the repository where we want to add the new rules
     */
    private static final String REPOSITORY_KEY = PYLINT;
    /**
     * Repository containing the rules' declaration
     */
    private static final String RULES_FOLDER = "/fr/cnes/sonar/plugins/python/rules/";
    /**
     * Path to the file containing cnes checker rules to import
     */
    private static final String RULES_FILE = RULES_FOLDER + "cnes-checker-rules.xml";
    /**
     * Path to the file containing other rules to import
     */
    private static final String OTHER_RULES_FILE = RULES_FOLDER + "additional-rules.xml";
    /**
     * Key of the language to extend with the new rules
     */
    private static final String PYTHON_KEY = "py";
    /**
     * Loader for python rules (come from Python Sonar Plugin)
     */
    private final RulesDefinitionXmlLoader xmlLoader;

    /**
     * Default constructor
     * @param xmlRulesLoader loader for python rules (come from Python Sonar Plugin)
     */
    public CnesPythonRulesDefinition(RulesDefinitionXmlLoader xmlRulesLoader) {
        this.xmlLoader = xmlRulesLoader;
    }

    /**
     * Load CNES specific rules for the CNES Checker (Pylint plugin)
     * and may load more rules, for example, unknown Pylint rules
     * @param context The plugin context
     */
    @Override
    public void define(Context context) {
        // create a rules repository to contain new rules
        final NewRepository repository = context
                .createRepository(REPOSITORY_KEY, PYTHON_KEY)
                .setName(REPOSITORY_NAME);
        // format for xml files
        final String encoding = Charsets.UTF_8.name();
        // load rules from xml file with the pylint format
        xmlLoader.load(repository, getClass().getResourceAsStream(RULES_FILE), encoding);
        xmlLoader.load(repository, getClass().getResourceAsStream(OTHER_RULES_FILE), encoding);
        // save modifications
        repository.done();
    }
}
