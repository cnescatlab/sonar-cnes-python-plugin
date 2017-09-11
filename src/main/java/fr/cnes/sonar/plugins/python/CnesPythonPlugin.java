package fr.cnes.sonar.plugins.python;

import org.sonar.api.Plugin;

/**
 * This class is the entry point for all extensions. It is referenced in pom.xml.
 * @author lequal
 */
public class CnesPythonPlugin implements Plugin {

    /**
     * Definition of the plugin
     * add new rules for Python:
     * + Checker CNES rules
     * + Unknown Pylint rules
     * @param context Execution context of the plugin
     */
    @Override
    public void define(Context context) {
        // add new python rules (checker-cnes and other pylint rules)
        context.addExtension(CnesPythonRulesDefinition.class);
    }
}
