# Task 1: Lazy Loading

* Aktiviere den LoadPictureTest
    * Warum wird das Bild nicht geladen?
    * Passe die Klasse PictureRepository so an, dass immer `loadContent` aufgerufen wird. Was ist nun das Problem?
* Passe die Methode `loadContent` an:
    * Sichtbarkeit ist nun private
    * Rückgabetyp `byte[]`
    * Im Fehlerfall (IO-Exception) soll null zurückgegeben werden.
    * Ändere den Typ von `content` zu  Supplier<byte[]>
    * Befülle den Supplier mittels Methodenreferenz `this::loadContent`
    * Ergänze eine Custom-Getter für den Content, welcher an den Supplier delegiert.
    * Was ist hier der Nachteil?
* Ändere den Typ von `content` zu  Eval<byte[]>
 * ergänze eine Custom-Getter für den Content, welcher an den Eval delegiert.
 * Fülle den content mittels `Eval.later(this::content)`


# Task 2: Immutable
* Passe die Pojo (Picture, Recipe, Ingredient) so an, dass sie immutable sind.
* Welche Konsequenzen hat dies für die Repositories?
* Welche Konsequenz hat es, wenn wir im Storage cyclops.data.HashMap?

# Task 3: Functional Composition
* Nutze ReactiveSeq in Recipe statt Listen
* Erstelle Methoden, welche schrittweise den Input transformieren
* Erzeuge statt ReactiveSeq Flux und wandle diese mittels Spouts.from(flux) in eine ReactiveSeq
* Welche weiteren Implementierung von ReactiveSeq gibt es?


# Task 4: No Nulls + Exception-Handling
* Passe den PictureService und RecipeService so an, dass er keine Exceptions mehr wirft
    * Nutze hierzu den Rückgabe-Typ Option<T>
    * In den Controllern kann dieser nun zu ResponseEntity::ok bzw* ResponseEntity.notfound() gemappt werden
* In der Picture-Klasse soll nun auch hilfsweise ein Option zurückgegeben werden
    * Ersetze im PictureService map durch flatMap
    * Welchen Nachteil haben wir durch die Verwendung von Option?
* Statt Option können wir auch Maybe, das lazy-Äquivalent
* try-catch-Blöcke lesen sich nicht besonders funktional
    * Ersetze diesen durch Try.withCatch
    * Der Try-Typ lässt sich per Methode in ein Maybe überführen
* Wie kann der Fehler aus dem Try-Block geloggt werden?


# Task 5: Funktionale Dependency Injection (Bonus-Level)
* Der RecipeTransformer hat eine Funktion um die Zutaten zu laden und eine um sie anzupassen.
* Erzeuge nun eine Methode, welche das transformieren erlaubt. Welchen Nachteil hat sie bei der Nutzung?
* Nutze statt Function, die Monade Reader
* Tatsächlich spielt die Fallback-Rückgabe bei loadIngredients keine Rolle, passe den Rückgabe-Typ zu Option<ReactiveSeq<Ingredients>> an.

