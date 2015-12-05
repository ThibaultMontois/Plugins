# cibles qui ne sont pas des fichiers (�vite conflit avec les �ventuels fichiers de m�me nom)
.PHONY: clean, docs, compile, jar, run

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

# toutes les t�ches
all: clean docs compile jar

#compilation des sources	
compile: 
	cd src ; javac -classpath $(CLASSPATH) $(SOURCES) -d ../bin

#cr�ation du jar
jar: 
	cd bin ; jar cvfm ../$(JAR_NAME) ../$(MANIFEST) $(DIR)

#g�n�ration de la doc	
docs:
	cd src ; javadoc $(PACKAGES) -d ../doc

#ex�cution du jar
run: 
	@java -jar $(JAR_NAME)

#nettoyage bin et doc
clean: 
	rm -f -r bin ; mkdir bin
	rm -f -r doc ; mkdir doc