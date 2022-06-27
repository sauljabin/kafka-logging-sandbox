# Kafka Logging Sandbox

The goal of this project is to present the visualization of some monitoring dashboards for kafka applications.

It does not tell you **how** to monitor kafka application, rather it's going to present **what** data you need to monitor and visualize on a dashboard.

> This repository is for educational purposes. This project is powered by [ELK Stack](https://www.elastic.co/what-is/elk-stack).

## Get Started

Create a docker network:

```sh
docker network create kafka-logging-sandbox_network
```

Run the elk cluster:

```sh
docker compose up -d
```

> If you are having erros like "**max virtual memory areas vm.max_map_count is too low, increase to at least [262144]**" look at [here](https://www.elastic.co/guide/en/elasticsearch/reference/master/docker.html#_set_vm_max_map_count_to_at_least_262144).

Test that is running:

```sh
curl "http://localhost:9200/_cat/nodes?v=true"
```

Creating the dashboards:

```sh
curl -s -X POST "http://localhost:5601/api/saved_objects/_import?createNewCopies=true" \
        -H "kbn-xsrf: true" --form \
        file=@./requests/create-dashboards.ndjson
```

Run the logs generator app:

> It's a java project that generates random logs. It is using [slf4j](http://www.slf4j.org/) as facade for logging and [logback](http://logback.qos.ch/) as logging framework.

```sh
./gradlew loggers:run
```

> Open [Kibana](http://localhost:5601)

## Screenshots

<p align="center">
<img alt="dashboard" src="https://raw.githubusercontent.com/sauljabin/kafka-logging-sandbox/main/screenshots/dashboard.png">
</p>

## Interesting Links

- [elasticsearch](https://www.docker.elastic.co/r/elasticsearch), [elasticsearch settings](https://www.elastic.co/guide/en/elasticsearch/reference/master/docker.html)
- [kibana](https://www.docker.elastic.co/r/kibana), [kibana settings](https://www.elastic.co/guide/en/kibana/master/docker.html)
- [logstash](https://www.docker.elastic.co/r/logstash), [logstash settings](https://www.elastic.co/guide/en/logstash/master/docker.html)
