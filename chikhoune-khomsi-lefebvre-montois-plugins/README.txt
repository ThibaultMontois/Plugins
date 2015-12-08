Projet Java COO : Plugins
Sellenia Chikhoune
Mohammed Khomsi
Benjamin Lefebvre
Thibault Montois
2015

#------------------------#

1/ Introduction

Le logiciel Plugins est un éditeur développé dans le cadre du quatrième projet de licence 3 informatique.

#------------------------#

2/ Usage

Il existe un Makefile dont les commandes sont les suivantes : 
	- make compile -> exécute la compilation de toutes les classes contenues dans le répertoire src
	- make jar -> crée le jar exécutable tp04-chikhoune-khomsi-lefebvre-montois.jar
	- make docs -> génére la documentation
	- make directories -> crée les répertoires dropins et dropinsTest
	- make clean -> supprime les répertoires bin, doc, dropins et dropinsTest
	- make ou make all -> lance make clean, make docs, make compile, make directories et make jar
	- make run -> exécute le jar

Attention à ne pas modifier l'architecture du répertoire pour que le Makefile puisse s'exécuter correctement.

La totalité des fonctions demandées dans le cahier des charges a été implémentée.

#------------------------#

3/ Architecture

Le projet est divisé en packages regroupant les classes par objectif.
L'architecture est la suivante : 

src
 |_plugins
   |_editor
   |_file
   |_timer
 |_test
   |_plugins
     |_editor
     |_file
     |_mock
     |_timer

#------------------------#

4/ Code Sample

Signature de la classe ConfigurableTimer et la méthode "actionPerformed" qui exécute régulièrement la méthode "checkFiles" des finders présent dans la liste : 

public class ConfigurableTimer extends Timer implements ActionListener {

  private List<Finder> finders;
  [...]
  public ConfigurableTimer(int delay) {
    super(delay, null);
    this.finders = new LinkedList<Finder>();
    this.addActionListener(this);
  }
  [...]
  public void actionPerformed(ActionEvent actionEvent) {
    for (Finder finder : this.finders)
      finder.checkFiles();
  }
}

La classe PluginFilter utilisée pour déterminer si un fichier est un plugin ou non : 

public class PluginFilter implements FilenameFilter {
  [...]
  public boolean accept(File directory, String fileName) {
    String className;
    Class<?> classFile;
    
    if (!fileName.toLowerCase().endsWith(".class"))
      return false;
    
    className = fileName.substring(0, fileName.indexOf(".class"));
    
    try {
      classFile = Class.forName("plugins." + className);
    } catch (ClassNotFoundException e) {
        // not in plugins package
        return false;
    }
    
    return this.implementsPlugin(classFile)
            && this.hasAConstructorWithoutParameters(classFile);
  }
  [...]
  private boolean implementsPlugin(Class<?> classFile) {
    return Plugin.class.isAssignableFrom(classFile);
  }
  [...]
  private boolean hasAConstructorWithoutParameters(Class<?> classFile) {
    try {
      classFile.getConstructor();
    } catch (NoSuchMethodException | SecurityException e) {
        return false;
    }
    return true;
  }
}

Signature de la classe PluginFinder et ses méthodes "checkFiles", "handlePlugins", "firePluginAdded" et "firePluginRemoved" : 

public class PluginFinder implements Finder {
  [...]
  public void checkFiles() {
    File[] plugins = this.directory.listFiles(this.filter);
    if (plugins != null)
      this.handlePlugins(plugins);
  }
  [...]
  private void handlePlugins(File[] plugins) {
    List<File> pluginsToRemove = new LinkedList<File>(this.plugins);
    for (File plugin : plugins) {
      if (this.plugins.contains(plugin))
        pluginsToRemove.remove(plugin);
      else {
        this.firePluginAdded(plugin);
        this.plugins.add(plugin);
      }
    }
    for (File plugin : pluginsToRemove) {
      this.firePluginRemoved(plugin);
      this.plugins.remove(plugin);
    }
  }
  [...]
  private void firePluginAdded(File plugin) {
    PluginChangedEvent event = new PluginChangedEvent(this, plugin, true);
    for (PluginChangedListener listener : this.listeners)
      listener.addPlugin(event);
  }
  [...]
  private void firePluginRemoved(File plugin) {
    PluginChangedEvent event = new PluginChangedEvent(this, plugin, false);
    for (PluginChangedListener listener : this.listeners)
      listener.removePlugin(event);
  }
}

Signature de la classe PluginChangedEvent, son constructeur et sa méthode "toPlugin" : 

public class PluginChangedEvent extends EventObject {
  [...]
  public PluginChangedEvent(Object source, File file, boolean addEvent) {
    super(source);
    this.plugin = this.toPlugin(file);
    
    if (this.plugin != null && addEvent)
      this.item = new JMenuItem(this.plugin.getLabel());
  }
  [...]
  private Plugin toPlugin(File file) {
    String filename = file.getName();
    filename = filename.substring(0, filename.indexOf(".class"));
    Class<?> classFile;
    try {
      classFile = Class.forName("plugins." + filename);
      return (Plugin) classFile.newInstance();
    } catch (ClassNotFoundException | InstantiationException
            | IllegalAccessException e) {
        return null;
    }
  }
}

Signature de la classe PluginChangedLogger, son constructeur et ses méthodes "addPlugin" et "removePlugin" : 

public class PluginChangedLogger implements PluginChangedListener {
  [...]
  public PluginChangedLogger(PluginFrame frame) {
    this.frame = frame;
    this.items = new HashMap<String, JMenuItem>();
  }
  [...]
  @Override
  public void addPlugin(PluginChangedEvent event) {
    JMenuItem item = null;
    Plugin plugin = event.getPlugin();
      if (plugin != null)
        item = event.getItem();
      if (item != null) {
        item.addActionListener(new PluginEventListener(this.frame, plugin));
        this.items.put(plugin.getLabel(), item);
      }
  }
  [...]
  @Override
  public void removePlugin(PluginChangedEvent event) {
    JMenuItem item;
    Plugin plugin = event.getPlugin();
    if (plugin != null) {
      item = this.items.remove(plugin.getLabel());
      item.removeActionListener(item.getActionListeners()[0]);
    }
  }
}

Signature de la classe ToolsMenu, son constructeur et ses méthodes "addPlugin" et "removePlugin" : 

public class ToolsMenu extends JMenu implements PluginChangedListener {
  [...]
  public ToolsMenu(String label) {
    super(label);
    this.items = new HashMap<String, JMenuItem>();
  }
  [...]
  @Override
  public void addPlugin(PluginChangedEvent event) {
    JMenuItem item = null;
    Plugin plugin = event.getPlugin();
    if (plugin != null)
      item = event.getItem();
    if (item != null) {
      this.items.put(plugin.getLabel(), item);
      this.add(item);
    }
  }
  [...]
  @Override
  public void removePlugin(PluginChangedEvent event) {
    JMenuItem item;
    Plugin plugin = event.getPlugin();
    if (plugin != null) {
      item = this.items.remove(plugin.getLabel());
      this.remove(item);
    }
  }
}















