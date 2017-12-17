FROM java:8-jre
MAINTAINER Eladii Vadim <vadimeladii@gmail.com>
ADD ./build/libs/data-warehouse-gateway.jar /app/
CMD ["java", "-jar", "/app/data-warehouse-gateway.jar"]
EXPOSE 8888