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
    public void define(final Context context) {
        // add new python rules (checker-cnes and other pylint rules)
        context.addExtension(CnesPythonRulesDefinition.class);
    }
}
