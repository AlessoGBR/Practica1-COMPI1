echo "INICIANDO COMPILADOR JFLEX"
java -jar /home/alesso/AndroidStudioProjects/Practica1-COMPI1/app/src/main/java/com/example/practica1_compi1/bknd/recursos/flex/jflex-full-1.9.1.jar -d /home/alesso/AndroidStudioProjects/Practica1-COMPI1/app/src/main/java/com/example/practica1_compi1/bknd/Lexer/Texto /home/alesso/AndroidStudioProjects/Practica1-COMPI1/app/src/main/java/com/example/practica1_compi1/bknd/Lexer/Texto/Lexer.flex

echo "INICIANDO COMPILADOR CUP"
java -jar /home/alesso/AndroidStudioProjects/Practica1-COMPI1/app/src/main/java/com/example/practica1_compi1/bknd/recursos/cup/cup-11a.jar -parser Parser -symbols ParserSym /home/alesso/AndroidStudioProjects/Practica1-COMPI1/app/src/main/java/com/example/practica1_compi1/bknd/Parcer/Texto/Parser.cup
mv Parser.java /home/alesso/AndroidStudioProjects/Practica1-COMPI1/app/src/main/java/com/example/practica1_compi1/bknd/Parcer/Texto/Parser.java
mv ParserSym.java /home/alesso/AndroidStudioProjects/Practica1-COMPI1/app/src/main/java/com/example/practica1_compi1/bknd/Parcer/Texto/ParserSym.java