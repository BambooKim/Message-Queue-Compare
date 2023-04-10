from kafka import KafkaConsumer
import json

consumer = KafkaConsumer(
    bootstrap_servers = [ 'localhost:9092' ],
    value_deserializer = lambda m: json.loads(m.decode('ascii'))
)

consumer.subscribe([ 'hello.kafka' ])

for message in consumer:
    print(message.value)