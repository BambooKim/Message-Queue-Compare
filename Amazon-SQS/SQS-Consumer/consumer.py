import boto3
import argparse
import json

region_name = 'ap-northeast-2'

def parse_args():
    parser = argparse.ArgumentParser(description='Boto3 Example')
    parser.add_argument('--access-key', type=str, help='AWS access key id')
    parser.add_argument('--secret-key', type=str, help='AWS secret access key')
    parser.add_argument('--queue_url', type=str, help='AWS SQS Endpoint')

    return parser.parse_args()

def receive_message(sqs, queue_url):
    response = sqs.receive_message(
        QueueUrl=queue_url,
        AttributeNames=['All'],
        MessageAttributeNames=['All'],
        MaxNumberOfMessages=1,
        WaitTimeSeconds=20
    )
    if 'Messages' in response:
        message = response['Messages'][0]
        message_body = json.loads(message['Body'])
        print('Received message: ', message_body)
        # SQS 메시지 삭제
        sqs.delete_message(QueueUrl=queue_url, ReceiptHandle=message['ReceiptHandle'])

def main():
    args = parse_args()

    session = boto3.Session(
        aws_access_key_id=args.access_key,
        aws_secret_access_key=args.secret_key
    )

    # boto3 클라이언트 생성
    sqs = session.client('sqs', region_name=region_name)

    while True:
        receive_message(sqs, queue_url=args.queue_url)



if __name__ == '__main__':
    main()
