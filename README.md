# Bigram Parser
The parser will take in a text file, assemble a collection of bigrams, and produce a histogram of the bigram distribution.

## Build Instructions
The project uses the Maven build system with Java 8.

To build (and run tests):
mvn clean compile assembly:single

Output: go-health-bigram-parser-1.0.jar

## Run Instructions
java -jar target/go-health-bigram-parser-1.0.jar <FullPathToFileWithName>

Example: java -jar target/go-health-bigram-parser-1.0.jar //home//brett//Development//GoHealthTest//go-health-bigram-parser//target//FoxHare.txt