# cibles qui ne sont pas des fichiers (�vite conflit avec les �ventuels fichiers de m�me nom)
.PHONY: clean, compile, docs, directories, jar, run

# variables � red�finir pour chaque applications
SOURCES = plugins/*.java plugins/*/*.java test/plugins/*.java test/plugins/*/*.java
# nom du fichier jar g�n�r�							
JAR_NAME = tp04-chikhoune-khomsi-lefebvre-montois.jar
# nom du manifeste utilis� pour la cr�ation du jar
MANIFEST = Manifest
# les packages utilis�s
PACKAGES = plugins plugins.editor plugins.file plugins.timer
# les r�pertoires utilis�s
DIR = ../doc plugins
# le classpath � utiliser
CLASSPATH = ../junit.jar:.

# Les plugins
PLUGINS = ToUpperCase.class ToLowerCase.class DeleteVowels.class
# Les "plugins" pour les tests
TESTPLUGINS = APlugin.class NotImplementsPlugin.class NotHasAConstructorWithoutParameters.class

# toutes les t�ches
all: clean docs compile directories jar

# compilation des sources	
compile: 
	mkdir bin
	cd src ; javac -classpath $(CLASSPATH) $(SOURCES) -d ../bin

# g�n�ration de la doc	
docs:
	mkdir doc
	cd src ; javadoc $(PACKAGES) -d ../doc

# cr�ation des r�pertoires dropins et dropinsTest
directories:
	mkdir -p dropins dropinsTest/empty
	cd bin/plugins ; cp $(PLUGINS) ../../dropins ; cp $(TESTPLUGINS) ../../dropinsTest
	cd bin/test/plugins ; cp NotInPluginsPackage.class ../../../dropinsTest
	cd dropinsTest ; > NotAClassFile

# cr�ation du jar
jar: 
	cd bin ; jar cvfm ../$(JAR_NAME) ../$(MANIFEST) $(DIR)

# ex�cution du jar
run: 
	@java -jar $(JAR_NAME)

# nettoyage bin et doc
clean: 
	rm -f -r bin
	rm -f -r doc
	rm -f -r dropins
	rm -f -r dropinsTest
