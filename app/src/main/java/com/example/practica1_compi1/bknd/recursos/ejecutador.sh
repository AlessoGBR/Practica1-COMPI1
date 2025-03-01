echo "INICIANDO COMPILADOR JFLEX"
java -jar /home/alesso/AndroidStudioProjects/Practica1-COMPI1/app/src/main/java/com/example/practica1_compi1/bknd/recursos/flex/jflex-full-1.9.1.jar -d /home/alesso/AndroidStudioProjects/Practica1-COMPI1/app/src/main/java/com/example/practica1_compi1/bknd/Lexer /home/alesso/AndroidStudioProjects/Practica1-COMPI1/app/src/main/java/com/example/practica1_compi1/bknd/Lexer/Lexer.flex

echo "INICIANDO COMPILADOR CUP"
java -jar /home/alesso/AndroidStudioProjects/Practica1-COMPI1/app/src/main/java/com/example/practica1_compi1/bknd/recursos/cup/cup-11a.jar -parser Parser -symbols ParserSym /home/alesso/AndroidStudioProjects/Practica1-COMPI1/app/src/main/java/com/example/practica1_compi1/bknd/Parcer/Parser.cup
mv Parser.java /home/alesso/AndroidStudioProjects/Practica1-COMPI1/app/src/main/java/com/example/practica1_compi1/bknd/Parcer/Parser.java
mv ParserSym.java /home/alesso/AndroidStudioProjects/Practica1-COMPI1/app/src/main/java/com/example/practica1_compi1/bknd/Parcer/ParserSym.java