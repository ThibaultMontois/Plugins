# cibles qui ne sont pas des fichiers (évite conflit avec les éventuels fichiers de même nom)
.PHONY: clean, docs, compile, jar, run

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

# toutes les tâches
all: clean docs compile jar

#compilation des sources	
compile: 
	cd src ; javac -classpath $(CLASSPATH) $(SOURCES) -d ../bin

#création du jar
jar: 
	cd bin ; jar cvfm ../$(JAR_NAME) ../$(MANIFEST) $(DIR)

#génération de la doc	
docs:
	cd src ; javadoc $(PACKAGES) -d ../doc

#exécution du jar
run: 
	@java -jar $(JAR_NAME)

#nettoyage bin et doc
clean: 
	rm -f -r bin ; mkdir bin
	rm -f -r doc ; mkdir doc
