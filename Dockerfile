FROM openjdk:14-alpine
COPY target/CryptoMarketWallet-*.jar CryptoMarketWallet.jar
EXPOSE 8080
CMD ["java", "-Dcom.sun.management.jmxremote", "-Xmx128m", "-jar", "CryptoMarketWallet.jar"]