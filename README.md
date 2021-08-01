
# api-gateway-dynamodb-lambda


###  Create role with permission

Create a role with Lambda and Dynamodb permission

![enter image description here](https://github.com/vikki-xiaohua/AWS-series-api-gateway-dynamodb-lambda/blob/main/image/iam-role.png)

###  Write codes

Finish codes and create a Jar file

1.  Creating a custom  _MethodHandler_
2.  Implementing the  _RequestHandler_  interface
3.  Implementing the  _RequestStreamHandler_  interface

Using a **RequestHandler** interface, we define what will be our input and output type. Input and Output serialization will be handled by the Lambda environment.

Using a **RequestStreamHandler** interface, we can read and write byte data using streams. This is useful when you don’t want to use Lambda’s serializations approach or Lambda’s serialization doesn’t fit your requirements.

###  Create  Dynamodb table on AWS Console

DynamoDB -> Create table

### Create Lambda Function on AWS Console

 **1. Create Lambda function 
 2. Upload the Jar file
 3.  Configure Handler
 4. Configure test event**
 

![enter image description here](https://github.com/vikki-xiaohua/AWS-series-api-gateway-dynamodb-lambda/blob/main/image/lambda-1.png)


![enter image description here](https://github.com/vikki-xiaohua/AWS-series-api-gateway-dynamodb-lambda/blob/main/image/role-2.png)

#### Hit Test button

![enter image description here](https://github.com/vikki-xiaohua/AWS-series-api-gateway-dynamodb-lambda/blob/main/image/test-1.png)

![enter image description here](https://github.com/vikki-xiaohua/AWS-series-api-gateway-dynamodb-lambda/blob/main/image/dynamodb-1.png)


