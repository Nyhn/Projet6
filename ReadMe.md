0- Prérequis

    * jdk-13.0.2
    * apache maven 3.6.3
    * apache tomcat 9.0.30
    * mysql 8.0.19

1- Récupérer le projet sur GitHub adresse : https://github.com/Nyhn/Projet6.git

    *https://github.com/Nyhn/Projet6.git
    
2- Installer la base de donnée:(Fichier dans MySQL)

    *Ouvrir MySQL Workbench
    *Creer une Database : db_climbup
    *importer dans la base créée : climbupDumpInstallTest_1.0.sql

3- Ouvrir terminal

    *Allez dans le répertoire Projet6
    *Tapez :
        mvn clean install
    *Tapez :
        mvn package
    *Allez dans le répertoire target
    *Tapez :
        java -jar Climb-0.0.1-SNAPSHOT.jar
4- Allez à l'adresse

    *http://localhost:8080/
    
