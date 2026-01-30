# Microservicio JWT Demo

## Demo de JWT con SpringBoot

```
  curl --location --request POST 'http://localhost:8083/authenticate' \
  --header 'Content-Type: application/json' \
  --data-raw '{
      "username": "admin",
      "password": "admin123"
  }'
