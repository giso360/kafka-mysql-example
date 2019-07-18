Reproducing Example By Udemy Free Online Course Found in:

https://www.udemy.com/apache-kafka-and-spring-boot-consumer-producer/

INSTRUCTIONS
-----------
1./ INSTALL
-----------
(if image not acquired)
docker pull landoop/fast-data-dev

-------------------------------------------------------
2./ RUN (localhost can be replaced with any custom ip)
-------------------------------------------------------

docker run --rm -p 2181:2181 -p 3030:3030 -p 8081-8083:8081-8083 -p 9581-9585:9581-9585 -p 9092:9092 -e ADV_HOST=localhost landoop/fast-data-dev:latest

-----------------------------------------
3./ Access Kafka Control Panel in Web UI:
-----------------------------------------
(wait for 2 minutes)
localhost:3030

---------------------------------------
4./ Commands For Accessing Kafka Broker
---------------------------------------

a./ view message queue:
-----------------------
kafka-console-consumer  --bootstrap-server 127.0.0.1:9092 --topic <topic_name> --from-beginning

in this case: kafka-console-consumer  --bootstrap-server 127.0.0.1:9092 --topic topicOne --from-beginning

b./ view messages @ specific offset and beyond
----------------------------------------------
kafka-console-consumer  --bootstrap-server 127.0.0.1:9092 --topic <topic_name> --partition <partition_no> --offset <offset_no>

c./ delete topic(s)
----------------------------------------------
kafka-topics --zookeeper localhost:2181 --delete --topic <topic_name>

in this case: kafka-topics --zookeeper localhost:2181 --delete --topic topicOne

d./ List Topics
----------------------------------------------
kafka-topics --list --zookeeper localhost:2181


---------------------------------------
5./ Kill Previous Container
---------------------------------------

docker container ls
docker rm -f <container-name>

*Then issue command of chapter 2.



