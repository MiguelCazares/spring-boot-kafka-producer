
## Run Locally

Clone the project

```bash
  https://github.com/MiguelCazares/spring-boot-kafka-producer.git
```

Go to the project directory

```bash
  cd spring-boot-kafka-producer
```

Download zookeeper and kafka

```bash
  docker compose -f docker-compose.yml -p kafka-producer up -d
```

Create topic

```bash
  docker exec -it <CONTAINER_ID_O_NOMBRE> kafka-topics --create --topic mi-topico --bootstrap-server localhost:9092 --partitions 3 --replication-factor 1
```

Topic list

```bash
  docker exec -it <CONTAINER_ID_O_NOMBRE> kafka-topics --list --bootstrap-server localhost:9092
```

Topic properties

```bash
  docker exec -it <CONTAINER_ID_O_NOMBRE> kafka-topics --describe --topic <nombre_del_topico> --bootstrap-server localhost:9092
```

Topic logs

```bash
  docker exec -it kafka-producer-kafka-1 kafka-console-consumer --bootstrap-server localhost:9092 --topic mi-topico --from-beginning
```
## Authors

- Miguel Angel Soledad Cazares


## Support

For support, email miguelsoledad751@gmail.com

