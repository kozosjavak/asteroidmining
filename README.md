# Asteroid mining game

This is a homework project at Budapest University of Technology and Economics, Computer Engineering specialisation.

# Task specification
https://www.iit.bme.hu/file/11582/feladat

# How to build

## 1. Select your IDE

Preferred IDE: <b>IntelliJ IDEA Ultimate 2020.3</b>

## 2. Install dependencies

> JDK 16

> JUnit 5.4.2

> Maven

## 3. Download sources

<b>From cmd/terminal</b> in the local directory where you want to download the project:
> git clone https://github.com/kozosjavak/asteroidmining.git

<b>From IntelliJ IDEA Ultimate</b>:

File > New > Project from Version Control > Repository URL

- Version Control: ```Git```
- URL: ```https://github.com/kozosjavak/asteroidmining.git```
- Directory: <i>The directory where you would like to clone the repository</i>

..and click Clone.

That's it.

## 4. Build sources

This step depends on your IDE.<br>
In IntelliJ IDEA Ultimate select:

Build > Build project

## 5. Run application

In IntelliJ IDEA Ultimate:

Run > Run 'Main'

## 6. Create & run JAR file

### Create JAR file
Maven have to create .jar file during build process.


### Run JAR file
In cmd/terminal:

- Set Java version to 16 (class file version at least 59.0)
- Navigate to the directory, which contains Skeleton.jar
> java -jar Skeleton.jar
