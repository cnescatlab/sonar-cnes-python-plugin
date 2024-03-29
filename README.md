## :warning: Deprecation notice

This project is no longer maintained as SonarQube consider pylint as an external analyzer. Feel free to fork this project and adapt plugin to your needs if necessary. Code is available as-is: we do not give any support for this project anymore.

Please refer to the [Sonarqube documentation](https://docs.sonarqube.org/latest/analyzing-source-code/importing-external-issues/importing-third-party-issues/) if you need to import pylint output in sonarqube.

# SonarQube CNES Python Plugin [![Build Status](https://travis-ci.org/lequal/sonar-cnes-python-plugin.svg?branch=master)](https://travis-ci.org/lequal/sonar-cnes-python-plugin) [![Quality Gate](https://sonarcloud.io/api/project_badges/measure?project=fr.cnes.sonar.plugins.python%3Asonar-cnes-python-plugin&metric=alert_status)](https://sonarcloud.io/dashboard?id=fr.cnes.sonar.plugins.python%3Asonar-cnes-python-plugin) [![Coverage](https://sonarcloud.io/api/project_badges/measure?project=fr.cnes.sonar.plugins.python%3Asonar-cnes-python-plugin&metric=coverage)](https://sonarcloud.io/dashboard?id=fr.cnes.sonar.plugins.python%3Asonar-cnes-python-plugin)
SonarQube is an open platform to manage code quality. This plugin adds further rules to check to Pylint using Pylint CNES Checker Plugin.

This plugin is free software; you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation; either version 3 of the License, or (at your option) any later version.

### Quickstart
- Setup a SonarQube instance
- Install Pylint
- Install Python CNES Checker
- Install SonarPython plugin
- Install the plugin
- Run an analysis

### Features
- 15 new rules from CNES for Pylint
- 1 unknown Pylint rules

### Resources
- Rules description
- Architecture

### How to contribute
If you experienced a problem with the plugin please open an issue. Inside this issue please explain us how to reproduce this issue and paste the log.

If you want to do a PR, please put inside of it the reason of this pull request. If this pull request fix an issue please insert the number of the issue or explain inside of the PR how to reproduce this issue.

### License
Copyright 2017 LEQUAL.

Licensed under the [GNU General Public License, Version 3.0](https://www.gnu.org/licenses/gpl.txt)
