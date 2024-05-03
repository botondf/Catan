Adding a readme now years later.

I tried to look into how this project was set up and this was what I figured out/remembered:

This was written in Java 8, as it was the last version that included native JavaFX support.
I used Eclipse 2018 or 2019.
There's a JavaFX runtime jar (jfxrt.jar) from the Java 8 JRE (we didn't use the SDK it seems).
Could not get it to run even with Java 8 JRE on Eclipse 2019, gives the error:
`Error: Could not find or load main class catan.Catan`

This also might be an outdated version. The recent version I remember did not have a `Main.java` file.
