# DemoJavaApp

AMI ID = **ami-0057d8e6fb0692b80**

##### CLI to create cluster in **AWS** :- 
Use the following cmd to create a cluster in aws after setting up aws profile using `aws configure` :-
```aws eks create-cluster --name test-cluster --kubernetes-version 1.16 --role-arn arn:aws:iam::967015130684:role/eksClusterRole --resources-vpc-config subnetIds=subnet-5c73ff52,subnet-6e34ae23,subnet-25b06004,subnet-6b4d9a34,securityGroupIds=sg-b1c4bd95```

