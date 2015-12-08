# cibles qui ne sont pas des fichiers (évite conflit avec les éventuels fichiers de même nom)
.PHONY: clean, compile, docs, directories, jar, run

# variables à redéfinir pour chaque applications
SOURCES = plugins/*.java plugins/*/*.java test/plugins/*.java test/plugins/*/*.java
# nom du fichier jar généré							
JAR_NAME = tp04-chikhoune-khomsi-lefebvre-montois.jar
# nom du manifeste utilisé pour la création du jar
MANIFEST = Manifest
# les packages utilisés
PACKAGES = plugins plugins.editor plugins.file plugins.timer
# les répertoires utilisés
DIR = ../doc plugins
# le classpath à utiliser
CLASSPATH = ../junit.jar:.

# Les plugins
PLUGINS = ToUpperCase.class ToLowerCase.class DeleteVowels.class
# Les "plugins" pour les tests
TESTPLUGINS = APlugin.class NotImplementsPlugin.class NotHasAConstructorWithoutParameters.class

# toutes les tâches
all: clean docs compile directories jar

# compilation des sources	
compile: 
	mkdir bin
	cd src ; javac -classpath $(CLASSPATH) $(SOURCES) -d ../bin

# génération de la doc	
docs:
	mkdir doc
	cd src ; javadoc $(PACKAGES) -d ../doc

# création des répertoires dropins et dropinsTest
directories:
	mkdir -p dropins dropinsTest/empty
	cd bin/plugins ; cp $(PLUGINS) ../../dropins ; cp $(TESTPLUGINS) ../../dropinsTest
	cd bin/test/plugins ; cp NotInPluginsPackage.class ../../../dropinsTest
	cd dropinsTest ; > NotAClassFile

# création du jar
jar: 
	cd bin ; jar cvfm ../$(JAR_NAME) ../$(MANIFEST) $(DIR)

# exécution du jar
run: 
	@java -jar $(JAR_NAME)

# nettoyage bin et doc
clean: 
	rm -f -r bin
	rm -f -r doc
	rm -f -r dropins
	rm -f -r dropinsTest
