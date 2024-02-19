# duvalhub-starters
Maven starters for Spring Boot development under duvalhub organization


## How to make a new release
Run the following command :
Maven prepare release and answer the question about the new version
```mvn release:prepare -Prelease```

Maven publish release
```mvn -Dmaven.central.username="$(pass maven-central/username)" -Dmaven.central.password="$(pass maven-central/password)" release:perform -Prelease```

