This is the source code release of the TigersEye DSL Framework's "Core" component group.

The TigersEye DSL Framework helps language developers to build domain-specific languages (DSLs) in form of libraries, also called internal or embedded DSLs. The languages derived in the framework are enabled for further composition through so-called combiners that compose the syntax, semantics and pragmatics of the language components.



Apache License
Version 2.0, January 2004
https://www.apache.org/licenses/LICENSE-2.0.html




# INSTALLATION
To complete the installation you new to copy the following files into /lib:

javalogo.jar
From: http://sourceforge.net/projects/javalogo/
Our via direct link: https://sourceforge.net/projects/javalogo/files/javalogo/0.1/javalogo.zip/download?use_mirror=autoselect



# GETTING STARTED
To build TigersEye, simply use the embedded gradle wrapper.
In the root directory "tigerseye-core" in which the build.gradle file is located,
you need to run from command line the following:
> gradlew build test 

To set up the project structure execute:
> gradlew cleanEclipse eclipse

To install the component group for customizations of the core library to be used in dependent projects execute:
> gradlew clean publishToMavenLocal

The project currently uses Groovy compiler version 2.5.1+ and Eclipse as IDE support.



# CONTRIBUTING
You may contribute to the project via github:
https://github.com/dinkelaker/tigerseye-core

You can access the git SCM via:
git@github.com:dinkelaker/tigerseye-core.git




