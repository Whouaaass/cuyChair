package plugins;

import co.edu.unicauca.cuychair.common.notificationPlugin.INotificationPlugin;

import java.io.File;
import java.io.IOException;
import java.net.URLClassLoader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

public class PluginManager {
    private static final String PLUGIN_FOLDER = "plugins"; // Carpeta donde están los JARs

    private List<INotificationPlugin> notificationPlugins;

    public void loadPlugins() {
        try {
            // Cargar los JARs desde la carpeta de plugins
            File pluginDir = new File(PLUGIN_FOLDER);
            if (!pluginDir.exists() || !pluginDir.isDirectory()) {
                System.out.println("No se encontró la carpeta de plugins: " + PLUGIN_FOLDER);
                return;
            }

            // Obtener todos los JARs en la carpeta
            File[] jarFiles = pluginDir.listFiles((dir, name) -> name.endsWith(".jar"));
            if (jarFiles == null || jarFiles.length == 0) {
                System.out.println("No se encontraron plugins en la carpeta: " + PLUGIN_FOLDER);
                return;
            }

            // Crear un ClassLoader que cargue las clases desde los JARs
            URL[] jarUrls = new URL[jarFiles.length];
            for (int i = 0; i < jarFiles.length; i++) {
                jarUrls[i] = jarFiles[i].toURI().toURL();
            }

            // Usar URLClassLoader para cargar las clases de los JARs
            URLClassLoader urlClassLoader = new URLClassLoader(jarUrls, this.getClass().getClassLoader());

            // Usar ServiceLoader para encontrar las implementaciones de Plugin
            ServiceLoader<INotificationPlugin> serviceLoader = ServiceLoader.load(INotificationPlugin.class, urlClassLoader);

            notificationPlugins = new ArrayList<>();
            // Ejecutar cada plugin encontrado
            for (INotificationPlugin plugin : serviceLoader) {
                plugin.start();
                notificationPlugins.add(plugin);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
