# Kafka Application Dashboard

The goal of this project is to present the visualization of some monitoring dashboards for kafka applications.

It does not tell you **how** to monitor kafka application, but rather it's going to present **what** data you need to monitor and visualize on a dashboard.

> This project is powered by [ELK Stack](https://www.elastic.co/what-is/elk-stack) sandbox locally.

## Dependencies

- [docker](https://www.docker.com/)
- [java](https://www.java.com/en/download/)
- [httpie](https://httpie.io/)
- [curl](https://curl.se/)
- [jq](https://stedolan.github.io/jq/)
- [elasticsearch](https://www.docker.elastic.co/r/elasticsearch), [elasticsearch settings](https://www.elastic.co/guide/en/elasticsearch/reference/master/docker.html)
- [kibana](https://www.docker.elastic.co/r/kibana), [kibana settings](https://www.elastic.co/guide/en/kibana/master/docker.html)
- [logstash](https://www.docker.elastic.co/r/logstash), [logstash settings](https://www.elastic.co/guide/en/logstash/master/docker.html)

## Get Started

Update the virtual memory as it is said at [here](https://www.elastic.co/guide/en/elasticsearch/reference/master/docker.html#_set_vm_max_map_count_to_at_least_262144).

Create a docker network:

```sh
docker network create elk-sandbox_network
```

Run the elk cluster:

```sh
cd elk
docker compose up -d
```

Test that is running:

```sh
http -b :9200/_cat/nodes v==true
```

Creating ELK Sandbox Dashboard:

```sh
curl -s -X POST "http://localhost:5601/api/saved_objects/_import?createNewCopies=true" \
        -H "kbn-xsrf: true" --form \
        file=@./requests/create-sandbox-dashboard.ndjson | jq '.success'
```

Run the logs generator app:

> It's a java project that generates random logs. It is using [slf4j](http://www.slf4j.org/) as facade for logging and [logback](http://logback.qos.ch/) as logging framework.

```sh
./gradlew run
```

Open kibana at [http://localhost:5601](http://localhost:5601)