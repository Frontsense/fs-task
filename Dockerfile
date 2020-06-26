FROM openjdk:11-jre-slim

RUN mkdir /app

WORKDIR /app

ENV JAVA_TOOL_OPTIONS -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:7999

ADD ./api/target/ /app

EXPOSE 8082

CMD java -cp classes:dependency/* com.kumuluz.ee.EeApplication
