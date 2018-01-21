#Weekday counter
Dieses Java-Programm erhält zwei Zeitpunkte als Eingabe und rechnet aller Sonntage zwischen diesen beiden Zeitpunkten, die auf den ersten Tag eines Monats fallen.

##"Build" und "Run" der Anwendung
Das Programm verwendet [Gradle](https://gradle.org/) als "Build-Tool".

Um die ausführbare JAR-File zu erhalten, müssen Sie den Befehl verwenden:

```
gradle build
```

Nach einem erfolgreichen "Build"-Schritt führen Sie:

```
java -jar build/libs/weekday-counter-1.0.jar 
```

Für die Tests  verwenden Sie den Befehl:

```
gradle test   
```